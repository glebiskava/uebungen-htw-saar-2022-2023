/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine einfache Mitarbeiterklasse mit dem Attribute Emial und Vorname und Nachname werden
 * von der Klasse Person geerbt
 */
public class Mitarbeiter extends Person {

    /**
     * Attribute für Mitarbeiter entnommen aus UML-Diagramm
     */
    private String email;

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

        Reservierung reservierung = new Reservierung(begin, ende);
        reservierung.setMitarbeiter(this);
        reservierung.setRaum(raum);
        reservierung.setBemerkung(bemerkung);
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