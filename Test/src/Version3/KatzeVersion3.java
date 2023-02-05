package Version3;

public class KatzeVersion3 extends TierVersion3 {

    private int anzahlMaeuse;

    public void maeuseFangen() {
        anzahlMaeuse++;
    }

    public int getAnzahlMaeuse() {
        return anzahlMaeuse;
    }

    public String toString() {
        return "Ich bin eine Katze und habe " + anzahlMaeuse + " Maus gefangen";
    }
}
