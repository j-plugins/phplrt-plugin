package com.github.xepozz.phplrt.language.psi.impl

import com.github.xepozz.phplrt.language.psi.PhplrtElementFactory
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement
import com.github.xepozz.phplrt.psi.PhplrtTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry

class PhplrtPsiImplUtil {
    companion object {
        @JvmStatic
        fun getNameIdentifier(element: PhplrtNamedElement): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            return keyNode?.psi
        }

        @JvmStatic
        fun isToken(element: PhplrtNamedElement): Boolean {
            return element.node.findChildByType(PhplrtTypes.TOKEN) != null
        }

        @JvmStatic
        fun isSkip(element: PhplrtNamedElement): Boolean {
            return element.node.findChildByType(PhplrtTypes.SKIP) != null
        }

        @JvmStatic
        fun isPragma(element: PhplrtNamedElement): Boolean {
            return element.node.findChildByType(PhplrtTypes.PRAGMA) != null
        }

        @JvmStatic
        fun getName(element: PhplrtNamedElement): String {
            val valueNode = element.nameIdentifier
            return valueNode?.text ?: ""
        }

        @JvmStatic
        fun setName(element: PhplrtNamedElement, name: String): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            if (keyNode != null) {
                val property = PhplrtElementFactory.createMetaDeclaration(element.project, name)
                val newKeyNode = property?.node?.findChildByType(PhplrtTypes.IDENTIFIER) ?: return null
                element.node.replaceChild(keyNode, newKeyNode)
            }

            return element
        }

        @JvmStatic
        fun getReferences(element: PhplrtNamedElement): Array<out PsiReference> =
            ReferenceProvidersRegistry.getReferencesFromProviders(element)

        @JvmStatic
        fun getReference(element: PhplrtNamedElement): PsiReference? =
            ReferenceProvidersRegistry.getReferencesFromProviders(element)
                .takeIf { it.size == 1 }
                ?.firstOrNull()
    }
}