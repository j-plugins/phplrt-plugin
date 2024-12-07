package com.github.xepozz.phplrtplugin.language

import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class PhplrtSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return PhplrtLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            PhplrtTypes.IDENTIFIER -> IDENTIFIER_KEYS
            PhplrtTypes.TOKEN_REFERENCE -> IDENTIFIER_KEYS
            PhplrtTypes.RULE_REFERENCE -> IDENTIFIER_KEYS
            PhplrtTypes.DOUBLE_COLON -> COLON_KEYS
            PhplrtTypes.TOKEN -> KEY_KEYS
            PhplrtTypes.SKIP -> KEY_KEYS
            PhplrtTypes.VALUE -> VALUE_KEYS
            PhplrtTypes.COMMENT -> COMMENT_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val SQUARES = TextAttributesKey.createTextAttributesKey("PHPLRT_IDENTIFIER", DefaultLanguageHighlighterColors.BRACKETS)
        val COLON = TextAttributesKey.createTextAttributesKey("PHPLRT_IDENTIFIER", DefaultLanguageHighlighterColors.SEMICOLON)
        val IDENTIFIER = TextAttributesKey.createTextAttributesKey("PHPLRT_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val KEY = TextAttributesKey.createTextAttributesKey("PHPLRT_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE = TextAttributesKey.createTextAttributesKey("PHPLRT_VALUE", DefaultLanguageHighlighterColors.STRING)
        val BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey("PHPLRT_VALUE", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        val COMMENT =
            TextAttributesKey.createTextAttributesKey("PHPLRT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("PHPLRT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)


        private val BAD_CHAR_KEYS = arrayOf<TextAttributesKey>(BAD_CHARACTER)
        private val KEY_KEYS = arrayOf<TextAttributesKey>(KEY)
        private val IDENTIFIER_KEYS = arrayOf<TextAttributesKey>(IDENTIFIER)
        private val VALUE_KEYS = arrayOf<TextAttributesKey>(VALUE)
        private val COLON_KEYS = arrayOf<TextAttributesKey>(COLON)
        private val BLOCK_COMMENT_KEYS = arrayOf<TextAttributesKey>(BLOCK_COMMENT)
        private val COMMENT_KEYS = arrayOf<TextAttributesKey>(COMMENT)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}