package com.github.xepozz.phplrtplugin.psi

import com.github.xepozz.phplrtplugin.language.PhplrtLanguage
import com.intellij.psi.tree.IElementType


class PhplrtElementType(debugName: String) : IElementType(debugName, PhplrtLanguage.INSTANCE) {
}