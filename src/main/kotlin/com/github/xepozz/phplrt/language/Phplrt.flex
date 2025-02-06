package com.github.xepozz.phplrt.language;

import com.intellij.psi.tree.IElementType;
import com.github.xepozz.phplrt.psi.PhplrtTypes;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;

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
QUANTIFIER_ZERO_ONE="?"
QUANTIFIER_ANY="*"
QUANTIFIER_ONE_INFINITE="+"
PARENTHESES_OPEN="("
PARENTHESES_CLOSE=")"
CURLY_BRACKETS_LEFT="{"
CURLY_BRACKETS_RIGHT="}"

WHITE_SPACE = [ \t\f]
CODE_DELIMITER = "->"


//WHITE_SPACE=[ \s\t\h]+
VALUE=[^\s\n]+
//VALUE=[^\s\h\t \r].*
LITERAL=[A-Za-z_][A-Za-z0-9_]*
END_OF_LINE_COMMENT="//"[^\n]*[^\n]?
MULTILINE_COMMENT=\/\*\*[\s\S]*?\*\/

%state WAITING_VALUE
%state WAITING_LITERAL
%state META_DECLARATION
%state RULE_DECLARATION
%state INLINE_CODE

%%
<YYINITIAL> {
    {META_START}                                                { yybegin(META_DECLARATION); return PhplrtTypes.META_START; }
    {LITERAL}                                                   { yybegin(RULE_DECLARATION); return PhplrtTypes.LITERAL; }
}
    {SHARP}                                                     { yybegin(RULE_DECLARATION); return PhplrtTypes.SHARP; }

<META_DECLARATION> {
    "token"                                                     { yybegin(WAITING_LITERAL); return PhplrtTypes.TOKEN; }
    "skip"                                                      { yybegin(WAITING_LITERAL); return PhplrtTypes.SKIP; }
    "pragma"                                                    { yybegin(WAITING_LITERAL); return PhplrtTypes.PRAGMA; }
    "include"                                                   { yybegin(WAITING_LITERAL); return PhplrtTypes.INCLUDE; }
}
<RULE_DECLARATION> {
    {LITERAL}                                                   { yybegin(RULE_DECLARATION); return PhplrtTypes.LITERAL; }
    {CODE_DELIMITER}                                            { yybegin(INLINE_CODE); return PhplrtTypes.CODE_DELIMITER; }
}
    {COLON}                                                     { return PhplrtTypes.COLON; }

<INLINE_CODE> {
//    {CURLY_BRACKETS_LEFT}                                       { yybegin(YYINITIAL); return PhplrtTypes.CURLY_BRACKETS_LEFT; }
//    {CURLY_BRACKETS_RIGHT}                                      { yybegin(YYINITIAL); return PhplrtTypes.CURLY_BRACKETS_RIGHT; }
    {CURLY_BRACKETS_LEFT}.*?{CURLY_BRACKETS_RIGHT}              { return PhplrtTypes.INLINE_CODE; }
}

[ \t\f\s\n]+                                                     { return TokenType.WHITE_SPACE; }

<YYINITIAL> {END_OF_LINE_COMMENT}                                { yybegin(YYINITIAL); return PhplrtTypes.COMMENT; }
<YYINITIAL> {MULTILINE_COMMENT}                                  { yybegin(YYINITIAL); return PhplrtTypes.COMMENT; }
//<YYINITIAL> {NEWLINE}                                            { yybegin(YYINITIAL); return PhplrtTypes.NEWLINE; }

<WAITING_LITERAL> {LITERAL}                                      { yybegin(WAITING_VALUE); return PhplrtTypes.LITERAL; }
<WAITING_VALUE> {WHITE_SPACE}+                                   { return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {VALUE}                                          { yybegin(YYINITIAL); return PhplrtTypes.VALUE; }


{LITERAL}                                                        { return PhplrtTypes.LITERAL; }
{SEMICOLON}                                                      { return PhplrtTypes.SEMICOLON; }
{OP_OR}                                                          { return PhplrtTypes.OP_OR; }
{QUANTIFIER_ZERO_ONE}                                            { return PhplrtTypes.QUANTIFIER_ZERO_ONE; }
{QUANTIFIER_ANY}                                                 { return PhplrtTypes.QUANTIFIER_ANY; }
{QUANTIFIER_ONE_INFINITE}                                        { return PhplrtTypes.QUANTIFIER_ONE_INFINITE; }
{PARENTHESES_OPEN}                                               { return PhplrtTypes.PARENTHESES_OPEN; }
{PARENTHESES_CLOSE}                                              { return PhplrtTypes.PARENTHESES_CLOSE; }
{DOUBLE_COLON}                                                   { return PhplrtTypes.DOUBLE_COLON; }
{LEFT_ARROW}                                                     { return PhplrtTypes.LEFT_ARROW; }
{RIGHT_ARROW}                                                    { return PhplrtTypes.RIGHT_ARROW; }

[^]                                                              { return TokenType.BAD_CHARACTER; }
