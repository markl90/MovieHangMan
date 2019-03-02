package hangman;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


class ListManagerTest {

    private List movies;
    private ListManager listManager;

    @BeforeClass
    void setup(){
        movies = new ArrayList<String>();
//        movies.add("the silence of the lambs");
//        movies.add("the lord of the rings");
//        movies.add("samurai");
//        movies.add("the matrix");
        listManager = new ListManager(movies);
    }

    @Test
    public void chooseRandomMovieTest(){
        movies.removeAll(movies);
        movies.add("the silence of the lambs");
        assertEquals(listManager.chooseRandomMovie(),"the silence of the lambs");
    }



}
