package de.fh_bielefeld.compiler_construction.parser;// Generated from /Users/MarvinSchirrmacher/Applications/fh-bielefeld-compilerbau/parser/src/MySqlParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MySqlParser}.
 */
public interface MySqlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MySqlParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSql(MySqlParser.SqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSql(MySqlParser.SqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#sqlCommand}.
	 * @param ctx the parse tree
	 */
	void enterSqlCommand(MySqlParser.SqlCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#sqlCommand}.
	 * @param ctx the parse tree
	 */
	void exitSqlCommand(MySqlParser.SqlCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#use}.
	 * @param ctx the parse tree
	 */
	void enterUse(MySqlParser.UseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#use}.
	 * @param ctx the parse tree
	 */
	void exitUse(MySqlParser.UseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#createDatabase}.
	 * @param ctx the parse tree
	 */
	void enterCreateDatabase(MySqlParser.CreateDatabaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#createDatabase}.
	 * @param ctx the parse tree
	 */
	void exitCreateDatabase(MySqlParser.CreateDatabaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#dropDatabase}.
	 * @param ctx the parse tree
	 */
	void enterDropDatabase(MySqlParser.DropDatabaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#dropDatabase}.
	 * @param ctx the parse tree
	 */
	void exitDropDatabase(MySqlParser.DropDatabaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#createView}.
	 * @param ctx the parse tree
	 */
	void enterCreateView(MySqlParser.CreateViewContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#createView}.
	 * @param ctx the parse tree
	 */
	void exitCreateView(MySqlParser.CreateViewContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#createTable}.
	 * @param ctx the parse tree
	 */
	void enterCreateTable(MySqlParser.CreateTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#createTable}.
	 * @param ctx the parse tree
	 */
	void exitCreateTable(MySqlParser.CreateTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#createColumn}.
	 * @param ctx the parse tree
	 */
	void enterCreateColumn(MySqlParser.CreateColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#createColumn}.
	 * @param ctx the parse tree
	 */
	void exitCreateColumn(MySqlParser.CreateColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void enterColumnConstraint(MySqlParser.ColumnConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void exitColumnConstraint(MySqlParser.ColumnConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tableConstraint}.
	 * @param ctx the parse tree
	 */
	void enterTableConstraint(MySqlParser.TableConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tableConstraint}.
	 * @param ctx the parse tree
	 */
	void exitTableConstraint(MySqlParser.TableConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#referenceDefinition}.
	 * @param ctx the parse tree
	 */
	void enterReferenceDefinition(MySqlParser.ReferenceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#referenceDefinition}.
	 * @param ctx the parse tree
	 */
	void exitReferenceDefinition(MySqlParser.ReferenceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#referenceAction}.
	 * @param ctx the parse tree
	 */
	void enterReferenceAction(MySqlParser.ReferenceActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#referenceAction}.
	 * @param ctx the parse tree
	 */
	void exitReferenceAction(MySqlParser.ReferenceActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#referenceControlType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceControlType(MySqlParser.ReferenceControlTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#referenceControlType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceControlType(MySqlParser.ReferenceControlTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#indexColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterIndexColumnDefinition(MySqlParser.IndexColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#indexColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitIndexColumnDefinition(MySqlParser.IndexColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#indexColumnNames}.
	 * @param ctx the parse tree
	 */
	void enterIndexColumnNames(MySqlParser.IndexColumnNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#indexColumnNames}.
	 * @param ctx the parse tree
	 */
	void exitIndexColumnNames(MySqlParser.IndexColumnNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#indexColumnName}.
	 * @param ctx the parse tree
	 */
	void enterIndexColumnName(MySqlParser.IndexColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#indexColumnName}.
	 * @param ctx the parse tree
	 */
	void exitIndexColumnName(MySqlParser.IndexColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#indexOption}.
	 * @param ctx the parse tree
	 */
	void enterIndexOption(MySqlParser.IndexOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#indexOption}.
	 * @param ctx the parse tree
	 */
	void exitIndexOption(MySqlParser.IndexOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#dropTable}.
	 * @param ctx the parse tree
	 */
	void enterDropTable(MySqlParser.DropTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#dropTable}.
	 * @param ctx the parse tree
	 */
	void exitDropTable(MySqlParser.DropTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#renameTable}.
	 * @param ctx the parse tree
	 */
	void enterRenameTable(MySqlParser.RenameTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#renameTable}.
	 * @param ctx the parse tree
	 */
	void exitRenameTable(MySqlParser.RenameTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#renameTableClause}.
	 * @param ctx the parse tree
	 */
	void enterRenameTableClause(MySqlParser.RenameTableClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#renameTableClause}.
	 * @param ctx the parse tree
	 */
	void exitRenameTableClause(MySqlParser.RenameTableClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(MySqlParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(MySqlParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#selectModifier}.
	 * @param ctx the parse tree
	 */
	void enterSelectModifier(MySqlParser.SelectModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#selectModifier}.
	 * @param ctx the parse tree
	 */
	void exitSelectModifier(MySqlParser.SelectModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#selectRows}.
	 * @param ctx the parse tree
	 */
	void enterSelectRows(MySqlParser.SelectRowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#selectRows}.
	 * @param ctx the parse tree
	 */
	void exitSelectRows(MySqlParser.SelectRowsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#selectRow}.
	 * @param ctx the parse tree
	 */
	void enterSelectRow(MySqlParser.SelectRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#selectRow}.
	 * @param ctx the parse tree
	 */
	void exitSelectRow(MySqlParser.SelectRowContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#selectInto}.
	 * @param ctx the parse tree
	 */
	void enterSelectInto(MySqlParser.SelectIntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#selectInto}.
	 * @param ctx the parse tree
	 */
	void exitSelectInto(MySqlParser.SelectIntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(MySqlParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(MySqlParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tableContents}.
	 * @param ctx the parse tree
	 */
	void enterTableContents(MySqlParser.TableContentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tableContents}.
	 * @param ctx the parse tree
	 */
	void exitTableContents(MySqlParser.TableContentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tableContent}.
	 * @param ctx the parse tree
	 */
	void enterTableContent(MySqlParser.TableContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tableContent}.
	 * @param ctx the parse tree
	 */
	void exitTableContent(MySqlParser.TableContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#tableRow}.
	 * @param ctx the parse tree
	 */
	void enterTableRow(MySqlParser.TableRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#tableRow}.
	 * @param ctx the parse tree
	 */
	void exitTableRow(MySqlParser.TableRowContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(MySqlParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(MySqlParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(MySqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(MySqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(MySqlParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(MySqlParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrderByExpression(MySqlParser.OrderByExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrderByExpression(MySqlParser.OrderByExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#groupByExpression}.
	 * @param ctx the parse tree
	 */
	void enterGroupByExpression(MySqlParser.GroupByExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#groupByExpression}.
	 * @param ctx the parse tree
	 */
	void exitGroupByExpression(MySqlParser.GroupByExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInsert(MySqlParser.InsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInsert(MySqlParser.InsertContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#insertValue}.
	 * @param ctx the parse tree
	 */
	void enterInsertValue(MySqlParser.InsertValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#insertValue}.
	 * @param ctx the parse tree
	 */
	void exitInsertValue(MySqlParser.InsertValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(MySqlParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(MySqlParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#updateAssignment}.
	 * @param ctx the parse tree
	 */
	void enterUpdateAssignment(MySqlParser.UpdateAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#updateAssignment}.
	 * @param ctx the parse tree
	 */
	void exitUpdateAssignment(MySqlParser.UpdateAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(MySqlParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(MySqlParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#replace}.
	 * @param ctx the parse tree
	 */
	void enterReplace(MySqlParser.ReplaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#replace}.
	 * @param ctx the parse tree
	 */
	void exitReplace(MySqlParser.ReplaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MySqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MySqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(MySqlParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(MySqlParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(MySqlParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(MySqlParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAtom(MySqlParser.ExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAtom(MySqlParser.ExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#expressionOrDefault}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOrDefault(MySqlParser.ExpressionOrDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#expressionOrDefault}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOrDefault(MySqlParser.ExpressionOrDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#expressionsOrDefaults}.
	 * @param ctx the parse tree
	 */
	void enterExpressionsOrDefaults(MySqlParser.ExpressionsOrDefaultsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#expressionsOrDefaults}.
	 * @param ctx the parse tree
	 */
	void exitExpressionsOrDefaults(MySqlParser.ExpressionsOrDefaultsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MySqlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(MySqlParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(MySqlParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(MySqlParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(MySqlParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#fileSizeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFileSizeLiteral(MySqlParser.FileSizeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#fileSizeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFileSizeLiteral(MySqlParser.FileSizeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#hexadecimalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#hexadecimalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(MySqlParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(MySqlParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MySqlParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MySqlParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void enterSpecificFunction(MySqlParser.SpecificFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#specificFunction}.
	 * @param ctx the parse tree
	 */
	void exitSpecificFunction(MySqlParser.SpecificFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunction(MySqlParser.AggregateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunction(MySqlParser.AggregateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(MySqlParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter(MySqlParser.FunctionParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(MySqlParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(MySqlParser.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(MySqlParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(MySqlParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(MySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(MySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(MySqlParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(MySqlParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#bitOperator}.
	 * @param ctx the parse tree
	 */
	void enterBitOperator(MySqlParser.BitOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#bitOperator}.
	 * @param ctx the parse tree
	 */
	void exitBitOperator(MySqlParser.BitOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void enterMathOperator(MySqlParser.MathOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void exitMathOperator(MySqlParser.MathOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(MySqlParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(MySqlParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(MySqlParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(MySqlParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#subId}.
	 * @param ctx the parse tree
	 */
	void enterSubId(MySqlParser.SubIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#subId}.
	 * @param ctx the parse tree
	 */
	void exitSubId(MySqlParser.SubIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#idSubId}.
	 * @param ctx the parse tree
	 */
	void enterIdSubId(MySqlParser.IdSubIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#idSubId}.
	 * @param ctx the parse tree
	 */
	void exitIdSubId(MySqlParser.IdSubIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(MySqlParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(MySqlParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#nullOrNotNull}.
	 * @param ctx the parse tree
	 */
	void enterNullOrNotNull(MySqlParser.NullOrNotNullContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#nullOrNotNull}.
	 * @param ctx the parse tree
	 */
	void exitNullOrNotNull(MySqlParser.NullOrNotNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#intervalType}.
	 * @param ctx the parse tree
	 */
	void enterIntervalType(MySqlParser.IntervalTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#intervalType}.
	 * @param ctx the parse tree
	 */
	void exitIntervalType(MySqlParser.IntervalTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(MySqlParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(MySqlParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#length}.
	 * @param ctx the parse tree
	 */
	void enterLength(MySqlParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#length}.
	 * @param ctx the parse tree
	 */
	void exitLength(MySqlParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 */
	void enterLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 */
	void exitLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#lengthTwoDimensionOptional}.
	 * @param ctx the parse tree
	 */
	void enterLengthTwoDimensionOptional(MySqlParser.LengthTwoDimensionOptionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#lengthTwoDimensionOptional}.
	 * @param ctx the parse tree
	 */
	void exitLengthTwoDimensionOptional(MySqlParser.LengthTwoDimensionOptionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#ifExists}.
	 * @param ctx the parse tree
	 */
	void enterIfExists(MySqlParser.IfExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#ifExists}.
	 * @param ctx the parse tree
	 */
	void exitIfExists(MySqlParser.IfExistsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySqlParser#ifNotExists}.
	 * @param ctx the parse tree
	 */
	void enterIfNotExists(MySqlParser.IfNotExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySqlParser#ifNotExists}.
	 * @param ctx the parse tree
	 */
	void exitIfNotExists(MySqlParser.IfNotExistsContext ctx);
}