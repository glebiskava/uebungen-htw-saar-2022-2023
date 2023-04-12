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
     * Getter für Bemerkung
     * @return bemerkung
     */
    public String getBemerkung() {
        return bemerkung;
    }

    /**
     * Setter für Bemerkung
     * @param bemerkung Bezeichnung für die Reservierung (z.B.: wer aht reserviert?)
     */
    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    /**
     * Getter für Begin
     * @return begin
     */
    public Uhrzeit getBegin() {
        return begin;
    }

    /**
     * Setter für Begin
     * @param begin Anfangszeit der Reservierung
     */
    public void setBegin(Uhrzeit begin) {
        this.begin = begin;
    }

    /**
     * Getter für Endzeit
     * @return ende
     */
    public Uhrzeit getEnde() {
        return ende;
    }

    /**
     * Setter für Endzeit
     * @param ende ende der Reservierung
     */
    public void setEnde(Uhrzeit ende) {
        this.ende = ende;
    }

    /**
     * Getter für Mitarbeiter
     * @return mitarbeiter
     */
    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    /**
     * Setter für Mitarbeiter
     * @param mitarbeiter mitarbeiter der einen Raum reserviert
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    /**
     * Getter für Raum
     * @return raum
     */
    public Raum getRaum() {
        return raum;
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
