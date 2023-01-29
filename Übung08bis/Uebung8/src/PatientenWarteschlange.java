/**
 * Dies ist eine Klasse PatientenWarteschlange fuer eine einfache Patienten Warteschlange fuehrung
 * @author Leopold Mittelberger, Elisee Brand
 * @version 2
 */
public class PatientenWarteschlange {
    /**
     * @param maxAnzahlPatienten Max Anzahl Patienten
     * @param patientenListe Array von objekt Patient
     * @param letzterPatient Index der laetzte Patient der zur der Array addiert ist
     */
    private int maxAnzahlPatienten;
    private Patient[] patientenListe;
    private int letzterPatient;

    /**
     * Konstruktor der die Groesse der array initialisiert
     * @param maxAnzahlPatienten gibt die Groesse der Array patientenListe
     */
    // Constructeur qui initialise la liste de patients avec la taille maximale donnée
    public PatientenWarteschlange(int maxAnzahlPatienten) {
        this.maxAnzahlPatienten = maxAnzahlPatienten;
        patientenListe = new Patient[maxAnzahlPatienten];
        letzterPatient = -1;
    }

    /**
     * Diese Funktion schaft ein patienten in das Array
     * @param nummer Identifikationsnummer der patient
     * @param vorname String fuer der Vorname der Patient
     * @param nachname String fuer der Nachname der Patient
     */
    public void neuerPatient(int nummer, String vorname, String nachname) {
        // Prueft, ob das Array voll ist oder nicht
        ErrorCheck.checkArrayVoll(letzterPatient, maxAnzahlPatienten);

        Patient patient = new Patient(nummer, vorname, nachname);

        //patient am ende das Array addieren
        letzterPatient++;
        patientenListe[letzterPatient] = patient;

    }

    /**
     * Dies Funktion loescht ein Patient aus das Array
     * @param nummer Identifikationsnummer der patient
     * @return der patient der geloescht wird
     */
    public Patient entfernePatient(int nummer) {
        // Patient in das Array suchen via identifikationsnummer
        int index = -1;
        for (int i = 0; i <= letzterPatient; i++) {
            Patient patient = patientenListe[i];
            if (patient.getpatientNummer() == nummer) {
                index = i;
                break;
            }
        }

        // Prueft, ob der Patient gefunden ist
        ErrorCheck.checkPatientGefunden(index);

        // Der gefundene Patient in einer variable lagern
        Patient tmp = patientenListe[index];
        // Jeder andere Patienten sieht seine platz in das Array inkrementiert werden
        for (int i = index; i < letzterPatient; i++) {
            patientenListe[i] = patientenListe[i + 1];
        }
        // Letzte platzt, wird zurückgesetzt
        patientenListe[letzterPatient] = null;
        letzterPatient--;

        return tmp;
    }

    /**
     * Diese funktion ruft der naechste patienten an, und loescht er von die patientenListe
     * @return der naechste / erste patient von das Array
     */
    public Patient derNaechsteBitte() {
        // Prueft ob es patienten in das Array gibt
        ErrorCheck.checkPatientenInArray(letzterPatient);

        Patient naechstePatient = patientenListe[0];
        //Ruft entfernePatient um das patient von das Array loeschen
        entfernePatient(naechstePatient.getpatientNummer());
        return naechstePatient;
    }

    /**
     * Gibt eine String presentation von die patientenListe aus
     * @return eine String presentation von die patientenListe
     */
    @Override
    public String toString() {
        String drucken = new String();

        drucken = "Warteliste\nPatientenummer\tVorname\tNachname\n";
        for (int i = 0; i < patientenListe.length; i++) {
            if(patientenListe[i] != null) {
                drucken += patientenListe[i].getpatientNummer() + "\t\t" + patientenListe[i].getVorname() + " \t" +
                        patientenListe[i].getNachname() + "\n";
            }
        }
        return drucken;
    }
}
