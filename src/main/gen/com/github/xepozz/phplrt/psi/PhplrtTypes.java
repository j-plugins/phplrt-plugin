// This is a generated file. Not intended for manual editing.
package com.github.xepozz.phplrt.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.xepozz.phplrt.language.psi.PhplrtElementType;
import com.github.xepozz.phplrt.language.psi.PhplrtElementTypeFactory;
import com.github.xepozz.phplrt.language.psi.PhplrtTokenType;
import com.github.xepozz.phplrt.psi.impl.*;

public interface PhplrtTypes {

  IElementType CODE = new PhplrtElementType("CODE");
  IElementType EXPRESSION = new PhplrtElementType("EXPRESSION");
  IElementType EXPRESSIONS = new PhplrtElementType("EXPRESSIONS");
  IElementType IDENTIFIER = new PhplrtElementType("IDENTIFIER");
  IElementType META_DECL = PhplrtElementTypeFactory.factory("META_DECL");
  IElementType OPERATOR = new PhplrtElementType("OPERATOR");
  IElementType QUANTIFIER = new PhplrtElementType("QUANTIFIER");
  IElementType RULE_DECL = PhplrtElementTypeFactory.factory("RULE_DECL");
  IElementType RULE_MODIFIER = new PhplrtElementType("RULE_MODIFIER");
  IElementType RULE_REFERENCE = new PhplrtElementType("RULE_REFERENCE");
  IElementType TOKEN_REFERENCE = new PhplrtElementType("TOKEN_REFERENCE");

  IElementType CODE_DELIMITER = new PhplrtTokenType("CODE_DELIMITER");
  IElementType COLON = new PhplrtTokenType("COLON");
  IElementType COMMENT = new PhplrtTokenType("COMMENT");
  IElementType DOUBLE_COLON = new PhplrtTokenType("DOUBLE_COLON");
  IElementType INCLUDE = new PhplrtTokenType("INCLUDE");
  IElementType INLINE_CODE = new PhplrtTokenType("INLINE_CODE");
  IElementType LEFT_ARROW = new PhplrtTokenType("LEFT_ARROW");
  IElementType LITERAL = new PhplrtTokenType("LITERAL");
  IElementType META_START = new PhplrtTokenType("META_START");
  IElementType OP_OR = new PhplrtTokenType("OP_OR");
  IElementType PARENTHESES_CLOSE = new PhplrtTokenType("PARENTHESES_CLOSE");
  IElementType PARENTHESES_OPEN = new PhplrtTokenType("PARENTHESES_OPEN");
  IElementType PRAGMA = new PhplrtTokenType("PRAGMA");
  IElementType QUANTIFIER_ANY = new PhplrtTokenType("QUANTIFIER_ANY");
  IElementType QUANTIFIER_ONE_INFINITE = new PhplrtTokenType("QUANTIFIER_ONE_INFINITE");
  IElementType QUANTIFIER_ZERO_ONE = new PhplrtTokenType("QUANTIFIER_ZERO_ONE");
  IElementType RIGHT_ARROW = new PhplrtTokenType("RIGHT_ARROW");
  IElementType SEMICOLON = new PhplrtTokenType("SEMICOLON");
  IElementType SHARP = new PhplrtTokenType("SHARP");
  IElementType SKIP = new PhplrtTokenType("SKIP");
  IElementType TOKEN = new PhplrtTokenType("TOKEN");
  IElementType VALUE = new PhplrtTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CODE) {
        return new PhplrtCodeImpl(node);
      }
      else if (type == EXPRESSION) {
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
      else if (type == QUANTIFIER) {
        return new PhplrtQuantifierImpl(node);
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
