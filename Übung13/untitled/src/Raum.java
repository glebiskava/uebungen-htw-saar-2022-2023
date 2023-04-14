import java.util.ArrayList;

public class Raum {

    /**
     * Attribute für Raum entnommen aus dem UML-Diagramm
     */
    private int geb;
    private int etage;
    private int raum;
    private int anzahlReservierungen;

    /**
     * Konstante GEBAEUDEGROESSE für eine fixe groesse des arrays
     */

    private static final int GEBAEUDEGROESSE = 10;

    /**
     * erstellen eines Array, um alle Reservierungen zu speichern
     */
    private Reservierung[] reservierungen = new Reservierung[GEBAEUDEGROESSE];

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
     * Methode die eine Reservierung im Array reservierugnen speichert und die anzahl an reservierungen um 1 erhoeht
     * bevor eine reservierung zusaetzlich hinzugefuegt wird, wird der Index (anzahlReservierungen) erhoeht, sodass
     * die vorherige Reservierung nicht überschrieben wird
     * @param reservierung Reservierung die gespeichert werden soll
     */
    public void addReservierung(Reservierung reservierung) {
        reservierungen[anzahlReservierungen++] = reservierung;
    }

    /**
     * ToString Methode die einen erstellten Raum als String aufbereitet zurückgibt
     * @return Raum als String
     */
    @Override
    public String toString() {
        String result = "Raum " + this.geb + "-" + this.etage + "." + this.raum + "\n";
        for (int i = 0; i < anzahlReservierungen; i++) {
            result += reservierungen[i].toString() + "\n";
        }
        return result;
    }
}
