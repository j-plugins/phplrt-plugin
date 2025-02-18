// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement;
import com.intellij.psi.StubBasedPsiElement;
import com.github.xepozz.phplrt.language.psi.stub.PhplrtRuleDeclarationStub;
import com.intellij.psi.PsiReference;

public interface PhplrtRuleDecl extends PhplrtNamedElement, StubBasedPsiElement<PhplrtRuleDeclarationStub> {

  @Nullable
  PhplrtCode getCode();

  @Nullable
  PhplrtExpressions getExpressions();

  @NotNull
  PhplrtIdentifier getIdentifier();

  @NotNull String getName();

  @Nullable PsiElement setName(@NotNull String name);

  @Nullable PsiElement getNameIdentifier();

  @Nullable PsiReference getReference();

  @NotNull PsiReference @NotNull [] getReferences();

}
