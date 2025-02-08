package com.github.xepozz.phplrt.ide.structureView

import com.intellij.ide.structureView.TreeBasedStructureViewBuilder
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

internal class PhplrtStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile) = Builder(psiFile)

    internal class Builder(val psiFile: PsiFile) : TreeBasedStructureViewBuilder() {
        override fun createStructureViewModel(editor: Editor?) = PhplrtStructureViewModel(editor, psiFile)
    }
}