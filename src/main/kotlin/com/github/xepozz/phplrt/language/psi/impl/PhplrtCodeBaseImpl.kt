package com.github.xepozz.phplrt.language.psi.impl

import com.github.xepozz.phplrt.psi.PhplrtCode
import com.github.xepozz.phplrt.psi.PhplrtTypes
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.impl.source.tree.LeafElement

abstract class PhplrtCodeBaseImpl : ASTWrapperPsiElement, PhplrtCode, PsiLanguageInjectionHost {
    constructor(node: ASTNode) : super(node)

    override fun getPresentation() = PresentationData(text, null, getIcon(0), null)

    override fun getIcon(flags: Int) = AllIcons.Nodes.Console

    override fun isValidHost() = true

    override fun updateText(newText: String): PsiLanguageInjectionHost? {
        val keyNode = this.node.findChildByType(PhplrtTypes.INLINE_CODE) as? LeafElement ?: return null
        keyNode.replaceWithText(newText)

        return this
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return LiteralTextEscaper.createSimple(this, true)
    }
}