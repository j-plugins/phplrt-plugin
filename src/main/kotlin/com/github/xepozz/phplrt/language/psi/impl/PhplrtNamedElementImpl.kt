package com.github.xepozz.phplrt.language.psi.impl

import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class PhplrtNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), PhplrtNamedElement