package Version4;

public final class KatzeVersion4 extends TierVersion4 {

    private int anzahlMaeuse;

    public KatzeVersion4(int hunger) {
        super(hunger);
    }

    public void maeuseFangen() {
        anzahlMaeuse++;
    }

    public int getAnzahlMaeuse() {
        return anzahlMaeuse;
    }

    public void geraeuscheMachen() {
        System.out.println("MIAAUUUUU");
    }

    @Override
    public String toString() {
        String katzeAlsString = "Ich bin eine Katze und habe " + anzahlMaeuse + " Maus gefangen";
        if (getHunger() < 0) {
            katzeAlsString += "Ich habe Hunger";
        } else {
            katzeAlsString += "Ich bin satt";
        }

        return katzeAlsString;
    }
}
