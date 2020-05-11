package consoleApp;
import consoleApp.Grep;
//package consoleApp;
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
        Grep gr = new Grep(false,false,false,"Симбирской", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("жил он в своей Симбирской деревне, где и женился на девице Авдотье");
        assertEquals(test, gr.logics());
    }

    @Test
    public void logics2() throws IOException {//filtrationCondition
        Grep gr = new Grep(true,false,false,"девять", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        test.add("графе Минихе и вышел в отставку премьер-майором в 17.. году. С тех пор");
        test.add("жил он в своей Симбирской деревне, где и женился на девице Авдотье");
        test.add("человек детей. Все мои братья и сестры умерли во младенчестве.");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics3() throws IOException {//ignoreWordRegister
        Grep gr = new Grep(false, true, false, "бРаТьЯ", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("человек детей. Все мои братья и сестры умерли во младенчестве.");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics4() throws IOException {//regex
        Grep gr = new Grep(false,false,true,"служил", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics40() throws IOException {//regex
        Grep gr = new Grep(false,false,true,"[ж]", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        test.add("жил он в своей Симбирской деревне, где и женился на девице Авдотье");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics400() throws IOException {//regex

        Grep gr = new Grep(false,false,true,"вышел|сестры", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("графе Минихе и вышел в отставку премьер-майором в 17.. году. С тех пор");
        test.add("человек детей. Все мои братья и сестры умерли во младенчестве.");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics5() throws IOException {//filtrationCondition&ignoreWordRegister
        Grep gr = new Grep(true,true,false,"СиМбИрСКОй", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        test.add("графе Минихе и вышел в отставку премьер-майором в 17.. году. С тех пор");
        test.add("Васильевне Ю., дочери бедного тамошнего дворянина. Нас было девять");
        test.add("человек детей. Все мои братья и сестры умерли во младенчестве.");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics6() throws IOException {//filtrationCondition&regex
        Grep gr = new Grep(true,false,true,"отставку", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        test.add("жил он в своей Симбирской деревне, где и женился на девице Авдотье");
        test.add("Васильевне Ю., дочери бедного тамошнего дворянина. Нас было девять");
        test.add("человек детей. Все мои братья и сестры умерли во младенчестве.");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics7() throws IOException {//ignoreWordRegister&regex
        Grep gr = new Grep(false,true,true,"мОлОдосТи", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics70() throws IOException {//ignoreWordRegister&regex
        Grep gr = new Grep(false,true,true,"\\S", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        test.add("графе Минихе и вышел в отставку премьер-майором в 17.. году. С тех пор");
        test.add("жил он в своей Симбирской деревне, где и женился на девице Авдотье");
        test.add("Васильевне Ю., дочери бедного тамошнего дворянина. Нас было девять");
        test.add("человек детей. Все мои братья и сестры умерли во младенчестве.");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics8() throws IOException {//all
        Grep gr = new Grep(true,true,true,"[ю-я]", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        test.add("графе Минихе и вышел в отставку премьер-майором в 17.. году. С тех пор");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics9() throws IOException {//all
        Grep gr = new Grep(true,true,true,"служИЛ|БРАТЬЯ", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("графе Минихе и вышел в отставку премьер-майором в 17.. году. С тех пор");
        test.add("жил он в своей Симбирской деревне, где и женился на девице Авдотье");
        test.add("Васильевне Ю., дочери бедного тамошнего дворянина. Нас было девять");
        assertEquals(test, gr.logics());
    }
    @Test
    public void logics10() throws IOException {//all
        Grep gr = new Grep(true,true,true,"ДЕРЕВНЕ", "src\\test\\textForTesting");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Отец мой Андрей Петрович Гринев в молодости своей служил при");
        test.add("графе Минихе и вышел в отставку премьер-майором в 17.. году. С тех пор");
        test.add("Васильевне Ю., дочери бедного тамошнего дворянина. Нас было девять");
        test.add("человек детей. Все мои братья и сестры умерли во младенчестве.");
        assertEquals(test, gr.logics());
    }
}