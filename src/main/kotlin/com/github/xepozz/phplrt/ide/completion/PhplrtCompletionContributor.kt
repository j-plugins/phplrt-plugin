package com.github.xepozz.phplrt.ide.completion

import com.github.xepozz.phplrt.PhplrtIcons
import com.github.xepozz.phplrt.ide.index.PhplrtTokenIndex
import com.github.xepozz.phplrt.psi.PhplrtIdentifier
import com.github.xepozz.phplrt.psi.PhplrtTypes
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
                    arrayOf("token", "skip", "pragma", "include")
                        .forEach {
                            result.addElement(
                                LookupElementBuilder.create(it)
                                    .withIcon(PhplrtIcons.FILE)
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

                    fileBasedIndex.processAllKeys(PhplrtTokenIndex.Companion.key, {
                        result.addElement(
                            LookupElementBuilder.create(it)
                                .withIcon(PhplrtIcons.FILE)
                        )
                        true
                    }, parameters.position.project)
                }
            }
        )
    }
}