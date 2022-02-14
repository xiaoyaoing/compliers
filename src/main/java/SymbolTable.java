import java.util.HashSet;

public class SymbolTable {
   private  int SIZE=1000;
   HashNode[] table;
   HashSet<String> classes=new HashSet<String>();
   int count=0;
   public  SymbolTable(){
       this.table=new HashNode[SIZE];
       for(int i=0;i<SIZE;i++)
           this.table[i]=null;
   }
   private  int getIndex(String name){
       int val = 0, i;
       for (char c : name.toCharArray()) {
           val = (val << 2) + (int) c;
            // HASH_TABLE_SIZE描述了符号表的大小
           if ((i = (val & ~SIZE)) != 0) {
               val = (val ^ (i >> 12)) & SIZE;
           }
       }
       return val%SIZE;
   }
   public  Type get(String name){
       int idx=getIndex(name);
       HashNode t=table[idx];
       while(t!=null)
       {
           if(t.name.equals(name))
               return t.type;
           t=t.next;
       }
       return  null;
   }
   public  void insert(String name,Type type){
       int idx=getIndex(name);
       HashNode t=table[idx];
       HashNode newNode=new HashNode(name,type);
       if(t==null)
           table[idx]=newNode;
       else
       {while(t.next!=null)
               t=t.next;
        t.next=newNode;
       }
   }
   public  boolean contains(String name){
//       if(name.equals("i_func_2909"))
//           System.out.println();
       return get(name)!=null;
   }

   public Kind getType(String name){
       return get(name).getType();
   }

    public void addclass(String name) {
       this.classes.add(name);

    }
}

class  HashNode{
    String name;
    Type type;
    HashNode next;
   public HashNode(String name,Type type){
       this.name=name;
       this.type=type;
       this.next=null;
   }
}
