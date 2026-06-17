grammar Simple;

program
    : PROGRAM ID BRACKET_OPEN sentence* BRACKET_CLOSE EOF
    ;

sentence: 
    var_decl
    | var_assign
    | println
    | conditional
    | for_loop
    ;

block: BRACKET_OPEN sentence* BRACKET_CLOSE;

var_decl: 
    VAR ID (COLON type)? (ASSIGN expression)? SEMICOLON
    ;

var_assign: ID ASSIGN expression SEMICOLON;

println: PRINTLN expression SEMICOLON;

conditional: 
    IF PAR_OPEN expression PAR_CLOSE block ELSE block
    ;

for_loop: 
    FOR PAR_OPEN init=for_init 
    SEMICOLON condition=expression 
    SEMICOLON update=for_update 
    PAR_CLOSE block
    ;

for_init: 
    VAR ID (COLON type)? ASSIGN expression
    | ID ASSIGN expression
    ;

for_update: ID ASSIGN expression;

type: 
    INT_TYPE
    | REAL_TYPE
    | STRING_TYPE
    | BOOL_TYPE
    ;

expression: logic_or;

logic_or: logic_and (OR logic_and)*;

logic_and: equality (AND equality)*;

equality: comparison ((EQ | NEQ) comparison)*;

comparison: additive ((GT | LT | GEQ | LEQ) additive)*;

additive: multiplicative ((PLUS | MINUS) multiplicative)*;

multiplicative: unary ((MULT | DIV) unary)*;

unary: 
    NOT unary
    | MINUS unary
    | primary
    ;

primary: 
	NUMBER
    | REAL_NUMBER
    | STRING
    | BOOLEAN
    | ID
    | PAR_OPEN expression PAR_CLOSE
    ;

PROGRAM: 'program';
VAR: 'var';
PRINTLN: 'println';
IF: 'if';
ELSE: 'else';
FOR: 'for';

INT_TYPE: 'int';
REAL_TYPE: 'real';
STRING_TYPE: 'string';
BOOL_TYPE: 'bool';

BOOLEAN: 'true' | 'false';

GEQ: '>=';
LEQ: '<=';
EQ: '==';
NEQ: '!=';
GT: '>';
LT: '<';
ASSIGN: '=';

AND: '&&';
OR: '||';
NOT: '!';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';

BRACKET_OPEN: '{';
BRACKET_CLOSE: '}';
PAR_OPEN: '(';
PAR_CLOSE: ')';
SEMICOLON: ';';
COLON: ':';

REAL_NUMBER: [0-9]+ '.' [0-9]+;
NUMBER: [0-9]+;
STRING: '"' ( ~["\\\r\n] | '\\' . )* '"';

ID: [a-zA-Z_][a-zA-Z_0-9]*;

LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t\n\r]+ -> skip;
