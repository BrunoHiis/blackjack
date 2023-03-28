import java.util.ArrayList;
import java.util.Scanner;

public class Mäng {
    public static final int BUST_NUMBER = 23;
    public static int raha = 1000;

    public void uusMäng() {
        Kaardid kaardid = new Kaardid();
        System.out.println("Uus mäng alustatud!");
        System.out.println("Sinu raha: " + raha);
        Scanner scanner = new Scanner(System.in);

        // Kui raha on 0, siis mäng lõppeb
        while (raha > 0) {
            // Küsi kasutajalt panus
            int panus = 0;

            // Küsib kasutajalt panuse, kuni ta sisestab õige panuse
            while (true) {
                System.out.println("Sisesta panus: ");
                panus = Integer.parseInt(scanner.nextLine());
                if (panus > 0 && panus <= raha) {
                    break;
                }
                System.out.println("Vigane panus! Palun sisesta panus vahemikus 1 kuni " + raha);
            }

            // Loome uue roundi klassi
            Round round = new Round(panus);
            round.uusRound();

            System.out.println("Sinu raha: " + raha);
        }
    }
}