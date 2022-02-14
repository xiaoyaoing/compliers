public  abstract class Type {

   Kind type;
   public  int firstaddress;
   public Kind getType() {
      return type;
   }
   public  boolean same(Type t){
      if(t==null) return false;
      return type==t.getType();
   }
   public  int getSize(){
      return 0;
   }


}







