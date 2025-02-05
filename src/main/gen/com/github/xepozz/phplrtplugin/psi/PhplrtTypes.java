// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrtplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.xepozz.phplrtplugin.psi.impl.*;

public interface PhplrtTypes {

  IElementType EXPRESSION = new PhplrtElementType("EXPRESSION");
  IElementType EXPRESSIONS = new PhplrtElementType("EXPRESSIONS");
  IElementType IDENTIFIER = new PhplrtElementType("IDENTIFIER");
  IElementType META_DECL = PhplrtElementTypeFactory.factory("META_DECL");
  IElementType OPERATOR = new PhplrtElementType("OPERATOR");
  IElementType RULE_DECL = new PhplrtElementType("RULE_DECL");
  IElementType RULE_MODIFIER = new PhplrtElementType("RULE_MODIFIER");
  IElementType RULE_REFERENCE = new PhplrtElementType("RULE_REFERENCE");
  IElementType TOKEN_REFERENCE = new PhplrtElementType("TOKEN_REFERENCE");

  IElementType COLON = new PhplrtTokenType("COLON");
  IElementType COMMENT = new PhplrtTokenType("COMMENT");
  IElementType DOUBLE_COLON = new PhplrtTokenType("DOUBLE_COLON");
  IElementType EOL = new PhplrtTokenType("EOL");
  IElementType LEFT_ARROW = new PhplrtTokenType("LEFT_ARROW");
  IElementType LITERAL = new PhplrtTokenType("LITERAL");
  IElementType META_START = new PhplrtTokenType("META_START");
  IElementType OP_OR = new PhplrtTokenType("OP_OR");
  IElementType PARENTHESES_CLOSE = new PhplrtTokenType("PARENTHESES_CLOSE");
  IElementType PARENTHESES_OPEN = new PhplrtTokenType("PARENTHESES_OPEN");
  IElementType PRAGMA = new PhplrtTokenType("PRAGMA");
  IElementType RIGHT_ARROW = new PhplrtTokenType("RIGHT_ARROW");
  IElementType RULE_MODIFIER_HIDDEN = new PhplrtTokenType("RULE_MODIFIER_HIDDEN");
  IElementType SEMICOLON = new PhplrtTokenType("SEMICOLON");
  IElementType SKIP = new PhplrtTokenType("SKIP");
  IElementType TOKEN = new PhplrtTokenType("TOKEN");
  IElementType VALUE = new PhplrtTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == EXPRESSION) {
        return new PhplrtExpressionImpl(node);
      }
      else if (type == EXPRESSIONS) {
        return new PhplrtExpressionsImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new PhplrtIdentifierImpl(node);
      }
      else if (type == META_DECL) {
        return new PhplrtMetaDeclImpl(node);
      }
      else if (type == OPERATOR) {
        return new PhplrtOperatorImpl(node);
      }
      else if (type == RULE_DECL) {
        return new PhplrtRuleDeclImpl(node);
      }
      else if (type == RULE_MODIFIER) {
        return new PhplrtRuleModifierImpl(node);
      }
      else if (type == RULE_REFERENCE) {
        return new PhplrtRuleReferenceImpl(node);
      }
      else if (type == TOKEN_REFERENCE) {
        return new PhplrtTokenReferenceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
