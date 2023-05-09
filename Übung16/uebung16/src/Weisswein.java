/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Weisswein-Klasse mit dem Attribut kaltgestellt
 * diese Klasse erbt von Wein
 */


public class Weisswein extends Wein {

    /**
     * Attribut kaltgestellt: ob wein kaltgestellt ist oder nicht
     */
    private boolean kaltGestellt;

    /**
     * Standardkonstruktor
     */
    public Weisswein() {
        super();
        this.kaltGestellt = false;
    }

    /**
     * Konstruktor mit name, preis, alkoholgehalt jahrgang, kaltgestellt
     * @param name name des Weissweins
     * @param preis preis des weissweins
     * @param alkoholgehalt alkoholgehalt des weissweins
     * @param jahrgang jahrgang des weissweins
     * @param kaltGestellt kaltgestellt ja oder nein
     */
    public Weisswein(String name, double preis, double alkoholgehalt, int jahrgang, boolean kaltGestellt) {
        super(name, preis, alkoholgehalt, jahrgang);
        this.kaltGestellt = kaltGestellt;
    }

    /**
     * Getter für istkaltgestellt
     * @return istkaltgestellt
     */
    public boolean getIstKaltGestellt() {
        return kaltGestellt;
    }

    /**
     * Setter für istKaltgestellt
     * @param kaltGestellt ja oder nein
     */
    public void setKaltGestellt(boolean kaltGestellt) {
        this.kaltGestellt = kaltGestellt;
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        return super.toString() + ", Weisswein, Kalt gestellt: " + kaltGestellt;
    }
}