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
        this.stunde = stunde;
        this.minute = minute;
    }

    /**
     * Getter für Stunde
     * @return stunde
     */
    public int getStunde() {
        return stunde;
    }

    /**
     * setter für Stunde
     * @param stunde auf welcehe soll gestellt werden
     */
    public void setStunde(int stunde) {
        this.stunde = stunde;
    }

    /**
     * Getter für Minute
     * @return welche Minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Setter für Minute
     * @param minute auf welche minute soll gestellt werden
     */
    public void setMinute(int minute) {
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

