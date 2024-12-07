package com.github.xepozz.phplrtplugin.psi.impl

import com.github.xepozz.phplrtplugin.psi.PhplrtNamedElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class PhplrtNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), PhplrtNamedElement