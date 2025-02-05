// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PhplrtMetaDecl extends PhplrtNamedElement, StubBasedPsiElement<PhplrtMetaDeclarationStub> {

  @Nullable
  PhplrtIdentifier getIdentifier();

  @NotNull String getName();

  @NotNull String getValue();

  @Nullable PsiElement getNameIdentifier();

  boolean isToken();

  boolean isSkip();

  boolean isPragma();

}
