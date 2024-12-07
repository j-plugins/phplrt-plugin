package com.github.xepozz.phplrtplugin.language

import com.github.xepozz.phplrtplugin.psi.PhplrtFile
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenSets
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

internal class PhplrtParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer {
        return PhplrtLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return PhplrtTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project?): PsiParser {
        return PhplrtParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return PhplrtFile(viewProvider)
    }

    override fun createElement(node: ASTNode): PsiElement {
        return PhplrtTypes.Factory.createElement(node)
    }

    companion object {
        val FILE = IFileElementType(PhplrtLanguage.INSTANCE)
    }
}