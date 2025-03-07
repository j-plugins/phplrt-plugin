package com.github.xepozz.phplrt.language

import com.github.xepozz.phplrt.PhplrtIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import java.io.Serializable

class PhplrtFileType private constructor() : LanguageFileType(PhplrtLanguage.INSTANCE), Serializable {
    override fun getName() = "Phplrt File"

    override fun getDescription() = "Phplrt language file"

    override fun getDefaultExtension() = "pp2"

    override fun getIcon() = PhplrtIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = PhplrtFileType()
    }
}