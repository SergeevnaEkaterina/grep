package consoleApp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {

    private final boolean filtrationCondition;
    private final boolean ignoreWordRegister;
    private Pattern regex;
    private String word;
    private final String inputName;
    public Grep (boolean filtrationCondition,boolean ignoreWordRegister,Pattern regex,String word,String inputName) {
        this.filtrationCondition = filtrationCondition ;
        this.ignoreWordRegister = ignoreWordRegister ;
        this.regex = regex;
        this.word=word;
        this.inputName=inputName;
    }
    public String foundIgnoreWordRegister(String a){
        return a.toLowerCase();
    }
    public String foundFiltrationCondition(String s,String word){
        if (!s.contains(word)) return s;
        return "";
    }
    public String foundRegex(Pattern r,String s){
        Matcher m = r.matcher(s);
        if (m.find()) return s;
        return "";
    }
public ArrayList<String> logics()  {
       String s;
    ArrayList<String> f = new ArrayList<>();
       try(BufferedReader br = new BufferedReader(new FileReader(inputName)))
       {
           if(regex ==null && !ignoreWordRegister  && !filtrationCondition) { //nothing found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                    f.add(s);
               }
           }
           if(regex !=null && !ignoreWordRegister && !filtrationCondition) { //only regex found
                   while((s=br.readLine()) !=null){
                       s = br.readLine();
                       f.add(foundRegex(regex,s));
                   }
           }
           if(regex !=null && (ignoreWordRegister) && !filtrationCondition) { //regex and ignoreWordRegister found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                   //понизить регистр регекса
                   f.add(foundRegex(regex,foundIgnoreWordRegister(s)));
               }
           }
           if(regex !=null && !ignoreWordRegister && (filtrationCondition)) { //regex and filtrationCondition found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                   f.add(foundRegex(regex,s));
               }
           }
           if(regex !=null && (ignoreWordRegister) && (filtrationCondition)) { //all found
               while((s=br.readLine()) !=null){
                   s = br.readLine().toLowerCase();
                   word = word.toLowerCase();
                   f.add(foundRegex(regex,s));
               }
           }
           if(regex ==null && !ignoreWordRegister && (filtrationCondition)) { //only filtrationCondition found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                   f.add(foundFiltrationCondition(s,word));
               }
           }
           if(regex ==null && (ignoreWordRegister) && (filtrationCondition)) { //only ignoreWordRegister found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                   f.add(foundIgnoreWordRegister(s));
               }
           }
           if(regex ==null && (ignoreWordRegister) && (filtrationCondition)) { // ignoreWordRegister and filtrationCondition found
               while((s=br.readLine()) !=null){
                   s = br.readLine();
                   s = foundIgnoreWordRegister(s);
                   word = foundIgnoreWordRegister(word);
                   f.add(foundFiltrationCondition(s,word));
               }
               br.close();
           }
       }
       catch (IOException exc) {
           System.out.println ( "Ошибка ввода-вывода: "+ exc );
           }
       return f;
      }
}
