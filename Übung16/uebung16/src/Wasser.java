/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Wasserklasse mit dem Attribut marke
 * diese Klasse erbt von AlkoholfreiesGetraenk
 */

public class Wasser extends AlkoholfreiesGetraenk {

    /**
     * Attribut Marke der Flasche
     */
    private String marke;

    /**
     * Standardkonstruktor
     */
    public Wasser() {
        super();
    }

    /**
     * Konstruktor mit name, preis, istGesund und marke
     * @param name name vom Wasser
     * @param preis preis des Wassers
     * @param istGesund ist es gesund?
     * @param marke marke des Wassers
     */
    public Wasser(String name, int preis, boolean istGesund, String marke) {
        super(name, preis, istGesund);
        this.marke = marke;
    }

    /**
     * Getter für Marke
     * @return marke des Wassers
     */
    public String getMarke() {
        return marke;
    }

    /**
     * Setter für marke
     * @param marke marke des Wassers
     */
    public void setQuelle(String marke) {
        this.marke = marke;
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        return super.toString() + ", Marke: " + marke;
    }
}