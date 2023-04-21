/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine einfache Uhrzeitklasse mit den Attributen Stunde und Minute
 */
public class Uhrzeit {

    /**
     *Attribute für Uhrzeit entnommen aus UML-Diagramm
     */
    private int stunde;
    private int minute;

    /**
     * Konstruktor für Uhrzeit
     * @param stunde welche Stunde
     * @param minute welche Minute
     */
    public Uhrzeit(int stunde, int minute) {
        ErrorCheck.checkStundeUhrzeit(stunde, minute);

        this.stunde = stunde;
        this.minute = minute;
    }

    /**
     * toString Methode gibt Uhrzeit als String zurück
     * @return Uhrzeit als String
     */
    @Override
    public String toString() {

        // wenn minute kleiner als 10 ist, wird eine Null davor gesetzt
        return stunde + ":" + (minute < 10 ? "0" : "") + minute + " Uhr";
    }
}

