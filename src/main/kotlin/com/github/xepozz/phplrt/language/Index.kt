package com.github.xepozz.phplrt.language

import com.github.xepozz.phplrt.psi.PhplrtFile
import com.github.xepozz.phplrt.psi.PhplrtMetaDecl
import com.github.xepozz.phplrt.psi.PhplrtMetaDeclarationStub
import com.github.xepozz.phplrt.psi.PhplrtNamedElement
import com.github.xepozz.phplrt.psi.impl.PhplrtMetaDeclImpl
import com.intellij.lang.ASTNode
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

class PhplrtTokenIndex : StringStubIndexExtension<PhplrtNamedElement>() {
    companion object {
        const val VERSION = 1
        val KEY = StubIndexKey.createIndexKey<String, PhplrtNamedElement>("phplrt.token.name")
    }

    override fun getVersion(): Int {
        return VERSION
    }

    override fun getKey() = KEY
}

class PhplrtFileStub(file: PhplrtFile?) : PsiFileStubImpl<PhplrtFile>(file)


abstract class PhplrtStubElementType<S : StubElement<T>, T : PsiElement?>(debugName: String) :
    IStubElementType<S, T>(debugName, PhplrtLanguage.INSTANCE) {
    override fun getExternalId(): String {
        return "Phplrt." + super.toString()
    }
}

abstract class PhplrtNamedStubElementType<S : NamedStubBase<T>, T : PhplrtNamedElement>
    (debugName: String) : PhplrtStubElementType<S, T>(debugName) {
    override fun indexStub(stub: S, sink: IndexSink) {
        val name = stub.name
        if (name != null) {
            sink.occurrence(PhplrtTokenIndex.KEY, name)
        }
    }
}


class PhplrtFileElementType(language: PhplrtLanguage?) : IStubFileElementType<PhplrtFileStub>(language) {
    override fun getStubVersion() = VERSION

    override fun serialize(stub: PhplrtFileStub, dataStream: StubOutputStream) = Unit

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?) = PhplrtFileStub(null)

//    override fun getExternalId(): String = super.externalId + ".FILE"

    companion object {
        @JvmField
        val INSTANCE = PhplrtFileElementType(PhplrtLanguage.INSTANCE)

        private const val VERSION = 3
    }
}

class PhplrtTokenDeclarationStubElementType(debugName: String) :
    PhplrtNamedStubElementType<PhplrtMetaDeclarationStub, PhplrtMetaDecl>(debugName) {
    override fun serialize(stub: PhplrtMetaDeclarationStub, dataStream: StubOutputStream) =
        dataStream.writeName(stub.name)

    override fun shouldCreateStub(node: ASTNode?) = node?.psi is PhplrtMetaDecl

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?) =
        PhplrtMetaDeclarationStub(parentStub, this, dataStream.readName())

    override fun createPsi(stub: PhplrtMetaDeclarationStub) = PhplrtMetaDeclImpl(stub, this)

    override fun createStub(psi: PhplrtMetaDecl, parentStub: StubElement<*>) =
        PhplrtMetaDeclarationStub(parentStub, this, psi.name)
}

