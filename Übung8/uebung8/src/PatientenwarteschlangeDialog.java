public class PatientenwarteschlangeDialog {
    public static void main(String[] args) {
        try {
            // Warteschlange fuer maximal 10 Patienten anlegen
            PatientenWarteschlange patientenwarteschlange = new
                    PatientenWarteschlange(10);
            patientenwarteschlange.neuerPatient(4711, "Tom", "Ate");
            // Neue Patienten anhaengen
            patientenwarteschlange.neuerPatient(1234, "Elle", "Fant");
            patientenwarteschlange.neuerPatient(1111, "Moni", "Tor");
            patientenwarteschlange.neuerPatient(2222, "Phil", "Harmonie");
            System.out.println(patientenwarteschlange); // Warteschlange ausgeben
            Patient entfernterPatient = patientenwarteschlange.entfernePatient(1234);
            // Patient entfernen
            System.out.println("Patient gelöscht: " + entfernterPatient);
            // naechsten Patient herausholen
            Patient naechsterPatient = patientenwarteschlange.derNaechsteBitte();
            System.out.println("Naechster Patient: " + naechsterPatient);
            System.out.println(patientenwarteschlange);



            // simplement pour testeer l'exo 2, à enlever avant de submit
            
            //double[] messwerte = {1.0, 2.0, 3.0, 4.0, 5.0};
            //Mittelwert moyenne = ArrayFunctions.berechneMittelwert(messwerte);

            //System.out.println("Mesures: " + Arrays.toString(messwerte));
            //System.out.println("Moyenne: " + moyenne.get_mittelwert());
            //System.out.println("Mesure la plus proche de la moyenne: " + moyenne.get_nahesterWert());
            //System.out.println("Mesure la plus éloignée de la moyenne: " + moyenne.get_entferntesterWert());


        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
