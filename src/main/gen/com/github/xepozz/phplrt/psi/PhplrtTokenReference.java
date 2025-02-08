// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement;

public interface PhplrtTokenReference extends PhplrtNamedElement {

  @NotNull
  PhplrtIdentifier getIdentifier();

  @NotNull String getName();

  @Nullable PsiElement setName(@NotNull String name);

  @Nullable PsiElement getNameIdentifier();

}
