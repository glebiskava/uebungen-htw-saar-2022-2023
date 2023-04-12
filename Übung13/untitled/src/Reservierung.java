public class Reservierung {

    private String bemerkung;
    private Uhrzeit begin;
    private Uhrzeit ende;

    public Reservierung(Uhrzeit begin, Uhrzeit ende) {
        this.begin = begin;
        this.ende = ende;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {

    }


}
