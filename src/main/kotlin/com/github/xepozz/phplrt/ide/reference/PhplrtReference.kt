package com.github.xepozz.phplrt.ide.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

internal class PhplrtReference(element: PsiElement, textRange: TextRange) :
    PsiPolyVariantReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult?> {
        myElement?.project

        println("multiResolve ${element}, ${element.text}")

        return emptyArray()
//        val properties: List<SimpleProperty?> = SimpleUtil.findProperties(project, key)
//        val results: List<ResolveResult?> = ArrayList()
//        for (property in properties) {
//            results.add(PsiElementResolveResult(property))
//        }
//        return results.toArray(kotlin.arrayOfNulls<ResolveResult>(0))
    }
}