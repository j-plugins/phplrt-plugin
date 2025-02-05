package com.github.xepozz.phplrt.psi

import com.github.xepozz.phplrt.language.Icons
import com.github.xepozz.phplrt.support.PhplrtReference
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiExternalReferenceHost
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.NamedStubBase
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef


abstract class PhplrtTokenReferenceBaseImpl :
    PhplrtNamedStubbedPsiElementBase<PhplrtTokenReferenceStub>,
    PhplrtTokenReference, PsiExternalReferenceHost {
    constructor(stub: PhplrtTokenReferenceStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)

    override fun getName(): String {
        val stub = stub
        return if (stub != null) StringUtil.notNullize(stub.name) else this.nameIdentifier!!.text
    }

    override fun getNameIdentifier(): PsiElement? = this.node.psi

    override fun setName(name: String): PsiElement {
        val keyNode = this.node.findChildByType(PhplrtTypes.IDENTIFIER)
        if (keyNode != null) {
            val property = PhplrtElementFactory.createTokenReference(this.project, name)
            println("create new TokenReference: $name of ${this.node}, res: $property")
            val newKeyNode = property?.firstChild?.node ?: return this
            this.node.replaceChild(keyNode, newKeyNode)
        }
        println("setName: $name of ${this.node}")

        return this
    }

    override fun getReference(): PsiReference? {
        return PhplrtReference(this, this.textRange)
    }

    override fun getPresentation(): ItemPresentation? {
        val declaration = this
        return object : ItemPresentation {
            override fun getPresentableText() = declaration.name

            override fun getIcon(unused: Boolean) = Icons.FILE
        }
    }
}

class PhplrtTokenReferenceStub : NamedStubBase<PhplrtTokenReference> {
    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: StringRef?) : super(
        parent,
        elementType,
        name
    )

    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: String?) : super(
        parent,
        elementType,
        name
    )
}