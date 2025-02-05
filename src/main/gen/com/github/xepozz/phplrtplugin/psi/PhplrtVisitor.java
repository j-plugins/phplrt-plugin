// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrtplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class PhplrtVisitor extends PsiElementVisitor {

  public void visitExpression(@NotNull PhplrtExpression o) {
    visitPsiElement(o);
  }

  public void visitExpressions(@NotNull PhplrtExpressions o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull PhplrtIdentifier o) {
    visitPsiElement(o);
  }

  public void visitMetaDecl(@NotNull PhplrtMetaDecl o) {
    visitNamedElement(o);
  }

  public void visitOperator(@NotNull PhplrtOperator o) {
    visitPsiElement(o);
  }

  public void visitRuleDecl(@NotNull PhplrtRuleDecl o) {
    visitPsiElement(o);
  }

  public void visitRuleModifier(@NotNull PhplrtRuleModifier o) {
    visitPsiElement(o);
  }

  public void visitRuleReference(@NotNull PhplrtRuleReference o) {
    visitPsiElement(o);
  }

  public void visitTokenReference(@NotNull PhplrtTokenReference o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull PhplrtNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
