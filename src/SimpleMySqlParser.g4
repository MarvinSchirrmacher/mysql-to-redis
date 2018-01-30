parser grammar SimpleMySqlParser;

options { tokenVocab=MySqlLexer; }

sqlCommand
    : sql SEMI EOF
    | SEMI EOF
    ;

sql
    : use
    | createDatabase | dropDatabase
    | createTable | dropTable | renameTable
    | select | insert | update | delete | replace
    ;

//-----------------------------------------------------------------------------
// Use
//-----------------------------------------------------------------------------

use
    : USE database=id
    ;

//-----------------------------------------------------------------------------
// Database
//-----------------------------------------------------------------------------

createDatabase
    : CREATE DATABASE ifNotExists? id
    ;

dropDatabase
    : DROP DATABASE ifExists? id
    ;

//-----------------------------------------------------------------------------
// Table
//-----------------------------------------------------------------------------

createTable
    : CREATE TEMPORARY? TABLE ifNotExists? ID (LIKE ID)?
    ;

dropTable
    : DROP TEMPORARY? TABLE ifExists? ids (RESTRICT | CASCADE)?
    ;

renameTable
    : RENAME TABLE renameTableClause (',' renameTableClause)*
    ;

renameTableClause
    : idSubId TO idSubId
    ;

//-----------------------------------------------------------------------------
// Select
//-----------------------------------------------------------------------------

select
    : SELECT selectModifier* selectRows selectInto?
      fromClause? orderByClause? limitClause?
    | SELECT selectModifier* selectRows
      fromClause? orderByClause? limitClause? selectInto?
    ;

selectModifier
    : (ALL | DISTINCT | DISTINCTROW)
    ;

selectRows
    : ('*' | ID ) (',' ID)*
    ;

selectInto
    : INTO id (',' id)*
    | INTO DUMPFILE STRING_LITERAL
    ;

fromClause
    : FROM ID
      (WHERE expression)?
      (
        GROUP BY
        groupByExpression (',' groupByExpression)*
        (WITH ROLLUP)?
      )?
      (HAVING expression)?
    ;

orderByClause
    : ORDER BY orderByExpression (',' orderByExpression)*
    ;

limitClause
    : LIMIT decimalLiteral OFFSET decimalLiteral
    ;

orderByExpression
    : expression (ASC | DESC)?
    ;

groupByExpression
    : expression (ASC | DESC)?
    ;

//-----------------------------------------------------------------------------
// Insert
//-----------------------------------------------------------------------------

insert
    : INSERT IGNORE? INTO? table=idSubId
      (
        ('(' columns=ids ')')? insertValue
      )
    ;

insertValue
    : select
    | (VALUES | VALUE)
      '(' expressionsOrDefaults ')' (',' '(' expressionsOrDefaults ')')*
    ;

//-----------------------------------------------------------------------------
// Update
//-----------------------------------------------------------------------------

update
    : UPDATE IGNORE? table=idSubId (AS? id)?
          SET updateAssignment (',' updateAssignment)*
          (WHERE expression)? orderByClause? limitClause?
    ;

updateAssignment
    : idSubId '=' expressionOrDefault
    ;

//-----------------------------------------------------------------------------
// Delete
//-----------------------------------------------------------------------------

delete
    : DELETE FROM table=idSubId
      (WHERE expression)?
      orderByClause? (LIMIT decimalLiteral)?
    ;

//-----------------------------------------------------------------------------
// Delete
//-----------------------------------------------------------------------------

replace
    : REPLACE INTO? table=idSubId
      (
        ('(' columns=ids ')')? insertValue
        | SET setFirst=updateAssignment
      )
    ;

//-----------------------------------------------------------------------------
// Expression
//-----------------------------------------------------------------------------

expression
    : (NOT | '!') expression
    | expression logicalOperator expression
    | predicate IS NOT? (TRUE | FALSE | UNKNOWN)
    | predicate
    ;

expressions
    : expression (',' expression)*
    ;

predicate
    : predicate NOT? IN '(' (select | expressions) ')'
    | predicate IS nullOrNotNull
    | predicate comparisonOperator predicate
    | predicate comparisonOperator (ALL | ANY | SOME) '(' select ')'
    | predicate NOT? BETWEEN predicate AND predicate
    | predicate SOUNDS LIKE predicate
    | predicate NOT? LIKE predicate (ESCAPE STRING_LITERAL)?
    | predicate NOT? regex=(REGEXP | RLIKE) predicate
    | (LOCAL_ID VAR_ASSIGN)? expressionAtom
    ;

expressionAtom
    : constant
    | idSubId
    | function
    | unaryOperator expressionAtom
    | BINARY expressionAtom
    | '(' expression (',' expression)* ')'
    | ROW '(' expression (',' expression)+ ')'
    | EXISTS '(' select ')'
    | '(' select ')'
    | INTERVAL expression intervalType
    | expressionAtom bitOperator expressionAtom
    | expressionAtom mathOperator expressionAtom
    ;

expressionOrDefault
    : expression | DEFAULT
    ;

expressionsOrDefaults
    : expressionOrDefault (',' expressionOrDefault)*
    ;

//-----------------------------------------------------------------------------
// Literals
//-----------------------------------------------------------------------------

constant
    : booleanLiteral | decimalLiteral | stringLiteral | hexadecimalLiteral
    | REAL_LITERAL | BIT_STRING | NOT? NULL_LITERAL
    ;

stringLiteral
    : STRING_CHARSET_NAME? STRING_LITERAL STRING_LITERAL+
    ;

decimalLiteral
    : DECIMAL_LITERAL | ZERO_DECIMAL | ONE_DECIMAL | TWO_DECIMAL
    ;

hexadecimalLiteral
    : STRING_CHARSET_NAME? HEXADECIMAL_LITERAL
    ;

booleanLiteral
    : TRUE | FALSE
    ;

//-----------------------------------------------------------------------------
// Functions
//-----------------------------------------------------------------------------

function
    : specificFunction
    | aggregateFunction
    ;

specificFunction
    : (SUBSTR | SUBSTRING) '('
        (stringLiteral | expression) FROM (decimalLiteral | expression)
        (FOR (decimalLiteral | expression))?
      ')'
    | TRIM '(' (BOTH | LEADING | TRAILING) (stringLiteral | expression)? FROM (stringLiteral | expression) ')'
    | TRIM '(' (stringLiteral | expression) FROM (stringLiteral | expression) ')'
    | (CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | CURRENT_USER | LOCALTIME)
    | VALUES '(' idSubId ')'
    ;

aggregateFunction
    : (AVG | MAX | MIN | SUM) '(' (ALL | DISTINCT)? functionParameter ')'
    | COUNT '(' ('*' | ALL? functionParameter) ')'
    | COUNT '(' DISTINCT functionParameters ')'
    | (
        BIT_AND | BIT_OR | BIT_XOR | STD | STDDEV | STDDEV_POP
        | STDDEV_SAMP | VAR_POP | VAR_SAMP | VARIANCE
      ) '(' ALL? functionParameter ')'
    | GROUP_CONCAT '('
        aggregator=DISTINCT? functionParameters
        (ORDER BY
          orderByExpression (',' orderByExpression)*
        )? (SEPARATOR separator=STRING_LITERAL)?
      ')'
    ;

functionParameter
    : constant | idSubId | expression
    ;

functionParameters
    : functionParameter (',' functionParameter)*
    ;

//-----------------------------------------------------------------------------
// Operators
//-----------------------------------------------------------------------------

unaryOperator
    : NOT | '!' | '~' | '+' | '-'
    ;

comparisonOperator
    : '=' | '>' | '<' | '<' '=' | '>' '='
    | '<' '>' | '!' '=' | '<' '=' '>'
    ;

logicalOperator
    : AND | XOR | OR | '&' '&' | '|' '|'
    ;

bitOperator
    : '<' '<' | '>' '>' | '&' | '^' | '|'
    ;

mathOperator
    : DIV | MOD | '+' | '-' | '*' | '/' | '%' | '--'
    ;

//-----------------------------------------------------------------------------
// Id
//-----------------------------------------------------------------------------

id
    : ID
    | intervalType
    | dataType
    ;

ids
    : id (',' id)*
    ;

subId
    : DOT_ID
    | '.' id
    ;

idSubId
    : id (subId subId? )?
    ;

//-----------------------------------------------------------------------------
// Common
//-----------------------------------------------------------------------------

nullOrNotNull
    : NOT? NULL_LITERAL
    ;

intervalType
    : QUARTER | MONTH | DAY | HOUR
    | MINUTE | WEEK | SECOND | MICROSECOND
    ;

dataType
    : DATE | TIME | TIMESTAMP | DATETIME | YEAR | ENUM | TEXT
    ;

ifExists
    : IF EXISTS
    ;

ifNotExists
    : IF NOT EXISTS
    ;