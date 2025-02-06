// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi.impl;

import com.github.xepozz.phplrt.psi.PhplrtQuantifier;
import com.github.xepozz.phplrt.psi.PhplrtVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class PhplrtQuantifierImpl extends ASTWrapperPsiElement implements PhplrtQuantifier {

    public PhplrtQuantifierImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PhplrtVisitor visitor) {
        visitor.visitQuantifier(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof PhplrtVisitor) accept((PhplrtVisitor) visitor);
        else super.accept(visitor);
    }

}
