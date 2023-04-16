public class Mitarbeiter extends Person {
    private Reservierung reservierung;
    /**
     * Attribute für Mitarbeiter entnommen aus UML-Diagramm
     */
    private String email;
    public Object Reservierung;

    /**
     * Konstruktor für Mitarbeiter
     * @param vorname vorname des Mitarbeiters
     * @param nachname Nachnamen des Mitarbeiters
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
     * @param ende Ende der reservierung
     * @param bemerkung bemerkung (wer hat reserviert?)
     */
    public void reserviere(Raum raum, Uhrzeit begin, Uhrzeit ende, String bemerkung) {
        reservierung = new Reservierung(begin, ende);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        reservierung.setBemerkung(bemerkung);
    }

    /**
     * Getter für E-Mail
     * @return E-Mail des Mitarbeiters
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter für E-Mail
     * @param email welche E-Mail soll gesetzt werden
     */
    public void setEmail(String email) {
        this.email = email;
    }


    public Reservierung getReservierung(){
        return reservierung;
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