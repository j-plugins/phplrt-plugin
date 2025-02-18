package com.github.xepozz.phplrt.language

import com.github.xepozz.phplrt.language.psi.PhplrtFile
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement
import com.github.xepozz.phplrt.language.psi.stub.PhplrtMetaDeclarationStub
import com.github.xepozz.phplrt.language.psi.stub.PhplrtRuleDeclarationStub
import com.github.xepozz.phplrt.psi.PhplrtMetaDecl
import com.github.xepozz.phplrt.psi.PhplrtRuleDecl
import com.github.xepozz.phplrt.psi.impl.PhplrtMetaDeclImpl
import com.github.xepozz.phplrt.psi.impl.PhplrtRuleDeclImpl
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.NamedStubBase
import com.intellij.psi.stubs.PsiFileStubImpl
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubIndexKey
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.intellij.psi.tree.IStubFileElementType

class PhplrtStubIndex : StringStubIndexExtension<PhplrtNamedElement>() {
    companion object {
        val KEY = StubIndexKey.createIndexKey<String, PhplrtNamedElement>("phplrt.index")
    }

    override fun getVersion() = 3

    override fun getKey() = KEY
}

class PhplrtFileStub(file: PhplrtFile?) : PsiFileStubImpl<PhplrtFile>(file)


abstract class PhplrtStubElementType<S : StubElement<T>, T : PsiElement?>(debugName: String) :
    IStubElementType<S, T>(debugName, PhplrtLanguage.INSTANCE) {
    override fun getExternalId(): String {
        return "Phplrt." + super.toString()
    }
}

abstract class PhplrtNamedStubElementType<S : NamedStubBase<T>, T : PhplrtNamedElement>(debugName: String) :
    PhplrtStubElementType<S, T>(debugName) {
    override fun indexStub(stub: S, sink: IndexSink) {
        val name = stub.name
        if (name != null) {
            sink.occurrence(PhplrtStubIndex.KEY, name)
        }
    }
}


class PhplrtFileElementType(language: PhplrtLanguage?) : IStubFileElementType<PhplrtFileStub>(language) {
    override fun getStubVersion() = VERSION

    override fun serialize(stub: PhplrtFileStub, dataStream: StubOutputStream) = Unit

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?) = PhplrtFileStub(null)

    override fun getExternalId(): String = "Phplrt"

    companion object {
        @JvmField
        val INSTANCE = PhplrtFileElementType(PhplrtLanguage.INSTANCE)

        private const val VERSION = 3
    }
}

class PhplrtMetaDeclarationStubElementType(debugName: String) :
    PhplrtNamedStubElementType<PhplrtMetaDeclarationStub, PhplrtMetaDecl>(debugName) {
    override fun serialize(stub: PhplrtMetaDeclarationStub, dataStream: StubOutputStream) =
        dataStream.writeName(stub.name)

//    override fun shouldCreateStub(node: ASTNode?) = node?.psi is PhplrtMetaDecl

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?) =
        PhplrtMetaDeclarationStub(parentStub, this, dataStream.readName())

    override fun createPsi(stub: PhplrtMetaDeclarationStub) = PhplrtMetaDeclImpl(stub, this)

    override fun createStub(psi: PhplrtMetaDecl, parentStub: StubElement<*>) =
        PhplrtMetaDeclarationStub(parentStub, this, psi.name)
}


class PhplrtRuleDeclarationStubElementType(debugName: String) :
    PhplrtNamedStubElementType<PhplrtRuleDeclarationStub, PhplrtRuleDecl>(debugName) {
    override fun serialize(stub: PhplrtRuleDeclarationStub, dataStream: StubOutputStream) =
        dataStream.writeName(stub.name)

//    override fun shouldCreateStub(node: ASTNode?) = node?.psi is com.github.xepozz.phplrt.psi.PhplrtRuleDecl

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?) =
        PhplrtRuleDeclarationStub(parentStub, this, dataStream.readName())

    override fun createPsi(stub: PhplrtRuleDeclarationStub) = PhplrtRuleDeclImpl(stub, this)

    override fun createStub(psi: PhplrtRuleDecl, parentStub: StubElement<*>) =
        PhplrtRuleDeclarationStub(parentStub, this, psi.name)
}

