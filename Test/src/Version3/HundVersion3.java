package Version3;

public class HundVersion3 extends TierVersion3 {

    private int anzahlStoecken;

    public void stoeckchenHolen() {
        anzahlStoecken++;
    }

    public int getAnzahlStoecken() {
        return anzahlStoecken;
    }

    public String toString() {
        String hundlsString = "Ich bin ein Hund und habe " + anzahlStoecken + " Stoecke geholt\n";

        if (getHunger() < 0) {
            hundlsString += "Ich habe Hunger";
        } else {
            hundlsString += "Ich bin satt";
        }

        return hundlsString;
    }
}
