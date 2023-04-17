/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine einfache Reservierungsklasse mit den Attributen begin, ende, bemerkung
 */
public class Reservierung {

    /**
     * Attribute für die Klasse Bemerkung entnommen aus dem UML-Diagramm
     */
    private String bemerkung;
    private Uhrzeit begin;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    private Raum raum;

    /**
     * Konstruktor für Reservierung, erstellt eine Reservierung mit Beginnzeit und Endzeit
     * @param begin anfangszeit der Reservierung
     * @param ende Endzeit der Reservierung
     */
    public Reservierung(Uhrzeit begin, Uhrzeit ende) {

        this.begin = begin;
        this.ende = ende;
    }

    /**
     * Setter für Bemerkung
     * @param bemerkung Bezeichnung für die Reservierung (z.B.: wer aht reserviert?)
     */
    public void setBemerkung(String bemerkung) {
        ErrorCheck.checkEingabeLeer(bemerkung);
        this.bemerkung = bemerkung;
    }

    /**
     * Setter für Mitarbeiter
     * @param mitarbeiter mitarbeiter der einen Raum reserviert
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    /**
     * Setter für Raum
     * @param raum raum der reserviert wird
     */
    public void setRaum(Raum raum) {

        this.raum = raum;
        raum.addReservierung(this);
    }

    /**
     * ToString Methode, die die Reservierung als String aufbereitet zurückgibt
     * @return wer welchen Raum wann reserviert hat
     */
    @Override
    public String toString() {
        return "gebucht von " + mitarbeiter.toString()
                + " von " + begin.toString()
                + " bis " + ende.toString()
                + " für " + bemerkung;
    }
}
