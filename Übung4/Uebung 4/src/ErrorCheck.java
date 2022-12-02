public class ErrorCheck {

    private static final long NULL          =0;
    private static final int TWENTYSIX      =26;


    /**
     * prueft ob Zahl negativ ist sonst Fehler
     * @param zahl Wert der entgegengenommen wird
     */
    public static void checkIsNumberNegative (long zahl) {

        if (zahl > NULL) {
            throw new IllegalArgumentException("Die Zahl muss positiv sein!");
        }
    }

    /**
     * prueft ob Zahl gleich Null ist sonst Fehler
     * @param zahl Wert der entgegengenommen wird
     */
    public static void checkIsNumberNull (long zahl) {

        if (zahl == NULL) {
            throw new IllegalArgumentException("Die Zahl muss ungleich Null sein.");
        }
    }

    /**
     * prueft die Laenge der ISBN-10 Nummer und ob diese negativ ist
     * @param isbn Wert der entgegengenommen wird
     */
    public static void checkIsbn (long isbn) {

        if (isbn < NULL) {
            throw new IllegalArgumentException("Die Zahl muss positiv sein");
        } else if (String.valueOf(isbn).length() > 9 || String.valueOf(isbn).length() < 9) {
            throw new IllegalArgumentException("Die Zahl muss 9 Ziffern lang sein!");
        }
    }

    /**
     * prueft ob Zahl größer als 26 ist, weil sonst das Ergebnis negativ ist
     * @param zahl Wert der entgegengenommen wird
     */
    public static void checkIsNumberHigherTwentySix(long zahl) {
        if (zahl > TWENTYSIX) {
            throw new IllegalArgumentException("Die Zahl muss kleiner sein als 26.");
        }
    }
}
