/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Softdrinkklasse mit dem Attribut marke
 * diese Klasse erbt von AlkoholfreiesGetraenk
 */

public class Softdrink extends AlkoholfreiesGetraenk {

    /**
     * Attribut geschmack des Softdrinks
     */
    private String geschmack;

    /**
     * Standardkonstruktor
     */
    public Softdrink() {
        this.geschmack = "unbekannt";
    }

    /**
     * Konstruktor mit name, preis, IstGesund und geschmack
     * @param name name des Softdrinks
     * @param preis preis des Softdrinks
     * @param istGesund ist der Softdrink gesund?
     * @param geschmack geschmack des Softdrinks
     */
    public Softdrink(String name, double preis, boolean istGesund, String geschmack) {
        super(name, preis, istGesund);
        this.geschmack = geschmack;
    }

    /**
     * Getter für geschmack
     * @return geschmack
     */
    public String getGeschmack() {
        return geschmack;
    }

    /**
     * Setter für Geschmack
     * @param geschmack geschmack des Softdrinks
     */
    public void setGeschmack(String geschmack) {
        this.geschmack = geschmack;
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        return super.toString() + ", Geschmack: " + geschmack;
    }
}