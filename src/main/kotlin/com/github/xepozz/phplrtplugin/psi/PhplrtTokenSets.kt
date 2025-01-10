package com.github.xepozz.phplrtplugin.psi

import com.intellij.psi.tree.TokenSet

object PhplrtTokenSets {
    val IDENTIFIERS = TokenSet.create(PhplrtTypes.IDENTIFIER)
    val COMMENTS = TokenSet.create(PhplrtTypes.COMMENT)
    val OPERATORS = TokenSet.create(
        PhplrtTypes.OP_OR, PhplrtTypes.PARENTHESES_OPEN, PhplrtTypes.PARENTHESES_CLOSE,
    )
    val KEYWORDS = TokenSet.create(
        PhplrtTypes.TOKEN, PhplrtTypes.SKIP, PhplrtTypes.PRAGMA,
    )
}