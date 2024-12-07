package com.github.xepozz.phplrtplugin.psi

import com.github.xepozz.phplrtplugin.language.PhplrtLanguage
import com.intellij.psi.tree.IElementType

class PhplrtTokenType(debugName: String) : IElementType(debugName, PhplrtLanguage.INSTANCE) {
    override fun toString(): String {
        return "PhplrtTokenType." + super.toString()
    }
}