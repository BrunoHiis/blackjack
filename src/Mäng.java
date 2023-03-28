public class Mäng {
    public static final int BUST_NUMBER = 23;
    public static int raha = 1000;

    public void uusMäng() {
        System.out.println("Uus mäng alustatud!");
        System.out.println("Sinu raha: " + raha);

        // Kui raha on 0, siis mäng lõppeb
        while(raha > 0) {
            // Küsi kasutajalt panus
            System.out.println("Sisesta panus: ");
            int panus = Integer.parseInt(System.console().readLine());

            // Loome uue roundi klassi
            Round round = new Round(panus);
            round.uusRound();

            System.out.println("Sinu raha: " + raha);
        }
    }
}
