// Generated from /Users/MarvinSchirrmacher/Applications/fh-bielefeld-compilerbau/parser/src/MySqlParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MySqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MySqlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MySqlParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql(MySqlParser.SqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#sqlCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlCommand(MySqlParser.SqlCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#use}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse(MySqlParser.UseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#createDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabase(MySqlParser.CreateDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#dropDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDatabase(MySqlParser.DropDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#createView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateView(MySqlParser.CreateViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#createTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(MySqlParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#createColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateColumn(MySqlParser.CreateColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraint(MySqlParser.ColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableConstraint(MySqlParser.TableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#referenceDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceDefinition(MySqlParser.ReferenceDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#referenceAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceAction(MySqlParser.ReferenceActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#referenceControlType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceControlType(MySqlParser.ReferenceControlTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#indexColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexColumnDefinition(MySqlParser.IndexColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#indexColumnNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexColumnNames(MySqlParser.IndexColumnNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#indexColumnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexColumnName(MySqlParser.IndexColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#indexOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOption(MySqlParser.IndexOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#dropTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTable(MySqlParser.DropTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#renameTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTable(MySqlParser.RenameTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#renameTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTableClause(MySqlParser.RenameTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(MySqlParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#selectModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectModifier(MySqlParser.SelectModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#selectRows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectRows(MySqlParser.SelectRowsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#selectRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectRow(MySqlParser.SelectRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#selectInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectInto(MySqlParser.SelectIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(MySqlParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#tableContents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableContents(MySqlParser.TableContentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#tableContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableContent(MySqlParser.TableContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#tableRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableRow(MySqlParser.TableRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(MySqlParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(MySqlParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#limitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitClause(MySqlParser.LimitClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#orderByExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByExpression(MySqlParser.OrderByExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#groupByExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByExpression(MySqlParser.GroupByExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(MySqlParser.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#insertValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertValue(MySqlParser.InsertValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(MySqlParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#updateAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateAssignment(MySqlParser.UpdateAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(MySqlParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#replace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplace(MySqlParser.ReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MySqlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(MySqlParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(MySqlParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAtom(MySqlParser.ExpressionAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#expressionOrDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOrDefault(MySqlParser.ExpressionOrDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#expressionsOrDefaults}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionsOrDefaults(MySqlParser.ExpressionsOrDefaultsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(MySqlParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#decimalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(MySqlParser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#fileSizeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileSizeLiteral(MySqlParser.FileSizeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#hexadecimalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(MySqlParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MySqlParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificFunction(MySqlParser.SpecificFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(MySqlParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#functionParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(MySqlParser.FunctionParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameters(MySqlParser.FunctionParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(MySqlParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(MySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperator(MySqlParser.LogicalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#bitOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOperator(MySqlParser.BitOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#mathOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathOperator(MySqlParser.MathOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MySqlParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#ids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIds(MySqlParser.IdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#subId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubId(MySqlParser.SubIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#idSubId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSubId(MySqlParser.IdSubIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(MySqlParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#nullOrNotNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullOrNotNull(MySqlParser.NullOrNotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#intervalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalType(MySqlParser.IntervalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(MySqlParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#length}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(MySqlParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#lengthTwoDimensionOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoDimensionOptional(MySqlParser.LengthTwoDimensionOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#ifExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExists(MySqlParser.IfExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySqlParser#ifNotExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNotExists(MySqlParser.IfNotExistsContext ctx);
}