package com.github.xepozz.phplrtplugin.psi.impl

import com.github.xepozz.phplrtplugin.psi.PhplrtElementFactory
import com.github.xepozz.phplrtplugin.psi.PhplrtNamedElement
import com.github.xepozz.phplrtplugin.psi.PhplrtRuleReference
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenDecl
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenReference
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue

class PhplrtPsiImplUtil {
    companion object {
        @JvmStatic
        fun getNameIdentifier(element: PhplrtNamedElement): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("getNameIdentifier: $keyNode of ${element.node}, $element res: ${keyNode?.psi?.text}")
            return keyNode?.psi
        }

        @JvmStatic
        fun getValue(element: PhplrtTokenReference): String? {
            val valueNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("valueNode: ${valueNode?.text} of ${element.node}")
            return valueNode?.text
        }

        @JvmStatic
        fun getValue(element: PhplrtRuleReference): String? {
            val valueNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("valueNode: ${valueNode?.text} of ${element.node}")
            return valueNode?.text
        }

        @JvmStatic
        fun getValue(element: PhplrtNamedElement): String? {
            val valueNode = element.node.findChildByType(PhplrtTypes.VALUE)
            println("valueNode: ${valueNode?.text} of ${element.node}")
            return valueNode?.text
        }

        @JvmStatic
        fun getName(element: PhplrtNamedElement): String? {
            val valueNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("getName: ${valueNode?.text} ${valueNode?.textRange} of ${element.node}")
            return valueNode?.text
        }

        @JvmStatic
        fun setName(element: PhplrtNamedElement, name: String): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER);
            if (keyNode != null) {
                val property = PhplrtElementFactory.createTokenDeclaration(element.project, name);
                val newKeyNode = property?.firstChild?.node ?: return null;
                element.node.replaceChild(keyNode, newKeyNode);
            }
            println("setName: $name of ${element.node}")

            return element
        }

        @JvmStatic
        fun setValue(element: PhplrtNamedElement, name: String): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.VALUE);
            if (keyNode != null) {
                val property = PhplrtElementFactory.createTokenDeclaration(element.project, name);
                val newKeyNode = property?.lastChild?.node ?: return null;
                element.node.replaceChild(keyNode, newKeyNode);
            }
            println("setName: $name of ${element.node}")

            return element
        }
    }
}