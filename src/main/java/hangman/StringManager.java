package hangman;

public class StringManager {

    private String plainTextString;
    private String hiddenString;
    private int remainingCharacters;

    public StringManager(String hangmanString) {
        this.plainTextString = hangmanString;
        buildHangManString();
    }

    public String buildHangManString(){
        System.out.println(plainTextString);     // remove this
        char [] characters = plainTextString.toCharArray();
        hiddenString = "";
        for (int i = 0; i<characters.length; i++){
            if (characters[i] != ' '){
                hiddenString += "-";
            }
            else{
                hiddenString += " ";
            }
        }
        return hiddenString;
    }


    public String guessLetter(String letter) {
        StringBuilder reveal = new StringBuilder(hiddenString);
        if (plainTextString.contains(letter)) {
            char[] characters = plainTextString.toCharArray();
            for (int i = 0; i < plainTextString.length(); i++) {
                if (String.valueOf(characters[i]).equals(letter)) {
                    reveal.setCharAt(i, letter.charAt(0));
                }
            }
        }
        return hiddenString = reveal.toString();
    }

    public String getPlainTextString() {
        return plainTextString;
    }

    public void setPlainTextString(String plainTextString) {
        this.plainTextString = plainTextString;
    }

    public String getHiddenString() {
        return hiddenString;
    }

    public void setHiddenString(String hiddenString) {
        this.hiddenString = hiddenString;
    }

    public void remainingLetters(){
        char[] characters =hiddenString.toCharArray();
        remainingCharacters = hiddenString.length();

        for(int i = 0; i<hiddenString.length(); i++){
            if (hiddenString.charAt(i) != '-'){
                remainingCharacters--;
            }
        }

        System.out.println(String.format("%s more letters to go...", remainingCharacters));
    }

}
