package com.github.xepozz.phplrt.language.parser

import com.intellij.lexer.FlexAdapter

class PhplrtLexerAdapter : FlexAdapter(PhplrtLexer(null))