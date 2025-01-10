package com.github.xepozz.phplrtplugin.language

import com.intellij.lexer.FlexAdapter

class PhplrtLexerAdapter : FlexAdapter(PhplrtLexer(null))