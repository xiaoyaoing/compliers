// Generated from CmmParser.g4 by ANTLR 4.9.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link CmmParserListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class Listener implements CmmParserListener {
    private  static int   getheight(ParserRuleContext programContext){
        if(programContext.parent==null)
            return 0;
        return 2+getheight((ParserRuleContext) programContext.parent);
    }
    private  static  int getline(ParserRuleContext ctx)
    {
        return ctx.start.getLine();
    }

    private static void  printSpaces(ParserRuleContext ctx) {
        for(int i=0;i<getheight(ctx);i++)
            System.err.print(' ');
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterProgram(CmmParser.ProgramContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Program (%d)\n",getline(ctx));
    }



    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(CmmParser.ProgramContext ctx) {
        int k=1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExtDef(CmmParser.ExtDefContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("ExtDef (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExtDef(CmmParser.ExtDefContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExtDecList(CmmParser.ExtDecListContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("ExtDecList (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExtDecList(CmmParser.ExtDecListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSpecifier(CmmParser.SpecifierContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Specifier (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSpecifier(CmmParser.SpecifierContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStructSpecifier(CmmParser.StructSpecifierContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("StructSpecifier (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStructSpecifier(CmmParser.StructSpecifierContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterOptTag(CmmParser.OptTagContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("OptTag (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOptTag(CmmParser.OptTagContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTag(CmmParser.TagContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Tag (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTag(CmmParser.TagContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVarDec(CmmParser.VarDecContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("VarDec (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVarDec(CmmParser.VarDecContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunDec(CmmParser.FunDecContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("FunDec (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunDec(CmmParser.FunDecContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVarList(CmmParser.VarListContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("VarList (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVarList(CmmParser.VarListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParamDec(CmmParser.ParamDecContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("ParamDec (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParamDec(CmmParser.ParamDecContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCompSt(CmmParser.CompStContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("CompSt (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCompSt(CmmParser.CompStContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStmtList(CmmParser.StmtListContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("StmtList (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmtList(CmmParser.StmtListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStmt(CmmParser.StmtContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Stmt (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmt(CmmParser.StmtContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDefList(CmmParser.DefListContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("DefList (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDefList(CmmParser.DefListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDef(CmmParser.DefContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Def (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDef(CmmParser.DefContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDecList(CmmParser.DecListContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("DecList (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDecList(CmmParser.DecListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDec(CmmParser.DecContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Dec (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDec(CmmParser.DecContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExp(CmmParser.ExpContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Exp (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExp(CmmParser.ExpContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArgs(CmmParser.ArgsContext ctx) {
        if(ctx.children==null) return;
        printSpaces(ctx);
        System.err.printf("Args (%d)\n",getline(ctx));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArgs(CmmParser.ArgsContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) {
        Token t= node.getSymbol();
        String tokenName=CmmLexer.VOCABULARY.getSymbolicName(t.getType());
        if(tokenName.equals("EOF"))return;
        printSpaces((ParserRuleContext) node.getParent() );
        System.err.print("  ");
        if(tokenName.equals("ID"))
            System.err.println("ID: "+t.getText());
        else if(tokenName.equals("TYPE"))
            System.err.println("TYPE: "+t.getText());
        else if(tokenName.equals("INT"))
            System.err.println("INT: "+ String.valueOf(Integer.decode(t.getText())));
        else if(tokenName.equals("FLOAT"))
            System.err.println("FLOAT: "+ Lab2.FloatParse(t.getText()));
        else
            System.err.println(tokenName);



    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) {

    }
}