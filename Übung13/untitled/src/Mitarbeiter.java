public class Mitarbeiter extends Person {

    /**
     * Attribute für Mitarbeiter entnommen aus UML-Diagramm
     */
    private String email;

    /**
     * Kosntruktor für Mitarbeiter
     * @param vorname vorname des Mitarbeiters
     * @param nachname Nacghnamen des Mitarbeiters
     * @param email E-Mail des Mitarbeiters
     */
    public Mitarbeiter(String vorname, String nachname, String email) {
        super(vorname, nachname);
        this.email = email;
    }

    /**
     * Methode zum Reservieren eines Raums
     * @param raum raum der reserviert werden soll
     * @param begin beginn der reservierung
     * @param ende ende der reservierung
     * @param bemerkung bemerkung (wer hat reserviert?)
     */
    public void reserviere(Raum raum, Uhrzeit begin, Uhrzeit ende, String bemerkung) {
        Reservierung reservierung = new Reservierung(begin, ende);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        reservierung.setBemerkung(bemerkung);
    }

    /**
     * Getter für Email
     * @return email des Mitarbeiters
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter für Email
     * @param email welche email soll gesetzt werden
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Methode die den Mitarbeiter als String zurückgibt
     * @return mitarbeiter als String
     */
    @Override
    public String toString() {
        return super.toString() + " (" + email + ")";
    }
}