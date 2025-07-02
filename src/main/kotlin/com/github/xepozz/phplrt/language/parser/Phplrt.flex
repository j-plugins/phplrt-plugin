package com.github.xepozz.phplrt.language.parser;

import com.intellij.psi.tree.IElementType;
import com.github.xepozz.phplrt.psi.PhplrtTypes;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;
import java.util.Stack;

%%

%public
%class PhplrtLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    int braceCount;
    private Stack<Integer> stack = new Stack<>();

    public void yycleanState(int newState) {
        stack.clear();
        yypushState(newState);
    }

    public void yypushState(int newState) {
        stack.push(yystate());
        yybegin(newState);
    }

    public void yypopState() {
        yybegin(stack.pop());
    }
%}


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
MULTILINE_COMMENT="/**"[\s\S]*?"*/"

NNL        = [^\u2028\u2029\u000A\u000B\u000C\u000D\u0085]

JavaComment = {TraditionalComment}|{EndOfLineComment}
TraditionalComment = "/*"{CommentContent}\*+"/"
EndOfLineComment = "//" {NNL}*
CommentContent = ([^*]|\*+[^*/])*
StringCharacter = [^\u2028\u2029\u000A\u000B\u000C\u000D\u0085\"\'\\]
StringLiteral = (\"({StringCharacter})*\") | (\'({StringCharacter})*\')
JavaRest = [^\{\}\"\'/]|"/"[^*/]
JavaCode = ({JavaRest}|{StringLiteral}|{JavaComment})+


%state WAITING_VALUE
%state WAITING_LITERAL
%state META_DECLARATION
%state RULE_DECLARATION
%state INLINE_CODE, BEFORE_INLINE_CODE, AFTER_INLINE_CODE


%%
<YYINITIAL> {
    {META_START}                                                { yypushState(META_DECLARATION); return PhplrtTypes.META_START; }
    {LITERAL}                                                   { yypushState(RULE_DECLARATION); return PhplrtTypes.LITERAL; }
    {SHARP}                                                     { yypushState(RULE_DECLARATION); return PhplrtTypes.SHARP; }
}

<META_DECLARATION> {
    "token"                                                     { yypushState(WAITING_LITERAL); return PhplrtTypes.TOKEN; }
    "skip"                                                      { yypushState(WAITING_LITERAL); return PhplrtTypes.SKIP; }
    "pragma"                                                    { yypushState(WAITING_LITERAL); return PhplrtTypes.PRAGMA; }
    "include"                                                   { yypushState(WAITING_LITERAL); return PhplrtTypes.INCLUDE; }
}
<RULE_DECLARATION> {
    {LITERAL}                                                   { yypushState(RULE_DECLARATION); return PhplrtTypes.LITERAL; }
    {CODE_DELIMITER}                                            { yypushState(BEFORE_INLINE_CODE); return PhplrtTypes.CODE_DELIMITER; }
    {COLON}                                                     { return PhplrtTypes.COLON; }
    {LITERAL}                                                   { return PhplrtTypes.LITERAL; }
    {SEMICOLON}                                                 { yycleanState(YYINITIAL); return PhplrtTypes.SEMICOLON; }
    {OP_OR}                                                     { return PhplrtTypes.OP_OR; }
    {QUANTIFIER_ZERO_ONE}                                       { return PhplrtTypes.QUANTIFIER_ZERO_ONE; }
    {QUANTIFIER_ANY}                                            { return PhplrtTypes.QUANTIFIER_ANY; }
    {QUANTIFIER_ONE_INFINITE}                                   { return PhplrtTypes.QUANTIFIER_ONE_INFINITE; }
    {PARENTHESES_OPEN}                                          { return PhplrtTypes.PARENTHESES_OPEN; }
    {PARENTHESES_CLOSE}                                         { return PhplrtTypes.PARENTHESES_CLOSE; }
    {DOUBLE_COLON}                                              { return PhplrtTypes.DOUBLE_COLON; }
    {LEFT_ARROW}                                                { return PhplrtTypes.LEFT_ARROW; }
    {RIGHT_ARROW}                                               { return PhplrtTypes.RIGHT_ARROW; }
}

<BEFORE_INLINE_CODE> "{"                                        { yypushState(INLINE_CODE); }
<AFTER_INLINE_CODE> "}"                                         { yypushState(RULE_DECLARATION); }

<INLINE_CODE> {
  "{"        { braceCount++; }
  "}"        { if (braceCount > 0) braceCount--; else { yypushback(1); yypushState(AFTER_INLINE_CODE); return PhplrtTypes.INLINE_CODE; } }
  {JavaCode} {  }
//  <<EOF>>    { nextState=REGEXPSTART; yybegin(REPORT_UNCLOSED); return FLEX_RAW; }
}

[ \t\f\s\n]+                                                     { return TokenType.WHITE_SPACE; }

//<YYINITIAL> {NEWLINE}                                            { yybegin(YYINITIAL); return PhplrtTypes.NEWLINE; }

<WAITING_LITERAL> {LITERAL}                                      { yypushState(WAITING_VALUE); return PhplrtTypes.LITERAL; }
<WAITING_VALUE> {
    {WHITE_SPACE}+                                               { return TokenType.WHITE_SPACE; }
    [^\r\n]+                                                     { yycleanState(YYINITIAL); return PhplrtTypes.VALUE; }
}

{END_OF_LINE_COMMENT}                                            { return PhplrtTypes.COMMENT; }
{MULTILINE_COMMENT}                                              { return PhplrtTypes.COMMENT; }

[^]                                                              { return TokenType.BAD_CHARACTER; }
