package com.github.xepozz.phplrt.ide.index

import com.github.xepozz.phplrt.language.psi.PhplrtFile
import com.github.xepozz.phplrt.psi.PhplrtMetaDecl
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileContent
import com.intellij.util.indexing.ID
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.VoidDataExternalizer
import java.io.Serializable

private typealias TokenIndexType = Void

data class TokenStored(
    val key: String,
    val value: String,
    val offset: Int,
) : Serializable


class PhplrtTokenIndex : AbstractIndex<TokenIndexType>() {
    companion object {
        val key = ID.create<String, TokenIndexType>("phplrt.tokens.names")
    }

    override fun getName() = key

    override fun getInputFilter() = FileBasedIndex.InputFilter { file -> file.name.endsWith(".pp2") }

    override fun getIndexer() = DataIndexer<String, TokenIndexType, FileContent> { content ->
        val psiFile = content.psiFile as? PhplrtFile ?: return@DataIndexer emptyMap()
        val result = mutableMapOf<String, Void?>()

        val metaTokens = PsiTreeUtil.findChildrenOfType(psiFile, PhplrtMetaDecl::class.java)
        for (metaDecl in metaTokens) {
            if (metaDecl.isToken) {
                result[metaDecl.name]
                result.put(metaDecl.name, null)
            }
        }

        return@DataIndexer result
    }

    override fun getValueExternalizer(): DataExternalizer<TokenIndexType> {
        return VoidDataExternalizer()
    }
}