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
        setArtikelNr(artikelNr);
        setArt(art);
        setBestand(bestand);
        setPreis(preis);
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
        ErrorCheck.checkBucheZugang(menge);
        bestand += menge;
    }

    /**
     * Vermindert den Bestand um bestimmte Menge.
     * Menge darf aber nicht groeßer sein als der aktuelle Bestand.
     * @param menge Menge die abgebucht werden soll
     */
    public void bucheAbgang(int menge) {
        ErrorCheck.checkBucheAbgang(bestand, menge);
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
    public void setArtikelNr(int artikelNr) {
        ErrorCheck.checkArtikelNr(artikelNr);
        this.artikelNr = artikelNr;
    }

    public void setBestand(int bestand) {
        ErrorCheck.checkBestand(bestand);
        this.bestand = bestand;
    }

    public void setPreis(double preis) {
        ErrorCheck.checkPreis(preis);
        this.preis = preis;
    }

    public void setArt(String art) {
        ErrorCheck.checkArt(art);
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


}