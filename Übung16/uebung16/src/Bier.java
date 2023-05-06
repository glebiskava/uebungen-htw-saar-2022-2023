/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Bier-Klasse
 * diese Klasse erbt von AlkoholischesGetraenk
 */

public class Bier extends AlkoholischesGetraenk {

    /**
     * Standardkonstruktor
     */
    public Bier() {
        super();
    }

    /**
     * Konstruktor mit name, preis, alkoholgehalt
     * @param name name des Biers
     * @param preis preis des Biers
     * @param alkoholgehalt alkoholgehalt des Biers
     */
    public Bier(String name, double preis, double alkoholgehalt) {
        super(name, preis, alkoholgehalt);
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        return super.toString() + ", Bier";
    }
}