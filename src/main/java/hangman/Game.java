package hangman;
import java.util.Scanner;
public class Game {

    private ListManager listManager;
    private StringManager stringManager;
    private Scanner scanner;
    private String previousGuesses;
    private int turns;
    private int lives =0;
    boolean hasWon = false;

    public Game() {
        this.listManager = new ListManager();
        this.stringManager = new StringManager(listManager.chooseRandomMovie());
        scanner = new Scanner(System.in);
    }

    public void play(){

        while(!hasWon){
            hasWon = stringManager.getHiddenString().contains("-") ? false : true;
            if(hasWon){continue;}
            if(lives==5 && !hasWon){break;}
            printHangMan(lives);
            showNewTurn();
            showHangManChallenge();
            System.out.println("Guess a letter:");
            String input = scanner.nextLine();
                if (input.length() > 1) {
                    System.out.println("only one letter at a time...");
                }
                else{
                    stringManager.guessLetter(input);
                    previousGuesses(input);
                    turns++;
                    showTurns();
                    stringManager.remainingLetters();
                    int consoleHangMan = lives;
                   // printHangMan(consoleHangMan);
                    if(!stringManager.getHiddenString().contains(input)){
                    lives++;}
                }
        }
        if(lives==5 && !hasWon){
            System.out.println("GAME OVER");
        }else {
            gameComplete();
        }
        wholeWithArmsOut();
    }

    public void checkWin(){
        hasWon = stringManager.getHiddenString().contains("-") ? false : true;
    }

    public void printHangMan(int life) {
        switch (life){
        case 0:
            nooseBase();
            break;
        case 1:
            nooseBase();
        break;
        case 2
        :
            baseAndStand();
        break;
        case 3
        :
            baseAndTop();
        break;
        case 4
        :
        topWithRope();
        break;
        case 5
        :
            wholeStandWithBody();
        break;
        default:
            printWithTitle();
        break;
    }


    }
    public void previousGuesses(String input){
        previousGuesses += " "+input.toUpperCase();
        System.out.println(previousGuesses);
    }
    public void showHangManChallenge(){
        System.out.println(stringManager.getHiddenString());
    }
    public void showTurns(){
        System.out.println(String.format("You've had %s turns!", turns));
    }
    public void showNewTurn(){
        System.out.println("\n==**New Turn**==\n");
    }
    public void printWithTitle() {
        System.out.println("==HANGMAN==");
        System.out.println("     |    |");
        System.out.println("     O    |");
        System.out.println("    |||   |");
        System.out.println("     |    |");
        System.out.println("    / \\  |");
        System.out.println("         /|");
        System.out.println("________/_|");
    }
    public void wholeWithArmsOut(){
        System.out.println("==HANGMAN==");
        System.out.println("      _____");
        System.out.println("     |    |");
        System.out.println("     O    |");
        System.out.println("    ~|~   |");
        System.out.println("     |    |");
        System.out.println("    / \\  |");
        System.out.println("         /|");
        System.out.println("________/_|");


    }
    public void wholeStandWithBody(){
        System.out.println("==HANGMAN==");
        System.out.println("      _____");
        System.out.println("     |    |");
        System.out.println("     O    |");
        System.out.println("    |||   |");
        System.out.println("     |    |");
        System.out.println("    / \\  |");
        System.out.println("         /|");
        System.out.println("________/_|");


    }
    public void topWithRope(){
        System.out.println("==HANGMAN==");
        System.out.println("      _____");
        System.out.println("     |    |");
        System.out.println("     O    |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("         /|");
        System.out.println("________/_|");


    }
    public void baseAndTop(){
        System.out.println("==HANGMAN==");
        System.out.println("      _____");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("         /|");
        System.out.println("________/_|");


    }
    public void baseAndStand(){
        System.out.println("==HANGMAN==");
        System.out.println("           ");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("          |");
        System.out.println("         /|");
        System.out.println("________/_|");


    }
    public void nooseBase() {
        System.out.println("==HANGMAN==");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("________/_|");
    }
    public void gameComplete(){
       // for (int i = 0; i < 5 ; i++) {
         //   System.out.println("\n\n\n\n\n");
            showTurns();
          //  printHangMan(5);
            System.out.println("Game Complete!");
      //  }
    }
}
