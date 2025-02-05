// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrtplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.xepozz.phplrtplugin.psi.PhplrtTypes.*;
import com.github.xepozz.phplrtplugin.psi.*;

public class PhplrtTokenReferenceImpl extends PhplrtNamedElementImpl implements PhplrtTokenReference {

  public PhplrtTokenReferenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PhplrtVisitor visitor) {
    visitor.visitTokenReference(this);
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

  @Override
  public @NotNull String getName() {
    return PhplrtPsiImplUtil.getName(this);
  }

  @Override
  public @Nullable PsiElement setName(@NotNull String name) {
    return PhplrtPsiImplUtil.setName(this, name);
  }

  @Override
  public @Nullable PsiElement getNameIdentifier() {
    return PhplrtPsiImplUtil.getNameIdentifier(this);
  }

}
