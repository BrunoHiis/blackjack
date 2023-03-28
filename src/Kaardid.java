import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Kaardid {
    private ArrayList<Kaart> kaardid;

    public Kaardid() {
        this.kaardid = looKaardipakk(4);
    }


    public static ArrayList<Kaart> looKaardipakk(int pakkideArv) {
        ArrayList<Kaart> kaardid = new ArrayList<>();
        ArrayList<String> Mastid = new ArrayList<>(Arrays.asList("risti", "ruutu", "ärtu", "poti"));
        LinkedHashMap<String, Integer> suurus = new LinkedHashMap<>();
        suurus.put("üks",1);
        suurus.put("kaks",2);
        suurus.put("kolm",3);
        suurus.put("neli",4);
        suurus.put("viis",5);
        suurus.put("kuus",6);
        suurus.put("seitse",7);
        suurus.put("kaheksa",8);
        suurus.put("üheksa", 9);
        suurus.put("kümme", 10);
        suurus.put("poiss", 10);
        suurus.put("emand", 10);
        suurus.put("kuningas",10);
        suurus.put("äss", 11);
        for (int i = 0; i < pakkideArv; i++) {
            for (String mast : Mastid) {
                for (Map.Entry<String, Integer> e : suurus.entrySet()) {
                    String s = e.getKey();
                    int Väärtus = e.getValue();
                    kaardid.add(new Kaart(mast, Väärtus, s));
                }
            }
        }
        return kaardid;
    }

    public Kaart lisaKaart() {
        int size = kaardid.size();
        int randomIndex = (int) (Math.random() * size);
        Kaart kaart = kaardid.remove(randomIndex);
        return kaart;
    }

}
