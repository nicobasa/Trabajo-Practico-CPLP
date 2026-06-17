// Generated from com\grupo\o\antlr\grupootp\Simple.g4 by ANTLR 4.5.1
package com.grupo.o.antlr.grupootp;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParser}.
 */
public interface SimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(SimpleParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(SimpleParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(SimpleParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(SimpleParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#var_assign}.
	 * @param ctx the parse tree
	 */
	void enterVar_assign(SimpleParser.Var_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#var_assign}.
	 * @param ctx the parse tree
	 */
	void exitVar_assign(SimpleParser.Var_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#println}.
	 * @param ctx the parse tree
	 */
	void enterPrintln(SimpleParser.PrintlnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#println}.
	 * @param ctx the parse tree
	 */
	void exitPrintln(SimpleParser.PrintlnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(SimpleParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(SimpleParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterFor_loop(SimpleParser.For_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitFor_loop(SimpleParser.For_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterFor_init(SimpleParser.For_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitFor_init(SimpleParser.For_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterFor_update(SimpleParser.For_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitFor_update(SimpleParser.For_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpleParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpleParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#logic_or}.
	 * @param ctx the parse tree
	 */
	void enterLogic_or(SimpleParser.Logic_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#logic_or}.
	 * @param ctx the parse tree
	 */
	void exitLogic_or(SimpleParser.Logic_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#logic_and}.
	 * @param ctx the parse tree
	 */
	void enterLogic_and(SimpleParser.Logic_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#logic_and}.
	 * @param ctx the parse tree
	 */
	void exitLogic_and(SimpleParser.Logic_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(SimpleParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(SimpleParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(SimpleParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(SimpleParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(SimpleParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(SimpleParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(SimpleParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(SimpleParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(SimpleParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(SimpleParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SimpleParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SimpleParser.PrimaryContext ctx);
}