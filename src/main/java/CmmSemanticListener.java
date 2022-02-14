import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

class descriptor{
    boolean isType;
    String name;
    Type type;
    boolean haserror;
    boolean isStruct;
    ArrayList<Integer> array=new ArrayList<Integer>();
    ArrayList<Pair<String,Type>> arglist=new  ArrayList<Pair<String,Type>>();
    HashSet<String> structFieldNames;
    public descriptor(){
        this.structFieldNames=new HashSet<>();
    }
    public descriptor(boolean isType, String name, ArrayList<Integer> array) {
        this.isType = isType;
        this.name = name;
        this.array = array;
    }

    public descriptor(boolean isType, String name) {
        this.isType = isType;
        this.name = name;
    }

    public descriptor(String name,ArrayList<Pair<String, Type>> paramList) {
        this.arglist=paramList;
        this.name=name;
    }

    public descriptor(boolean haserror) {
        this.haserror=haserror;
    }

    public descriptor(Type type) {
        this.type=type;

    }

    public int  getNum(){
        assert isArray();
        int ans=1;
        for(Integer i:array)
            ans*=i;
        return ans;
    }
    public  boolean isArray(){
        return this.array.size()>0;
    }

    public boolean isType() {
        return isType;
    }

    public void setType(boolean type) {
        isType = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getstructFieldNames() {
        return  structFieldNames;
    }
}
public class CmmSemanticListener extends  CmmParserBaseListener{

    public  static int  structNumber=0; //匿名结构体数量
     ParseTreeProperty<descriptor> values=new ParseTreeProperty();
     SymbolTable symbolTable=new SymbolTable();
     ArrayList<Pair<Integer,Integer>> errors=new ArrayList<>();
     HashSet<Integer> errorLines=new HashSet<>();
     HashSet<ParseTree> errorTrees=new HashSet<>();
     HashSet<String> filedName=new HashSet<>();
     private  boolean isLeave(ParseTree tree){
         return  tree instanceof TerminalNode;
     }
     private   static Type getTypeFromName(String name){
         if(name.equals("INT"))
             return new INT();
         if(name.equals("FLOAT"))
             return new FLOAT();
         return null;
     }

     public   void reportError(int line,int type,ParseTree ...t){
//         if(this.errorLines.contains(line))
//             return ;
         if(t.length!=0)
         this.errorTrees.add(t[0]);
         this.errors.add(new Pair<>(line,type));
         this.errorLines.add(line);
//         System.err.printf("Error type %d at Line %d: \n",type,line);
     }
    private  boolean compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        if(!o1.a.equals(o2.a))
            return o1.a<o2.a;
        return o1.b>o2.b;
    }
     public  void report(){
         for(int i=0;i<errors.size();i++)
         {   int  minal=i;
             for(int j=i+1;j< errors.size();j++)
                if(compare(errors.get(j),errors.get(minal)))
                    minal=j;
             Pair<Integer, Integer> temp=errors.get(i);
             errors.set(i,errors.get(minal));
             errors.set(minal,temp);
         }
         int curline=-1;
         boolean haspr=false;
         for(int j=0;j<errors.size();j++){
             Pair<Integer,Integer> i=errors.get(j);
//             if(j!=errors.size()-1 && errors.get(j+1).a==i.a &&
//                     errors.get(j+1).b==i.b)
//                 continue;
             if(i.a!=curline || true){
                 curline=i.a;
                 System.err.printf("Error type %d at Line %d: \n",i.b,i.a);
             }
         }
     }


    private  static  int getline(ParserRuleContext ctx)
    {
        return ctx.start.getLine();
    }
    /* 根据两个描述符向符号表增加表项*/
    private void addSymbol(descriptor spec, descriptor id) {

        if(id.isArray()){
        ARRAY array=new ARRAY(spec.type,id.array);
        symbolTable.insert(id.name,array);
        return ;
     }
        symbolTable.insert(id.name, spec.type);


    }

    public  Type getExpType(CmmParser.ExpContext exp){
//        if(errorTrees.contains(exp))
//            return null;
        if(exp.LP()!=null){
            if(exp.ID()==null)
                return getExpType(exp.exp(0));
            FUNCTION f= (FUNCTION) symbolTable.get((exp.ID().getText()));
            if(f==null)
//                reportError(getline(exp),2); ;
                ;

         else    return f.getReturnType();
        }
      else   if(exp.DOT()!=null){
           if(getExpType(exp.exp(0)).getType()!=Kind.STRUCT_TYPE)
               return null;
            STRUCT struct= (STRUCT) getExpType(exp.exp(0));
         Type t=   struct.getField(exp.ID().getText());
         if(t==null)
         {
             //reportError(getline(exp),14);
             return null;
         }
         return t;
        }   //结构体访问
       else  if(exp.LB()!=null){
           Type t=getExpType(exp.exp(0));
           if(t.getType()!=Kind.ARRAY_TYPE)
           {
               //reportError(getline(exp),10);
               return null;}
           if(getExpType(exp.exp(1))!=null  &&   getExpType(exp.exp(1)).getType()!=Kind.INT_TYPE)
           {
//               reportError(getline(exp),12);
               return null;
           }
           ARRAY a=(ARRAY) t;
           if(a.getNums().size()==1)
               return a.getElement();
           else
               return new ARRAY(a.getElement(),
                       getSubList(a.getNums(),1,a.getNums().size()));

           }
            //数组访问
      else   if(exp.ASSIGNOP()!=null){
          return getExpType((exp.exp(0)));
        }
      else if(exp.ID()!=null)
          return symbolTable.get(exp.ID().getText());
      else if(exp.INT()!=null)
          return new INT();
      else if(exp.FLOAT()!=null)
          return new FLOAT();
      else if(exp.RELOP()!=null){
          return new INT();
        }
      else
          return getExpType(exp.exp(0));
    return null;
    }

    private ArrayList<Integer> getSubList(ArrayList<Integer> nums, int i, int size) {
        ArrayList<Integer> t=new ArrayList<>();
        for(int j=i;j<size;j++)
            t.add(nums.get(i));
        return t;
    }

    private Type LoadTypeFromKind(Kind type) {
        if(type==Kind.INT_TYPE)
            return new INT();
        if(type==Kind.FLOAT_TYPE)
            return new FLOAT();
        if(type==Kind.ARRAY_TYPE)
            return new ARRAY();
        if(type==Kind.FUNCTION_TYPE)
            return new FUNCTION();
        if(type==Kind.STRUCT_TYPE)
            return new STRUCT();
        return null;

    }


    @Override
    public void enterProgram(CmmParser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(CmmParser.ProgramContext ctx) {
        super.exitProgram(ctx);

        CmmInterCodeListener.symbolTable=this.symbolTable;

    }

    @Override
    public void enterExtDef(CmmParser.ExtDefContext ctx) {
//        if(ctx.funDec()!=null && symbolTable.contains(ctx.funDec().ID().getText()))
//        {    reportError(getline(ctx),4,ctx);
//            while(ctx.children.size()!=0)
//                ctx.removeLastChild();}
//        super.enterExtDef(ctx);
    }
    void hanldeReturn(CmmParser.StmtContext stmt,Type returnType){
        if(stmt.RETURN()!=null)
        {if(getExpType(stmt.exp())!=null &&   !getExpType(stmt.exp()).same(returnType))
                reportError(getline(stmt),8,stmt);}
        else if(stmt.compSt()!=null)
            for(CmmParser.StmtContext i: stmt.compSt().stmtList().stmt())
                hanldeReturn(i,returnType);
          else
        {for(CmmParser.StmtContext i:stmt.stmt())
                hanldeReturn(i,returnType);}
    }
    @Override
    public void exitExtDef(CmmParser.ExtDefContext ctx) {
        if(childHasError(ctx.children))
            return ;
        if(ctx.children.isEmpty())
            return ;
        String text=ctx.specifier().getText();
        if(ctx.funDec()!=null){
        descriptor t=    values.get(ctx.specifier());
        if(t==null) return ;
           Type returnType=t.type;
          for( CmmParser.StmtContext i:  ctx.compSt().stmtList().stmt())
             hanldeReturn(i,returnType);
        }
        else if(ctx.extDecList()!=null){
                descriptor spec=values.get(ctx.specifier());
                if(spec==null)
                    return ;
                for(CmmParser.VarDecContext i: ctx.extDecList().varDec())
                {descriptor id= values.get(i);
                if(symbolTable.contains(id.name) )
                    reportError(getline(i),3,ctx);
            else    addSymbol(spec,id);}

        }





    }

    private Type getType(CmmParser.SpecifierContext specifier) {
        if(specifier.structSpecifier()!=null){
               return values.get(specifier).type;
        }
        else return specifier.getText().equals("int")?new INT():new FLOAT();


    }

    @Override
    public void enterExtDecList(CmmParser.ExtDecListContext ctx) {
        super.enterExtDecList(ctx);
    }

    @Override
    public void exitExtDecList(CmmParser.ExtDecListContext ctx) {
        super.exitExtDecList(ctx);
    }

    @Override
    public void enterSpecifier(CmmParser.SpecifierContext ctx) {
        assert  ctx.children.size()==1;

        if(isLeave(ctx.getChild(0)))
        {
          boolean c=    ctx.TYPE().getText().equals("int");
            values.put(ctx,new descriptor(c?new INT():new FLOAT()));
        }
        else {
            ;
        }


    }

    @Override
    public void exitSpecifier(CmmParser.SpecifierContext ctx) {
        super.exitSpecifier(ctx);
        if(ctx.structSpecifier()!=null)
        {
            descriptor d=values.get(ctx.structSpecifier());
            if(d==null)
                return ;
            d.isStruct=true;
            values.put(ctx,d);
        }
    }

    @Override
    public void enterStructSpecifier(CmmParser.StructSpecifierContext ctx) {
        if(ctx.optTag()!=null)
        {String name=ctx.optTag().ID()!=null?ctx.optTag().ID().getText():generateAstructName();
        if(symbolTable.contains(name) && ctx.optTag().ID()!=null)
        {  reportError(getline(ctx),16);
        while(ctx.children.size()>0)
            ctx.removeLastChild();
        }}

    }

    @Override
    public void exitStructSpecifier(CmmParser.StructSpecifierContext ctx) {
        //结构体定义
        if(ctx.optTag()!=null){
            String name=ctx.optTag().ID()!=null?ctx.optTag().ID().getText():generateAstructName();
            if(symbolTable.contains(name) && ctx.optTag().ID()!=null)
                reportError(getline(ctx),16);
            STRUCT struct=new STRUCT();
           for(CmmParser.DefContext i: ctx.defList().def()){
             descriptor d=  values.get(i.specifier());
            for(CmmParser.DecContext j: i.decList().dec())
            {   if(j.ASSIGNOP()!=null)
            {
               ; //reportError(getline(j),15);
            }
                descriptor t= values.get(j.varDec());
            if(!t.haserror)
//            if(struct.containsFiled(t.name))
//            {
//                reportError(getline(j),15);
//                continue;
//            }

                //addSymbol(d,t);
                struct.getParamList().add(new Pair<>(t.name,symbolTable.get(t.name)));
            }
           }
            values.put(ctx,new descriptor(struct));
             symbolTable.insert(name,struct);
             symbolTable.addclass(name);
        }
        else if(ctx.tag()!=null){
//            if(symbolTable.contains(ctx.tag().ID().getText()))
//                reportError(getline(ctx),16);
            STRUCT type;
            if(!symbolTable.contains(ctx.tag().getText()))
                type=null;
            else  type= symbolTable.get(ctx.tag().getText()).type==Kind.STRUCT_TYPE?
                    (STRUCT) symbolTable.get(ctx.tag().getText()):null;
            descriptor t=new descriptor(type);
            if(type==null || !symbolTable.classes.contains(ctx.tag().getText()))
                reportError(getline(ctx),17);
             values.put(ctx,t);
        }

    }

    private String generateAstructName() {
        structNumber++;
        return "No Name Struct"+structNumber;
    }

    @Override
    public void enterOptTag(CmmParser.OptTagContext ctx) {
        super.enterOptTag(ctx);
    }

    @Override
    public void exitOptTag(CmmParser.OptTagContext ctx) {
        super.exitOptTag(ctx);
    }

    @Override
    public void enterTag(CmmParser.TagContext ctx) {
        super.enterTag(ctx);
    }

    @Override
    public void exitTag(CmmParser.TagContext ctx) {
        super.exitTag(ctx);
    }

    @Override
    public void enterVarDec(CmmParser.VarDecContext ctx) {
         ArrayList<Integer> list=new ArrayList<Integer>();
        String id=ctx.getStart().getText();
//        if(! (ctx.parent instanceof CmmParser.ParamDecContext || ctx.parent instanceof CmmParser.DecContext) && !symbolTable.contains(id))
//            reportError(getline(ctx),1);  //未定义就使用
        for(int i=1;i<ctx.children.size();i++)
        {
            if(i%3==2)
            list.add(Integer.valueOf(ctx.getChild(i).getText()));
        }
        descriptor d=new descriptor(false,id,list);
        values.put(ctx,d);
    }

    @Override
    public void exitVarDec(CmmParser.VarDecContext ctx) {
        super.exitVarDec(ctx);
    }

    @Override
    public void enterFunDec(CmmParser.FunDecContext ctx) {
        super.enterFunDec(ctx);
    }

    @Override
    public void exitFunDec(CmmParser.FunDecContext ctx) {
       String funcame= ctx.ID().getText();
       if(symbolTable.contains(funcame)){
           reportError(getline(ctx),4,ctx);
           values.put(ctx,new descriptor(true));
           return ;
       }

       CmmParser.VarListContext varList= ctx.varList();
       ArrayList<Pair<String,Type>> paramList=new ArrayList<Pair<String,Type>> ();
       if(varList!=null)
        for(CmmParser.ParamDecContext i:varList.paramDec()){
            if(errorTrees.contains(i))
                continue;
            String paramId=values.get(i.varDec()).name;
       paramList.add(new Pair<>(paramId,symbolTable.get(paramId)));
     }
        descriptor descriptor=new descriptor(funcame,paramList);
        values.put(ctx,descriptor);
     CmmParser.ExtDefContext ext= (CmmParser.ExtDefContext)ctx.parent;
        Type returnType=getType(ext.specifier());
        if(symbolTable.contains(ctx.ID().getText()))
        {
            return;
        }
        symbolTable.insert(descriptor.name,new FUNCTION(returnType,descriptor.arglist));
    }

    @Override
    public void enterVarList(CmmParser.VarListContext ctx) {
        super.enterVarList(ctx);
    }

    @Override
    public void exitVarList(CmmParser.VarListContext ctx) {
        super.exitVarList(ctx);
    }

    @Override
    public void enterParamDec(CmmParser.ParamDecContext ctx) {
        super.enterParamDec(ctx);
    }

    @Override
    public void exitParamDec(CmmParser.ParamDecContext ctx) {
        descriptor spec=values.get(ctx.specifier());
        descriptor id=values.get(ctx.varDec());
        if(symbolTable.contains(id.getName()))
        {reportError(getline(ctx.varDec()),3);
        errorTrees.add(ctx);
        return ;}
        addSymbol(spec,id);
        super.exitParamDec(ctx);
    }

    @Override
    public void enterCompSt(CmmParser.CompStContext ctx) {
        super.enterCompSt(ctx);
    }

    @Override
    public void exitCompSt(CmmParser.CompStContext ctx) {
        super.exitCompSt(ctx);
    }

    @Override
    public void enterStmtList(CmmParser.StmtListContext ctx) {
        super.enterStmtList(ctx);
    }

    @Override
    public void exitStmtList(CmmParser.StmtListContext ctx) {
        super.exitStmtList(ctx);
    }

    @Override
    public void enterStmt(CmmParser.StmtContext ctx) {
        super.enterStmt(ctx);
    }

    @Override
    public void exitStmt(CmmParser.StmtContext ctx) {
        if(ctx.IF()!=null || ctx.WHILE()!=null)
        {   if(errorTrees.contains(ctx.exp()))
            return ;
            if(getExpType(ctx.exp())==null)
                return ;
            else if(getExpType(ctx.exp()).getType()!=Kind.INT_TYPE)
                    reportError(getline(ctx),7);
        }
        super.exitStmt(ctx);
    }

    @Override
    public void enterDefList(CmmParser.DefListContext ctx) {

        values.put(ctx,new descriptor());
        super.enterDefList(ctx);
    }

    @Override
    public void exitDefList(CmmParser.DefListContext ctx) {

        super.exitDefList(ctx);
    }

    @Override
    public void enterDef(CmmParser.DefContext ctx) {
        super.enterDef(ctx);
    }

    @Override
    public void exitDef(CmmParser.DefContext ctx) {
        boolean isstruct=ctx.parent.parent instanceof CmmParser.StructSpecifierContext;

        CmmParser.SpecifierContext specifier =  ctx.specifier();
        descriptor spec=values.get(specifier);
        if(spec==null)
            return ;
         CmmParser.DecListContext list=ctx.decList();

         for(int i=0;i<(list.children.size()+1)/2;i++)
         {
          descriptor id=values.get(list.dec(i).varDec());
             if(isstruct &&
                     (symbolTable.contains(id.name)
                        || (list.dec(i).ASSIGNOP()!=null)))
             {
                 reportError(getline(list.dec(i).varDec()),15);
                 values.get(list.dec(i).varDec()).haserror=true;
                // list.children.remove(i*2+1);
                 continue;}
         if( list.dec(i).exp()!=null){
           if( getExpType(list.dec(i).exp())!=null &&
                   !  getExpType(list.dec(i).exp()).same(spec.type))
               reportError(getline(ctx),5);
         }

          if(symbolTable.contains(id.getName()))
          {reportError(getline(list.dec(i).varDec()),3); continue;}
          if(isstruct)
          filedName.add(id.getName());
          addSymbol(spec,id);
         }

    }


    @Override
    public void enterDecList(CmmParser.DecListContext ctx) {

        super.enterDecList(ctx);
    }

    @Override
    public void exitDecList(CmmParser.DecListContext ctx) {
        super.exitDecList(ctx);
    }

    @Override
    public void enterDec(CmmParser.DecContext ctx) {
        if(ctx.ASSIGNOP()!=null){
            CmmParser.DefContext t= (CmmParser.DefContext) ctx.parent.parent;
            Type type=  getExpType(ctx.exp());
            if(type==null)
                return ;
//            if(!values.get(t.specifier()).type.same(getExpType(ctx.exp())))
//                reportError(getline(ctx),5);
        }
        super.enterDec(ctx);
    }

    @Override
    public void exitDec(CmmParser.DecContext ctx) {


        super.exitDec(ctx);
    }

    @Override
    public void enterExp(CmmParser.ExpContext ctx) {
      

    }
    void handleExpId(CmmParser.ExpContext ctx){
//        if(errorLines.contains(getline(ctx)))
//            return;
        if( ctx.ID()!=null)
        {
            if(ctx.LP()!=null)
            {

                if(symbolTable.contains(ctx.ID().getText()) &&
                        symbolTable.get(ctx.ID().getText()).getType()!= Kind.FUNCTION_TYPE)
                {  reportError(getline(ctx),11,ctx); }
                else  if(!symbolTable.contains(ctx.ID().getText()))  //未定义的函数调用
                    reportError(getline(ctx),2,ctx);
                else    if(!match(ctx.args(),symbolTable.get(ctx.ID().getText())))
                    reportError(getline(ctx),9,ctx);
            }
            else   if(ctx.DOT()==null && !symbolTable.contains(ctx.ID().getText()))  //未定义的变量
                reportError(getline(ctx),1,ctx);

        }
    }

    void handleexpAssign(CmmParser.ExpContext ctx){

        if(ctx.ASSIGNOP()!=null){
            if(notLeftVal(ctx.exp(0)))
                reportError(getline(ctx),6,ctx);
         else   if(getExpType(ctx.exp(0))==null || getExpType(ctx.exp(1))==null)
               return ;
           else if(!getExpType(ctx.exp(0)).same(getExpType(ctx.exp(1))))
                reportError(getline(ctx),5,ctx);

        }
    }
    @Override
    public void exitExp(CmmParser.ExpContext ctx) {
//        if(errorLines.contains(getline(ctx)))
//            return ;
//        for(CmmParser.ExpContext i:ctx.exp())
//            if(getExpType(i)==null)
//                return ;
        if(childHasError(ctx.children))
            return ;

        handleExpId(ctx);
        handleexpAssign(ctx);
        handleExpDot(ctx);
        handleExpCompute(ctx);
        handleExpArray(ctx);
    }

    private boolean childHasError(List<ParseTree> childs) {
        for(ParseTree i:childs)
        {
            if(errorTrees.contains(i))
                return true;
        }
        return false;
    }

    private void handleExpArray(CmmParser.ExpContext ctx) {
        if(ctx.LB()!=null){
            Type t=getExpType(ctx.exp(0));  //检查是否对数组对象引用
            if(t !=null &&  t.getType()!=Kind.ARRAY_TYPE)
                reportError(getline(ctx),10,ctx);
            Type t2=getExpType(ctx.exp(1));

            if( t2!=null &&
                    t2.getType()!=Kind.INT_TYPE)
                reportError(getline(ctx),12,ctx);
        }
    }

    private void handleExpCompute(CmmParser.ExpContext ctx) {
        int line=getline(ctx);
        if(ctx.exp().isEmpty())
            return ;
        if(getExpType(ctx.exp(0))==null)
            return ;
        Kind firstType=getExpType(ctx.exp(0)).getType();

        boolean c=ctx.STAR()!=null || ctx.DIV()!=null || ctx.PLUS()!=null ||
                ctx.MINUS()!=null || ctx.RELOP()!=null;
        if(ctx.MINUS()!=null && ctx.exp().size()==1) //负号
        {if(firstType!= Kind.INT_TYPE &&  firstType!= Kind.FLOAT_TYPE)
                reportError(line,7,ctx);}
        else  if(ctx.NOT()!=null)
            {if(firstType!=Kind.INT_TYPE)
            reportError(line,7,ctx);}
        else    if(ctx.STAR()!=null || ctx.DIV()!=null || ctx.PLUS()!=null ||
                    ctx.MINUS()!=null )  //加减乘除 比较
            {
                if(getExpType(ctx.exp(1))==null)
                    return ;
                Kind secondType=getExpType(ctx.exp(1)).getType();;
                if(firstType!=secondType)
                    reportError(line,7,ctx);
             else    if(firstType!=Kind.INT_TYPE && firstType!=Kind.FLOAT_TYPE )
                 reportError(line,7,ctx);
            }
       if(ctx.RELOP()!=null){
           if(getExpType(ctx.exp(1))==null)
               return ;
           Kind secondType=getExpType(ctx.exp(1)).getType();
           if(firstType!=secondType)
               reportError(line,7,ctx);
           else    if(firstType!=Kind.INT_TYPE && firstType!=Kind.FLOAT_TYPE )
               reportError(line,7,ctx);


       }
      else if(ctx.AND()!=null || ctx.OR()!=null)
            {
                if(getExpType(ctx.exp(1))==null)
                    return ;
                Kind secondType=getExpType(ctx.exp(1)).getType();
                if(firstType!=Kind.INT_TYPE || secondType!=Kind.INT_TYPE)
                    reportError(line,7,ctx);
            }

    }

    private void handleExpDot(CmmParser.ExpContext ctx) {
        if(errorLines.contains(getline(ctx)))
            return;
        if(ctx.DOT()!=null){
            Type type =getExpType(ctx.exp(0));
            if(type==null)
                return;
            if(type.getType()!=Kind.STRUCT_TYPE)
            {reportError(getline(ctx),13,ctx); return ;}
            //非结构体

//            if(!symbolTable.contains( ((STRUCT) type).getName()))
//                reportError(getline(ctx),17);  //未定义的结构体
            String fieldName=ctx.ID().getText();
           if(! ((STRUCT) type).containsFiled(fieldName))
               reportError(getline(ctx),14,ctx);    //未定义的属性

        }
    }

    private boolean match(CmmParser.ArgsContext args, Type type) {

        if(type.getType()!=Kind.FUNCTION_TYPE)
            return false;
        type=(FUNCTION)type;
        List<Pair<String,Type>> list2= ((FUNCTION) type).getParamList();
        if(args==null )
            return list2.size()==0;
      List<CmmParser.ExpContext> list1= args.exp();

    if(list1.size()!=list2.size())
        return false;
    for(int i=0;i<list1.size();i++)
    {  if(getExpType(list1.get(i))==null|| list2.get(i).b==null)
            continue;
        if(!getExpType(list1.get(i)).same(list2.get(i).b))
            return false;}
       return true;}



    private boolean notLeftVal(CmmParser.ExpContext exp) {
        if(exp.ID()!=null && exp.getChildCount()==1){
            Type t=symbolTable.get(exp.getText());
            if(t==null)
                return false;
            return t.type==Kind.FUNCTION_TYPE;

        }

        if(exp.LP()!=null && exp.ID()==null)
            return notLeftVal(exp.exp(0));
        if(exp.ASSIGNOP()!=null)
            return notLeftVal(exp.exp(0));
        if(exp.ID()!=null && exp.LP()!=null){
            Type t=symbolTable.get(exp.ID().getText());
            if(!(t  instanceof FUNCTION)) return false;
        }
        if(exp.LB()!=null)
        {
             Type t=getExpType(exp.exp(0));
             if(t==null)
                 return false;
            if(t.getType()==Kind.ARRAY_TYPE)
                return false;
            else reportError(getline(exp),10);
        }
        if(exp.DOT()!=null){
            Type t=getExpType(exp.exp(0));
            if(t==null || t.getType()!=Kind.FUNCTION_TYPE)
                return false;

            return false;
        }
        return true;
    }

    @Override
    public void enterArgs(CmmParser.ArgsContext ctx) {
        super.enterArgs(ctx);
    }

    @Override
    public void exitArgs(CmmParser.ArgsContext ctx) {
        super.exitArgs(ctx);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
    }
}
