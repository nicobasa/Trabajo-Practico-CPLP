// Generated from com\grupo\o\antlr\grupootp\Simple.g4 by ANTLR 4.5.1
package com.grupo.o.antlr.grupootp;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(SimpleParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(SimpleParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#var_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_assign(SimpleParser.Var_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#println}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln(SimpleParser.PrintlnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(SimpleParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_loop(SimpleParser.For_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_init(SimpleParser.For_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_update(SimpleParser.For_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SimpleParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#logic_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_or(SimpleParser.Logic_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#logic_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_and(SimpleParser.Logic_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(SimpleParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(SimpleParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#additive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(SimpleParser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#multiplicative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(SimpleParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(SimpleParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SimpleParser.PrimaryContext ctx);
}