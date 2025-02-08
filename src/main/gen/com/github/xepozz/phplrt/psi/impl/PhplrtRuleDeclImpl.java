// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi.impl;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static com.github.xepozz.phplrt.psi.PhplrtTypes.*;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.xepozz.phplrt.psi.*;

public class PhplrtRuleDeclImpl extends ASTWrapperPsiElement implements PhplrtRuleDecl {

  public PhplrtRuleDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PhplrtVisitor visitor) {
    visitor.visitRuleDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PhplrtVisitor) accept((PhplrtVisitor)visitor);
    else super.accept(visitor);
  }

    @Override
    @Nullable
    public PhplrtCode getCode() {
        return PsiTreeUtil.getChildOfType(this, PhplrtCode.class);
    }

  @Override
  @Nullable
  public PhplrtExpressions getExpressions() {
    return PsiTreeUtil.getChildOfType(this, PhplrtExpressions.class);
  }

  @Override
  @NotNull
  public PhplrtIdentifier getIdentifier() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, PhplrtIdentifier.class));
  }

  @Override
  @Nullable
  public PhplrtRuleModifier getRuleModifier() {
    return PsiTreeUtil.getChildOfType(this, PhplrtRuleModifier.class);
  }

}
