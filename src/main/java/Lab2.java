import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Lab2
{
        static   boolean  haserror=false;
    private static CmmParser LoadParser(String filePath) throws IOException {
        InputStream file = new FileInputStream(filePath);
        CharStream input = CharStreams.fromStream(file);
        CmmLexer lexer=new CmmLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return  new CmmParser(tokens);
    }
    public static  void main(String[] args) throws IOException {
        // String  filePath=args[0];
        String filePath="/Users/yjp/nju/大三上/编译原理/Lab/src/resources/test1.cmm";
        CmmParser parser=LoadParser(filePath);
        parser.removeErrorListeners();;
        parser.addErrorListener(new MyErrorListener());

       ParseTree tree=parser.program();
        if(parser.getNumberOfSyntaxErrors()>0) return ;
//        if(haserror)
//            return;
     ParseTreeWalker walker=new ParseTreeWalker();
     ParseTreeListener listener=new Listener();
        walker.walk(listener,tree);
    }
    public static String FloatParse(String text){
        StringBuilder buffer = new StringBuilder();
        if(text.charAt(0)=='.'){
            buffer.append('0');
            buffer.append(text);
        }else if(text.contains(".E") || text.contains(".e")){
            int idx=text.indexOf(".");
            buffer.append(text);
            buffer.insert(idx+1, '0');
        }else{
            buffer.append(text);
        }
        BigDecimal value = new BigDecimal(buffer.toString());
        value = value.setScale(6, RoundingMode.DOWN);
        return value.toPlainString();
    }
}
