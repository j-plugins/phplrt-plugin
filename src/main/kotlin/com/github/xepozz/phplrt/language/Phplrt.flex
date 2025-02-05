package com.github.xepozz.phplrt.language;

import com.intellij.psi.tree.IElementType;
import com.github.xepozz.phplrt.psi.PhplrtTypes;
import com.intellij.psi.TokenType;

%%

%class PhplrtLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

META_START="%"
COLON=":"
DOUBLE_COLON="::"
SHARP="#"
SEMICOLON=";"
LEFT_ARROW="<"
RIGHT_ARROW=">"
OP_OR="|"
PARENTHESES_OPEN=\(
PARENTHESES_CLOSE=\)
//NEWLINE=\r|\n|\r\n


//ALPHANUM = [\p{Letter}\p{Number}]
WHITE_SPACE = [ \t\f]
EOL = \R


//WHITE_SPACE=[ \s\t\h]+
VALUE=[^\r\n]+
//VALUE=[^\s\h\t \r].*
LITERAL=[A-Za-z_][A-Za-z0-9_]*
END_OF_LINE_COMMENT="//"[^\n]*[^\n]?
MULTILINE_COMMENT=\/\*\*[\s\S]*?\*\/

%state WAITING_VALUE
%state WAITING_LITERAL
%state WAITING_META

%%
<YYINITIAL> {
    {META_START}                                                { yybegin(WAITING_META); return PhplrtTypes.META_START; }
}
<WAITING_META> {
    "token"                                                     { yybegin(WAITING_LITERAL); return PhplrtTypes.TOKEN; }
    "skip"                                                      { yybegin(WAITING_LITERAL); return PhplrtTypes.SKIP; }
    "pragma"                                                    { yybegin(WAITING_LITERAL); return PhplrtTypes.PRAGMA; }
}

<YYINITIAL> {SHARP}                                              { return PhplrtTypes.RULE_MODIFIER_HIDDEN; }
<YYINITIAL> {END_OF_LINE_COMMENT}                                { yybegin(YYINITIAL); return PhplrtTypes.COMMENT; }
<YYINITIAL> {MULTILINE_COMMENT}                                  { yybegin(YYINITIAL); return PhplrtTypes.COMMENT; }
//<YYINITIAL> {NEWLINE}                                            { yybegin(YYINITIAL); return PhplrtTypes.NEWLINE; }
{EOL}+                                                           { return PhplrtTypes.EOL; }
{WHITE_SPACE}+                                                   { return TokenType.WHITE_SPACE; }

<WAITING_LITERAL> {LITERAL}                                      { yybegin(WAITING_VALUE); return PhplrtTypes.LITERAL; }
<WAITING_VALUE> {WHITE_SPACE}+                                   { return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {VALUE}                                          { yybegin(YYINITIAL); return PhplrtTypes.VALUE; }

{LITERAL}                                                        { return PhplrtTypes.LITERAL; }
{COLON}                                                          { return PhplrtTypes.COLON; }
{SEMICOLON}                                                      { return PhplrtTypes.SEMICOLON; }
{OP_OR}                                                          { return PhplrtTypes.OP_OR; }
{PARENTHESES_OPEN}                                               { return PhplrtTypes.PARENTHESES_OPEN; }
{PARENTHESES_CLOSE}                                              { return PhplrtTypes.PARENTHESES_CLOSE; }
{DOUBLE_COLON}                                                   { return PhplrtTypes.DOUBLE_COLON; }
{LEFT_ARROW}                                                     { return PhplrtTypes.LEFT_ARROW; }
{RIGHT_ARROW}                                                    { return PhplrtTypes.RIGHT_ARROW; }

[^]                                                              { return TokenType.BAD_CHARACTER; }
