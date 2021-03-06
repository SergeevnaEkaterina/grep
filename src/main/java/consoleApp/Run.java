package consoleApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import java.io.IOException;
import java.util.regex.Pattern;
public class Run {
    @Option(name = "-v", usage = "Инвертирует условие фильтрации(выводит только то, что ему не соответствует)")
    private boolean filtrationCondition;
    @Option(name = "-i", usage = "Игнорирует регистр слов")
    private boolean ignoreWordRegister;
    @Option(name = "-r", usage = "Выводятся только строки, содержащие данное регулярное выражение")
    private boolean regex;
    @Argument(required = true, metaVar = "InputName",index = 1, usage = "Входной файл")
    private String inputName;
    @Argument(required = true, metaVar = "Word", usage = "Выводятся только строки, содержащие данное слово")
    private String word;
    public static void main(String[] args) {
        new Run().launch(args);
    }
    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar grep.jar [-v] [-i] [-r] word inputName.txt");
            parser.printUsage(System.err);
            return;
        }
        Grep g = new Grep(filtrationCondition,ignoreWordRegister,regex,word,inputName);
        try {
            List<String> output = g.logics();
            for (String e: output)
                System.out.println(e);
        }catch (IOException exc) {
            System.err.println(exc.getMessage());
        }
    }
}