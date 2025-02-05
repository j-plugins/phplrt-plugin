// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PhplrtTokenReference extends PhplrtNamedElement {

  @NotNull
  PhplrtIdentifier getIdentifier();

  @NotNull String getName();

  @Nullable PsiElement setName(@NotNull String name);

  @Nullable PsiElement getNameIdentifier();

}
