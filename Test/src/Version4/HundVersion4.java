package Version4;

public final class HundVersion4 extends TierVersion4 {

    private int anzahlStoecken;

    public HundVersion4(int hunger) {
        super(hunger);
    }

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

    @Override
    public void geraeuscheMachen() {
        System.out.println("WAU WAU");
    }
}
