// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi.impl;

import com.github.xepozz.phplrt.psi.PhplrtExpression;
import com.github.xepozz.phplrt.psi.PhplrtRuleReference;
import com.github.xepozz.phplrt.psi.PhplrtTokenReference;
import com.github.xepozz.phplrt.psi.PhplrtVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PhplrtExpressionImpl extends ASTWrapperPsiElement implements PhplrtExpression {

  public PhplrtExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PhplrtVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PhplrtVisitor) accept((PhplrtVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PhplrtRuleReference getRuleReference() {
    return PsiTreeUtil.getChildOfType(this, PhplrtRuleReference.class);
  }

  @Override
  @Nullable
  public PhplrtTokenReference getTokenReference() {
    return PsiTreeUtil.getChildOfType(this, PhplrtTokenReference.class);
  }

}
