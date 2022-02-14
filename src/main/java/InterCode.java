public abstract class InterCode {
//
//    static  InterCode head;
//    static  InterCode tail;
    CodeKind codeKind;
    // 指向下一条中间代码
    InterCode next;

    public  InterCode tail(){
        if(next==null)
            return this;
        return next.tail();
    }

    public  static  class defaultCode extends  InterCode {

    }
    public static class MonoOpInterCode extends InterCode {
    Operand operand;
    public  MonoOpInterCode(CodeKind codeKind, Operand operand)
    {
        this.codeKind=codeKind;
        this.operand=operand;
    }

        @Override
        public String toString() {

           switch (this.codeKind) {
               case label:
                   return String.format("LABEL %s :",this.operand.getVal());
               case function:
                  return String.format("FUNCTION %s :",this.operand.getVal());
               case read:
                   return String.format("READ %s",this.operand.getVal());
               case write:
                   return String.format("WRITE %s",this.operand.getVal());
               case param:
                   return String.format("PARAM %s",this.operand.getVal());
               case arg:
                   return String.format("ARG %s",this.operand.getVal());
               case Return:
                   return  String.format("RETURN %s",this.operand.getVal());
               case jump:
                   return  String.format("GOTO %s",this.operand.getVal());

           }
           return "ERROR";
        }
    }
public static class BinOpInterCode extends InterCode {
    Operand operand1;
    Operand operand2;
    Operand result;

    public BinOpInterCode(CodeKind kind, Operand dest, Operand operand1, Operand operand2) {
         super();
         this.codeKind=kind;
         this.result=dest;
         this.operand1=operand1;
         this.operand2=operand2;
    }
    String getComputeSymbol(CodeKind kind){
        if(kind==CodeKind.mul)
            return "*";
        if(kind==CodeKind.add)
            return "+";
        if(kind==CodeKind.sub)
            return "-";
        if(kind==CodeKind.div)
            return "/";
        return "";
    }
    @Override
    public String toString() {
        String computeSymbol=getComputeSymbol(this.codeKind);
        return String.format("%s := %s %s %s",result.getVal(),operand1.getVal(),
                computeSymbol,
                operand2.getVal());
    }
}
public static class AssignInterCode extends InterCode {
    Operand leftOperand;
    Operand rightOperand;

    public AssignInterCode(Operand leftOperand, Operand rightOperand) {
        if(rightOperand==null && leftOperand!=null )
            this.leftOperand=null;
        this.leftOperand=leftOperand;
        this.rightOperand=rightOperand;
        this.codeKind=CodeKind.assign;
    }

    public AssignInterCode(CodeKind kind, Operand t2, Operand t1) {
        this.codeKind=kind;
        this.leftOperand=t2;
        this.rightOperand=t1;
    }

    @Override
    public String toString() {
        if(codeKind==CodeKind.address1)
            return String.format("%s := &%s",leftOperand.getVal(),rightOperand.getVal());
        if(codeKind==CodeKind.address2)
            return String.format("%s := *%s",leftOperand.getVal(),rightOperand.getVal());
        if(codeKind==CodeKind.address3)
            return String.format("*%s := %s",leftOperand.getVal(),rightOperand.getVal());
        String s=rightOperand.kind!=OperandKInd.constant? rightOperand.value:"#"+rightOperand.value;
        if(rightOperand.kind==OperandKInd.function)
            s=String.format("CALL %s",rightOperand.getVal());

        return String.format("%s := %s",leftOperand.value,s);


    }
}
public static class ConditionJumpInterCode extends InterCode {
    Operand operand1;
    String relop;
    Operand operand2;
    Operand label;

    public ConditionJumpInterCode(Operand operand1, String relop, Operand operand2, Operand label) {
        this.operand1 = operand1;
        this.relop = relop;
        this.operand2 = operand2;
        this.label = label;
    }

    @Override
    public String toString() {
        return String.format("IF %s %s %s GOTO %s",operand1.getVal(),relop,operand2.getVal(),label.getVal());
    }
}

public static class MemDecInterCode extends InterCode {
    Operand operand;
    int size;

    public MemDecInterCode(Operand operand, int size) {
        this.operand = operand;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("DEC %s %s",operand.getVal(),String.valueOf(size));
    }
}
public  static  class InterCodeList{
    InterCode head;
    InterCode tail;
}
 }


