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
////        @JvmStatic
////        fun getNameIdentifier(element: PhplrtMetaDecl) = element.nameIdentifier
////        @JvmStatic
////        fun getNameIdentifier(element: PhplrtRuleDecl) = element.nameIdentifier
//        @JvmStatic
//        fun getNameIdentifier(element: PsiNameIdentifierOwner) = element.nameIdentifier

        @JvmStatic
        fun isToken(element: PhplrtNamedElement): Boolean {
            return element.node.findChildByType(PhplrtTypes.TOKEN) != null
        }

        @JvmStatic
        fun isSkip(element: PhplrtNamedElement): Boolean {
            return element.node.findChildByType(PhplrtTypes.TOKEN) != null
        }

        @JvmStatic
        fun isPragma(element: PhplrtNamedElement): Boolean {
            return element.node.findChildByType(PhplrtTypes.TOKEN) != null
        }

        @JvmStatic
        fun getValue(element: PhplrtNamedElement): String {
            val keyNode = element.node.findChildByType(PhplrtTypes.VALUE)
            return keyNode?.text ?: ""
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
    }
}