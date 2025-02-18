// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement;
import com.intellij.psi.StubBasedPsiElement;
import com.github.xepozz.phplrt.language.psi.stub.PhplrtMetaDeclarationStub;
import com.intellij.psi.PsiReference;

public interface PhplrtMetaDecl extends PhplrtNamedElement, StubBasedPsiElement<PhplrtMetaDeclarationStub> {

  @Nullable
  PhplrtIdentifier getIdentifier();

  @NotNull String getName();

  @NotNull String getValue();

  @Nullable PsiElement getNameIdentifier();

  boolean isToken();

  boolean isSkip();

  boolean isPragma();

  @NotNull PsiReference @NotNull [] getReferences();

}
