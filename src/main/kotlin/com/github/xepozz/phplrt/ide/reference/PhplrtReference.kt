package com.github.xepozz.phplrt.ide.reference

import com.github.xepozz.phplrt.language.PhplrtStubIndex
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex

//internal class PhplrtReference(val myElement: PhplrtNamedElement) : PsiReferenceBase<PsiElement>(myElement) {
internal class PhplrtReference(val myElement: PhplrtNamedElement) :
    PsiPolyVariantReferenceBase<PsiElement>(myElement), PsiPolyVariantReference {
    init {
        rangeInElement =
            myElement.nameIdentifier?.textRangeInParent ?: myElement.textRange.shiftLeft(myElement.textOffset)
        println("range for: ${myElement.name} is ${rangeInElement}, text: ${myElement.text}")
    }

    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult?> {

        println("multiResolve ${myElement.name}")
        val project = myElement.project
        val result = StubIndex.getElements(
            PhplrtStubIndex.KEY,
            myElement.name!!,
            project,
            GlobalSearchScope.projectScope(project),
            PhplrtNamedElement::class.java,
        )
//        val index = FileBasedIndex.getInstance()
//            .processValues(PhplrtStubIndex)

        println("print scope $result")
        return PsiElementResolveResult.createResults(result)
    }
}