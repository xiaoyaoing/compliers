import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test {
  public   static  String readfile(String file) throws IOException {

      FileReader f=new FileReader(file);
     char[] buff =new char[10000];
        f.read(buff);
         return  String.valueOf(buff);
  }
    @org.junit.Test
    public  void Test1() throws IOException {
        PrintStream ps=new PrintStream(new
                FileOutputStream("/Users/yjp/nju/大三上/编译原理/Lab/src/resources/normaltest04Y.out"));

        System.setErr(ps);
        Lab2.main(null);
        String s1="Error type 1 at Line 4:";
        String s2="Error type 1 at line 4:"   ;
        assertEquals(s1,s2);
    }

    @org.junit.Test
    public  void Test2(){
      String s1="Program (1)\n" +
              "  ExtDef (1)\n" +
              "    Specifier (1)\n" +
              "      TYPE: int\n" +
              "    FunDec (1)\n" +
              "      ID: add\n" +
              "      LP\n" +
              "      VarList (1)\n" +
              "        ParamDec (1)\n" +
              "          Specifier (1)\n" +
              "            TYPE: int\n" +
              "          VarDec (1)\n" +
              "            ID: a\n" +
              "        COMMA\n" +
              "        ParamDec (1)\n" +
              "          Specifier (1)\n" +
              "            TYPE: int\n" +
              "          VarDec (1)\n" +
              "            ID: b\n" +
              "      RP\n" +
              "    CompSt (1)\n" +
              "      LC\n" +
              "      DefList (2)\n" +
              "        Def (2)\n" +
              "          Specifier (2)\n" +
              "            TYPE: int\n" +
              "          DecList (2)\n" +
              "            Dec (2)\n" +
              "              VarDec (2)\n" +
              "                ID: c\n" +
              "                LB\n" +
              "                INT: 2\n" +
              "                RB\n" +
              "                LB\n" +
              "                INT: 3\n" +
              "                RB\n" +
              "                LB\n" +
              "                INT: 4\n" +
              "                RB\n" +
              "          SEMI\n" +
              "      StmtList (3)\n" +
              "        Stmt (3)\n" +
              "          Exp (3)\n" +
              "            Exp (3)\n" +
              "              Exp (3)\n" +
              "                Exp (3)\n" +
              "                  Exp (3)\n" +
              "                    ID: c\n" +
              "                  LB\n" +
              "                  Exp (3)\n" +
              "                    INT: 1\n" +
              "                  RB\n" +
              "                LB\n" +
              "                Exp (3)\n" +
              "                  INT: 2\n" +
              "                RB\n" +
              "              LB\n" +
              "              Exp (3)\n" +
              "                INT: 3\n" +
              "              RB\n" +
              "            ASSIGNOP\n" +
              "            Exp (3)\n" +
              "              INT: 0\n" +
              "          SEMI\n" +
              "        Stmt (4)\n" +
              "          RETURN\n" +
              "          Exp (4)\n" +
              "            Exp (4)\n" +
              "              ID: a\n" +
              "            PLUS\n" +
              "            Exp (4)\n" +
              "              ID: b\n" +
              "          SEMI\n" +
              "      RC";
      String s2="Program (1)\n" +
              "  ExtDef (1)\n" +
              "    Specifier (1)\n" +
              "      TYPE: int\n" +
              "    FunDec (1)\n" +
              "      ID: add\n" +
              "      LP\n" +
              "      VarList (1)\n" +
              "        ParamDec (1)\n" +
              "          Specifier (1)\n" +
              "            TYPE: int\n" +
              "          VarDec (1)\n" +
              "            ID: a\n" +
              "        COMMA\n" +
              "        ParamDec (1)\n" +
              "          Specifier (1)\n" +
              "            TYPE: int\n" +
              "          VarDec (1)\n" +
              "            ID: b\n" +
              "      RP\n" +
              "    CompSt (1)\n" +
              "      LC\n" +
              "      DefList (2)\n" +
              "        Def (2)\n" +
              "          Specifier (2)\n" +
              "            TYPE: int\n" +
              "          DecList (2)\n" +
              "            Dec (2)\n" +
              "              VarDec (2)\n" +
              "                ID: c\n" +
              "                LB\n" +
              "                INT: 2\n" +
              "                RB\n" +
              "                LB\n" +
              "                INT: 3\n" +
              "                RB\n" +
              "                LB\n" +
              "                INT: 4\n" +
              "                RB\n" +
              "          SEMI\n" +
              "      StmtList (3)\n" +
              "        Stmt (3)\n" +
              "          Exp (3)\n" +
              "            Exp (3)\n" +
              "              Exp (3)\n" +
              "                Exp (3)\n" +
              "                  Exp (3)\n" +
              "                    ID: c\n" +
              "                  LB\n" +
              "                  Exp (3)\n" +
              "                    INT: 1\n" +
              "                  RB\n" +
              "                LB\n" +
              "                Exp (3)\n" +
              "                  INT: 2\n" +
              "                RB\n" +
              "              LB\n" +
              "              Exp (3)\n" +
              "                INT: 3\n" +
              "              RB\n" +
              "            ASSIGNOP\n" +
              "            Exp (3)\n" +
              "              INT: 0\n" +
              "          SEMI\n" +
              "        Stmt (4)\n" +
              "          RETURN\n" +
              "          Exp (4)\n" +
              "            Exp (4)\n" +
              "              ID: a\n" +
              "            PLUS\n" +
              "            Exp (4)\n" +
              "              ID: b\n" +
              "          SEMI\n" +
              "      RC";
      assertEquals(s1,s2);

    }
}
