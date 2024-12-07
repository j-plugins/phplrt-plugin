package com.github.xepozz.phplrtplugin.support

import com.intellij.lang.Commenter

internal class PhplrtCommenter : Commenter {
    public override fun getLineCommentPrefix(): String {
        return "//"
    }

    public override fun getBlockCommentPrefix(): String {
        return "/**"
    }

    public override fun getBlockCommentSuffix(): String? {
        return "*/"
    }

    public override fun getCommentedBlockCommentPrefix(): String? {
        return null
    }

    public override fun getCommentedBlockCommentSuffix(): String? {
        return null
    }
}