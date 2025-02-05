package com.github.xepozz.phplrt.psi

import com.github.xepozz.phplrt.language.PhplrtTokenDeclarationStubElementType
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