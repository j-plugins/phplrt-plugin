package com.github.xepozz.phplrt.psi.impl

import com.github.xepozz.phplrt.psi.PhplrtElementFactory
import com.github.xepozz.phplrt.psi.PhplrtNamedElement
import com.github.xepozz.phplrt.psi.PhplrtTypes
import com.intellij.psi.PsiElement

class PhplrtPsiImplUtil {
    companion object {
        @JvmStatic
        fun getNameIdentifier(element: PhplrtNamedElement): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("1getNameIdentifier: $keyNode of ${element.node}, $element res: ${keyNode?.psi?.text}")
            return keyNode?.psi
        }

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
            println("getValue: $keyNode of ${element.node}, $element res: ${keyNode?.psi?.text}")
            return keyNode?.text ?: ""
        }

        @JvmStatic
        fun getName(element: PhplrtNamedElement): String {
            val valueNode = getNameIdentifier(element)
            println("getName: ${valueNode?.text} ${valueNode?.textRange} of ${element.node}")
            return valueNode?.text ?: ""
        }

        @JvmStatic
        fun setName(element: PhplrtNamedElement, name: String): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            if (keyNode != null) {
                val property = PhplrtElementFactory.createTokenDeclaration(element.project, name)
                println("create new TokenDeclaration: $name of ${element.node}, res: $property")
                val newKeyNode = property?.firstChild?.node ?: return null
                element.node.replaceChild(keyNode, newKeyNode)
            }
            println("setName: $name of ${element.node}")

            return element
        }
    }
}