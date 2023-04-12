public class Raum {

    private int geb;
    private int etage;
    private int raum;

    public Raum(int geb, int etage, int raum) {
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
    }

    @Override
    public String toString() {
        return "Raum " + geb + "-" + etage + "." + raum;
    }
}
