import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorCheck extends RuntimeException{
    //Konstanten fuer Mitarbeiter
    private static final String MAIL_LEER = "Leeres Mail";
    private static final String MAIL_FALSCH = "Falsches Mail";

    //Konstanten fuer Person
    private static final String NAME_LEER = "Leeres name";
    private static final String VORNAME_LEER = "Falsches vorname";

    //Konstanten fuer Raum
    private static final String NEGATIV_RAUM_ZAHL = "Negativ raum zahl";
    private static final String NEGATIV_GEB_ZAHL = "Negativ gebaeude zahl";
    private static final String SCHON_EXISTIERENDE_RAUM_ZAHL = "Dieser raum zahl existiert schon";

    //Konstanten fuer Uhrzeit
    private static final String FALSCHE_UHRZEIT_STUNDE = "Falsche Uhrzeit beim stunde, soll zwischen 0 und 23";
    private static final String FALSCHE_UHRZEIT_MIN = "Falsche Uhrzeit beim stunde, soll zwischen 0 und 59";

    public ErrorCheck(){
        super();
    }
    public ErrorCheck(String msg){
        super(msg);
    }


    //check fuer mitarbeiter

    /**
     * Check ob das mail leer ist oder nicht
     * 
     * @param email
     * @throws ErrorCheck
     */
    public static void checkEmail(String email) throws ErrorCheck{
        if(email == null || email.trim().isEmpty()){
            throw new ErrorCheck(MAIL_LEER);
        }
    }

    /**
     * Check ob das mail mindestens ein zeichnen davor und danach das @ zeichnen hat. Mit regex (".+@.+")
     * 
     * @param email
     * @throws ErrorCheck
     */
    public static void checkEmailMitA(String email) throws ErrorCheck{
        Pattern pattern = Pattern.compile(".+@.+");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new ErrorCheck(MAIL_FALSCH);
        }
    }

    //check fuer Person
    /**
     * Check ob name leer ist
     * 
     * @param name
     * @throws ErrorCheck
     */
    public static void checkName(String name) throws ErrorCheck{
        if(name == null || name.trim().isEmpty()){
            throw new ErrorCheck(NAME_LEER);
        }
    }

    /**
     * Check ob vorname leer ist
     * 
     * @param name
     * @throws ErrorCheck
     */
    public static void checkVorname(String vorname) throws ErrorCheck{
        if(vorname == null || vorname.trim().isEmpty()){
            throw new ErrorCheck(VORNAME_LEER);
        }
    }



    //check fuer Raum
    /**
     * Check ob raum oder gebaude ein negatives zahl hat
     * 
     * @param raumZahl zahl des raum
     * @param gebZahl zahl des gebaeude
     * @throws ErrorCheck
     */
    public static void checkNegativesRaumZahl(int raumZahl, int gebZahl) throws ErrorCheck{
        if(raumZahl < 0){
            throw new ErrorCheck(NEGATIV_RAUM_ZAHL);
        }
        if(gebZahl < 0){
            throw new ErrorCheck(NEGATIV_GEB_ZAHL);
        }
    }

    /**
     * Check ob raum schon existiert
     * 
     * @param geb
     * @param etage
     * @param raum
     * @throws ErrorCheck
     */
    public static void checkSchonExistierendeRaumZahl(Reservierung[] reservierungen, int geb, int etage, int raum) throws ErrorCheck{
        // for (Object obj : reservierungen) {
        //     if(obj != null) {
        //         String result = "Raum " + geb + "-" + etage + "." + raum + "\n";
        //         if(geb == Raum.getReservierung(0)){
        //             throw new ErrorCheck(SCHON_EXISTIERENDE_RAUM_ZAHL);
        //         }
        //     }
        // }
        
    }


    //check fuer Uhrzeit
    public static void checkUhrzeitRichtigeUhr(int stunde, int min){
        if(stunde < 0 || stunde > 23){
            throw new ErrorCheck(FALSCHE_UHRZEIT_STUNDE);
        }
        if(min < 0 || min > 59){
            throw new ErrorCheck(FALSCHE_UHRZEIT_MIN);
        }
    }

}