package aufgabe1;

import java.util.Objects;

/**
 * Dies ist eine Klasse Artikel fuer eine einfache Bestandsfuehrung
 * @author Leopold Mittelberger, Elisee Brand
 * @version 2
 */

public class Artikel {
    /** Attribute */
    private int artikelNr;
    private String art;
    private int bestand;
    private double preis;


    private static final int BESTAND_DEFAULT   = 0;
    private static final int PREIS_DEFAULT     = 0;


    /** Konstruktoren
     * erster Konstruktor fuer Artikel(artikelNr, art und Bestand)
     * Aufruf der Funktion zum Pruefen der Eingaben beim Anlegen eines Objektes
     * @param artikelNr Nummer des Artikels
     * @param art Beschreibung des Artikels
     * @param bestand Anzahl der Artikel
     */
    public Artikel(int artikelNr, String art, int bestand, double preis) {
        ErrorCheck.checkBestand(bestand);
        ErrorCheck.checkPreis(preis);
        setArtikelNr(artikelNr);
        setArt(art);
        setBestand(bestand);
        setPreis(preis);
    }

    /**
     * weiter Konstruktor für Artikel(artikelNr und art)
     */
    public Artikel(int artikelNr, String art) {
        this(artikelNr, art, BESTAND_DEFAULT, PREIS_DEFAULT);
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
        return "Artikel: " + artikelNr +
                ", Art: " + art +
                ", Bestand: " + bestand +
                ", Preis: " + preis;
    }

    /**
     * Setter für jedes Attribut
     * Setter hier noetig, falls in einem Handel Inventur geführt wird, falls ein
     * etwas geklaut wird, zum Beispiel
     * Bestand darf nicht negativ sein
     * 
     * 
     * Setter für ArtikelNr soll 4stelluge sein
     * @param ArtikelNr numùmer des Artikels
     */
    public void setArtikelNr(int artikelNr) {
        ErrorCheck.checkArtikelNr(artikelNr);
        this.artikelNr = artikelNr;
    }

     /**
     * Setter für Bestand
     * @param bestand Anzahl der Artikel
     */
    public void setBestand(int bestand) {
        ErrorCheck.checkGroesserAlsNull(bestand);
        ErrorCheck.checkBestand(bestand);
        this.bestand = bestand;
    }

    /**
     * Setter für Preis
     * @param preis Preis des Artikels
     */
    public void setPreis(double preis) {
        ErrorCheck.checkPreis(preis);
        this.preis = preis;
    }

    /**
     * Setter für Art
     * @param art Beschreibung des Artikels
     */
    public void setArt(String art) {
        ErrorCheck.checkArt(art);
        this.art = art;
    }

    /**Getter fuer jedes Attribut*/
    /**
     * Getter für ArtikelNr
     * @return ArtikelNr Nummer des Artikels
     */
    public int getArtikelNr() {

        return artikelNr;
    }

    /**
     * Getter für Art
     * @return Art Beschreibung des Artikels
     */
    public String getArt() {

        return art;
    }

    /**
     * Getter für Bestand
     * @return Bestand Anzahl der Artikel
     */
    public int getBestand() {

        return bestand;
    }

    /**
     * Getter für Preis
     * @return Preis Preis des Artikels
     */
    public double getPreis(){

        return preis;
    }

    /**
     * Diese Methode vergleicht
     * @param object The object to be compared with
     * @return boolean true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (!(object instanceof Artikel artikel)) {
            return false;
        }
        return artikelNr == artikel.artikelNr &&
                bestand == artikel.bestand &&
                Double.compare(artikel.preis, preis) == 0 &&
                Objects.equals(art, artikel.art);
    }

    /**
     * This method is used to generate a unique hash code for the object
     * @return int The hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(artikelNr, art, bestand, preis);
    }


}