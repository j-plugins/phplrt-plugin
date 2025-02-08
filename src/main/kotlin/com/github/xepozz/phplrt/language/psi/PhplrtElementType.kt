package com.github.xepozz.phplrt.language.psi

import com.github.xepozz.phplrt.language.PhplrtLanguage
import com.intellij.psi.tree.IElementType


class PhplrtElementType(debugName: String) : IElementType("PhplrtElementType($debugName)", PhplrtLanguage.INSTANCE)
