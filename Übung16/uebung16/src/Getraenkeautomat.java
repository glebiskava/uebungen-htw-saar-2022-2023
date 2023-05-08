import java.util.ArrayList;

/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Getraenkeautomat-Klasse mit den Attributen kapazitaet und flaschenlager
 * diese Klasse hat den geenerischen Typparameter T welcher von Getraenk erbt
 */


public class Getraenkeautomat<T extends Getraenk> {

    /**
     * Arraylist erstellen für das Flaschenlager
     */
    private ArrayList<Flasche<T>> flaschenlager;

    /**
     * Attribut kapazitaet des Getraenkeautomats
     */
    private final int kapazitaet;

    /**
     * Konstruktor mit kapazitaet
     * @param kapazitaet kapazitaet des Getraenkeautomats
     */
    public Getraenkeautomat(int kapazitaet) {
        if (kapazitaet <= 0) {
            throw new IllegalArgumentException("Die Kapazität muss größer als Null sein!");
        }
        this.flaschenlager = new ArrayList<>();
        this.kapazitaet = kapazitaet;
    }

    /**
     * Methode zum Einlegen der Flaschen
     * @param flasche falsche die eingelegt werden soll
     */
    public void flascheEinlegen(Flasche<T> flasche) {
        if (flaschenlager.size() < kapazitaet && flasche.istVoll()) {
            flaschenlager.add(flasche);
        }
    }

    /**
     * methode zum Ausgeben der Flasche
     * @return flasche die ausgegeben wird
     */
    public Flasche<T> flascheAusgeben() {
        if (flaschenlager.isEmpty()) {
            return null;
        }
        Flasche<T> flasche = flaschenlager.remove(0);
        flasche.leeren();
        return flasche;
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Getraenkeautomat:\n");
        for (Flasche<T> flasche : flaschenlager) {
            sb.append(flasche.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
