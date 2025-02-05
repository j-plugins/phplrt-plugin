package com.github.xepozz.phplrtplugin.psi

import com.github.xepozz.phplrtplugin.language.PhplrtTokenDeclarationStubElementType
import com.intellij.psi.tree.IElementType

class PhplrtElementTypeFactory {
    companion object {
        @JvmStatic
        fun factory(name: String): IElementType {
            if (name == "META_DECL") return PhplrtTokenDeclarationStubElementType(name)

            throw RuntimeException("Unknown element type: $name")
        }
    }
}