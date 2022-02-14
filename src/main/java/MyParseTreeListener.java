import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyParseTreeListener implements ParseTreeListener {

    @Override
    public void visitTerminal(TerminalNode terminalNode) {
        return;
    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {
        return;
    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        String s=parserRuleContext.toString();
        String t=parserRuleContext.getText();
      int n=  parserRuleContext.getAltNumber();
      RuleContext text= parserRuleContext.getRuleContext();
        return;
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {
        parserRuleContext.toString();
        return;
    }
}
