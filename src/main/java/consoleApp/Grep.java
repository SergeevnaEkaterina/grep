package consoleApp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        this.word = word;
        this.inputName = inputName;
    }
    public List<String> logics() throws IOException {
        ArrayList<String> f = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(inputName)))
        {
            String s;
            if(regex ==null && !ignoreWordRegister  && !filtrationCondition) { //nothing found
                while((s=br.readLine()) !=null){
                    s = br.readLine();
                    f.add(s);
                }
            }
            if(regex !=null && !ignoreWordRegister && !filtrationCondition) { //only regex found
                while((s=br.readLine()) !=null){
                    s = br.readLine();
                    Pattern p = Pattern.compile(String.valueOf(regex));
                    Matcher m = p.matcher(s);
                    if (m.find()) f.add(s);
                }
            }
            if(regex !=null && (ignoreWordRegister) && !filtrationCondition) { //regex and ignoreWordRegister found
                while((s=br.readLine()) !=null){
                    s = br.readLine();
                    Pattern p = Pattern.compile(String.valueOf(regex), Pattern.CASE_INSENSITIVE);
                    Matcher m = p.matcher(s);
                    if (m.find()) f.add(s);
                }
            }
            if(regex !=null && !ignoreWordRegister && (filtrationCondition)) { //regex and filtrationCondition found
                while((s=br.readLine()) !=null){
                    s = br.readLine();
                    Pattern p = Pattern.compile(regex.toString());
                    Matcher m = p.matcher(s);
                    if(!m.find()) f.add(s);
                }
            }
            if(regex !=null && (ignoreWordRegister) && (filtrationCondition)) { //all found
                while((s=br.readLine()) !=null){
                    s = br.readLine().toLowerCase();
                    Pattern p = Pattern.compile(String.valueOf(regex), Pattern.CASE_INSENSITIVE);
                    Matcher m = p.matcher(s);
                    if(!m.find()) f.add(s);
                }
            }
            if(regex ==null && !ignoreWordRegister && (filtrationCondition)) { //only filtrationCondition found
                while((s=br.readLine()) !=null){
                    s = br.readLine();
                    if(!s.contains(word)) f.add(s);
                }
            }
            if(regex ==null && (ignoreWordRegister) && !filtrationCondition) { //only ignoreWordRegister found
                while((s=br.readLine()) !=null){
                    s = br.readLine().toLowerCase();
                    f.add(s);
                }
            }
            if(regex ==null && (ignoreWordRegister) && (filtrationCondition)) { // ignoreWordRegister and filtrationCondition found
                while ((s = br.readLine()) != null) {
                    s = br.readLine().toLowerCase();
                    word = word.toLowerCase();
                    if(!s.contains(word)) f.add(s);
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