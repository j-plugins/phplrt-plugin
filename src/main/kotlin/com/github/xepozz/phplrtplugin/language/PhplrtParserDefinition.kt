package com.github.xepozz.phplrtplugin.language

import com.github.xepozz.phplrtplugin.psi.PhplrtFile
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenSets
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

internal class PhplrtParserDefinition : ParserDefinition {
    override fun createLexer(project: Project) = PhplrtLexerAdapter()

    override fun getCommentTokens() = PhplrtTokenSets.COMMENTS

    override fun getWhitespaceTokens(): TokenSet = PhplrtTokenSets.WHITESPACES

    override fun getStringLiteralElements(): TokenSet = PhplrtTokenSets.STRING_LITERALS

    override fun createParser(project: Project?) = PhplrtParser()

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider) = PhplrtFile(viewProvider)

    override fun createElement(node: ASTNode): PsiElement = PhplrtTypes.Factory.createElement(node)

    companion object {
        val FILE = IFileElementType(PhplrtLanguage.INSTANCE)
    }
}