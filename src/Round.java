import java.util.ArrayList;
import java.util.Scanner;

public class Round {
    private ArrayList<Kaart> mängijaKaardid = new ArrayList<>();
    private ArrayList<Kaart> diileriKaardid = new ArrayList<>();
    private int paunseSuurus;
    private Kaardid kaardipakk;

    public Round(int betSize) {
        this.paunseSuurus = betSize;
        this.kaardipakk = new Kaardid();
        mängijaKaardid.add(kaardipakk.lisaKaart());
        mängijaKaardid.add(kaardipakk.lisaKaart());

        diileriKaardid.add(kaardipakk.lisaKaart());
    }

    public void printRoundBeginningInfo() {
        System.out.println("Mängija kaardid: " + mängijaKaardid);
        System.out.println("Diileri kaardid: " + diileriKaardid);
        System.out.println("Panuse suurus: " + paunseSuurus);
    }

    public int getKäeVäärtus(ArrayList<Kaart> käsi) {
        int väärtus = 0;
        int ässadeArv = 0;

        for (Kaart kaart : käsi) {
            väärtus += kaart.getVäärtus();
            if (kaart.getSuurus().equals("äss")) {
                ässadeArv++;
            }
        }

        while (väärtus > Mäng.BUST_NUMBER && ässadeArv > 0) {
            väärtus -= 10;
            ässadeArv--;
        }

        return väärtus;
    }

    public void uusRound() {
        boolean mängijaJääb = false;

        printRoundBeginningInfo();

        // Kui mängija kaartide skoor on väiksem kui 23, siis küsi kasutajalt, kas ta tahab veel kaarte võtta
        while (getKäeVäärtus(mängijaKaardid) < Mäng.BUST_NUMBER && !mängijaJääb) {
            System.out.println("Kas soovid veel kaarte võtta (Juurde/Jääb)? (Juurde/Jääb)");
            Scanner scanner = new Scanner(System.in);
            String vastus = scanner.nextLine();
            vastus = vastus.toLowerCase();

            if (vastus.equals("juurde")) {
                Kaart uusKaart = kaardipakk.lisaKaart();
                mängijaKaardid.add(uusKaart);
                System.out.println("Said juurde: " + uusKaart);
                System.out.println("Mängija kaardid: " + mängijaKaardid);
            } else {
                // Mängija lõpetab mängu, kuna Jääb
                mängijaJääb = true;
            }
        }

// Bust
        if (getKäeVäärtus(mängijaKaardid) > Mäng.BUST_NUMBER) {
            System.out.println("Mängija kaardid: " + mängijaKaardid);
            Mäng.raha -= paunseSuurus;
            return;
        }

// Diiler võtab kaarte, kuni tema skoor on vähem kui 18
        while (getKäeVäärtus(diileriKaardid) < 18) {
            diileriKaardid.add(kaardipakk.lisaKaart());
        }

        System.out.println("Diileri kaardid: " + diileriKaardid);

// Diiler bust
        if (getKäeVäärtus(diileriKaardid) > Mäng.BUST_NUMBER) {
            System.out.println("Diiler on üle!");
            Mäng.raha += paunseSuurus;
            return;
        }

// Pakkuja võidab
        if (getKäeVäärtus(diileriKaardid) > getKäeVäärtus(mängijaKaardid)) {
            System.out.println("Pakkuja võitis!");
            Mäng.raha -= paunseSuurus;
            return;
        }

// Mängija võidab
        if (getKäeVäärtus(diileriKaardid) < getKäeVäärtus(mängijaKaardid)) {
            System.out.println("Palju õnne, sa võitsid!");
            Mäng.raha += paunseSuurus;
            return;
        }

// Viik
        if (getKäeVäärtus(diileriKaardid) == getKäeVäärtus(mängijaKaardid)) {
            System.out.println("Viik!");
            return;
        }
    }
}