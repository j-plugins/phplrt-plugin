package com.github.xepozz.phplrt.language

import com.github.xepozz.phplrt.PhplrtIcons
import com.intellij.openapi.fileTypes.LanguageFileType

class PhplrtFileType private constructor() : LanguageFileType(PhplrtLanguage.INSTANCE) {
    override fun getName() = "Phplrt File"

    override fun getDescription() = "Phplrt language file"

    override fun getDefaultExtension() = "pp2"

    override fun getIcon() = PhplrtIcons.FILE

    companion object {
        val INSTANCE = PhplrtFileType()
    }
}