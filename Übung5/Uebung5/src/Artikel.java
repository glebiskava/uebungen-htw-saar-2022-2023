/**
 * Dies ist eine Klasse Artikel fuer eine einfache Bestandsfuehrung
 * @author Leopold Mittelberger, Elisee Brand
 * @version 2
 */

public class Artikel {

    /**
     * @param artikelNr Nummer des Artikels
     * @param art Beschreibung des Artikels
     * @param bestand Anzahl der Artikel
     */
    public int artikelNr;
    private String art;
    private int bestand;
    private double preis;


    /** Konstruktoren
     * erster Konstruktor fuer Artikel(artikelNr, art und Bestand)
     * Aufruf der Funktion zum Pruefen der Eingaben beim Anlegen eines Objektes
     */
    public Artikel(int artikelNr, String art, int bestand, double preis) {
        checkArtikelAttribute(artikelNr, art, bestand, preis);
    }

    /**
     * weiter Konstruktor für Artikel(artikelNr und art)
     */
    public Artikel(int artikelNr, String art) {
        this(artikelNr, art, 0, 0);
    }

    /**
     * Methoden
     * Erhoeht den Bestand um bestimmte Menge.
     * Menge darf aber nicht negativ sein.
     * @param menge Menge die dazu gebucht werden soll
     */
    public void bucheZugang(int menge) {
        if (menge < 0){
            throw new IllegalArgumentException("Keine gültige Eingabe! Geben Sie einen positiven Wert ein.");
        }
        bestand += menge;
    }

    /**
     * Vermindert den Bestand um bestimmte Menge.
     * Menge darf aber nicht groeßer sein als der aktuelle Bestand.
     * @param menge Menge die abgebucht werden soll
     */
    public void bucheAbgang(int menge) {
        if (menge < 0 || (bestand - menge) < 0){
            throw new IllegalArgumentException("Keine gültige Eingabe! Die Differenz zwischen Bestand und Menge ist " +
                    "negativ.");
        }
        bestand -= menge;
    }

    /**
     * gibt ein Objekt als String aus
     */
    @Override
    public String toString() {
        String stringOutput = "Artikel: " + artikelNr +
                ", Art: " + art +
                ", Bestand: " + bestand +
                ", Preis: " + preis;
        return stringOutput;
    }

    /**
     * Setter für jedes Attribut
     * Setter hier noetig, falls in einem Handel Inventur geführt wird, falls ein
     * etwas geklaut wird, zum Beispiel
     * Bestand darf nicht negativ sein
     */

    public void setBestand(int bestand) {
        if(bestand < 0) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie einen positiven Wert ein.");
        }
        this.bestand = bestand;
    }
    public void setPreis(double preis) {
        if(preis < 0) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie einen positiven Wert ein.");
        }
        this.preis = preis;
    }

    /**
     * Setter fuer Art ist hier noetig, da es sich hier um eine Beschreibung handelt die geaendert werden kann.
     * Darf kein leerer String sein
     */

    public void setArt(String art) {
        if(art.strip().isEmpty()) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie eine Beschreibung ein.");
        }
        this.art = art;
    }
    /**Getter fuer jedes Attribut*/
    public int getArtikelNr() {
        return artikelNr;
    }

    public String getArt() {
        return art;
    }

    public int getBestand() {
        return bestand;
    }
    public double getPreis(){
        return preis;
    }

    /**
     * Diese Funktion prueft auf fehlerhafte Eingaben
     * @param artikelNr Nummer des Artikels, welche vierstellig sein muss und mit 1 anfangen muss sonst ist es nicht
     * moeglich eine vierstellige Zahl einzugeben
     * @param art Beschreibung des Artikels und darf auch Zahlen enthalten zum Beispiel: Apple Telefon, Art: IPhone 14
     * @param bestand Anzahl der Artikel muss groeßer als 0 sein
     */
    public void checkArtikelAttribute(int artikelNr, String art, int bestand, double preis) {
        if(String.valueOf(artikelNr).length() != 4 || artikelNr < 1000) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie eine positive vierstellige Zahl ein, " +
                    "die mit 1 anfaengt.");
        } else if(art.strip().isEmpty()) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie eine Beschreibung ein.");
        } else if (bestand < 0) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Geben Sie einen positiven Wert ein");
        }
        this.artikelNr = artikelNr;
        this.art = art;
        this.bestand = bestand;
        this.preis = preis;
    }
}
