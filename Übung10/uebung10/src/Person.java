/**
 * Dies ist eine einfache Klasse Person mit den folgenden Attributen und Methoden:

 * Get- und set-Methoden fuer die beiden Attribute
 */

public class Person {

    /**
     * Attribute
     *  vorname: String vorname der Person
     *  nachname: String nachname der Person
     */
    private String vorname;
    private String nachname;

    /**
     * Konstruktor fuer die Klasse Person
     * @param vorname vorname der Person
     * @param nachname nachname der Person
     */
    public Person(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    /**
     * Setter fuer Attribut vorname, legt den vornamen der Person fest
     * @param vorname vorname der Person
     */
    public void setVorname(String vorname){
        //check
        this.vorname = vorname;
    }

    /**
     * Setter fuer Attribut nachname, legt den nachname der Person fest
     * @param nachname nachname der Person
     */
    public void setNachname(String nachname){
        //check
        this.nachname = nachname;
    }

    /**
     * Getter fuer Attribute Vorname
     * @return vorname der Person
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Getter fuer Attribut nachname
     * @return nachname der Person
     */
    public String getNachname(){
        return nachname;
    }

    /**
     * toString Methode die ein Objekt als String aufbereitet und wiedergibt
     * @return vorname und nachname der Person
     */
    @Override
    public String toString(){
        return vorname + " " + nachname;
    }

}