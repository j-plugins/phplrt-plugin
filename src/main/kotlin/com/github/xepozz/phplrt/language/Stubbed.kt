package com.github.xepozz.phplrt.language

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class PhplrtStubbedPsiElementBase<T : StubElement<*>> : StubBasedPsiElementBase<T>, PsiElement {
    constructor(stub: T, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)

    override fun toString(): String {
        return elementType.toString()
    }
}
