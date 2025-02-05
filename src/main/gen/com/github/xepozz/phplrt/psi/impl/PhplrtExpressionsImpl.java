// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi.impl;

import com.github.xepozz.phplrt.psi.PhplrtExpression;
import com.github.xepozz.phplrt.psi.PhplrtExpressions;
import com.github.xepozz.phplrt.psi.PhplrtOperator;
import com.github.xepozz.phplrt.psi.PhplrtVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PhplrtExpressionsImpl extends ASTWrapperPsiElement implements PhplrtExpressions {

  public PhplrtExpressionsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PhplrtVisitor visitor) {
    visitor.visitExpressions(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PhplrtVisitor) accept((PhplrtVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PhplrtExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PhplrtExpression.class);
  }

  @Override
  @NotNull
  public List<PhplrtOperator> getOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PhplrtOperator.class);
  }

}
