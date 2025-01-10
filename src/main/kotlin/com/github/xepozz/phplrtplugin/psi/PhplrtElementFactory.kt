package com.github.xepozz.phplrtplugin.psi

import com.github.xepozz.phplrtplugin.language.PhplrtFileType

object PhplrtElementFactory {
    fun createTokenDeclaration(project: com.intellij.openapi.project.Project, name: String): PhplrtTokenReference? {
        val file = createFile(project, name)
        return file.firstChild as PhplrtTokenReference
    }

    fun createFile(project: com.intellij.openapi.project.Project, text: String): PhplrtFile {
        val name = "dummy.pp2"
        return com.intellij.psi.PsiFileFactory.getInstance(project)
            .createFileFromText(name, PhplrtFileType.INSTANCE, text) as PhplrtFile
    }
}