package com.github.xepozz.phplrt.language.parser

import com.intellij.lexer.FlexAdapter

class PhplrtLexerAdapter : FlexAdapter(
    PhplrtLexer(null)
)

//class PhplrtLexerAdapter2 : com.intellij.lexer.LayeredLexer(
//    FlexAdapter(PhplrtLexer(null)),
//    TokenSet.create()
//)