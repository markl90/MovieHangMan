package hangman;

import java.util.Scanner;

public class Game {

    private ListManager listManager;
    private StringManager stringManager;
    private Scanner scanner;
    private String previousGuesses = "";
    private int turns;


    public Game() {
        this.listManager = new ListManager();
        this.stringManager = new StringManager(listManager.chooseRandomMovie());
        scanner = new Scanner(System.in);
    }

    public void play(){
        while(stringManager.getHiddenString().contains("-")){
            showNewTurn();
            showChallenge();
            System.out.println("Guess a letter:");
            String input = scanner.nextLine();
          //  if(alreadyPicked(input){ play();}
            if (input.length() > 1) {
                System.out.println("only one letter at a time...");
            }
            if (alreadyPicked(input)){
                play();
            }

            else{
                stringManager.guessLetter(input);
                previousGuesses(input);
                turns++;
                showTurns();
                stringManager.remainingLetters();
            }

        }
    }


    public void previousGuesses(String input){
        previousGuesses += " "+input.toUpperCase();
        System.out.println(previousGuesses);
    }

    public void showChallenge(){
        System.out.println(stringManager.getHiddenString());
    }

    public void showTurns(){
        System.out.println(String.format("You've had %s turns!", turns));
    }

    public void showNewTurn(){
        System.out.println("==========HANGMAN==========");
    }

    public boolean alreadyPicked(String input){
        if (previousGuesses.contains(input)){
            System.out.println(String.format("You've chosen %s already, try a different letter...", input));
            return true;
        }
        return false;

    }

}
