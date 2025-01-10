package com.github.xepozz.phplrtplugin.psi

import com.github.xepozz.phplrtplugin.language.PhplrtFileType
import com.github.xepozz.phplrtplugin.language.PhplrtLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class PhplrtFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PhplrtLanguage.INSTANCE) {
    override fun getFileType() = PhplrtFileType.INSTANCE

    override fun toString() = "Phplrt File"
}