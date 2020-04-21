package consoleApp;
import org.junit.Test;
import org.junit.Test;
import consoleApp.Grep;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import static org.junit.Assert.assertEquals;
public class GrepTest {
    @Test
    public void logics1() throws IOException {//nothing
        Grep gr = new Grep(false,false,null,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Умом Россию не понять");
        test.add("Аршином общим не измерить");
        test.add("У ней особенная стать");
        test.add("В Россию можно только верить");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics2() throws IOException {//filtrationCondition
        Grep gr = new Grep(true,false,null,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Умом Россию не понять");
        test.add("Аршином общим не измерить");
        test.add("В Россию можно только верить");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics3() throws IOException {//ignoreWordRegister
        Grep gr = new Grep(false,true,null,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("умом россию не понять");
        test.add("аршином общим не измерить");
        test.add("у ней особенная стать");
        test.add("в россию можно только верить");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics4() throws IOException {//regex
        Pattern p = Pattern.compile("стать");
        Grep gr = new Grep(false,false,p,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("У ней особенная стать");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics5() throws IOException {//filtrationCondition&ignoreWordRegister
        Grep gr = new Grep(true,true,null,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("умом россию не понять");
        test.add("аршином общим не измерить");
        test.add("в россию можно только верить");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics6() throws IOException {//filtrationCondition&regex
        Pattern p = Pattern.compile("стать");
        Grep gr = new Grep(true,false,p,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Умом Россию не понять");
        test.add("Аршином общим не измерить");
        test.add("В Россию можно только верить");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics7() throws IOException {//ignoreWordRegister&regex
        Pattern p = Pattern.compile("стать");
        Grep gr = new Grep(false,true,p,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("у ней особенная стать");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics8() throws IOException {//all
        Pattern p = Pattern.compile("стать");
        Grep gr = new Grep(true,true,p,"стать", "C:\\Users\\220\\IdeaProjects\\grep\\src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("умом россию не понять");
        test.add("аршином общим не измерить");
        test.add("в россию можно только верить");
        assertEquals(test, gr.logics());
    }
}