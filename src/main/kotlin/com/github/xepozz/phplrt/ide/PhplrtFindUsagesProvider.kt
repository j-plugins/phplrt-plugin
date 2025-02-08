package com.github.xepozz.phplrt.ide

import com.github.xepozz.phplrt.language.parser.PhplrtLexerAdapter
import com.github.xepozz.phplrt.language.psi.PhplrtTokenSets
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.ElementDescriptionUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.usageView.UsageViewLongNameLocation

class PhplrtFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner() = DefaultWordsScanner(
        PhplrtLexerAdapter(),
        PhplrtTokenSets.IDENTIFIERS,
        PhplrtTokenSets.COMMENTS,
        PhplrtTokenSets.STRING_LITERALS,
//        TokenSet.EMPTY,
        PhplrtTokenSets.OPERATORS,
        PhplrtTokenSets.KEYWORDS,
    )

    override fun canFindUsagesFor(psiElement: PsiElement) = psiElement is PsiNamedElement

    override fun getHelpId(psiElement: PsiElement) = null

    override fun getType(element: PsiElement) =
        element.javaClass.canonicalName
//        ElementDescriptionUtil.getElementDescription(element, UsageViewTypeLocation.INSTANCE);

    override fun getDescriptiveName(element: PsiElement) =
        ElementDescriptionUtil.getElementDescription(element, UsageViewLongNameLocation.INSTANCE)

    override fun getNodeText(element: PsiElement, useFullName: Boolean) =
        StringUtil.unquoteString(element.text)
//        ElementDescriptionUtil.getElementDescription(element, UsageViewNodeTextLocation.INSTANCE);
}