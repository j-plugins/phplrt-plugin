package com.github.xepozz.phplrt.ide.reference

import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext

class PhplrtReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PhplrtNamedElement::class.java)
//            PlatformPatterns.psiElement(PhplrtTypes.LITERAL)
//            PlatformPatterns.elementType().tokenSet(PhplrtTokenSets.IDENTIFIERS),
//                .withParent(PlatformPatterns.psiElement(PhplrtTypes.TOKEN_REFERENCE))
            ,
            Provider,
            PsiReferenceRegistrar.HIGHER_PRIORITY
        )
    }

    object Provider : PsiReferenceProvider() {
        override fun getReferencesByElement(
            element: PsiElement,
            context: ProcessingContext
        ): Array<out PsiReference> {
            val element = element as? PhplrtNamedElement ?: return emptyArray()
//            println("rule reference $element")

            return arrayOf(PhplrtReference(element))
        }
    }
}