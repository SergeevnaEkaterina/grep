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
    private boolean regex;
    private String word;
    private final String inputName;

    public Grep(boolean filtrationCondition, boolean ignoreWordRegister, boolean regex, String word, String inputName) {
        this.filtrationCondition = filtrationCondition;
        this.ignoreWordRegister = ignoreWordRegister;
        this.regex = regex;
        this.word = word;
        this.inputName = inputName;
    }
    public List<String> logics() throws IOException {
        ArrayList<String> f = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputName))) {
            String s;
            if (!regex) {
                if (!ignoreWordRegister) {
                    if (!filtrationCondition) {//nothing
                        while ((s = br.readLine()) != null) {
                            if (s.contains(word)) f.add(s);

                        }
                    } else {//filtrationCondition
                        while ((s = br.readLine()) != null) {
                            if (!s.contains(word)) f.add(s);
                        }
                    }
                } else {
                    if (!filtrationCondition) {//ignoreWordRegister
                        while ((s = br.readLine()) != null) {
                            if (s.contains(word)) f.add(s.toLowerCase());

                        }
                    } else {//ignoreWordRegister&filtrationCondition
                        while ((s = br.readLine()) != null) {
                            s = s.toLowerCase();
                            word = word.toLowerCase();
                            if (!s.contains(word)) f.add(s);
                        }
                    }
                }
            }
            else{
                if(!ignoreWordRegister){
                    if (!filtrationCondition){//regex
                        while((s=br.readLine()) !=null){
                            Pattern p = Pattern.compile(word);
                            Matcher m = p.matcher(s);
                            if (m.find()) f.add(s);
                        }
                    }
                    else{//regex&filtrationCondition
                        while((s=br.readLine()) !=null){
                            Pattern p = Pattern.compile(word);
                            Matcher m = p.matcher(s);
                            if(!m.find()) f.add(s);
                        }
                    }
                }
                else{
                    if (!filtrationCondition){//regex&ignoreWordRegister
                        while((s=br.readLine()) !=null){
                            Pattern p = Pattern.compile(word, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
                            Matcher m = p.matcher(s);
                            if (m.find()) f.add(s.toLowerCase());
                        }
                    }
                    else{//all
                        while((s=br.readLine()) !=null){
                            Pattern p = Pattern.compile(word, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
                            Matcher m = p.matcher(s);
                            if(!m.find()) f.add(s.toLowerCase());
                        }
                    }
                }
                }
            br.close();
            return f;
        }
    }
}