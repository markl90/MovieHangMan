package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ListManager {

    private List movies;
    private File file;
    private Scanner scanner;

    public ListManager(List movies) {
        this.movies = movies;
    }


    public ListManager() {
        this.movies = new ArrayList<String>();
        file = new File(ClassLoader.getSystemResource("movies.txt").getFile());
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        addMoviesToList();
    }


    public void addMoviesToList(){
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            movies.add(line);
        }
    }

    public String chooseRandomMovie(){
        Random random = new Random();
        int selection = random.nextInt(movies.size());
        return movies.get(selection).toString();
    }




}
