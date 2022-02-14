parser grammar CmmParser;
options{
    tokenVocab=CmmLexer;
}

program:extDef * EOF;
extDef:specifier extDecList SEMI|
        specifier SEMI |
        specifier funDec compSt;
extDecList: varDec (COMMA varDec)*;

specifier:TYPE |structSpecifier;
structSpecifier:STRUCT optTag LC defList RC
        |STRUCT tag;
optTag:ID ? ;
tag:ID;

varDec://
        ID ((LB Types.INT RB)
        | (LB {notifyErrorListeners("array size must be an integer constant, not FLOAT");}FLOAT RB)
        | (LB {notifyErrorListeners("array size must be an integer constant, not ID");}ID RB ))*
        ;

funDec: ID LP varList RP
        | ID LP RP;
varList:paramDec (COMMA paramDec)*; // int i
paramDec:specifier varDec; //int i

compSt:LC defList stmtList RC;
stmtList:stmt*;
stmt:exp SEMI
|compSt
| RETURN exp? SEMI
|IF LP exp RP stmt
|IF LP exp RP stmt ELSE stmt
|WHILE LP exp RP stmt;


defList:def * ;
def:specifier decList SEMI;
decList:dec (COMMA dec)*;

dec: varDec ASSIGNOP exp
|varDec ;

exp:
LP exp RP
|ID LP args RP
|ID LP RP
|exp LB exp RB
|exp DOT ID
|MINUS exp
|NOT exp
|exp STAR exp
|exp DIV exp
|exp PLUS exp
|exp MINUS exp
|exp RELOP exp
|exp AND exp
|exp OR exp
|exp ASSIGNOP exp
 //
|ID
|INT
|FLOAT;
args: exp (COMMA exp)*;