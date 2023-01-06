public class Patient {
    private int patientNummer;
    private String vorname;
    private String nachname;

    public Patient(int patientNummer, String vorname, String nachname) {
        this.patientNummer = patientNummer;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public int getpatientNummer() {
        return patientNummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    @Override
    public String toString() {
        return patientNummer + ", " + vorname + ", " + nachname;
    }
}