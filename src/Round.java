import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Round {
    private Kaardid mängijaKaardid = new Kaardid();
    private Kaardid diileriKaardid = new Kaardid();
    private int paunseSuurus;

    public Round(int betSize) {
        this.paunseSuurus = betSize;

        mängijaKaardid.lisaKaart();
        mängijaKaardid.lisaKaart();

        diileriKaardid.lisaKaart();
    }

    public void printRoundBeginningInfo() {
        System.out.println("Mängija kaardid: " + mängijaKaardid);
        System.out.println("Dealeri kaardid: " + diileriKaardid);
        System.out.println("Panuse suurus: " + paunseSuurus);
    }

    public void uusRound() {
        boolean mängijaJääb = false;

        printRoundBeginningInfo();

        // Kui mängija kaartide skoor on väiksem kui 23, siis küsi kasutajalt, kas ta tahab veel kaarte võtta
        while (mängijaKaardid.getVäärtus() < Mäng.BUST_NUMBER && !mängijaJääb) {
            System.out.println("Kas soovid veel kaarte võtta (Juurde/Jääb)? (Juurde/Jääb)");
            Scanner scanner = new Scanner(System.in);
            String vastus = scanner.nextLine();
            vastus = vastus.toLowerCase();

            if (vastus.equals("juurde")) {
                mängijaKaardid.lisaKaart();
                System.out.println("Said juurde: " + mängijaKaardid.get(mängijaKaardid.size() - 1));
                System.out.println("Mängija kaardid: " + mängijaKaardid);
            } else {
                // Mängija lõpetab mängu, kuna Jääb
                mängijaJääb = true;
                break;
            }
        }

        // Bust
        if(mängijaKaardid.getVäärtus() < Mäng. BUST_NUMBER) {
            System.out.println("Mängija kaardid: " + mängijaKaardid);
            Mäng.raha -= paunseSuurus;
            return;
        }

        // Dealer Diiler kaarte, kuni ta skoor on vähem kui 18
        while (diileriKaardid.getVäärtus() < 18) {
            diileriKaardid.lisaKaart();
        }

        System.out.println("Diiler kaardid: " + diileriKaardid);

        // Diiler bust
        if (diileriKaardid.getVäärtus() > Mäng.BUST_NUMBER) {
            System.out.println("Diiler on üle!");
            Mäng.raha += paunseSuurus;
            return;
        }

        // Pakkuja võidab
        if (diileriKaardid.getVäärtus() > mängijaKaardid.getVäärtus()) {
            System.out.println("Pakkuja võitis!");
            Mäng.raha -= paunseSuurus;
            return;
        }

        // Mängija võidab
        if (diileriKaardid.getVäärtus() < mängijaKaardid.getVäärtus()) {
            System.out.println("Palju õnne, sa võitsid!");
            Mäng.raha += paunseSuurus;
            return;
        }

        // Viik
        if (diileriKaardid.getVäärtus() == mängijaKaardid.getVäärtus()) {
            System.out.println("Viik!");
            return;
        }
    }
}
