package com.github.xepozz.phplrtplugin.language

import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class PhplrtSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = PhplrtLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType) = when (tokenType) {
        PhplrtTypes.IDENTIFIER -> IDENTIFIER_KEYS
        PhplrtTypes.TOKEN_REFERENCE -> IDENTIFIER_KEYS
        PhplrtTypes.RULE_REFERENCE -> IDENTIFIER_KEYS
        PhplrtTypes.SEMICOLON -> SEMICOLON_KEYS
        PhplrtTypes.DOUBLE_COLON -> BRACES_KEYS
        PhplrtTypes.LEFT_ARROW -> BRACES_KEYS
        PhplrtTypes.RIGHT_ARROW -> BRACES_KEYS
        PhplrtTypes.SQUARES -> BRACKETS_KEYS
        PhplrtTypes.RULE_MODIFIER -> KEY_KEYS
        PhplrtTypes.TOKEN -> KEY_KEYS
        PhplrtTypes.SKIP -> KEY_KEYS
        PhplrtTypes.VALUE -> VALUE_KEYS
        PhplrtTypes.COMMENT -> COMMENT_KEYS
        TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
        else -> EMPTY_KEYS
    }

    companion object {

        private val BAD_CHAR_KEYS = arrayOf(
            HighlighterColors.BAD_CHARACTER,
        )
        private val BRACES_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.BRACES
        )
        private val BRACKETS_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.BRACKETS
        )
        private val KEY_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.KEYWORD
        )
        private val IDENTIFIER_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.IDENTIFIER
        )
        private val VALUE_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.STRING
        )
        private val SEMICOLON_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.SEMICOLON,
        )
        private val BLOCK_COMMENT_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )
        private val COMMENT_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}