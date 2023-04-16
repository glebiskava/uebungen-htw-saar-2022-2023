public class ErrorCheck extends RuntimeException{
    //Konstanten für Mitarbeiter
    private static final String MAIL_LEER = "Leeres Mail";
    private static final String MAIL_FALSCH = "Falsches Mail";

    //Konstanten für Person
    private static final String NAME_LEER = "Leeres name";
    private static final String VORNAME_LEER = "Falsches vorname";

    //Konstanten für Raum
    private static final String NEGATIV_RAUM_ZAHL = "Negativ raum zahl";
    private static final String SCHON_EXISTIERENDE_RAUM_ZAHL = "Dieser raum zahl existiert schon";

    public ErrorCheck(){
        super();
    }
    public ErrorCheck(String msg){
        super(msg);
    }


    //check für mitarbeiter

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
     * Check ob das mail leer ist oder nicht
     * 
     * @param email
     * @throws ErrorCheck
     */
    public static void checkEmailMitA(String email) throws ErrorCheck{
        // if(){
        //     throw new ErrorCheck(MAIL_FALSCH);
        // }
    }

    //check für Person
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



    //check für Raum
    /**
     * Check ob raum ein negatives zahl hat
     * 
     * @param name
     * @throws ErrorCheck
     */
    public static void checkNegativesRaumZahl(int raumZahl) throws ErrorCheck{
        if(raumZahl < 0){
            throw new ErrorCheck(NEGATIV_RAUM_ZAHL);
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
        for (Object obj : reservierungen) {
            if(obj != null) {
                String result = "Raum " + geb + "-" + etage + "." + raum + "\n";
                if(geb == Raum.getReservierung(0)){
                    throw new ErrorCheck(SCHON_EXISTIERENDE_RAUM_ZAHL);
                }
            }
        }
        
    }

}