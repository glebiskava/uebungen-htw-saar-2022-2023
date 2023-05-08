/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Wein-Klasse
 * diese Klasse erbt von AlkoholischesGetraenk
 */


public  class Wein extends AlkoholischesGetraenk {

    /**
     * Attribut jahrgang für jahrgang des Weins
     */
    private int jahrgang;

    /**
     * Standardkonstruktor
     */
    public Wein() {
        super();
    }

    /**
     * Konstruktor mit name, preis, alkoholgehalt und jahrgang
     * @param name name des weins
     * @param preis preis des weins
     * @param alkoholgehalt alkoholgehalt des weins
     * @param jahrgang jahrgang des Weins
     */
    public Wein(String name, double preis, double alkoholgehalt, int jahrgang) {
        super(name, preis, alkoholgehalt);
        this.jahrgang = jahrgang;
    }

    /**
     * Getter für Jahrgang
     * @return jahrgang
     */
    public int getJahrgang() {
        return jahrgang;
    }

    /**
     * Setter für Jahrgang
     * @param jahrgang jahrgang des weins
     */
    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        return super.toString() + ", Rebsorte: " + ", Jahrgang: " + jahrgang;
    }
}