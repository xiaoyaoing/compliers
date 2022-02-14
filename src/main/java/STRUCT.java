import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class STRUCT extends  Type {
    private ArrayList<Pair<String, Type>> paramList=new ArrayList<Pair<String, Type>>();
    String name="";


    public  STRUCT(ArrayList<Pair<String, Type>> paramList){
        this.paramList=paramList;
        this.type=Kind.STRUCT_TYPE;
    }

    public  STRUCT(String name,ArrayList<Pair<String, Type>> paramList){
        this.paramList=paramList;
        this.type=Kind.STRUCT_TYPE;
        this.name=name;
    }
    public boolean containsFiled(String fieldName){
        for(int i=0;i<paramList.size();i++)
            if(paramList.get(i).a.equals(fieldName))
                return true;
            return false;
    }
    public  int getSize(){
        int size=0;
        for(Pair<String, Type> i :paramList ){
            size+=i.b.getSize();
        }
        return size;
    }

    public ArrayList<Pair<String, Type>> getParamList() {
        return paramList;
    }

    public void setParamList(ArrayList<Pair<String, Type>> paramList) {
        this.paramList = paramList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public STRUCT() {
        this.type=Kind.STRUCT_TYPE;
    }

    public Type getField(String text) {
        for(int i=0;i<paramList.size();i++)
            if(paramList.get(i).a.equals(text))
                return paramList.get(i).b;
            return null;

    }

    @Override
    public  boolean same(Type t){
        if(t.type!=Kind.STRUCT_TYPE)
            return false;
        STRUCT another=(STRUCT) t;
        if(another.paramList.size()!=(paramList.size()))
            return false;
        for(int i=0;i<paramList.size();i++)
            if(!another.paramList.get(i).b.same(paramList.get(i).b))
                return false;

            return true;
    }

    public int getoffset(String text) {
        int ans=0;
        int idx=0;
        while(idx<this.paramList.size() &&  !this.paramList.get(idx).a.equals(text)){
            ans+=paramList.get(idx).b.getSize();
            idx++;
        }
        return ans;
    }
}
