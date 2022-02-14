lexer grammar CmmLexer;

channels {
    ESQLCOMMENT,
    ERRORCHANNEL
}

//SKIP 当Antlr解析到下面的代码时，会选择跳过
// 遇到 \t\r\n 会忽略
SPACE: [\t\r\n ]+ -> skip;
// 遇到 /*!  */ 会当作注释跳过
SL_COMMENT : '//' .*? '\n' -> skip;  // non-greedy
ML_COMMENT : '/*' .*? '*/' -> skip;  // non-greedy
DOT:'.';




TYPE:  'int' | 'float';


SEMI:[;];
COMMA:[,];

ASSIGNOP:[=];
RELOP:'>' | '<' | '>=' | '<=' | '==' | '!=';
PLUS:[+];
MINUS:[-];
STAR:[*];
DIV:[/];
AND:'&&';
OR:'||';
NOT:'!';
LP:'(';
RP:')';
LB:'[';
RB:']';
LC:'{';
RC:'}';
STRUCT : 'struct' ;
RETURN :'return';
IF :'if';
ELSE: 'else';
WHILE : 'while';

INT: OCTINT | HEXINT  |  DECINT ;
FLOAT:  NORMALFLOAT | EXPFLOAT;

ID: ( '_' | [a-z]  | [A-Z]) ( '_' | [a-zA-Z] | [0-9])*;
fragment OCTINT: [0][0-7]+;
fragment DECINT: '0'[xX][0-9A-Fa-f]+;
fragment HEXINT: '0'| [1-9][0-9]*;


fragment NORMALFLOAT: Types.INT '.' DEC_DIGIT+;
fragment  EXPFLOAT: (NORMALFLOAT | (DEC_DIGIT + '.') | ('.' DEC_DIGIT+))[Ee][+-]?DEC_DIGIT+;
fragment DEC_DIGIT: [0-9];

// 使用ID_LETTER代表a-z的大写小写字母和_
fragment ID_LETTER: [a-zA-Z];
// 表示用A代表a和A，这样就可以不区分大小写了，以下同理
fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment Types.F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];