import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static CmmParser LoadParser(String filePath) throws IOException {
        InputStream file = new FileInputStream(filePath);
        CharStream input = CharStreams.fromStream(file);
        CmmLexer lexer=new CmmLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return  new CmmParser(tokens);
    }

   static void f() throws IOException,NullPointerException {
        String filePath= "/Users/yjp/nju/大三上/编译原理/Lab/src/resources/L3tests/normalcases/normaltest00.cmm";

        CmmParser parser=LoadParser(filePath);
        ParseTree tree=parser.program();
        ParseTreeListener listener=new CmmSemanticListener();
        ParseTreeWalker walker=new ParseTreeWalker();
        walker.walk(listener,tree);
//        ((CmmSemanticListener) listener).report();
        CmmInterCodeListener interCodeListener=new CmmInterCodeListener();
        CmmInterCodeListener.semanticListener= (CmmSemanticListener) listener;
        walker.walk(interCodeListener,tree);
       InterCode t= interCodeListener.code;
       String outidr="/Users/yjp/nju/大三上/编译原理/Lab/src/resources/L4";
       interCodeListener.OutInter(outidr);
    }

    public  static  void main(String[] args) throws IOException {
        f();

    }

}
