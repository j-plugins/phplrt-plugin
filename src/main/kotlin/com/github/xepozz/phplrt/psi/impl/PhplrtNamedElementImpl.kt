package com.github.xepozz.phplrt.psi.impl

import com.github.xepozz.phplrt.psi.PhplrtNamedElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class PhplrtNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), PhplrtNamedElement