package com.github.xepozz.phplrtplugin.support

import com.github.xepozz.phplrtplugin.psi.PhplrtIdentifier
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenReference
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenType
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext

class TokenReferenceReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement()
//                .withParent(
//                    PlatformPatterns.psiElement(PhplrtTypes.LITERAL)
//                        .withParent(PhplrtIdentifier::class.java)
//                )
            ,
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    println("PhplrtIdentifier.getReferencesByElement\n ${element}, ${element::class}\n")
                    return PsiReference.EMPTY_ARRAY
                }
            }
        )
//        registrar.registerReferenceProvider(
//            PlatformPatterns.psiElement(PhplrtTypes.IDENTIFIER),
//            object : PsiReferenceProvider() {
//                override fun getReferencesByElement(
//                    element: PsiElement,
//                    context: ProcessingContext
//                ): Array<PsiReference> {
//                    println("TokenReferenceReferenceContributor.PhplrtTypes.IDENTIFIER\n ${element}\n")
//                    return PsiReference.EMPTY_ARRAY
//                }
//            }
//        )
    }
}