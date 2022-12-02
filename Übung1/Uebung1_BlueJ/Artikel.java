/**
 * Dies ist eine Klasse Artikel für eine einfache Bestandsführung
 * @author Leopold Mittelberger, Elisee Brand
 */
public class Artikel {

    /**
     * Attribute
     * @param artikelNr 
     * @param Art Beschreibung des Objektes
     * @param bestand Artikelbestand in Stück
     */ 
    private int artikelNr;
    private String art;
    private int bestand;


    /** 
     * Konstruktoren
     * erster Konstruktor für Artikel(artikelNr, art und Bestand)
     */
    public Artikel(int artikelNr, String art, int bestand) {
        this.artikelNr = artikelNr;
        this.art = art;
        this.bestand = bestand;
    }

    /**
     * weiter Konstruktor für Artikel(artikelNr und art)
     */
    public Artikel(int artikelNr, String art) {
        this(artikelNr, art, 0);
    }

    /**
     * Der Standardkonstruktor ist der automatisch generierte Konstruktor ohne
     * Argumente, es sei denn, Sie definieren einen anderen Konstruktor.
     * Alle nicht initialisierten Felder werden auf ihre Standardwerte gesetz und da schon
     * ein dritter Konstruktor "Artikel(int artikelNr, String art, int bestand)"
     * existiert, wäre es unnötig einen Standardkonstruktor zu erstellen, da ein
     * erster Konstruktor mit allen Attributen der Klasse Artikel
     * schon existiert
     * Quelle: https://www.viresist.org/java-tutorials/java-standardkonstruktor/
     */


    /**
     * Methoden
     * erhoeht den Bestand um bestimmte menge
     * @param menge Menge die dazu gebucht werden soll
     */
    public void bucheZugang(int menge) {

        bestand += menge;
    }

    /**
     * vermindert den Bestand um bestimmte menge
     * @param menge Menge die abgebucht werden soll
     */
    public void bucheAbgang(int menge) {

        bestand -= menge;
    }

    /**
     * gibt Objekt als String aus
     */
    @Override
    public String toString() {
        String stringOutput = "Artikel: " + artikelNr +
                ", Art: " + art +
                ", Bestand: " + bestand;

        return stringOutput;
    }


    //Setter für jedes Attribut
    /**
     * Setter hier noetig, falls in einem Handel Inventur geführt wird falls ein
     * etwas gekalut wird zum Beispiel
     */
    public void setBestand(int bestand) {

        this.bestand = bestand;
    }

    /**
     * Setter für Art ist hier noetig, da sich die Art eines 
     * Artikels nicht aendert
     */

    public void setArt(String art) {

        this.art = art;
    }
    /**
     * Getter für jedes Attribut
     */
    public int getArtikelNr() {

        return artikelNr;
    }

    public String getArt() {

        return art;
    }

    public int getBestand() {

        return bestand;
    }
}

