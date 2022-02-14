import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Struct;
import java.util.*;

public class CmmInterCodeListener  extends  CmmParserBaseListener{
    InterCode code;
    static SymbolTable symbolTable;
    HashMap <String,Operand> operandTable=new HashMap<>();
  public static  CmmSemanticListener semanticListener;
    static int tempcount=0;
    static int labelcount=0;
    static  int vcount=0;
    Operand getConstant(int constant){
        return new Operand(OperandKInd.constant,String.valueOf(constant));
    }
    Operand generateNewTemp(){
        return new Operand(OperandKInd.variable,"t"+String.valueOf(tempcount++));
    }
    Operand generateNewLabel() {
        return new Operand(OperandKInd.label,"label"+String.valueOf(labelcount++));

    }
    private Operand generatenewVariable() {
        return new Operand(OperandKInd.variable,"v"+String.valueOf(vcount++));
    }
    Operand handlePlace(Operand place){
        if(place==null)
            return generateNewTemp();
        return place;
    }
    Operand getFromOperandTable(String text){
        Operand t=operandTable.get(text);
        t=t==null?generateNewTemp():t;
        Kind kind=symbolTable.get(text).getType();
//        if(kind==Kind.ARRAY_TYPE || kind==Kind.STRUCT_TYPE)
//            t.kind=OperandKInd.address;
        return t;
    }
    InterCode translateExp(CmmParser.ExpContext exp,Operand place){
        place=handlePlace(place);
        if(exp.DOT()!=null && exp.getChildCount()==3 && exp.getChild(1).getText().equals(".") ){
            Operand t=generateNewTemp();
            t.isleft=true;
            InterCode code1=  translateExp(exp.exp(0),t);
            STRUCT struct;
            CmmParser.ExpContext e=exp.exp(0);

          Type type= semanticListener.getExpType(exp.exp(0));
          if(type.getType()==Kind.ARRAY_TYPE){
              struct= (STRUCT) ((ARRAY)type).getElement();
          }
            else struct= (STRUCT) type;
           int offset=struct.getoffset(exp.ID().getText());

           InterCode code2=new InterCode.BinOpInterCode(CodeKind.add,place,t,getConstant(offset));
           code1.tail().next=code2;
            if(!place.isleft)
            {
                //place.kind=OperandKInd.address;
                code1.tail().next=new InterCode.AssignInterCode(CodeKind.address2,t,place);
                code1.tail().next=new InterCode.AssignInterCode(place,t);
                //code1.tail().next=new InterCode.AssignInterCode(CodeKind.address2,t,place);
            }
          //  code1.tail().next=new InterCode.AssignInterCode(place,t);
            return code1;

        }

        if(exp.LB()!=null && exp.getChildCount()==4 ){
            Operand t1=generateNewTemp();
            Operand t2=generateNewTemp();
            Operand t3=generateNewTemp();
            t1.isleft=true;
            InterCode code1= translateExp(exp.exp(0),t1);
            InterCode code2= translateExp(exp.exp(1),t2);
           ARRAY array= (ARRAY) symbolTable.get(exp.exp(0).ID().getText());
            int size=array.getElement().getSize();
            InterCode code4=new InterCode.BinOpInterCode(CodeKind.mul,t2,t2,
                   getConstant(size));
           InterCode code3=new InterCode.BinOpInterCode(CodeKind.add,place,t1,t2);
           code1.tail().next=code2; code2.tail().next=code4;
           code4.tail().next=code3;

           if(!place.isleft)
           {
               //place.kind=OperandKInd.address;
               code1.tail().next=new InterCode.AssignInterCode(CodeKind.address2,t1,place);
               code1.tail().next=new InterCode.AssignInterCode(place,t1);
           }
//           if(place!=null)
//               code1.tail().next=new InterCode.AssignInterCode(place,)
           return code1;
        }
        if(exp.LP()!=null && exp.exp()!=null && exp.ID()==null)
            return translateExp(exp.exp(0),place);
        if(exp.INT()!=null){
                Operand t=new Operand(OperandKInd.constant,exp.INT().getText());
               // if(place==null) return new InterCode.defaultCode();
                return  new InterCode.AssignInterCode(place,t);
        }
            else if(exp.ASSIGNOP()!=null){
                Operand t1=generateNewTemp();
                InterCode code1=translateExp(exp.exp(1),t1);
//                if(t1.kind==OperandKInd.address)
//                {
//                    Operand t2=generateNewTemp();
//                    code1.tail().next=new InterCode.AssignInterCode(CodeKind.address2,t2,t1);
//                    code1.tail().next=new InterCode.AssignInterCode(t1,t2);
//                    t1.kind=OperandKInd.variable;
//                }
                InterCode code2;
                if(exp.exp(0).getChildCount()==1)
                      code2=  new InterCode.AssignInterCode(getFromOperandTable(exp.exp(0).getText()),t1);
                else{
                    Operand t2=generateNewTemp();
                    t2.isleft=true;
                    code2=   translateExp(exp.exp(0),t2);
                    InterCode   code3=new InterCode.AssignInterCode(CodeKind.address3,t2,t1);
                    code2.tail().next=code3;
                }
                code1.tail().next=code2;
             if     (place!=null)
             {           InterCode code3=new InterCode.AssignInterCode(
                         t1.kind==OperandKInd.address?CodeKind.address2:CodeKind.assign,place,t1);;

                     code2.tail().next=code3;}

                return code1;
        }
            else if(exp.ID()!=null && exp.getChildCount()==1){
            //    if(place==null) return new InterCode.defaultCode();
                Operand t= getFromOperandTable(exp.ID().getText());
                if(t.kind==OperandKInd.address
                        //&& symbolTable.get(exp.ID().getText()).getType()==Kind.ARRAY_TYPE
                )
                {   return new InterCode.AssignInterCode(CodeKind.address1,place,t);}
                 else   return new InterCode.AssignInterCode(place,t);

        }
            else if(exp.MINUS()!=null && exp.getChildCount()==2){
                Operand t=   generateNewTemp();
                InterCode code1=translateExp(exp.exp(0),t);
                InterCode code2=new InterCode.BinOpInterCode(CodeKind.sub,place,getConstant(0),t);
                code1.tail().next=code2;
                return code1;
        }
            else if(exp.PLUS()!=null || exp.MINUS()!=null || exp.STAR()!=null || exp.DIV()!=null){
                Operand t1=generateNewTemp();
                Operand t2=generateNewTemp();
                CodeKind kind=getExpComputeKind(exp);
                InterCode code1=translateExp(exp.exp(0),t1);
                InterCode code2=translateExp(exp.exp(1),t2);
                if(place==null){
                    code1.tail().next=code2;
                    return code1;
                }
                InterCode code3=new InterCode.BinOpInterCode(kind,place,t1,t2);
                InterCode codes[]={code1,code2,code3};
                link(codes);
                return code1;
        }
            else if(isCond(exp)){
                Operand label1=generateNewLabel();
                Operand label2=generateNewLabel();
                InterCode code0=new InterCode.AssignInterCode(place,getConstant(0));
                InterCode code1=translateCond(exp,label1,label2);
                InterCode code2=new InterCode.MonoOpInterCode(CodeKind.label,label1);
                InterCode code3=new InterCode.AssignInterCode(place,getConstant(1));
                InterCode code4=new InterCode.MonoOpInterCode(CodeKind.label,label2);
                InterCode codes[]={code0,code1,code2,code3,code4};
                link(codes);
                return code0;
        }
        else if(funcCallType(exp)==1){
            String name=exp.ID().getText();

         if(name.equals("read")){
             return new InterCode.MonoOpInterCode(CodeKind.read,place);
         }
         Operand operand=new Operand(OperandKInd.function,name);
         return new InterCode.AssignInterCode(place,operand);
        }
        else if(funcCallType(exp)==2){
            ArrayList<Operand> list=new ArrayList<>();
            String name=exp.ID().getText();
            InterCode code1=translateArgs(exp.args(),list);
           // Collections.reverse(list);
            if(name.equals("write"))
            {
                code1.tail().next=new InterCode.MonoOpInterCode(CodeKind.write,list.get(0));
                return code1;
            }

            for(int i=0;i<list.size();i++){
                code1.tail().next=  new InterCode.MonoOpInterCode(CodeKind.arg,list.get(i));
          }
                Operand operand=new Operand(OperandKInd.function,name);
                if(place!=null)
                code1.tail().next=new InterCode.AssignInterCode(place,operand);
                else
                code1.tail().next=new InterCode.MonoOpInterCode(CodeKind.function,operand);
               return code1;
        }
        return  new InterCode.AssignInterCode(generateNewTemp(),getConstant(0));


    }

    private InterCode translateArgs(CmmParser.ArgsContext args, ArrayList<Operand> list) {
        LinkedList<InterCode> codes=new LinkedList<>();
        for(int i=args.exp().size()-1;i>=0;i--)
        { Operand t1=generateNewTemp();
       // t1.isleft=true;
            t1.isArg=true;
        if(semanticListener.getExpType(args.exp(i)).type==Kind.STRUCT_TYPE)
            t1.isleft=true;
        InterCode code1=translateExp(args.exp(i),t1);
        t1.kind=OperandKInd.variable;
        codes.add(code1);
        list.add(t1);}
        link(codes);
        return codes.get(0);
    }
    private void link(LinkedList<InterCode> codes) {
        for(int i=0;i<codes.size()-1;i++)
            codes.get(i).tail().next=codes.get(i+1);

    }

    private int funcCallType(CmmParser.ExpContext exp) {
        if(exp.ID()!=null && exp.LP()!=null){
            if(exp.args()==null)
                return 1;
            return 2;
        }
        return 0;
    }

    private boolean isCond(CmmParser.ExpContext exp) {
        return exp.RELOP()!=null || exp.NOT()!=null || exp.OR()!=null || exp.AND()!=null;

    }

    InterCode translateCompst(CmmParser.CompStContext comp){
        InterCode code1=translateDefList(comp.defList());
        InterCode code2=translateStmtList(comp.stmtList());
        if(code1==null)
            return code2;
        code1.tail().next=code2;

        return code1;

    }

    private  InterCode translateDef(CmmParser.DefContext def){
        if(def.specifier().structSpecifier()==null)
      return   handleNormalDef(def);
       else return handleStructDef(def);

    }

    private InterCode handleStructDef(CmmParser.DefContext def) {
        InterCode head=new InterCode.AssignInterCode(null,null);

        for(CmmParser.DecContext dec: def.decList().dec()){
            CmmParser.VarDecContext vardec=dec.varDec();
            int size=symbolTable.get(vardec.ID(0).getText()).getSize();

            Operand t=new Operand(OperandKInd.address,vardec.ID(0).getText());
            operandTable.put(t.value,t);
            head.tail().next=new InterCode.MemDecInterCode(t,size);
        }
        return head.next;
    }
    private  InterCode translateVardec(CmmParser.VarDecContext vardec){
        Operand v= generatenewVariable();
        if(vardec.getChildCount()>1){
            v.kind=OperandKInd.address;
            String name=vardec.ID(0).getText();
            v.value=name;
            operandTable.put(vardec.ID(0).getText(),v);
            ARRAY array=     (ARRAY) symbolTable.get(name);
            int length=array.getSize();
            Operand operand=new Operand(OperandKInd.address,name);
            InterCode t=new InterCode.MemDecInterCode(operand,length);
            return t;
        }
        else {
            operandTable.put(vardec.ID(0).getText(),v);
            CmmParser.DecContext dec=null;
            if(vardec.parent instanceof CmmParser.DecContext  ) dec= (CmmParser.DecContext) vardec.parent;
            if(dec!=null && dec.ASSIGNOP()!=null)
            {
                Operand t1=generateNewTemp();
                InterCode code1=translateExp(dec.exp(),t1);
                code1.tail().next=new InterCode.AssignInterCode(v,t1);
                return code1;
            }
            return null;
        }
    }
    private InterCode handleNormalDef(CmmParser.DefContext def) {
        InterCode head=new InterCode.AssignInterCode(null,null);

        for(CmmParser.DecContext dec: def.decList().dec()){
            InterCode t=translateVardec(dec.varDec());
            if(t!=null)
            head.tail().next=t;
        }
        return head.next;
    }


    private InterCode translateDefList(CmmParser.DefListContext deflist) {
        InterCode head=new InterCode.AssignInterCode(null,null);
        InterCode temp=null;
        for(CmmParser.DefContext def:deflist.def()){

            head.tail().next=translateDef(def);
        }
        return  head.next;
    }

    InterCode translateStmtList(CmmParser.StmtListContext stmtList){
        InterCode head=new InterCode.MonoOpInterCode(CodeKind.add,null);
        for(CmmParser.StmtContext stmt:stmtList.stmt()){
            head.tail().next=translateStmt(stmt);
        }
        return  head.next;
    }
    InterCode translateStmt(CmmParser.StmtContext stmt){
        if(stmt.compSt()!=null){
            return translateCompst(stmt.compSt());
        }
        else if(stmt.exp()!=null && stmt.getChildCount()==2){
            return translateExp(stmt.exp(),null);
        }
        else if(stmt.RETURN()!=null){
           Operand operand = generateNewTemp();
           InterCode code1=translateExp(stmt.exp(),operand);
           if(code1==null){
               code1=null;
           }
           InterCode code2=new InterCode.MonoOpInterCode(CodeKind.Return,operand);
           code1.tail().next=code2;
           return code1;
        }
        Operand label1=generateNewLabel();
        Operand label2=generateNewLabel();

        InterCode code2=translateStmt(stmt.stmt(0));
        InterCode labelCode1=new InterCode.MonoOpInterCode(CodeKind.label,label1);
        InterCode labelCode2=new InterCode.MonoOpInterCode(CodeKind.label,label2);
         if(stmt.IF()!=null){
             InterCode code1=translateCond(stmt.exp(),label1,label2);
            if(stmt.ELSE()==null){
                InterCode codes[]={code1,labelCode1,code2,labelCode2};
                link(codes);
                return code1;
            }
            else {
                InterCode code3=translateStmt(stmt.stmt(1));

                Operand label3=generateNewLabel();
                InterCode jumpcode=new InterCode.MonoOpInterCode(CodeKind.jump,label3);
                InterCode labelCode3=new InterCode.MonoOpInterCode(CodeKind.label,label3);
                InterCode codes[]={code1,labelCode1,code2,jumpcode,labelCode2,code3,labelCode3};
                link(codes);
                return code1;
            }
        }
        else if(stmt.WHILE()!=null){
             Operand label3=generateNewLabel();
             InterCode code1=translateCond(stmt.exp(),label2,label3);
            InterCode labelCode3=new InterCode.MonoOpInterCode(CodeKind.label,label3);
            InterCode Goto=new InterCode.MonoOpInterCode(CodeKind.jump,label1);
            InterCode codes[]={labelCode1,code1,labelCode2,code2,Goto,labelCode3};
            link(codes);
            return labelCode1;
        }
        return null;

    }

    private InterCode translateCond(CmmParser.ExpContext exp, Operand label1, Operand label2) {
        if(exp.RELOP()!=null){
            Operand t1=generateNewTemp();
            Operand t2=generateNewTemp();
           InterCode code1= translateExp(exp.exp(0),t1);
           InterCode code2=translateExp(exp.exp(1),t2);
           InterCode code3=new InterCode.ConditionJumpInterCode(t1,exp.RELOP().getText(),t2,label1);
           InterCode code4=new InterCode.MonoOpInterCode(CodeKind.jump,label2);
           InterCode codes[]={code1,code2,code3,code4};
           link(codes);
           return code1;
        }
        else if(exp.NOT()!=null){
            return  translateCond(exp.exp(0),label2,label1);
        }
        else if(exp.AND()!=null){
            Operand label3=generateNewLabel();
            InterCode code1=translateCond(exp.exp(0),label3,label2);
            InterCode code2=translateCond(exp.exp(1),label1,label2);
            InterCode code3=new InterCode.MonoOpInterCode(CodeKind.label,label3);
            code1.tail().next=code3; code3.next=code2;
            return code1;
        }
        else if(exp.OR()!=null){
            Operand label3=generateNewLabel();
            InterCode code1=translateCond(exp.exp(0),label1,label3);
            InterCode code2=translateCond(exp.exp(1),label1,label2);
            InterCode code3=new InterCode.MonoOpInterCode(CodeKind.label,label3);
            code1.tail().next=code3; code3.next=code2;
            return code1;
        }
        else {
            Operand t1=generateNewTemp();
            InterCode code1=translateExp(exp,t1);
            InterCode code2=new InterCode.ConditionJumpInterCode(t1,"!=",getConstant(0),label1);
            InterCode code3=new InterCode.MonoOpInterCode(CodeKind.jump,label2);
            code1.tail().next=code2;
            code2.tail().next=code3;
            return code1;

        }

    }

    private void link(InterCode[] codes) {
        for(int i=0;i<codes.length-1;i++)
            codes[i].tail().next=codes[i+1];
    }


    private CodeKind getExpComputeKind(CmmParser.ExpContext exp) {
        if(exp.PLUS()!=null)
             return CodeKind.add;
        if(exp.MINUS()!=null)
             return CodeKind.sub;
        if(exp.STAR()!=null)
            return CodeKind.mul;
        if(exp.DIV()!=null)
            return CodeKind.div;
        return null;



    }
    @Override
    public void enterProgram(CmmParser.ProgramContext ctx)  {
        super.enterProgram(ctx);


        symbolTable.insert("read",new FUNCTION(new INT(),new ArrayList<Pair<String, Type>>()));
        ArrayList<Pair<String, Type>> writeParam=new ArrayList();
        writeParam.add(new Pair<String,Type>("yjpWrite",new INT()));
        symbolTable.insert("write",new FUNCTION(new INT(),writeParam));
    }

    InterCode translateProgram(CmmParser.ProgramContext programContext){
        InterCode head=new InterCode.AssignInterCode(null,null);
        for(CmmParser.ExtDefContext extDefContext :programContext.extDef()){
            head.tail().next=translateExtDef(extDefContext);
        }
        return  head.next;
    }

    private InterCode translateExtDef(CmmParser.ExtDefContext extDef) {
        InterCode head=new InterCode.defaultCode();
        if(extDef.extDecList()!=null){
            for(CmmParser.VarDecContext vardec:extDef.extDecList().varDec())
            { if(extDef.specifier().structSpecifier()!=null){
                  //  String name=getStructName(extDef.specifier().structSpecifier());
                    int size=symbolTable.get(vardec.ID(0).getText()).getSize();
                    Operand t=new Operand(OperandKInd.address,vardec.ID(0).getText());
                    
                    head.tail().next=new InterCode.MemDecInterCode(t,size);
            }
            else {
                head.tail().next=translateVardec(vardec);
            }
            }
            return head.next;
        }
        else if(extDef.getChildCount()==2){

        }
        else if(extDef.funDec()!=null){
           InterCode code1= translateFundec(extDef.funDec());
           InterCode code2= translateCompst(extDef.compSt());
           code1.tail().next=code2;
           return code1;
        }
        return null;
    }

    private String getStructName(CmmParser.StructSpecifierContext structSpecifier) {
        if(structSpecifier.tag()!=null)
        return structSpecifier.tag().ID().getText();
        else
        return structSpecifier.optTag().getText();

    }

    public  void OutInter(String path) throws FileNotFoundException {
        File file = new File(path);
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        InterCode temp=this.code;
        while(temp!=null){
            if(! (temp instanceof  InterCode.defaultCode))
            ps.println(temp.toString());
            temp=temp.next;
        }

    }
    private InterCode translateFundec(CmmParser.FunDecContext funDec) {
        Operand function=new Operand(OperandKInd.function,funDec.ID().getText());
        InterCode code1=new InterCode.MonoOpInterCode(CodeKind.function,function);
        if(funDec.varList()==null)
            return code1;
        for(CmmParser.ParamDecContext paramDec: funDec.varList().paramDec()){
            Operand v=generatenewVariable();
            operandTable.put(paramDec.varDec().ID(0).getText(),v);
            code1.tail().next=new InterCode.MonoOpInterCode(CodeKind.param,v);
        }
        return code1;
    }

    @Override
    public void exitProgram(CmmParser.ProgramContext ctx) {

        super.exitProgram(ctx);
        this.code=translateProgram(ctx);
    }

    @Override
    public void enterExtDef(CmmParser.ExtDefContext ctx) {
        super.enterExtDef(ctx);
    }

    @Override
    public void exitExtDef(CmmParser.ExtDefContext ctx) {
        super.exitExtDef(ctx);

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
        super.enterSpecifier(ctx);
    }

    @Override
    public void exitSpecifier(CmmParser.SpecifierContext ctx) {
        super.exitSpecifier(ctx);
    }

    @Override
    public void enterStructSpecifier(CmmParser.StructSpecifierContext ctx) {
        super.enterStructSpecifier(ctx);
    }

    @Override
    public void exitStructSpecifier(CmmParser.StructSpecifierContext ctx) {
        super.exitStructSpecifier(ctx);
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
        super.enterVarDec(ctx);
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
        super.exitFunDec(ctx);
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
        super.exitStmt(ctx);
    }

    @Override
    public void enterDefList(CmmParser.DefListContext ctx) {
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
        super.exitDef(ctx);
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
        super.enterDec(ctx);
    }

    @Override
    public void exitDec(CmmParser.DecContext ctx) {
        super.exitDec(ctx);
    }

    @Override
    public void enterExp(CmmParser.ExpContext ctx) {
        super.enterExp(ctx);
    }

    @Override
    public void exitExp(CmmParser.ExpContext ctx) {
//        translateExp();
        super.exitExp(ctx);
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
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }
}
