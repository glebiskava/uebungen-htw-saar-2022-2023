/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache abstrakte AlkoholischesGetraenk Klasse mit dem Attribut alkoholgehalt
 * diese Klasse erbt von Getraenk
 */

public abstract class AlkoholischesGetraenk extends Getraenk {

    /**
     * Attribut alkoholgehalt für gehalt des Alkohols im Getraenk
     */
    private double alkoholgehalt;

    /**
     * Standardkonstruktor
     */
    public AlkoholischesGetraenk() {
        super();
        this.alkoholgehalt = 0.0;
    }

    /**
     * Konstruktor mit name, preis, alkoholgehalt
     * @param name name des AlkoholischesGetraenk
     * @param preis preis des AlkoholischesGetraenk
     * @param alkoholgehalt alkoholgehalt des AlkoholischesGetraenk
     */
    public AlkoholischesGetraenk(String name, double preis, double alkoholgehalt) {
        super(name, preis);
        this.alkoholgehalt = alkoholgehalt;
    }

    /**
     * Getter für alkoholgehalt
     * @return alkoholgehalt
     */
    public double getAlkoholgehalt() {
        return alkoholgehalt;
    }

    /**
     * Setter für Alkoholgehalt
     * @param alkoholgehalt alkoholgehalts des AlkoholischesGetraenk
     */
    public void setAlkoholgehalt(double alkoholgehalt) {
        this.alkoholgehalt = alkoholgehalt;
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        return super.toString() + ", Alkoholgehalt: " + alkoholgehalt + " %";
    }
}