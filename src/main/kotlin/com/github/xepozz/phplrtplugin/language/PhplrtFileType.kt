package com.github.xepozz.phplrtplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class PhplrtFileType private constructor() : LanguageFileType(PhplrtLanguage.INSTANCE) {
     override fun getName(): String {
        return "Phplrt File"
    }

     override fun getDescription(): String {
        return "Phplrt language file"
    }

     override fun getDefaultExtension(): String {
        return "pp2"
    }

     override fun getIcon(): Icon {
        return Icons.FILE
    }

    companion object {
        val INSTANCE = PhplrtFileType()
    }
}