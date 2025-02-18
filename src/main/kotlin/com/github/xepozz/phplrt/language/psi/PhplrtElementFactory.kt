package com.github.xepozz.phplrt.language.psi

import com.github.xepozz.phplrt.language.PhplrtFileType
import com.github.xepozz.phplrt.psi.PhplrtMetaDecl
import com.github.xepozz.phplrt.psi.PhplrtRuleDecl
import com.github.xepozz.phplrt.psi.PhplrtTokenReference
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

object PhplrtElementFactory {
    fun createMetaDeclaration(project: Project, name: String): PhplrtMetaDecl? {
        val file = createFile(project, name)
        return file.firstChild as PhplrtMetaDecl
    }

    fun createTokenReference(project: Project, name: String): PhplrtTokenReference? {
        val file = createFile(project, name)
        return file.firstChild as PhplrtTokenReference
    }
    fun createRuleDeclaration(project: Project, name: String): PhplrtRuleDecl? {
        val file = createFile(project, name)
        return file.firstChild as PhplrtRuleDecl
    }

    fun createFile(project: Project, text: String): PhplrtFile {
        val name = "dummy.pp2"
        return PsiFileFactory.getInstance(project)
            .createFileFromText(name, PhplrtFileType.INSTANCE, text) as PhplrtFile
    }
}