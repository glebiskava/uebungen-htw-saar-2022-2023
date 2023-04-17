/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine einfache Personenklasse mit den Attributen Vorname und Nachname
 */
public class Person {

    /**
     * Attribute für Person entnommen aus dem UML-Diagramm
     */
    private String vorname;
    private String nachname;

    /**
     * Konstruktor für Person
     * @param vorname vorname der Person
     * @param nachname nachname der Person
     */
    public Person(String vorname, String nachname) {

        this.vorname = vorname;
        this.nachname = nachname;
    }

    /**
     * Methode gibt Person als String aufbereitet zurück
     * @return Person als String
     */
    @Override
    public String toString() {

        return vorname + " " + nachname;
    }
}
