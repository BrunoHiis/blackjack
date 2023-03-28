import java.util.ArrayList;
import java.util.Scanner;

public class Mäng {
    public static final int BUST_NUMBER = 23;
    public static int raha = 1000;
    public static void main(String[] args) {
        Mäng mäng = new Mäng();
        mäng.uusMäng();
    }

    public void uusMäng() {
        Kaardid kaardid = new Kaardid();
        System.out.println("Uus mäng alustatud!");
        System.out.println("Sinu raha: " + raha);
        Scanner scanner = new Scanner(System.in);

        // Kui raha on 0, siis mäng lõppeb
        while(raha > 0) {
            // Küsi kasutajalt panus
            System.out.println("Sisesta panus: ");
            int panus = Integer.parseInt(scanner.nextLine());

            // Loome uue roundi klassi
            Round round = new Round(panus);
            round.uusRound();

            System.out.println("Sinu raha: " + raha);
        }
    }
}