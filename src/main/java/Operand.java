public class Operand {
    public boolean isleft;
    public boolean isArg;
    OperandKInd kind;
    String value;
    public  Operand(OperandKInd kind,String value){
        this.kind=kind;
        this.value=value;
        isleft=false;
        isArg=false;
    }

    public String getVal(){
        if(this.kind==OperandKInd.constant)
            return "#"+value;
        return  value;
    }
}


