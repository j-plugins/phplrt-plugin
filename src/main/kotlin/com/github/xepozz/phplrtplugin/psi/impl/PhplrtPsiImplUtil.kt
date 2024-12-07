package com.github.xepozz.phplrtplugin.psi.impl

import com.github.xepozz.phplrtplugin.psi.PhplrtElementFactory
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenDecl
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue

class PhplrtPsiImplUtil {
    companion object {
        @JvmStatic
        fun getNameIdentifier(element: PhplrtTokenDecl): PsiElement? {
            val keyNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("keyNode: $keyNode of ${element.node}")
            return keyNode?.psi
        }

        @JvmStatic
        fun getValue(element: PhplrtTokenDecl): String? {
            val valueNode = element.node.findChildByType(PhplrtTypes.VALUE)
            println("valueNode: $valueNode of ${element.node}")
            return valueNode?.text
        }

        @JvmStatic
        fun getName(element: PhplrtTokenDecl): String {
            println("getName: ${element.node} of ${element.node}")
            return getKey(element)
        }

        @JvmStatic
        fun getKey(element: PhplrtTokenDecl): String {
            val valueNode = element.node.findChildByType(PhplrtTypes.IDENTIFIER)
            println("valueNode: $valueNode of ${element.node}")
            return "valueNode?.text"
        }

        @JvmStatic
        fun setName(element: PhplrtTokenDecl, name: String): PsiElement? {
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
        fun setValue(element: PhplrtTokenDecl, name: String): PsiElement? {
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