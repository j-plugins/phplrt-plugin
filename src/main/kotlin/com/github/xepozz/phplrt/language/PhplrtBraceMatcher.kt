package com.github.xepozz.phplrt.language

import com.github.xepozz.phplrt.psi.PhplrtTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class PhplrtBraceMatcher : PairedBraceMatcher {
    private val bracePairs = arrayOf(
        BracePair(PhplrtTypes.LEFT_ARROW, PhplrtTypes.RIGHT_ARROW, true),
        BracePair(PhplrtTypes.PARENTHESES_OPEN, PhplrtTypes.PARENTHESES_CLOSE, true),
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