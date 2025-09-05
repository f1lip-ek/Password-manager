import java.util.Random;

public class Chars {

    Random rd = new Random();

    /**
     *  1. Array with small and big letters
     */
    private final char[] lowerCaseAlphabet; // 26 lowercase letters

    private final char[] upperCaseAlphabet; // 26 uppercase letters

    /**
     * 2. Array with numbers 0-9
      */
    private final char[] numbers;

    /**
     * 3. Array with special characters
     */
    private final char[] specialCharacters;

    public Chars() {
        this.lowerCaseAlphabet = new char[26];
        this.upperCaseAlphabet = new char[26];
        this.numbers = new char[10];
        this.specialCharacters = new char[]{
                '.', ',', '!', '?', ':', ';', '-', '_', '(', ')', '[', ']', '{', '}', '@',
                '#', '$', '%', '^', '&', '*', '+', '=', '/', '\\', '\"', '<', '>', '|', '~'
        };
        setChars();
    }

    /**
     * Method for filling arrays with alphabet and numbers
     */
    public void setChars() {
        for (int i = 0; i < 26; i++) {
            lowerCaseAlphabet[i] = (char) ('a' + i);         // lowercase letters a-z
            upperCaseAlphabet[i] = (char) ('A' + i);     // uppercase letters A-Z
        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = (char) ('0' + i);
        }
    }

    public char[] getLowerCaseAlphabet() {
        return lowerCaseAlphabet;
    }

    public char[] getNumbers() {
        return numbers;
    }

    public char[] getSpecialCharacters() {
        return specialCharacters;
    }

    public char[] getUpperCaseAlphabet() {
        return upperCaseAlphabet;
    }

    public char getRandomChar(char[] character){
        return character[rd.nextInt(character.length)];
    }
}
