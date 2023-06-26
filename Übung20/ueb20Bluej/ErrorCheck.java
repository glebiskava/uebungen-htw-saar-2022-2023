import java.util.Map;

public class ErrorCheck {


    /**
     * preuft auf fehlerhafte eingabe bei artikelart
     * @param art Beschreibung des artikels
     */
    public static void checkArt (String art) {
        if(art.isBlank()) {
            throw new IllegalArgumentException("Geben Sie keine Leerzeichen ein!");
        }
    }

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
        if (bestand < 1) {
            throw new IllegalArgumentException("Geben Sie eine Zahl hoeher als 0 ein!");
        }
    }

    /**
     * checkt ob artikel preis groesser ist als 0
     * @param preis preis des artikels
     */
    public static void checkPreis (double preis) {
        if (preis <= 0.0) {
            throw new IllegalArgumentException("Geben Sie eine Zahl hoeher als 0 ein!");
        }
    }

    /**
     * checkt ob Artikelnummer vierstellig ist
     * @param artikelNr nummer des artikels
     */
    public static void checkArtikelNr (int artikelNr) {
        if(String.valueOf(artikelNr).length() != 4 || artikelNr < 1000) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie eine positive vierstellige Zahl ein, "
                    + "die mit 1 anfaengt.");
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
     * checkt, ob menge die abgebucht wird positiv ist und ob die differenz zwischen Bestand und Menge positiv bleibt
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
     * checkt, ob das Lager leer ist
     * @param lager array mit objekten
     */
    public static void checkLagerLeer(Lager lager) {
        Map<Integer, Artikel> map = lager.getArtikelMap();  
        if (map.size() == 0){
            throw new IllegalArgumentException("Das Lager ist leer. Legen Sie erst ein Artikel an!");
        }
    }

    /**
     * checkt, ob ein Objekt schon im Lager vorhanden ist
     * @param artikelMap
     * 
     */
    public static void checkAlreadyInLager(Map<Integer, Artikel> artikelMap, Artikel artikel) {
        if (artikelMap.get(artikel.getArtikelNr()) != null) {
            throw new IllegalArgumentException("Ein artikel mit dieser nummer existiert schon");
        }
    }

    /**
     * checkt, ob ein Objekt noch nicht Lager vorhanden ist
     * @param artikelNr nummer des artikels
     * @param artikel objekt
     */
    public static void checkIfNotAlreadyInLager(Map<Integer, Artikel> artikelMap, int artikelNr){
        if (artikelMap.get(artikelNr) == null) {
            throw new IllegalArgumentException("Ein artikel mit dieser nummer existiert nicht");
        }
    }


    /**
     * checkt, ob der Index null ist
     * @param lager array mit objekten
     * @param index position im array
     */
    public static void checkNullIndex(Map<Integer, Artikel> artikelMap, Artikel artikel) {
        if (artikelMap.get(artikel.getArtikelNr()) == null) {
            throw new IllegalArgumentException("An dieser Position ist kein Artikel");
        }
    }

    /**
     * checkt ob es schon ein lager gibt
     * @param lager array mit objekten
     */
    public static void checkSchonLager(Lager lager){
        if(lager != null) {
            throw new IllegalArgumentException("Es existiert schon ein Lager. Nutzen Sie es!");
        }
    }

    /**
     * checkt ob noch kein lager existiert
     * @param lager array mit obj
     */
    public static void checkLagerExistiert(Lager lager){
        if(lager == null) {
            throw new IllegalArgumentException("Es existiert noch kein Lager. Legen Sie eins an!");
        }
    }
    /**
     * checkt, ob das String Leer ist
     * @param string string
     */
    public static void checkStringNichtLeer(String string){
        if(string.isBlank()) {
            throw new IllegalArgumentException("Der String ist leer, geben Sie einen Wert an");
        }
    }

    /**
     * checkt ob wert groesser als null ist
     * @param zahl wert der uebergeben wird
     */
    public static void checkGroesserAlsNull(int zahl){
        if(zahl <= 0) {
            throw new IllegalArgumentException("Der Zahl, muss Groesser als 0 sein");
        }
    }

    /**
     * checkt ob jahr zwischen 1900 und 2022 liegt
     * @param zahl wert der uebergeben wird
     */
    public static void checkZwischen1900und2022(int zahl){
        if(1900 > zahl || zahl > 2022) {
            throw new IllegalArgumentException("Der Zahl, muss Groesser als 1900 und Kleiner als 2022 sein");
        }
    }
    
    //check fuer ueb18
    /**
     * checkt ob (sonderangebot) schon in art addiert wurde oder nicht
     * @param zahl wert der uebergeben wird
     */
    public static void checkSonderangebot(String art){
        if(art.contains("(Sonderangebot)")) {
            throw new IllegalArgumentException("Sonderangebot ist schon in das Art addiert worden");
        }
    }
    
}