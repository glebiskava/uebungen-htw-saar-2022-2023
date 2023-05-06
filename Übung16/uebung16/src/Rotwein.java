/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Rotwein-Klasse
 * diese Klasse erbt von Wein
 */


public class Rotwein extends Wein {

    /**
     * Standardkonstruktor
     */
    public Rotwein() {
        super();
    }

    /**
     * Konstruktor mit name, preis, alkoholgehalt und jahrgang
     * @param name name des Rotweins
     * @param preis preis des Rotweins
     * @param alkoholgehalt alkohogehalt des Rotweins
     * @param jahrgang jahrgang des Rotweins
     */
    public Rotwein(String name, double preis, double alkoholgehalt, int jahrgang) {
        super(name, preis, alkoholgehalt, jahrgang);
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        return super.toString() + ", Rotwein";
    }
}