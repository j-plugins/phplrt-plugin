package com.github.xepozz.phplrt.psi

import com.github.xepozz.phplrt.language.PhplrtFileType
import com.github.xepozz.phplrt.language.PhplrtLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class PhplrtFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PhplrtLanguage.INSTANCE) {
    override fun getFileType() = PhplrtFileType.INSTANCE

    override fun toString() = "Phplrt File"
}