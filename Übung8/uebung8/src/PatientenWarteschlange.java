import java.util.LinkedList;
import java.util.Queue;

public class PatientenWarteschlange {
    private Queue<Patient> patienten;
    private int maxAnzahlPatienten;

    public PatientenWarteschlange(int maxAnzahlPatienten) {
        this.maxAnzahlPatienten = maxAnzahlPatienten;
        patienten = new LinkedList<>();
    }

    public void neuerPatient(int patientNummer, String vorname, String nachname) {
        if (patienten.size() >= maxAnzahlPatienten) {
            throw new RuntimeException("Die Warteschlange ist voll.");
        }
        patienten.add(new Patient(patientNummer, vorname, nachname));
    }

    public Patient entfernePatient(int patientNummer) {
        for (Patient patient : patienten) {
            if (patient.getpatientNummer() == patientNummer) {
                patienten.remove(patient);
                return patient;
            }
        }
        throw new RuntimeException("Es gibt keinen Patienten mit der angegebenen ID in der Warteschlange.");
    }

    public Patient derNaechsteBitte() {
        return patienten.poll();
    }

    public boolean istLeer() {
        return patienten.isEmpty();
    }

    public int anzahlPatienten() {
        return patienten.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Warteliste\n");
        sb.append("Patientenummer\tVorname\tNachname\n");
        for (Patient patient : patienten) {
            sb.append(patient.getpatientNummer());
            sb.append("\t\t");
            sb.append(patient.getVorname());
            sb.append("\t\t");
            sb.append(patient.getNachname());
            sb.append("\n");
        }
        return sb.toString();
    }

}