import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.HashSet;

public class MyErrorListener  extends BaseErrorListener {
    private HashSet<Integer> set=new HashSet<>();
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        Lab2.haserror=true;
        if(set.contains(line))
            return;
        else set.add(line);
        System.err.println("Error type B at Line " + line + ":" +" " +msg);
    }
}
