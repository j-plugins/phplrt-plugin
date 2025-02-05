package com.github.xepozz.phplrtplugin.support

import com.github.xepozz.phplrtplugin.language.Icons
import com.github.xepozz.phplrtplugin.psi.PhplrtIdentifier
import com.github.xepozz.phplrtplugin.psi.PhplrtTypes
import com.github.xepozz.phplrtplugin.support.index.PhplrtTokenIndex
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import com.intellij.util.indexing.FileBasedIndex

class PhplrtCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement()
                .afterLeaf(PlatformPatterns.psiElement(PhplrtTypes.META_START)),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    arrayOf("token", "skip", "pragma")
                        .forEach {
                            result.addElement(
                                LookupElementBuilder.create(it)
                                    .withIcon(Icons.FILE)
                            )
                        }
                }
            }
        )

        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement()
                .withParent(PhplrtIdentifier::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val fileBasedIndex = FileBasedIndex.getInstance()

                    fileBasedIndex.processAllKeys(PhplrtTokenIndex.key, {
                        result.addElement(
                            LookupElementBuilder.create(it)
                                .withIcon(Icons.FILE)
                        )
                        true
                    }, parameters.position.project)
                }
            }
        )
    }
}