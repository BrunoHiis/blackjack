public class Kaart {
    private String mast;
    private int väärtus;
    private String suurus;

    public Kaart(String mast, int väärtus, String suurus) {
        this.mast = mast;
        this.väärtus = väärtus;
        this.suurus = suurus;
    }

    public String getMast() {
        return mast;
    }

    public void setMast(String mast) {
        this.mast = mast;
    }

    public int getVäärtus() {
        return väärtus;
    }

    public void setVäärtus(int väärtus) {
        this.väärtus = väärtus;
    }

    public String getSuurus() {
        return suurus;
    }

    public void setSuurus(String suurus) {
        this.suurus = suurus;
    }
}
