// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi.impl;

import com.github.xepozz.phplrt.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PhplrtMetaDeclImpl extends PhplrtMetaDeclarationBaseImpl implements PhplrtMetaDecl {

  public PhplrtMetaDeclImpl(@NotNull PhplrtMetaDeclarationStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public PhplrtMetaDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PhplrtVisitor visitor) {
    visitor.visitMetaDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PhplrtVisitor) accept((PhplrtVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PhplrtIdentifier getIdentifier() {
    return PsiTreeUtil.getChildOfType(this, PhplrtIdentifier.class);
  }

  @Override
  public @NotNull String getName() {
    return PhplrtPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull String getValue() {
    return PhplrtPsiImplUtil.getValue(this);
  }

  @Override
  public @Nullable PsiElement getNameIdentifier() {
    return PhplrtPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public boolean isToken() {
    return PhplrtPsiImplUtil.isToken(this);
  }

  @Override
  public boolean isSkip() {
    return PhplrtPsiImplUtil.isSkip(this);
  }

  @Override
  public boolean isPragma() {
    return PhplrtPsiImplUtil.isPragma(this);
  }

}
