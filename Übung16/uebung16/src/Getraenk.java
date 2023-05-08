/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache Getraenkklasse mit den Attributen name und preis
 */

public abstract class Getraenk {

    /**
     * Attribute: name und preis des Getraenks
     */
    private String name;
    private double preis;


    /**
     * Standardkonstruktor
     */
    public Getraenk() {
        this.name = "";
        this.preis = 0.0;
    }

    /**
     * Konstruktor mit name und preis
     * @param name name des Getraenks
     * @param preis preis des Getraenks
     */
    public Getraenk(String name, double preis) {
        ErrorCheck.checkStringEmpty(name);
        ErrorCheck.checkDoubleEmpty(preis);
        this.name = name;
        this.preis = preis;
    }

    /**
     * Getter für name
     * @return name des Getraenks
     */
    public String getName() {
        return name;
    }

    /**
     * Setter für name
     * @param name name ds Getraenks
     */
    public void setName(String name) {
        ErrorCheck.checkStringEmpty(name);
        this.name = name;
    }

    /**
     * Getter für Preis
     * @return preis des Getraenks
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Setter für Preis
     * @param preis preis des Getraenks
     */
    public void setPreis(double preis) {
        ErrorCheck.checkDoubleEmpty(preis);
        this.preis = preis;
    }

    /**
     * To-String Methode gibt name und preis als String zurück
     * @return name und preis des Getraenks
     */
    @Override
    public String toString() {
        return name + " (" + preis + " Euro)";
    }
}