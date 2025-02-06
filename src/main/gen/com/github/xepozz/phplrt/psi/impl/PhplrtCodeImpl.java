// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi.impl;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static com.github.xepozz.phplrt.psi.PhplrtTypes.*;

import com.github.xepozz.phplrt.language.psi.impl.PhplrtCodeBaseImpl;
import com.github.xepozz.phplrt.psi.*;

public class PhplrtCodeImpl extends PhplrtCodeBaseImpl implements PhplrtCode {

    public PhplrtCodeImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PhplrtVisitor visitor) {
        visitor.visitCode(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof PhplrtVisitor) accept((PhplrtVisitor) visitor);
        else super.accept(visitor);
    }

}
