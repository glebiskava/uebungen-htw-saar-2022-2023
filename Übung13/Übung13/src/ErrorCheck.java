import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Dies ist eine einfache ErrorCheck Klasse wo alle eingabe erst getestet werden bevor sie weitergeleitet werden
 */
public class ErrorCheck extends RuntimeException {

    /**
     * Alle Fehlermeldungen werden in Konstanten ausgelagert
     */
    private static final String LEERE_EINGABE = "Eingabe darf nicht leer sein!";
    private static final String NEGATIV_EINGABE = "Die Eingabe darf nicht negativ sein!";
    private static final String MITARBEITER_EXISTIERT_SCHON = "Dieser Mitarbeiter existiert schon!";
    private static final String RAUM_EXISTIERT_SCHON = "Dieser Raum existiert schon!";
    private static final String UHRZEIT_EXISTIERT_SCHON = "Diese Uhrzeit existiert schon!";
    private static final String MAIL_FALSCH = "Die E-Mail muss ein @ enthalten!";
    private static final String FALSCHE_UHRZEIT_STUNDE = "Geben Sie eine Stunde zwischen 0 und 23 ein!";
    private static final String FALSCHE_UHRZEIT_MIN = "Geben Sie eine Minute zwischen 0 und 59 ein!";
    private static final String INDEX_UNGUELTIG = "Geben Sie einen Index zwischen 0 und 49 an!";

    /**
     * Konstruktor ohne Fehlermeldungen
     */
    public ErrorCheck() {
        super();
    }

    /**
     * Konstruktor mit Fehlermeldung
     * @param msg fehlermeldung als String
     */
    public ErrorCheck(String msg) {
        super(msg);
    }

    /**
     * Methode die prueft ob es schon einen Mitarbeiter mit dem selben vorname, nachname und email gibt
     * @param vorname vorname des Mitarbeites
     * @param nachname nachname des Mitarbeiters
     * @param email email des Mitarbeiters
     * @param mitarbeiterArr Array mit alle Mitarbeitern
     * @throws ErrorCheck
     */
    /*public static void checkIfMitarbeiterExists(String vorname,
                                     String nachname,
                                     String email,
                                     Mitarbeiter[] mitarbeiterArr) throws ErrorCheck {
        for (Mitarbeiter mitarbeiter : mitarbeiterArr) {
            if (vorname.equals(mitarbeiter.getVorname())) {
                if (nachname.equals(mitarbeiter.getNachname())) {
                    if (email.equals(mitarbeiter.getEmail())) {
                        throw new ErrorCheck(MITARBEITER_EXISTIERT_SCHON);
                    }
                }
            }
        }
    }*/

    /**
     * Check ob das Eingabe leer ist oder nicht
     *
     * @param eingabe email des Mitarbeiters
     * @throws ErrorCheck
     */
    public static void checkEingabeLeer(String eingabe) throws ErrorCheck{
        if(eingabe == null || eingabe.trim().isEmpty()){
            throw new ErrorCheck(LEERE_EINGABE);
        }
    }

    /**
     * Check ob das mail mindestens ein zeichnen davor und danach das @ zeichnen hat. Mit regex (".+@.+")
     *
     * @param email emaild es Mitarbeiters
     * @throws ErrorCheck
     */
    public static void checkEmailMitAt(String email) throws ErrorCheck{
        Pattern pattern = Pattern.compile(".+@.+");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new ErrorCheck(MAIL_FALSCH);
        }
    }

    /**
     * Check ob raum oder gebaude ein negatives zahl hat
     *
     * @param zahl zahl
     * @throws ErrorCheck
     */
    public static void checkNegativeZahl(int zahl) throws ErrorCheck{
        if(zahl < 0) {
            throw new ErrorCheck(NEGATIV_EINGABE);
        }
    }

    /**
     * Check, ob ein raum schon existiert
     *
     * @param geb
     * @param etage
     * @param raeume
     * @throws ErrorCheck
     */
    /*public static void raumNummerExistiertSchon (Raum[] raeume, int geb, int etage, int raumNummer) throws ErrorCheck{
        for (Raum raum : raeume) {
            if (geb == raum.getGeb()) {
                if (etage == raum.getEtage()) {
                    if (raumNummer == raum.getRaum()) {
                        throw new ErrorCheck(RAUM_EXISTIERT_SCHON);
                    }
                }
            }
        }
    }*/

    /**
     * check ob stunde zwischen 0 und 23 ist und minute zwischen 0 und 59 ist
     * @param stunde stunde
     * @param min minute
     */
    public static void checkStundeUhrzeit(int stunde, int min){
        if(stunde < 0 || stunde > 23) {
            throw new ErrorCheck(FALSCHE_UHRZEIT_STUNDE);
        }
        if(min < 0 || min > 59) {
            throw new ErrorCheck(FALSCHE_UHRZEIT_MIN);
        }
    }

    /**
     * Checkt ob ein guetliger INdex eingegeben wurde
     * @param index index des arrays
     */
    public static void indexUngueltig(int index) {
        if (index >= 50) {
            throw new ErrorCheck(INDEX_UNGUELTIG);
        }
    }


}
