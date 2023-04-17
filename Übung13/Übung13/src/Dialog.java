import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine einfache Dialogklassse zum interaktiven Testen der Aufgabe
 */
public class Dialog {

    /**
     * Scanner objekt initialisieren fuer das einlesen der eingabe im terminal
     */
    private final Scanner input;

    /**
     * Konstante fuer fixe array groesse
     */
    private static final int MAX_GROESSE = 50;

    /**
     * Uhrzeit, Mitarbeiter und Raum Arrays erstellen
     */
    private Uhrzeit[] uhrzeitArr;
    private Mitarbeiter[] mitarbeiterArr;
    private Raum[] raumArr;

    /**
     * variablen fuer die laengeerfassung der verschiedenen arrays
     */
    private int uhrzeitArrLaenge = 0;
    private int mitarbeiterArrLaenge = 0;
    private int raumArrLaenge = 0;

    /**
     * Konstanten anlegen fuer einfache zahlen menueeingabe im terminal
     */
    private static final int MITARBEITER_ANLEGEN = 1;
    private static final int MITARBEITER_ANZEIGEN = 2;
    private static final int RAUM_ANLEGEN = 3;
    private static final int RAUM_ANZEIGEN = 4;
    private static final int RAUM_RESERVIEREN = 5;
    private static final int UHRZEIT_ANLEGEN = 6;
    private static final int UHRZEIT_ANZEIGEN = 7;
    private static final int RESERVIEREN = 8;
    private static final int PRINT_RESERVIERUNG_ZU_RAUM = 9;
    private static final int PROGRAMM_ENDE = 0;

    /**
     * String konstanten fuer jeden Menue punkt --> uebersichtlichkeit im code
     */
    private static final String MITARBEITER_ANLEGEN_STR = " : Mitarbeiter anlegen";
    private static final String MITARBEITER_ANZEIGEN_STR = " : Mitarbeiter anzeigen";
    private static final String RAUM_ANLEGEN_STR = " : Raum anlegen";
    private static final String RAUM_ANZEIGEN_STR = " : Raum anzeigen";
    private static final String RAUM_RESERVIEREN_STR = " : Raum reservieren";
    private static final String UHRZEIT_ANLEGEN_STR = " : Uhrzeit anlegen";
    private static final String UHRZEIT_ANZEIGEN_STR = " : Uhrzeit anzeigen";
    private static final String RESERVIEREN_STR = " : Reservieren";
    private static final String PRINT_RESERVIERUNG_ZU_RAUM_STR = " : Reservierungen zu einem Raum anzeigen";
    private static final String PROGRAMM_ENDE_STR = " : Programm beenden";

    /**
     * Scanner objekt erstellen des Typs Input
     */
    public Dialog(){

        input = new Scanner(System.in);
    }

    /**
     * do while schleife zum starten des Programms
     * fehleingaben werden hier
     */
    public void dialogStart(){

        uhrzeitArr = new Uhrzeit[MAX_GROESSE];
        mitarbeiterArr = new Mitarbeiter[MAX_GROESSE];
        raumArr = new Raum[MAX_GROESSE];
        int befehl = 0;

        do{
            try{
                menueAnzeigen();
                befehl = funktionVerarbeitung();
                funktionAusfuehrung(befehl);
            } catch (IllegalArgumentException e){
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Geben Sie eine gueltige Zahl des gewollten Datentypen ein!");
                input.nextLine();
            } catch (Exception e){
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (befehl != PROGRAMM_ENDE);
    }

    /**
     * Methode zeigt das Menue an
     */
    public void menueAnzeigen(){

        System.out.print("\n\n\n" +
                MITARBEITER_ANLEGEN        + MITARBEITER_ANLEGEN_STR        + "\n" +
                MITARBEITER_ANZEIGEN       + MITARBEITER_ANZEIGEN_STR       + "\n" +
                RAUM_ANLEGEN               + RAUM_ANLEGEN_STR               + "\n" +
                RAUM_ANZEIGEN              + RAUM_ANZEIGEN_STR              + "\n" +
                RAUM_RESERVIEREN           + RAUM_RESERVIEREN_STR           + "\n" +
                UHRZEIT_ANLEGEN            + UHRZEIT_ANLEGEN_STR            + "\n" +
                UHRZEIT_ANZEIGEN           + UHRZEIT_ANZEIGEN_STR           + "\n" +
                RESERVIEREN                + RESERVIEREN_STR                + "\n" +
                PRINT_RESERVIERUNG_ZU_RAUM + PRINT_RESERVIERUNG_ZU_RAUM_STR + "\n" +
                PROGRAMM_ENDE              + PROGRAMM_ENDE_STR              + "\n" +
                "Geben Sie eine der angegebenen Zahlen ein : "
        );

    }

    /**
     * Methode zum Einlesen der Nutzereingabe und Rueckgabe
     * @return Nutzer Eingabe befehl als Int
     */
    public int funktionVerarbeitung(){

        int befehl = input.nextInt();
        return befehl;
    }

    /**
     * Methode zur Ausführung der Nutzereingabe der Menuepunkte
     * @param befehl
     */
    public void funktionAusfuehrung(int befehl){

        if(befehl > PRINT_RESERVIERUNG_ZU_RAUM || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch (befehl) {
                case MITARBEITER_ANLEGEN:
                    mitarbeiterAnlegen();
                    break;
                case MITARBEITER_ANZEIGEN:
                    mitarbeiterAnzeigen();
                    break;
                case RAUM_ANLEGEN:
                    raumAnlegen();
                    break;
                case RAUM_ANZEIGEN:
                    raumAnzeigen();
                    break;
                case RAUM_RESERVIEREN:
                    raumReservieren();
                    break;
                case UHRZEIT_ANLEGEN:
                    uhrzeitAnlegen();
                    break;
                case UHRZEIT_ANZEIGEN:
                    uhrzeitAnzeigen();
                    break;
                case RESERVIEREN:
                    reservieren();
                    break;
                case PRINT_RESERVIERUNG_ZU_RAUM:
                    printReservierungZuRaum();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }

    /**
     * Methode zur Eingabe des Vornamens, Nachnamens und E-Mail
     */
    public void mitarbeiterAnlegen() {

        // Eingabe des Vornamens
        System.out.println("Vorname : ");
        String vorname = input.next();
        input.nextLine();

        //Eingabe des Nachnamens
        System.out.println("Nachname : ");
        String nachname = input.next();
        input.nextLine();

        //Eingabe Email
        System.out.println("E-Mail : ");
        String email = input.next();
        input.nextLine();

        mitarbeiterArr[mitarbeiterArrLaenge] = new Mitarbeiter(vorname, nachname, email);
        mitarbeiterArrLaenge++;
    }

    /**
     * Methode die alle Mitarbeiter ausgibt, wenn das Array nicht leer ist
     */
    public void mitarbeiterAnzeigen() {

        if(isArrayEmpty(mitarbeiterArr)) {
            System.out.println("Es gibt noch keinen Mitarbeiter. Legen Sie einen an!");
        } else {
            printOutArrayObject(mitarbeiterArr);
        }
    }

    /**
     * Methode zum Anlegen eines Raumes
     */
    public void raumAnlegen() {

        //Gebaeude Eingabe
        System.out.println("Gebaeude : ");
        int gebaeude = input.nextInt();
        input.nextLine();

        //Etage Eingabe
        System.out.println("Etage : ");
        int etage = input.nextInt();
        input.nextLine();

        //Eingabe Raum
        System.out.println("Raum : ");
        int raum = input.nextInt();
        input.nextLine();

        raumArr[raumArrLaenge] = new Raum(gebaeude, etage, raum);
        raumArrLaenge++;
    }

    /**
     * Methode gibt alle Raeume aus, wenn das array nicht leer
     */
    public void raumAnzeigen() {

        if(isArrayEmpty(raumArr)) {
            System.out.println("Es gibt noch keinen Raum. Legen Sie einen an!");
        } else {
            printOutArrayObject(raumArr);
        }
    }

    /**
     * Methode um eine Uhrzeit anzulegen
     */
    public void uhrzeitAnlegen() {

        //Eingabe Stunde
        System.out.println("Stunde : ");
        int stunde = input.nextInt();
        input.nextLine();

        //Eingabe Minuten
        System.out.println("Minute : ");
        int minute = input.nextInt();
        input.nextLine();

        uhrzeitArr[uhrzeitArrLaenge] = new Uhrzeit(stunde, minute);
        uhrzeitArrLaenge++;
    }

    /**
     * Methode die alle Uhrzeiten ausgibt, wenn das array nicht leer ist
     */
    public void uhrzeitAnzeigen() {

        if(isArrayEmpty(uhrzeitArr)) {
            System.out.println("Es gibt noch keine Uhrzeit. Legen Sie eine an!");
        } else {
            printOutArrayObject(uhrzeitArr);
        }
    }

    /**
     * Methode zum reservieren anhand eines existierenden Mitarbeiters und Raum
     * Uhrzeit und Bemerkung werden selbst gewählt
     */
    public void reservieren() {

       if(isArrayEmpty(raumArr)) {
           System.out.println("Es existiert noch kein Raum. Legen Sie einen an!");
       } else if (isArrayEmpty(mitarbeiterArr)) {
           System.out.println("Es existiert noch kein Raum. Legen Sie einen an!");
       } else {
           //Mitarbeiter waehlen anhand Index
           System.out.println("Geben Sie den Index des Mitarbeiters an : ");
           int indexM = input.nextInt();
           input.nextLine();

           //Raum waehlen anhand Index
           System.out.println("Geben Sie den Index des Raumes an : ");
           int indexR = input.nextInt();
           input.nextLine();

           //Startzeit-Stunde Eingabe
           System.out.println("Geben Sie eine Anfangsstunde ein : ");
           int startStunde = input.nextInt();
           input.nextLine();

           //Startzeit-Minute Eingabe
           System.out.println("Geben Sie eine Anfangsminute ein : ");
           int startMinute = input.nextInt();
           input.nextLine();

           //Endzeit-Stunde Eingabe
           System.out.println("Geben Sie eine Endstunde ein : ");
           int endStunde = input.nextInt();
           input.nextLine();

           //Endzeit-Minute Eingabe
           System.out.println("Geben Sie eine Endminute ein : ");
           int endMinute = input.nextInt();
           input.nextLine();

           //Bemerkung fuer den Raum
           System.out.println("Geben Sie eine Bemerkung fuer den Raume ein: ");
           String bemerkung = input.next();
           input.nextLine();

           Mitarbeiter mitarbeiter = mitarbeiterArr[indexM];
           Raum raum = raumArr[indexR];

           mitarbeiter.reserviere(
                   raum,
                   new Uhrzeit(startStunde, startMinute),
                   new Uhrzeit(endStunde, endMinute),
                   bemerkung
           );
       }
    }

    /**
     * Methode die einem Raum eine Reservierung hinzufuegt --> Ein Raum wird reserviert
     * Ein Raum muss erst erstellt werden
     */

    public void raumReservieren() {

        if(isArrayEmpty(mitarbeiterArr)) {

            System.out.println("Es gibt noch keinen Mitarbeiter. Legen Sie einen an!");

        } else if(isArrayEmpty(raumArr)) {

            System.out.println("Es git noch keinen Raum. Legen Sie einen an!");

        } else {

            //Eingabe des Inde eines Raumes
            System.out.println("Geben Sie den Index des Raumes an : ");
            int indexR = input.nextInt();
            input.nextLine();
            Raum raum = raumArr[indexR];

            //Startzeit-Stunde Eingabe
            System.out.println("Geben Sie eine Anfangsstunde ein : ");
            int startStunde = input.nextInt();
            input.nextLine();

            //Startzeit-Minute Eingabe
            System.out.println("Geben Sie eine Anfangsminute ein : ");
            int startMinute = input.nextInt();
            input.nextLine();

            //neue Uhrzeit wird dem Array hinzugefuegt
            Uhrzeit begin = new Uhrzeit(startStunde, startMinute);
            uhrzeitArr[uhrzeitArrLaenge] = begin;
            uhrzeitArrLaenge++;

            //Endzeit-Stunde Eingabe
            System.out.println("Geben Sie eine Endstunde ein : ");
            int endStunde = input.nextInt();
            input.nextLine();

            //Endzeit-Minute Eingabe
            System.out.println("Geben Sie eine Endminute ein : ");
            int endMinute = input.nextInt();
            input.nextLine();

            //neue Uhrzeit wird dem Array hinzugefuegt
            Uhrzeit ende = new Uhrzeit(endStunde, endMinute);
            uhrzeitArr[uhrzeitArrLaenge] = ende;
            uhrzeitArrLaenge++;

            raum.addReservierung(new Reservierung(begin, ende));
        }
    }

    /**
     * Methode gibt eine bestimmte reservierung aus zu einem bestimmten Raum
     */
    public void printReservierungZuRaum() {
        if(isArrayEmpty(mitarbeiterArr)) {

            System.out.println("Es gibt noch keinen Mitarbeiter. Legen Sie einen an!");

        } else if(isArrayEmpty(raumArr)) {

            System.out.println("Es git noch keinen Raum. Legen Sie einen an!");

        } else {
            //Eingabe des Index des Raums
            System.out.println("Geben Sie den Index des Raumes an : ");
            int raumIndex = input.nextInt();
            input.nextLine();
            Raum raum = raumArr[raumIndex];

            //Eingabe des Index der Reservierung
            System.out.println("Geben Sie den Index der Reservierung an : ");
            int reservierungIndex = input.nextInt();
            input.nextLine();

            Reservierung reservierung = raum.getReservierung(reservierungIndex);
            System.out.println(reservierung);
        }
    }

    /**
     * Methode die prueft ob das array leer ist
     * @param arrayObject Objekt im Array
     * @return true oder false
     */
    public boolean isArrayEmpty(Object[] arrayObject) {
        for(Object obj : arrayObject) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Methode die ein Objekt ausgibt, wenn es nicht leer ist
     * @param arrayObject
     */
    public void printOutArrayObject(Object[] arrayObject) {
        for (Object obj : arrayObject) {
            if(obj != null) {
                System.out.println(obj);
            }
        }
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args argumenten Array
     */
    public static void main(String[] args) {
        new Dialog().dialogStart();
    }
}