package consoleApp;

import org.junit.Test;
import consoleApp.Grep;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GrepTest {

    @Test
    public void logics() throws IOException {
        Grep grep = new Grep(false,false,null,"", "");
        ArrayList<String> test = new ArrayList<>();
        test.add("Умом Россию не понять");
        test.add("Аршином общим не измерить");
        test.add("У ней особенная стать");
        test.add("В Россию можно только верить");
        assertEquals(test, grep.logics());
    }

}