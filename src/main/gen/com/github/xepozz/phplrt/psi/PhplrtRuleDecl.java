// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PhplrtRuleDecl extends PsiElement {

  @Nullable
  PhplrtExpressions getExpressions();

  @NotNull
  PhplrtIdentifier getIdentifier();

  @Nullable
  PhplrtRuleModifier getRuleModifier();

}
