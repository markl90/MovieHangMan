package hangman;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringManagerTest {

    StringManager stringManager;

    @Before
    public void setUp() throws Exception {
        stringManager = new StringManager("happy feet");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void buildHangManString() {
        String plainTextFilm = "The matrix";
        String expectedResult = "--- ------";
        stringManager = new StringManager(plainTextFilm);
        assertEquals (stringManager.buildHangManString(), expectedResult);
    }

    @Test
    public void revealLetterTest(){
        stringManager.setPlainTextString("oceans11");
        stringManager.setHiddenString("--------");
        assertEquals("-----s--",stringManager.guessLetter("s"));
    }


}