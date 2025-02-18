package com.github.xepozz.phplrt.language.psi.stub

import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement
import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class PhplrtNamedStubbedPsiElementBase<T : StubElement<*>> :
    StubBasedPsiElementBase<T>, PsiElement,
    PhplrtNamedElement {
    constructor(stub: T, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)
}

