// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static com.github.xepozz.phplrt.psi.PhplrtTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PhplrtParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return phplrtFile(b, l + 1);
  }

  /* ********************************************************** */
  // tokenReference | ruleReference
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = tokenReference(b, l + 1);
    if (!r) r = ruleReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression (operator? expression)*
  public static boolean expressions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSIONS, "<expressions>");
    r = expression(b, l + 1);
    r = r && expressions_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (operator? expression)*
  private static boolean expressions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expressions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressions_1", c)) break;
    }
    return true;
  }

  // operator? expression
  private static boolean expressions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expressions_1_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // operator?
  private static boolean expressions_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_1_0_0")) return false;
    operator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DOUBLE_COLON identifier DOUBLE_COLON
  static boolean hiddenTokenReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hiddenTokenReference")) return false;
    if (!nextTokenIs(b, DOUBLE_COLON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, DOUBLE_COLON);
    r = r && identifier(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, DOUBLE_COLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LITERAL
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LITERAL);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // metaDecl|ruleDecl|COMMENT|EOL
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = metaDecl(b, l + 1);
    if (!r) r = ruleDecl(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // META_START (TOKEN|SKIP|PRAGMA) identifier VALUE
  public static boolean metaDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metaDecl")) return false;
    if (!nextTokenIs(b, META_START)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, META_DECL, null);
    r = consumeToken(b, META_START);
    p = r; // pin = 1
    r = r && report_error_(b, metaDecl_1(b, l + 1));
    r = p && report_error_(b, identifier(b, l + 1)) && r;
    r = p && consumeToken(b, VALUE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TOKEN|SKIP|PRAGMA
  private static boolean metaDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metaDecl_1")) return false;
    boolean r;
    r = consumeToken(b, TOKEN);
    if (!r) r = consumeToken(b, SKIP);
    if (!r) r = consumeToken(b, PRAGMA);
    return r;
  }

  /* ********************************************************** */
  // OP_OR
  public static boolean operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator")) return false;
    if (!nextTokenIs(b, OP_OR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_OR);
    exit_section_(b, m, OPERATOR, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean phplrtFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "phplrtFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "phplrtFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ruleModifier? identifier COLON expressions SEMICOLON
  public static boolean ruleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleDecl")) return false;
    if (!nextTokenIs(b, "<rule decl>", LITERAL, RULE_MODIFIER_HIDDEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE_DECL, "<rule decl>");
    r = ruleDecl_0(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    p = r; // pin = 3
    r = r && report_error_(b, expressions(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ruleModifier?
  private static boolean ruleDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleDecl_0")) return false;
    ruleModifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // RULE_MODIFIER_HIDDEN
  public static boolean ruleModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleModifier")) return false;
    if (!nextTokenIs(b, RULE_MODIFIER_HIDDEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_MODIFIER_HIDDEN);
    exit_section_(b, m, RULE_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // identifier PARENTHESES_OPEN PARENTHESES_CLOSE
  public static boolean ruleReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleReference")) return false;
    if (!nextTokenIs(b, LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeTokens(b, 0, PARENTHESES_OPEN, PARENTHESES_CLOSE);
    exit_section_(b, m, RULE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // hiddenTokenReference | visibleTokenReference
  public static boolean tokenReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tokenReference")) return false;
    if (!nextTokenIs(b, "<token reference>", DOUBLE_COLON, LEFT_ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOKEN_REFERENCE, "<token reference>");
    r = hiddenTokenReference(b, l + 1);
    if (!r) r = visibleTokenReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_ARROW identifier RIGHT_ARROW
  static boolean visibleTokenReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "visibleTokenReference")) return false;
    if (!nextTokenIs(b, LEFT_ARROW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LEFT_ARROW);
    r = r && identifier(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, RIGHT_ARROW);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
