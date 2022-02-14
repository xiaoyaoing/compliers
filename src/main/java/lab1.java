import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import  org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;


public class lab1
{
    static ArrayList<Integer>  errorLineList=new ArrayList<>();
    public static void main(String[] args) throws IOException {
      // String  filePath=args[0];
        String filePath="/Users/yjp/nju/大三上/编译原理/Lab/test1.cmm";
        InputStream file = new FileInputStream(filePath);
        CharStream input = CharStreams.fromStream(file);
        file = new FileInputStream(filePath);


        CmmLexer lexer=new CmmLexer(input){
            @Override
            public void notifyListeners(LexerNoViableAltException e){
                String text = _input.getText(Interval.of(_tokenStartCharIndex, _input.index()));
                System.err.printf("Error type A at Line %d: undefined %s%n", getLine(), text);
            }
        };

        List<? extends Token> tokenList=lexer.getAllTokens();
        for(Token i:tokenList){
            ;
        }
        if(errorLineList.size()>0){

            return;
        }
        for(int i=0;i<tokenList.size();i++){
            Token token= tokenList.get(i);
         String tokenName=   lexer.getVocabulary().getSymbolicName(token.getType());
         String text=token.getText();
         if(tokenName=="INT"){
             text =String.valueOf(Integer.decode(text));
         }
         if(tokenName=="FLOAT"){
            text =FloatParse(text);
         }
         Integer line=token.getLine();
         if(i!= tokenList.size()-1)
                System.err.printf("%s %s at Line %d.%n",tokenName,String.valueOf(text),line);
         else System.err.printf("%s %s at Line %d.",tokenName,String.valueOf(text),line);
        }

    }
    private  static  String getzeros(int n)
    {
        String ans="";
        for(int i=0;i<n;i++)
            ans+="0";
        return  ans;
    }
    private static String  converseFloat(String text) {
        int idx=text.indexOf('.');
        String s1=text.substring(0,idx);
        String s2=text.substring(idx+1);
        if(s1=="") s1="0";
        if(s2=="")s2="0";
        if(s2.indexOf('e')!=-1 || s2.indexOf('E')!=-1){
            idx=s2.indexOf('e');

            if(idx==-1) idx=s2.indexOf('E');
            String num=s2.substring(idx+1);
            s2=s2.substring(0,idx);
            Integer t=Integer.parseInt(num);
            if(t>=0) {
                if(t>=s2.length()) {s1=s1+s2+getzeros(t-s2.length()); s2=getzeros(0);}
                else {
                   s1=s1+s2.substring(0,t); s2=s2.substring(t);
                }
            }
            else {
                t=-t;
                if(t>=s1.length()){s2=getzeros(t-s1.length())+s1+s2; s1=getzeros(0);}
                else {
                    s2=s1.substring(s1.length()-t)+s2;
                    s1=s1.substring(0,s1.length()-t);
                }
            }
        }
        if(s1=="") s1="0";
        if(s2=="")s2="0";
        for(idx=0;idx<s1.length();idx++)
            if(s1.charAt(idx)!='0')
                break;
        if(idx!=s1.length())
        s1=String.valueOf(Long.parseLong(s1.substring(idx)));
        s2=s2.length()>6?s2.substring(0,6):s2+getzeros(6-s2.length());
        return  s1+"."+s2;
    }

    private static String converseInt(String text) {
        if(text.length()<2) return  text;
        if(text.charAt(0)!='0') return  text;
        if(text.charAt(1)=='X' || text.charAt(1)=='x') {
            text=text.substring(2);
            long ans=0;
            for(int i=0;i<text.length();i++)
            {   char c=text.charAt(i);
                ans=ans*16+(c>='a'?c-'a'+10:(c>='A'?c-'A'+10:c-'0'));}
            return  String.valueOf(ans);
        }
        else {
            text=text.substring(1);
            long  ans=0;
            for(int i=0;i<text.length();i++)
            {   char c=text.charAt(i);
                ans=ans*8+c-'0';}
            return  String.valueOf(ans);
        }
    }
    public static String FloatParse(String text){
        StringBuilder buffer = new StringBuilder();
        if(text.charAt(0)=='.'){
            buffer.append('0');
            buffer.append(text);
        }else if(text.contains(".E") || text.contains(".e")){
            int idx=text.indexOf(".");
            buffer.append(text);
            buffer.insert(idx+1, '0');
        }else{
            buffer.append(text);
        }
        BigDecimal value = new BigDecimal(buffer.toString());
        value = value.setScale(6, RoundingMode.DOWN);
        return value.toPlainString();
    }


}