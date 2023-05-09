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
    private ArrayList<Flasche<? extends Getraenk>> flaschenlager;

    /**
     * Attribut kapazitaet des Getraenkeautomats
     */
    private final int kapazitaet;

    /**
     * Konstruktor mit kapazitaet
     * @param kapazitaet kapazitaet des Getraenkeautomats
     */
    public Getraenkeautomat(int kapazitaet) {
        ErrorCheck.checkIntegerEmpty(kapazitaet);
        this.flaschenlager = new ArrayList<>();
        this.kapazitaet = kapazitaet;
    }

    /**
     * Methode zum Einlegen der Flaschen
     * @param flasche falsche die eingelegt werden soll
     */
    public void flascheEinlegen(Flasche<? extends Getraenk> flasche) {
        if (flaschenlager.size() > kapazitaet && !flasche.istVoll()) {
            System.out.println("Der Automat ist voll. Geben Sie eine Flasche aus oder legen Sie einen neuen an!");
        } else {
            flaschenlager.add(flasche);
        }
    }

    /**
     * methode zum Ausgeben der Flasche
     * @return flasche die ausgegeben wird
     */
    public Flasche<? extends Getraenk> flascheAusgeben() {
        if (flaschenlager.size() == 0) {
            System.out.println("Es gibt noch keinen Flaschen. Legen Sie erst einen an!");
        }
        return flaschenlager.remove(0);
    }

    /**
     * Methode gibt objekt als String zurück
     * @return objekt als String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // if (flaschenlager.isEmpty()) {
        //     System.out.println("Es gibt noch keinen Flaschen. Legen Sie erst einen an!");
        // } else {
        // sb.append("Getraenkeautomat:\n");
        for (Flasche<? extends Getraenk> flasche : flaschenlager) {
            sb.append(flasche.toString());
            sb.append("\n");
        }
        // }
        return sb.toString();
    }

}