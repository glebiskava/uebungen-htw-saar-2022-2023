/**
 * Check viele dinge hier, um das code in der anderen Klasse besser zu lesen
 * @author Leopold Mittelberger, Elisee Brand
 * @version 2
 */

public class ErrorCheck {

    /**
     * prueft funktion, ob das Array leer ist
     * @param strings ist das Array
     */
    public static void checkLehrArray (String[] strings) {
        if (strings.length == 0) {
            throw new IllegalArgumentException("Das Array ist Leer");
        }
    }

    /**
     * Prueft, ob das Array voll ist oder nicht
     * @param letzterPatient ist index von der letzte patient in das Array
     * @param maxAnzahlPatienten ist die max Groesse von das Array
     */
    public static void checkArrayVoll (int letzterPatient, int maxAnzahlPatienten) {
        if (letzterPatient == maxAnzahlPatienten - 1) {
            throw new RuntimeException("Die Warteschlange ist voll!");
        }
    }

    /**
     * Prueft, ob der Patient gefunden ist
     * @param index ist der patient index in das Array
     */
    public static void checkPatientGefunden (int index) {
        if (index == -1) {
            throw new RuntimeException("Der Patient ist nicht vorhanden!");
        }
    }

    /**
     * Prueft ob es patienten in das Array gibt
     * @param letzterPatient ist index von der letzte patient in das Array
     */
    public static void checkPatientenInArray (int letzterPatient) {
        if (letzterPatient == -1) {
            throw new RuntimeException("Die Warteschlange ist leer!");
        }
    }
}