package com.github.xepozz.phplrt.language.psi

import com.github.xepozz.phplrt.language.PhplrtMetaDeclarationStubElementType
import com.github.xepozz.phplrt.language.PhplrtRuleDeclarationStubElementType
import com.intellij.psi.tree.IElementType

class PhplrtElementTypeFactory {
    companion object {
        @JvmStatic
        fun factory(name: String): IElementType {
            if (name == "META_DECL") return PhplrtMetaDeclarationStubElementType(name)
            if (name == "RULE_DECL") return PhplrtRuleDeclarationStubElementType(name)

            throw RuntimeException("Unknown element type: $name")
        }
    }
}