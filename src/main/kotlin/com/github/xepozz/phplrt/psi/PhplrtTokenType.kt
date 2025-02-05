package com.github.xepozz.phplrt.psi

import com.github.xepozz.phplrt.language.PhplrtLanguage
import com.intellij.psi.tree.IElementType

class PhplrtTokenType(debugName: String) : IElementType(debugName, PhplrtLanguage.INSTANCE) {
    override fun toString() = "PhplrtTokenType." + super.toString()
}