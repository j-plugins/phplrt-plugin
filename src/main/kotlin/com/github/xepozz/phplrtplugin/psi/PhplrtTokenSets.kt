package com.github.xepozz.phplrtplugin.psi

import com.intellij.psi.tree.TokenSet

object PhplrtTokenSets {
    val IDENTIFIERS = TokenSet.create(PhplrtTypes.IDENTIFIER)

    val COMMENTS = TokenSet.create(PhplrtTypes.COMMENT)
}