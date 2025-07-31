import java.util.Random;

public class Chars {

    Random rd = new Random();

    /**
     *  1. Pole s malými a velkými písmeny bez háčků a čárek
     */
    private final char[] abecedaMalaPismena; // 26 malých

    private final char[] abecedaVelkaPismena; // 26 velkych

    /**
     * 2. Pole s čísly 0–9
      */
    private final char[] cisla;

    /**
     * 3. Pole se speciálními znaky
     */
    private final char[] znaky;

    public Chars() {
        this.abecedaMalaPismena = new char[26];
        this.abecedaVelkaPismena = new char[26];
        this.cisla = new char[10];
        this.znaky = new char[]{
                '.', ',', '!', '?', ':', ';', '-', '_', '(', ')', '[', ']', '{', '}', '@',
                '#', '$', '%', '^', '&', '*', '+', '=', '/', '\\', '\"', '<', '>', '|', '~'
        };
        setChars();
    }

    /**
     * Metoda na naplneni poli abecedy a cisel
     */
    public void setChars() {
        for (int i = 0; i < 26; i++) {
            abecedaMalaPismena[i] = (char) ('a' + i);         // malé znaky a-z
            abecedaVelkaPismena[i] = (char) ('A' + i);     // velké znaky A-Z
        }

        for (int i = 0; i < 10; i++) {
            cisla[i] = (char) ('0' + i);
        }
    }

    public char[] getAbecedaMalaPismena() {
        return abecedaMalaPismena;
    }

    public char[] getCisla() {
        return cisla;
    }

    public char[] getZnaky() {
        return znaky;
    }

    public char[] getAbecedaVelkaPismena() {
        return abecedaVelkaPismena;
    }

    public char getRandomChar(char[] znak){
        return znak[rd.nextInt(znak.length)];
    }
}
