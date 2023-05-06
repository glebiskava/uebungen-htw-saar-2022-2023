/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache abstrakte AlkoholfreiesGetraenk Klasse mit dem Attribut istGesund
 * diese Klasse erbt von Getraenk
 */

public abstract class AlkoholfreiesGetraenk extends Getraenk {

    /**
     * Attribut: istGesund --> ist das AlkoholfreieGetraenk gesund oder nicht
     */
    private boolean istGesund;

    /**
     * Standardkonstruktor
     */
    public AlkoholfreiesGetraenk() {
        super();
        this.istGesund = false;
    }

    /**
     * Konstruktor mit name, preis und istGesund
     * @param name name des AlkoholfreiesGetraenk
     * @param preis preis AlkoholfreiesGetraenk
     * @param istGesund ist es gesund ja oder nein
     */
    public AlkoholfreiesGetraenk(String name, double preis, boolean istGesund) {
        super(name, preis);
        this.istGesund = istGesund;
    }

    /**
     * Getter für istGesund
     * @return istGesund
     */
    public boolean getIstGesund() {
        return istGesund;
    }

    /**
     * Setter für istGesund
     * @param istGesund ist es gesund ja oder nein
     */
    public void setIstGesund(boolean istGesund) {
        this.istGesund = istGesund;
    }

    /**
     * to-String Methode gibt AlkoholfreiesGetraenk als String zurück
     * @return AlkoholfreiesGetraenk als String
     */
    @Override
    public String toString() {
        String gesund = istGesund ? "gesund" : "ungesund";
        return super.toString() + ", " + gesund;
    }
}