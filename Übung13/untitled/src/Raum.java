import java.util.ArrayList;

public class Raum {

    /**
     * Attribute für Raum entnommen aus dem UML-Diagramm
     */
    private int geb;
    private int etage;
    private int raum;

    /**
     * erstellen einer Arraylist, um alle Reservierungen zu speichern
     */
    private ArrayList<Reservierung> reservierungen;

    /**
     * Konstruktor für Raum
     * @param geb Gebaeude in dem der Raum ist
     * @param etage Etage auf, der der Raum ist
     * @param raum welcher Raum gebucht werden soll
     */
    public Raum(int geb, int etage, int raum) {
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
    }

    /**
     * Methode die eine Reservierung in einer ArrayListe speichert
     * @param reservierung Reservierung die gespeichert werden soll
     */
    public void addReservierung(Reservierung reservierung) {
        this.reservierungen.add(reservierung);
    }

    /**
     * ToString Methode die einen erstellten Raum als String aufbereitet zurückgibt
     * @return Raum als String
     */
    @Override
    public String toString() {
        String s = "Raum " + geb + "-" + etage + "." + raum + "\n";
        for (Reservierung r : reservierungen) {
            s += r.toString() + "\n";
        }
        return s;
    }
}
