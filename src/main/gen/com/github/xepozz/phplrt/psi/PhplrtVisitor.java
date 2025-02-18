// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.github.xepozz.phplrt.language.psi.PhplrtNamedElement;
import com.intellij.psi.PsiLanguageInjectionHost;

public class PhplrtVisitor extends PsiElementVisitor {

  public void visitCode(@NotNull PhplrtCode o) {
    visitPsiLanguageInjectionHost(o);
  }

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

  public void visitQuantifier(@NotNull PhplrtQuantifier o) {
    visitPsiElement(o);
  }

  public void visitRuleDecl(@NotNull PhplrtRuleDecl o) {
    visitNamedElement(o);
  }

  public void visitRuleReference(@NotNull PhplrtRuleReference o) {
    visitNamedElement(o);
  }

  public void visitTokenReference(@NotNull PhplrtTokenReference o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull PhplrtNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiLanguageInjectionHost(@NotNull PsiLanguageInjectionHost o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
