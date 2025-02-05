package com.github.xepozz.phplrt.support

import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class PhplrtStructureViewModel(editor: Editor?, psiFile: PsiFile) :
    StructureViewModelBase(psiFile, editor, PhplrtStructureViewElement(psiFile)), ElementInfoProvider {
    override fun getSorters(): Array<Sorter?> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return false
//        return element.value is SimpleProperty
    }

//    protected override fun getSuitableClasses(): Array<Class<*>> {
//        return arrayOf<java.lang.Class<*>>(SimpleProperty::class.java)
//    }
}