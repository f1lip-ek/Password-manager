import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("res\\passwords.txt", true))){
            writer.newLine();
            writer.write(password);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
            case 0 -> password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
            case 1 -> password += chars.getRandomChar(chars.getAbecedaMalaPismena());
            case 2 -> password += chars.getRandomChar(chars.getCisla());
            case 3 -> password += chars.getRandomChar(chars.getZnaky());
        }
    /*1*/} else if (user.isUpperCase() && user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
                case 1 -> password += chars.getRandomChar(chars.getAbecedaMalaPismena());
                case 2 -> password += chars.getRandomChar(chars.getCisla());
            }
    /*2*/} else if (user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
                case 1 -> password += chars.getRandomChar(chars.getAbecedaMalaPismena());
                case 2 -> password += chars.getRandomChar(chars.getZnaky());
            }
    /*3*/} else if (user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
                case 1 -> password += chars.getRandomChar(chars.getAbecedaMalaPismena());
            }
    /*4*/} else if (user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
                case 1 -> password += chars.getRandomChar(chars.getCisla());
                case 2 -> password += chars.getRandomChar(chars.getZnaky());
            }
    /*5*/} else if (user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
                case 1 -> password += chars.getRandomChar(chars.getCisla());
                case 2 -> password += chars.getRandomChar(chars.getZnaky());
            }
    /*6*/} else if (user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
                case 1 -> password += chars.getRandomChar(chars.getZnaky());
            }
    /*7*/} else if (user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getAbecedaVelkaPismena());
            }
    /*8*/} else if (!user.isUpperCase() && user.isLowerCase() && user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaMalaPismena());
                case 1 -> password += chars.getRandomChar(chars.getCisla());
                case 2 -> password += chars.getRandomChar(chars.getZnaky());
            }
    /*9*/} else if (!user.isUpperCase() && user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaMalaPismena());
                case 1 -> password += chars.getRandomChar(chars.getCisla());
            }
    /*10*/} else if (!user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getAbecedaMalaPismena());
                case 1 -> password += chars.getRandomChar(chars.getZnaky());
            }
    /*11*/} else if (!user.isUpperCase() && user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getAbecedaMalaPismena());
            }
    /*12*/} else if (!user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && user.isSpecial()) {
            switch (randomNum) {
                case 0 -> password += chars.getRandomChar(chars.getCisla());
                case 1 -> password += chars.getRandomChar(chars.getZnaky());
            }
    /*13*/} else if (!user.isUpperCase() && !user.isLowerCase() && user.isNumbers() && !user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getCisla());
            }
    /*14*/} else if (!user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && user.isSpecial()) {
            if (randomNum == 0) {
                password += chars.getRandomChar(chars.getZnaky());
            }
    /*15*/} else if (!user.isUpperCase() && !user.isLowerCase() && !user.isNumbers() && !user.isSpecial()) {
            System.out.println("You choose nothing");
        }

        
    }

}
