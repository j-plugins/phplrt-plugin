package com.github.xepozz.phplrtplugin.psi.impl

import com.github.xepozz.phplrtplugin.psi.PhplrtElementFactory
import com.github.xepozz.phplrtplugin.psi.PhplrtIdentifier
import com.github.xepozz.phplrtplugin.psi.PhplrtNamedElement
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenReference
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue

class PhplrtPsiImplUtil {
    companion object {
        @JvmStatic
        fun getNameIdentifier(element: PhplrtNamedElement): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("1getNameIdentifier: $keyNode of ${element.node}, $element res: ${keyNode?.psi?.text}")
            return keyNode?.psi
        }

        @JvmStatic
        fun getNameIdentifier(element: PhplrtTokenReference): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("2getNameIdentifier: $keyNode of ${element.node}, $element res: ${keyNode?.psi?.text}")
            return keyNode?.psi
        }

        @JvmStatic
        fun getNameIdentifier(element: PhplrtIdentifier): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.LITERAL)
//            println("3getNameIdentifier: $keyNode of ${element.node}, $element res: ${keyNode?.psi?.text}")
            return keyNode?.psi
        }

        @JvmStatic
        fun getName(element: PhplrtNamedElement): String? {
            val valueNode = getNameIdentifier(element)
            println("getName: ${valueNode?.text} ${valueNode?.textRange} of ${element.node}")
            return valueNode?.text
        }

        @JvmStatic
        fun setName(element: PhplrtNamedElement, name: String): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER);
            if (keyNode != null) {
                val property = PhplrtElementFactory.createTokenDeclaration(element.project, name);
                println("create new TokenDeclaration: $name of ${element.node}, res: $property")
                val newKeyNode = property?.firstChild?.node ?: return null;
                element.node.replaceChild(keyNode, newKeyNode);
            }
            println("setName: $name of ${element.node}")

            return element
        }
    }
}