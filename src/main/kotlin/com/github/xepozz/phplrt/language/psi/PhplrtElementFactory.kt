package com.github.xepozz.phplrt.language.psi

import com.github.xepozz.phplrt.language.PhplrtFileType
import com.github.xepozz.phplrt.psi.PhplrtTokenReference
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

object PhplrtElementFactory {
    fun createTokenDeclaration(project: Project, name: String): PhplrtTokenReference? {
        val file = createFile(project, name)
        return file.firstChild as PhplrtTokenReference
    }

    fun createTokenReference(project: Project, name: String): PhplrtTokenReference? {
        val file = createFile(project, name)
        return file.firstChild as PhplrtTokenReference
    }

    fun createFile(project: Project, text: String): PhplrtFile {
        val name = "dummy.pp2"
        return PsiFileFactory.getInstance(project)
            .createFileFromText(name, PhplrtFileType.INSTANCE, text) as PhplrtFile
    }
}