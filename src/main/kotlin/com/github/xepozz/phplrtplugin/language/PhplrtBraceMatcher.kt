package com.github.xepozz.phplrtplugin.language

import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class PhplrtBraceMatcher : PairedBraceMatcher {
    private val bracePairs = arrayOf(
        BracePair(PhplrtTypes.PARENTHESES_OPEN, PhplrtTypes.PARENTHESES_CLOSE, false),
        BracePair(PhplrtTypes.DOUBLE_COLON, PhplrtTypes.DOUBLE_COLON, true),
    )

    override fun getPairs() = bracePairs

    override fun isPairedBracesAllowedBeforeType(
        p0: IElementType,
        p1: IElementType?
    ) = true

    override fun getCodeConstructStart(
        file: PsiFile,
        openingBraceOffset: Int
    ): Int = openingBraceOffset

}