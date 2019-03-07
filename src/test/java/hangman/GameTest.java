package hangman;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void hasWonTest(){
        StringManager stringManager = new StringManager("test");

        Game game = new Game();
        stringManager.setHiddenString("test");
        game.checkWin();
        game.showHangManChallenge();
        System.out.println(stringManager.getHiddenString()+"!!!");
        assertTrue(game.hasWon);

    }

}