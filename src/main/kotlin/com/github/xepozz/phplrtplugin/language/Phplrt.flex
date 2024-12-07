package com.github.xepozz.phplrtplugin.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes;
import com.intellij.psi.TokenType;

%%

%class PhplrtLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
COLON=:
SEMICOLON=";"
DOUBLE_COLON="::"
LEFT_ARROW="<"
RIGHT_ARROW=">"
RIGHT_ARROW=">"
OP_OR="|"
SQUARES=\(\)
RULE=[a-zA-Z_]+
WHITE_SPACE=[\ \s\t\h]
VALUE=[^\n]+
IDENTIFIER=[a-zA-Z_]+
END_OF_LINE_COMMENT="//"[^\r\n]*
MULTILINE_COMMENT=\/\*\*[\s\S]*?\*\/

%state WAITING_VALUE
%state WAITING_IDENTIFIER
%state WAITING_EXPRESSION

%%
<YYINITIAL> {
    "%token"                                                     { yybegin(WAITING_IDENTIFIER); return PhplrtTypes.TOKEN; }
    "%skip"                                                      { yybegin(WAITING_IDENTIFIER); return PhplrtTypes.SKIP; }
}

<YYINITIAL> {END_OF_LINE_COMMENT}                                { yybegin(YYINITIAL); return PhplrtTypes.COMMENT; }
<YYINITIAL> {MULTILINE_COMMENT}                                  { yybegin(YYINITIAL); return PhplrtTypes.COMMENT; }
<YYINITIAL> ({CRLF}{WHITE_SPACE}?)+                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_IDENTIFIER> {IDENTIFIER}                                { yybegin(WAITING_VALUE); return PhplrtTypes.IDENTIFIER; }
<WAITING_VALUE> {VALUE}                                          { yybegin(YYINITIAL); return PhplrtTypes.VALUE; }

<YYINITIAL> {RULE}                                               { yybegin(WAITING_IDENTIFIER); return PhplrtTypes.RULE; }

{IDENTIFIER}                                                     { return PhplrtTypes.IDENTIFIER; }
{COLON}                                                          { return PhplrtTypes.COLON; }
{SEMICOLON}                                                      { return PhplrtTypes.SEMICOLON; }
{OP_OR}                                                          { return PhplrtTypes.OP_OR; }
{WHITE_SPACE}+                                                   { return TokenType.WHITE_SPACE; }
{SQUARES}                                                        { return PhplrtTypes.SQUARES; }
{DOUBLE_COLON}                                                   { return PhplrtTypes.DOUBLE_COLON; }
{LEFT_ARROW}                                                     { return PhplrtTypes.LEFT_ARROW; }
{RIGHT_ARROW}                                                    { return PhplrtTypes.RIGHT_ARROW; }

[^]                                                              { return TokenType.BAD_CHARACTER; }
