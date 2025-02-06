// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface PhplrtExpression extends PsiElement {

    @Nullable
    PhplrtExpressions getExpressions();

    @Nullable
    PhplrtQuantifier getQuantifier();

  @Nullable
  PhplrtRuleReference getRuleReference();

  @Nullable
  PhplrtTokenReference getTokenReference();

}
