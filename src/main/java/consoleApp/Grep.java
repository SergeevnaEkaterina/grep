package consoleApp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {
    private final String word;
    private final String inputName ;
    public Grep (String word, String inputName) {
        this.word = word;
        this.inputName = inputName;
    }
public void logics(boolean filtrationCondition,boolean ignoreWordRegister, Pattern regex)  {
       String s;
       try(BufferedReader br = new BufferedReader(new FileReader(inputName)))
       {
           if(regex ==null && ignoreWordRegister =false && !filtrationCondition) { //nothing found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                    System.out.println(s);
               }
           }
           if(regex !=null && ignoreWordRegister =false && filtrationCondition=false) { //only regex found
                   while((s=br.readLine()) !=null){
                       s = br.readLine();
                       Matcher matcher = regex.matcher(s);
                       if (matcher.find()) System.out.println(s);
                   }
           }
           if(regex !=null && ignoreWordRegister =true && filtrationCondition=false) { //regex and ignoreWordRegister found
               while((s=br.readLine()) !=null){
                   s = br.readLine().toLowerCase();
                   Matcher matcher = regex.matcher(s);
                   if (matcher.find()) System.out.println(s);
               }
           }
           if(regex !=null && ignoreWordRegister =false && filtrationCondition=true) { //regex and filtrationCondition found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                   Matcher matcher = regex.matcher(s);
                   if (matcher.find()==false) System.out.println(s);
               }
           }
           if(regex !=null && ignoreWordRegister =true && filtrationCondition==1) { //all found
               while((s=br.readLine()) !=null){
                   s = br.readLine().toLowerCase();
                   Matcher matcher = regex.matcher(s);
                   if (matcher.find()==false) System.out.println(s);
               }
           }
           if(regex ==null && ignoreWordRegister ==0 && filtrationCondition==1) { //only filtrationCondition found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                   if (s.contains(word)==false) System.out.println(s);
               }
           }
           if(regex ==null && ignoreWordRegister ==1 && filtrationCondition==0) { //only ignoreWordRegister found
               while((s=br.readLine()) !=null){
                   s = br.readLine().toLowerCase();
                   System.out.println(s);
               }
           }
           if(regex ==null && ignoreWordRegister ==1 && filtrationCondition==1) { // ignoreWordRegister and filtrationCondition found
               while((s=br.readLine()) !=null){
                   s = br.readLine().toLowerCase();
                   if (s.contains(word)==false) System.out.println(s);
               }
               br.close();
           }

       }
       catch (IOException exc) {
           System.out.println ( "Ошибка ввода-вывода: "+ exc );
           }
      }
   }
