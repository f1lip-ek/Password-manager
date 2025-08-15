import java.util.Random;

public class RandomGenerator {

    private final Random rd;
    private final Chars chars;
    public static User user;
    private int numOfCategories;
    private int randomNum;
    public static String password;

    public RandomGenerator() {
        this.rd = new Random();
        this.chars = new Chars();
        user = new User();
        password = "";
    }

    public void generatePassword() {
        setNumOfCategories();
        for (int i = 0; i < user.getLength(); i++) {
            this.randomNum = rd.nextInt(numOfCategories);
            categoryChecker();
        }
        System.out.println(password);
    }

    public void setNumOfCategories(){
        numOfCategories = 0;
        if(user.isUpperCase()){
            numOfCategories++;
        }
        if(user.isLowerCase()){
            numOfCategories++;
        }
        if(user.isNumbers()){
            numOfCategories++;
        }
        if(user.isSpecial()){
            numOfCategories++;
        }
    }

    public void categoryChecker(){
    /*0*/if(user.isUpperCase() && user.isLowerCase() && user.isNumbers() && user.isSpecial()){
        switch (randomNum) {
            case 0 -> password += chars.getRandomChar(chars.getUpperCaseAlphabet());
            case 1 -> password += chars.getRandomChar(chars.getLowerCaseAlphabet());
            case 2 -> password += chars.getRandomChar(chars.getNumbers());
            case 3 -> password += chars.getRandomChar(chars.getSpecialCharacters());
        }
    /*1*/} else if (user.isUpperCase() && user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getUpperCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getLowerCaseAlphabet());
                case 2 -> password += chars.getRandomChar(chars.getNumbers());
            }
    /*2*/} else if (user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getUpperCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getLowerCaseAlphabet());
                case 2 -> password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*3*/} else if (user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getUpperCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getLowerCaseAlphabet());
            }
    /*4*/} else if (user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getUpperCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getNumbers());
                case 2 -> password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*5*/} else if (user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getUpperCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getNumbers());
                case 2 -> password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*6*/} else if (user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getUpperCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*7*/} else if (user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getUpperCaseAlphabet());
            }
    /*8*/} else if (!user.isUpperCase() && user.isLowerCase() && user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getLowerCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getNumbers());
                case 2 -> password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*9*/} else if (!user.isUpperCase() && user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getLowerCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getNumbers());
            }
    /*10*/} else if (!user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getLowerCaseAlphabet());
                case 1 -> password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*11*/} else if (!user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getLowerCaseAlphabet());
            }
    /*12*/} else if (!user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getNumbers());
                case 1 -> password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*13*/} else if (!user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getNumbers());
            }
    /*14*/} else if (!user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getSpecialCharacters());
            }
    /*15*/} else if (!user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            System.out.println("You choose nothing");
        }

        
    }

}
