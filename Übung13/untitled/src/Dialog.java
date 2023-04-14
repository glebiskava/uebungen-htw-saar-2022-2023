import java.util.InputMismatchException;
import java.util.Scanner;

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
    private int uhrzeitLaenge = 0;
    private int mitarbeiterLaenge = 0;
    private int raumLaenge = 0;

    /**
     * Konstanten anlegen fuer einfache zahlen menueeingabe im terminal
     */
    private static final int MITARBEITER_ANLEGEN = 1;
    private static final int MITARBEITER_ANZEIGEN = 2;
    private static final int RAUM_ANLEGEN = 3;
    private static final int RAUM_ANZEIGEN = 4;
    private static final int UHRZEIT_ANLEGEN = 5;
    private static final int UHRZEIT_ANZEIGEN = 6;
    private static final int RESERVIEREN = 7;
    private static final int PROGRAMM_ENDE = 0;

    /**
     * String konstanten fuer jeden Menue punkt --> uebersichtlichkeit im code
     */
    private static final String MITARBEITER_ANLEGEN_STR = " : Mitarbeiter anlegen";
    private static final String MITARBEITER_ANZEIGEN_STR = " : Mitarbeiter anzeigen";
    private static final String RAUM_ANLEGEN_STR = " : Raum anlegen";
    private static final String RAUM_ANZEIGEN_STR = " : Raum anzeigen";
    private static final String UHRZEIT_ANLEGEN_STR = " : Uhrzeit anlegen";
    private static final String UHRZEIT_ANZEIGEN_STR = " : Uhrzeit anzeigen";
    private static final String RESERVIEREN_STR = " : Reservieren";
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

    public void menueAnzeigen(){
        System.out.print("\n\n\n" +
                RESERVIEREN       + ": Reservieren\n"    +
                PROGRAMM_ENDE     + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }
    public int funktionVerarbeitung(){
        int befehl = input.nextInt();
        return befehl;
    }

    public void funktionAusfuehrung(int befehl){
        if(befehl > RESERVIEREN || befehl < PROGRAMM_ENDE){
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch(befehl){
                // case MITARBEITER_ANLEGEN:
                //     MitarbeiterAnlegen();
                //     break;
                // case RAUM_ANLEGEN:
                //     RaumAnlegen();
                //     break;
                case RESERVIEREN:
                    Reservieren();
                    break;
                // case MITARBEITER_ANLEGEN:
                //     MitarbeiterAnlegen();
                //     break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }

        }

    }
    // public void UhrZeitAnlegen(){
    //     System.out.println("Geben Sie eine Uhr ein und dann die Minuten für das Begin der Reservierung ein: \n");

    //     System.out.println("Uhr: \n");
    //     int inputUhr = input.nextInt();

    //     System.out.println("Uhr: \n");
    //     int inputMin = input.nextInt();

    //     Uhrzeit uhrzeit = new Uhrzeit(inputUhr, inputMin);
    // }

    // public void MitarbeiterAnlegen(){
    //     System.out.println("Vorname: ");
    //     String mitarbeiterVorname = input.next();
    //     input.nextLine();

    //     System.out.println("Nachname: ");
    //     String mitarbeiterNachname = input.next();
    //     input.nextLine();

    //     System.out.println("Email: ");
    //     String mitarbeiterEmail = input.next();
    //     input.nextLine();

    //     // Mitarbeiter mitarbeiter = new Mitarbeiter(mitarbeiterVorname, mitarbeiterNachname, mitarbeiterEmail);
    //     //queue.addLast(new Person(personVorname, personNachname));
    //     // System.out.println(mitarbeiter);

    // }

    // public void RaumAnlegen(){
    //     System.out.println("Um den Raum anzulegen brauchen Sie den Gebaude, den Etage und der Nummer den Raum\n");
    //     System.out.println("Geb: ");
    //     int RaumGeb = input.nextInt();
    //     input.nextLine();

    //     System.out.println("Etage: ");
    //     int RaumEtage = input.nextInt();
    //     input.nextLine();

    //     System.out.println("Raum: ");
    //     int RaumRaum = input.nextInt();
    //     input.nextLine();

    //     Raum raum = new Raum(RaumGeb, RaumEtage, RaumRaum);
    // }

    public void Reservieren(){
        //mitarbeiter anlegen
        System.out.println("Mitarbeiter anlegen, mit vorname, name und email: ");
        System.out.println("Vorname: ");
        String mitarbeiterVorname = input.next();
        input.nextLine();

        System.out.println("Nachname: ");
        String mitarbeiterNachname = input.next();
        input.nextLine();

        System.out.println("Email: ");
        String mitarbeiterEmail = input.next();
        input.nextLine();

        Mitarbeiter mitarbeiter = new Mitarbeiter(mitarbeiterVorname, mitarbeiterNachname, mitarbeiterEmail);


        //Raum anlegen
        System.out.println("Um den Raum anzulegen brauchen Sie den Gebaude, den Etage und der Nummer den Raum\n");
        System.out.println("Geb: ");
        int RaumGeb = input.nextInt();
        input.nextLine();

        System.out.println("Etage: ");
        int RaumEtage = input.nextInt();
        input.nextLine();

        System.out.println("Raum: ");
        int RaumRaum = input.nextInt();
        input.nextLine();

        Raum raum = new Raum(RaumGeb, RaumEtage, RaumRaum);


        //Begin Uhr anelegen
        System.out.println("Geben Sie eine Uhr ein und dann die Minuten für das Begin der Reservierung ein: \n");
        System.out.println("Uhr: \n");
        int inputUhrBegin = input.nextInt();

        System.out.println("Uhr: \n");
        int inputMinBegin = input.nextInt();

        Uhrzeit uhrzeitBegin = new Uhrzeit(inputUhrBegin, inputMinBegin);


        //EndeUhr anlegen
        System.out.println("Geben Sie eine Uhr ein und dann die Minuten für das Ende der Reservierung ein: \n");
        System.out.println("Uhr: \n");
        int inputUhrEnde = input.nextInt();

        System.out.println("Uhr: \n");
        int inputMinEnde = input.nextInt();

        Uhrzeit uhrzeitEnde = new Uhrzeit(inputUhrEnde, inputMinEnde);

        //Name des kurse anlegen
        System.out.println("Geben Sie der Name des Kurse für die Reservierung ein: \n");
        System.out.println("Name der Kurs: \n");
        String nameKurs = input.next();

        mitarbeiter.reserviere(raum, uhrzeitBegin, uhrzeitEnde, nameKurs);
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args
     */
    public static void main(String args[]) {
        new Dialog().dialogStart();
    }
}