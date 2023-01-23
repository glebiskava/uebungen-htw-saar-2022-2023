/**
 * Dies ist eine einfache Klasse zu einer Person mit den Attributen Vorname und Nachname
 * @author Elisee Brand, Leopold Mittelberger
 */

public class Person {

    /**
     * Attribute der Klasse Person
     * String vorname: Vorname der Person
     * String nachname: Nachname der Person
     */
    private String vorname;
    private String nachname;

    /**
     * Konstruktor fuer die Klasse Person
     * @param vorname vorname der Person
     * @param nachname Nachname der Person
     */
    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    /**
     * Setter fuer die Attribute der Klasse
     */
    public void setVorname(){
        //check
        this.vorname = vorname;
    }
    public void setNachname(){
        //check
        this.nachname = nachname;
    }

    /**
     * Getter fuer die Attribute der Klasse
     * @return vorname
     * @return nachname
     */
    public String getVorname(){
        return vorname;
    }

    public String getNachname(){
        return nachname;
    }
}