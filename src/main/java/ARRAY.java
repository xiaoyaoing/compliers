import java.util.ArrayList;

public class ARRAY extends  Type{
    private   Type  element;
    private ArrayList<Integer> nums;
    public  ARRAY(Type element,ArrayList<Integer> nums){
        this.element=element;
        this.nums=nums;
        this.type=Kind.ARRAY_TYPE;
    }

    @Override
    public boolean same(Type t) {
        if(t.type!=Kind.ARRAY_TYPE)
            return false;
        ARRAY another=(ARRAY)  t;
        return element.same(another.element) && nums.size()==another.nums.size();
    }

    @Override
    public  int getSize(){
        int base=element.getSize();
        for(int i:nums)
            base*=i;
        return base;
    }

    public ARRAY() {

    }

    public Type getElement() {
        return element;
    }

    public void setElement(Type element) {
        this.element = element;
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }

    public void setNums(ArrayList<Integer> nums) {
        this.nums = nums;
    }
}
