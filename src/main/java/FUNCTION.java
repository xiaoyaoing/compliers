import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class FUNCTION extends  Type{
    private  Type returnType;
    private   ArrayList<Pair<String, Type>> paramList;



    public FUNCTION(Type returnType, ArrayList<Pair<String, Type>> arglist) {
        this.returnType=returnType;
        this.paramList=arglist;
        this.type=Kind.FUNCTION_TYPE;
    }

    public FUNCTION() {

    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public ArrayList<Pair<String, Type>> getParamList() {
        return paramList;
    }

    public void setParamList(ArrayList<Pair<String, Type>> paramList) {
        this.paramList = paramList;
    }
}
