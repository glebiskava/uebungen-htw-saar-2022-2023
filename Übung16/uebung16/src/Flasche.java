/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Flaschen-Klasse
 * diese Klasse hat eine generischen typparameter welcher von Getraenk für erbt
 */

public class Flasche<T extends Getraenk> {

    /**
     * Attribute: inhalt und voll
     */
    private T inhalt;
    private boolean voll;

    /**
     * Standardkonstruktor
     */
    public Flasche() {
        this.voll = false;
    }

    /**
     * Getter für Inhalt
     * @return Inhalt des Getraenks
     */
    public T getInhalt() {
        return inhalt;
    }

    /**
     * methode zum Füllen der Flaschen
     * @param inhalt inhalt der flasche
     */
    public void fuellen(T inhalt) {
        this.inhalt = inhalt;
        this.voll = true;
    }

    /**
     * Methode zum Leeren der Flasche
     */
    public void leeren() {
        this.inhalt = null;
        this.voll = false;
    }

    /**
     * methode zum Sagen ob Flasche voll ist oder nicht
     * @return istvoll
     */
    public boolean istVoll() {
        return voll;
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        if (voll) {
            return inhalt.toString() + " Flasche";
        } else {
            return "Leere Flasche";
        }
    }
}
