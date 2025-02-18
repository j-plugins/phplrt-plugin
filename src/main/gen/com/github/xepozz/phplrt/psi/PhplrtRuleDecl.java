// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement;
import com.intellij.psi.PsiReference;

public interface PhplrtRuleDecl extends PhplrtNamedElement {

  @Nullable
  PhplrtCode getCode();

  @Nullable
  PhplrtExpressions getExpressions();

  @Nullable
  PhplrtIdentifier getIdentifier();

  @Nullable
  PhplrtRuleModifier getRuleModifier();

  @NotNull String getName();

  @Nullable PsiElement setName(@NotNull String name);

  @Nullable PsiElement getNameIdentifier();

  @NotNull PsiReference @NotNull [] getReferences();

}
