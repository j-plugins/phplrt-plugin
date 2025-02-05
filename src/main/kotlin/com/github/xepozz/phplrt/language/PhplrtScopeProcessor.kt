package com.github.xepozz.phplrt.language

import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor

class PhplrtScopeProcessor : PsiScopeProcessor {
    override fun execute(element: PsiElement, state: ResolveState): Boolean {
        println("psi scope $element $state")
        return false
    }
}