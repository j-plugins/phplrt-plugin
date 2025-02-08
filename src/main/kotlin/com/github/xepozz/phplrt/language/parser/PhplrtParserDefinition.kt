package com.github.xepozz.phplrt.language.parser

import com.github.xepozz.phplrt.language.PhplrtLanguage
import com.github.xepozz.phplrt.psi.PhplrtFile
import com.github.xepozz.phplrt.psi.PhplrtTokenSets
import com.github.xepozz.phplrt.psi.PhplrtTypes
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

    override fun getWhitespaceTokens(): TokenSet = TokenSet.WHITE_SPACE

    override fun getStringLiteralElements(): TokenSet = PhplrtTokenSets.STRING_LITERALS

    override fun createParser(project: Project?) = PhplrtParser()

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider) = PhplrtFile(viewProvider)

    override fun createElement(node: ASTNode): PsiElement = PhplrtTypes.Factory.createElement(node)

    companion object {
        val FILE = IFileElementType(PhplrtLanguage.Companion.INSTANCE)
    }
}