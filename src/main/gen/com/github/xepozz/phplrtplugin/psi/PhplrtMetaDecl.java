// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrtplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;

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
