package com.github.xepozz.phplrt.ide.structureView

import com.github.xepozz.phplrt.language.psi.PhplrtFile
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement
import com.github.xepozz.phplrt.psi.PhplrtMetaDecl
import com.github.xepozz.phplrt.psi.PhplrtRuleDecl
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class PhplrtStructureViewElement(val item: PsiElement) : SortableTreeElement, PsiTreeElementBase<PsiElement>(item) {
    override fun getAlphaSortKey(): String {
        return item.text ?: ""
    }

    override fun getChildrenBase(): Collection<StructureViewTreeElement> {
        val file = item as? PhplrtFile ?: return emptySet()

        val collection = mutableListOf<PsiElement>()
        collection.addAll(PsiTreeUtil.findChildrenOfType(file, PhplrtMetaDecl::class.java))
        collection.addAll(PsiTreeUtil.findChildrenOfType(file, PhplrtRuleDecl::class.java))

        return collection.map { PhplrtStructureViewElement(it) }
    }

    override fun getPresentableText(): String {
        return when (item) {
            is PhplrtFile -> "Phplrt File"
            is PhplrtMetaDecl -> item.name ?: "Unknown meta declaration"
            is PhplrtRuleDecl -> item.identifier.text
            is PhplrtNamedElement -> item.name ?: "Unknown phplrt token"
            else -> "Unknown"
        }
    }
}