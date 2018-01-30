parser grammar MySqlParser;

options { tokenVocab=MySqlLexer; }

sql
    @init {
        // System.out.println("[Rule: sqlCommand]");
    }
    : (sqlCommand SEMI)* EOF
    | (SEMI)* EOF
    ;

sqlCommand
    @init {
        // System.out.println("[Rule: sql]");
    }
    : use
    | createDatabase | dropDatabase | createView
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
    @init {
        // System.out.println("[Rule: createDatabase]");
    }
    : CREATE (DATABASE | SCHEMA) ifNotExists? id
    ;

dropDatabase
    : DROP (DATABASE | SCHEMA) ifExists? id
    ;

createView
    : CREATE (OR REPLACE)? VIEW id ('(' ids ')')? AS
      select (WITH (CASCADED | LOCAL)? CHECK OPTION)?
    ;

//-----------------------------------------------------------------------------
// Table
//-----------------------------------------------------------------------------

createTable
    : CREATE TEMPORARY? TABLE ifNotExists? id (LIKE id)?
    | CREATE TEMPORARY? TABLE ifNotExists? id
      '(' createColumn (',' createColumn)* ')'
    ;

createColumn
    : id dataType columnConstraint*
    | tableConstraint
    | indexColumnDefinition
    ;

columnConstraint
    : nullOrNotNull
    | DEFAULT defaultValue
    | AUTO_INCREMENT
    | PRIMARY? KEY
    | UNIQUE KEY?
    | COMMENT STRING_LITERAL
    | referenceDefinition
    ;

tableConstraint
    : (CONSTRAINT id?)? PRIMARY KEY USING? indexColumnNames indexOption*
    | (CONSTRAINT id?)?
      UNIQUE (INDEX | KEY)? id?
      USING? indexColumnNames indexOption*
    | (CONSTRAINT id?)?
      FOREIGN KEY id? indexColumnNames
      referenceDefinition
    | CHECK '(' expression ')'
    ;

referenceDefinition
    : REFERENCES idSubId indexColumnNames (MATCH (FULL | PARTIAL | SIMPLE))? referenceAction?
    ;

referenceAction
    : ON DELETE referenceControlType (ON UPDATE referenceControlType)?
    | ON UPDATE referenceControlType (ON DELETE referenceControlType)?
    ;

referenceControlType
    : RESTRICT | CASCADE | SET NULL_LITERAL | NO ACTION
    ;

indexColumnDefinition
    : (INDEX | KEY) id? USING? indexColumnNames indexOption*
    | (FULLTEXT | SPATIAL) (INDEX | KEY)? id? indexColumnNames indexOption*
    ;

indexColumnNames
    : '(' indexColumnName (',' indexColumnName)* ')'
    ;

indexColumnName
    : id ('(' decimalLiteral ')')? (ASC | DESC)?
    ;

indexOption
    : KEY_BLOCK_SIZE '='? fileSizeLiteral
    | USING
    | WITH PARSER id
    | COMMENT STRING_LITERAL
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
    : ('*' | selectRow ) (',' selectRow)*
    ;

selectRow
    : idSubId (AS? id)?
    | idSubId '.' '*'
    | (LOCAL_ID VAR_ASSIGN)? expression (AS? id)?
    ;

selectInto
    : INTO id (',' id)*
    | INTO DUMPFILE STRING_LITERAL
    ;

fromClause
    : FROM tableContents
      (WHERE expression)?
      (
        GROUP BY
        groupByExpression (',' groupByExpression)*
        (WITH ROLLUP)?
      )?
      (HAVING expression)?
    ;

tableContents
    : tableContent (',' tableContent)*
    ;

tableContent
    : tableRow join* | '(' tableRow join*')'
    ;

tableRow
    : idSubId
    | (select | '(' select ')') AS? id
    | '(' tableContents ')'
    ;

join
    : (INNER | CROSS)? JOIN tableRow (ON expression | USING '(' ids ')')?
    | STRAIGHT_JOIN tableRow (ON expression)?
    | (LEFT | RIGHT) OUTER? JOIN tableRow (ON expression | USING '(' ids ')')
    | NATURAL ((LEFT | RIGHT) OUTER?)? JOIN tableRow
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
    : (STRING_CHARSET_NAME? STRING_LITERAL | START_NATIONAL_STRING_LITERAL) STRING_LITERAL+
    | (STRING_CHARSET_NAME? STRING_LITERAL | START_NATIONAL_STRING_LITERAL)
    ;

decimalLiteral
    : DECIMAL_LITERAL | ZERO_DECIMAL | ONE_DECIMAL | TWO_DECIMAL
    ;

fileSizeLiteral
    : FILESIZE_LITERAL | decimalLiteral;

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
    @init {
        // System.out.println("[Rule: id]");
    }
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

defaultValue
    : NULL_LITERAL
    | constant
    | CURRENT_TIMESTAMP (ON UPDATE LOCALTIMESTAMP)?
    ;

nullOrNotNull
    : NOT? NULL_LITERAL
    ;

intervalType
    : MONTH | DAY | HOUR | MINUTE | WEEK | SECOND | MICROSECOND
    ;

dataType
    : (CHAR | VARCHAR | TINYTEXT | TEXT | MEDIUMTEXT | LONGTEXT) length? BINARY?
    | (INT | INTEGER | BIGINT | TINYINT | SMALLINT | MEDIUMINT) length? UNSIGNED? ZEROFILL?
    | (REAL | DOUBLE | FLOAT) lengthTwoDimension? UNSIGNED? ZEROFILL?
    | (DECIMAL | NUMERIC) lengthTwoDimensionOptional? UNSIGNED? ZEROFILL?
    | (DATE | TINYBLOB | BLOB | MEDIUMBLOB | LONGBLOB | BOOL | BOOLEAN)
    | (BIT | TIME | TIMESTAMP | DATETIME | BINARY | VARBINARY | YEAR) length?
    | (ENUM | SET) '(' STRING_LITERAL (',' STRING_LITERAL)* ')' BINARY?
    ;

length
    : '(' decimalLiteral ')'
    ;

lengthTwoDimension
    : '(' decimalLiteral ',' decimalLiteral ')'
    ;

lengthTwoDimensionOptional
    : '(' decimalLiteral (',' decimalLiteral)? ')'
    ;

ifExists
    : IF EXISTS
    ;

ifNotExists
    : IF NOT EXISTS
    ;