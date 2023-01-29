public class datei1 { //24LOC
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
    public datei1(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    /**
     * Setter fuer Attribut vorname, legt den vornamen der Person fest
     * @param vorname vorname der Person
     */
    public void setVorname(String vorname){
        this.vorname = vorname;
    }
}