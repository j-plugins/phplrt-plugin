// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi.impl;

import com.github.xepozz.phplrt.psi.PhplrtIdentifier;
import com.github.xepozz.phplrt.psi.PhplrtRuleReference;
import com.github.xepozz.phplrt.psi.PhplrtVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

public class PhplrtRuleReferenceImpl extends ASTWrapperPsiElement implements PhplrtRuleReference {

  public PhplrtRuleReferenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PhplrtVisitor visitor) {
    visitor.visitRuleReference(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PhplrtVisitor) accept((PhplrtVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PhplrtIdentifier getIdentifier() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, PhplrtIdentifier.class));
  }

}
