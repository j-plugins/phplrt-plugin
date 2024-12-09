package com.github.xepozz.phplrtplugin.support

import com.github.xepozz.phplrtplugin.language.PhplrtLexerAdapter
import com.github.xepozz.phplrtplugin.psi.PhplrtTokenSets
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet

class PhplrtFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner() = DefaultWordsScanner(
        PhplrtLexerAdapter(),
        PhplrtTokenSets.IDENTIFIERS,
        PhplrtTokenSets.COMMENTS,
        TokenSet.EMPTY,
        PhplrtTokenSets.OPERATORS,
        PhplrtTokenSets.KEYWORDS,
    )

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is PsiNamedElement
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }


    override fun getType(element: PsiElement): String {
        return ""
    }


    override fun getDescriptiveName(element: PsiElement): String {
        return ""
    }


    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {

        return "element ${element.text}"
    }
}