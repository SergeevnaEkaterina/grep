package consoleApp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Grep {
    private boolean filtrationCondition;
    private boolean ignoreWordRegister;
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
    boolean flagsProcessing(String a){
        boolean b = false;
        String filt = "";
        Pattern p;
        if (regex){
            filt = word;
        }
        else filt=Pattern.quote(word);
        if (ignoreWordRegister) {
            p = Pattern.compile(filt, Pattern.UNICODE_CASE| Pattern.CASE_INSENSITIVE);
        }
        else p = Pattern.compile(filt);
        Matcher m = p.matcher(a);
        b = m.find();
        if (filtrationCondition) {
            b = !b;
        }
        return b;
    }
    public List<String> logics() throws IOException {
        List<String> f = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputName))) {
            String s;
            while ((s = br.readLine()) != null) {
                if (flagsProcessing(s)) f.add(s);
            }
            return f;
        }
    }
}