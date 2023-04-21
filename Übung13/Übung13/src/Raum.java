import java.util.ArrayList;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine einfache Raumklasse mit den Attributen gebaeude, etage und raum.
 * Jeder Raumm hat eine bestimmt Anzahl an Reservierungen
 */
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

    private static final int GEBAEUDEGROESSE = 50;

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
        ErrorCheck.checkNegativeZahl(geb);
        ErrorCheck.checkNegativeZahl(etage);
        ErrorCheck.checkNegativeZahl(raum);

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
     * gibt die reservierungen an einer bestimmten Stelle im Array zurueck
     * @param index
     * @return
     */
    public Reservierung getReservierung(int index) {
        ErrorCheck.indexUngueltig(index);

        return reservierungen[index];
    }

    /**
     * Getter fuer Gebaeude
     * @return gebaeude nummer
     */
    /*public int getGeb() {
        return geb;
    }*/

    /**
     * Getter fuer etage
     * @return etagen nummer
     */
    /*public int getEtage() {
        return etage;
    }*/

    /**
     * Getter fuer Raum
     * @return raum nummer
     */
    /*public int getRaum() {
        return raum;
    }*/

    /**
     * ToString Methode die einen erstellten Raum als String aufbereitet zurückgibt
     * @return Raum als String
     */
    @Override
    public String toString() {

        String result = "Raum " + this.geb + "-" + this.etage + "." + this.raum + "\n";
        for (int i = 0; i < anzahlReservierungen; i++) {
            if (reservierungen[i] != null) {
                result += reservierungen[i].toString() + "\n";
            }
        }
        return result;
    }
}
