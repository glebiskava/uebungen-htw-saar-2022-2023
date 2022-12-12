public class ErrorCheck {

    /**
     * prueft die maxiamle groesse des arrays
     * @param maxGroesse maximale groesse
     */
    public static void checkArrayGroesse (int maxGroesse) {
        if (maxGroesse < 1) {
            throw new IllegalArgumentException("Das Lager muss mindestens 1 Artikel enthalten muessen.");
        }
    }

    /**
     * checkt ob bestand groesser al 0 ist
     * @param bestand menge von artikel
     */
    public static void checkBestand (int bestand) {
        if (bestand < 0) {
            throw new IllegalArgumentException("Geben Sie eine Zahl hoeher als 0 ein!");
        }
    }

    /**
     * checkt ob artikel preis groesser ist als 0
     * @param preis preis des artikels
     */
    public static void checkPreis (double preis) {
        if (preis < 0.0) {
            throw new IllegalArgumentException("Geben Sie eine Zahl hoeher als 0 ein!");
        }
    }

    /**
     * preuft auf fehlerhafte eingabe bei artikelart
     * @param art Beschreibung des artikels
     */
    public static void checkArt (String art) {
        if(art.strip().isEmpty()) {
            throw new IllegalArgumentException("Geben Sie keine Leerzeichen ein!");
        }
    }

    /**
     * checkt ob Artikelnummer vierstellig ist
     * @param artikelNr nummer des artikels
     */
    public static void checkArtikelNr (int artikelNr) {
        if(String.valueOf(artikelNr).length() != 4 || artikelNr < 1000) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie eine positive vierstellige Zahl ein, " +
                    "die mit 1 anfaengt.");
        }
    }

    /**
     * checkt ob zugebuchte menge positiv ist
     * @param menge menge die zugebucht werden soll
     */
    public static void checkBucheZugang (int menge) {
        if (menge < 0){
            throw new IllegalArgumentException("Keine gültige Eingabe! Geben Sie einen positiven Wert ein.");
        }
    }

    /**
     * checkt ob menge die abgebucht wird posittiv ist und ob die differenz zwischen BEstand und Menge positiv bleibt
     * @param bestand aktuelle meneg die vorhanden ist
     * @param menge anzahl die abgebucht wird
     */
    public static void checkBucheAbgang (int bestand, int menge) {
        if (menge < 0 || (bestand- menge) < 0){
            throw new IllegalArgumentException("Keine gültige Eingabe! Die Differenz zwischen Bestand und Menge ist " +
                    "negativ.");
        }
    }

    /**
     * checkt ob das Lager leer ist
     * @param lager array mit objekten
     */
    public static void checkLagerLeer(Artikel[] lager) {
        int counter = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null ){
                counter++;
            }
        }
        if (counter == 0){
            throw new IllegalArgumentException("Das Lager ist leer. Legen Sie erst ein Artikel an!");
        }
    }

    /**
     * checkt ob ein Objekt schon im Lager vorhanden ist
     * @param artikelNr nummer des Artikels
     * @param artikel objekt
     */
    public static void checkAlreadyInLager(int artikelNr, Artikel[] artikel){
        for (int x = 0; x < artikel.length; x++) {
            if (artikel[x] != null && artikel[x].getArtikelNr() == artikelNr) {
                throw new IllegalArgumentException("Die Artikelnummer " + artikelNr + " ist bereits einem anderen\n" +
                        "zugeordnet worden.");
            }
        }
    }

    /**
     * checkt ob ein Objekt noch nicht Lager vorhanden ist
     * @param artikelNr nummer des artikels
     * @param artikel objekt
     */
    public static void checkIfNotAlreadyInLager(int artikelNr, Artikel[] artikel){
        for (int i = 0; i < artikel.length; i++) {
            if (artikel[i] != null && artikel[i].getArtikelNr() == artikelNr) {
                return;
            }
        } throw new IllegalArgumentException("Die Artikelnummer " + artikelNr + " wurde keinem Artikel zugeordnet");
    }

    /**
     * checkt ob das Lager voll ist
     * @param lager arraay mit objekten
     */
    public static void checkObLagerVoll(Artikel[] lager) {
        int anzahl = 0;
        for (int x = 0; x < lager.length; x++) {
            if (lager[x] != null ){
                anzahl += 1;
            }
        }
        if (anzahl == lager.length) {
            throw new IllegalArgumentException("Das Lager ist voll. Loeschen Sie erst ein Artikel!");
        }
    }

    /**
     * checkt ob der die Grenze des Arrays erreicht ist
     * @param index position im Array
     * @param laenge laenge des Arrays
     */
    public static void checkRangeOfIndex(int index, int laenge) {
        if (index < 0 || index >= laenge) {
            throw new IllegalArgumentException("Die Groesse des Lagers wird überschritten" + "\n"
                    + " Er muss zwischen 0 und " + (laenge - 1) + " liegen.");
        }
    }

    /**
     * checkt ob der Index null ist
     * @param lager array mit objekten
     * @param index position im array
     */
    public static void checkNullIndex(Artikel[] lager, int index) {
        if (lager[index] == null) {
            throw new IllegalArgumentException("An dieser Position ist kein Artikel");
        }
    }

    /**
     * checkt ob die ob das Lager mindestens ein objekt enthalten kann
     * @param anzahl groesse des objektes
     */
    public static void checkLagerGroesse(int anzahl) {
        if (anzahl < 1) {
            throw new IllegalArgumentException("Das Lager muss mindestens 1 Artikel enthalten muessen.");
        }
    }


}