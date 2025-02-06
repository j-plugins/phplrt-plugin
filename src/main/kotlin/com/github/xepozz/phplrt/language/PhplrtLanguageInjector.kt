package com.github.xepozz.phplrt.language

import com.github.xepozz.phplrt.psi.PhplrtCode
import com.github.xepozz.phplrt.psi.PhplrtTypes
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost

class PhplrtLanguageInjector : MultiHostInjector {
    val phpLanguage = Language.findLanguageByID("PHP")
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, element: PsiElement) {
        if (phpLanguage == null) return

        when (element) {
            is PhplrtCode -> {
                if (element.textLength > 0) {
                    val code = element.node.findChildByType(PhplrtTypes.INLINE_CODE) ?: return

                    val codeRangeInParent = element.textRange.intersection(code.textRange).shiftLeft(element.textOffset)
                    registrar.startInjecting(phpLanguage)
                        .addPlace("<?php ", null, element, codeRangeInParent)
                        .doneInjecting()
                }
            }
        }
    }

    override fun elementsToInjectIn(): List<Class<out PsiElement>> {
        return listOf(PsiLanguageInjectionHost::class.java)
    }
}