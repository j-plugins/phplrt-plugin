package com.github.xepozz.phplrt.language

import com.github.xepozz.phplrt.psi.PhplrtIdentifier
import com.github.xepozz.phplrt.psi.PhplrtMetaDecl
import com.github.xepozz.phplrt.psi.PhplrtRuleDecl
import com.github.xepozz.phplrt.psi.PhplrtRuleReference
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement

class PhplrtAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is PhplrtIdentifier -> {
                val attributes = when {
                    element.parent is PhplrtRuleDecl -> PHPLRT_RULE_DECLARATION
                    element.parent is PhplrtMetaDecl -> PHPLRT_META_DECLARATION
                    element.parent is PhplrtRuleReference -> PHPLRT_RULE_REFERENCE
                    else -> DefaultLanguageHighlighterColors.LOCAL_VARIABLE
                }
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange)
                    .textAttributes(attributes)
                    .create()
            }
        }
    }

    companion object {
        val PHPLRT_RULE_DECLARATION = TextAttributesKey.createTextAttributesKey(
            "PHPLRT_RULE_DECLARATION_IDENTIFIER",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION,
        )
        val PHPLRT_RULE_REFERENCE = TextAttributesKey.createTextAttributesKey(
            "PHPLRT_RULE_REFERENCE_IDENTIFIER",
            DefaultLanguageHighlighterColors.FUNCTION_CALL,
        )
        val PHPLRT_META_DECLARATION = TextAttributesKey.createTextAttributesKey(
            "PHPLRT_META_DECLARATION_IDENTIFIER",
            DefaultLanguageHighlighterColors.PARAMETER,
        )
    }
}