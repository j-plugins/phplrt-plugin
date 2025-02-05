package com.github.xepozz.phplrt.language

import com.intellij.lexer.FlexAdapter

class PhplrtLexerAdapter : FlexAdapter(PhplrtLexer(null))