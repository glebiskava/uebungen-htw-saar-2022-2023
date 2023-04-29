import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

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
    // private static final int MAX_GROESSE = 50;

    /**
     * Uhrzeit, Mitarbeiter und Raum Arrays erstellen
     */
    private float[] floatZahlenArr;
    // private Mitarbeiter[] mitarbeiterArr;
    // private Raum[] raumArr;

    /**
     * variablen fuer die laengeerfassung der verschiedenen arrays
     */
    // private int uhrzeitArrLaenge = 0;
    // private int mitarbeiterArrLaenge = 0;
    // private int raumArrLaenge = 0;

    /**
     * Konstanten anlegen fuer einfache zahlen menueeingabe im terminal
     */
    private static final int ZAHLEN_MANUEL_GEBEN = 1;
    private static final int ZAHLEN_RANDOM_GEBEN = 2;
    private static final int ZAHLEN_ARRAY_ZEIGEN = 3;
    // private static final int RAUM_ANLEGEN = 3;
    // private static final int UHRZEIT_ANLEGEN = 4;
    // private static final int UHRZEIT_ANZEIGEN = 5;
    // private static final int RESERVIEREN = 6;
    // private static final int PRINT_RESERVIERUNG_ZU_RAUM = 7;
    // private static final int RAUM_ANZEIGEN = 8;
    private static final int PROGRAMM_ENDE = 0;

    /**
     * String konstanten fuer jeden Menue punkt --> uebersichtlichkeit im code
     */
    private static final String ZAHLEN_MANUEL_GEBEN_STR = " : Zahlen manuel eingeben";
    private static final String ZAHLEN_RANDOM_GEBEN_STR = " : Random zahlen generieren";
    private static final String ZAHLEN_ARRAY_ZEIGEN_STR = " : Float array anzeigen";
    // private static final String RAUM_ANLEGEN_STR = " : Raum anlegen";
    // private static final String UHRZEIT_ANLEGEN_STR = " : Uhrzeit anlegen";
    // private static final String UHRZEIT_ANZEIGEN_STR = " : Uhrzeit anzeigen";
    // private static final String RESERVIEREN_STR = " : Reservieren";
    // private static final String PRINT_RESERVIERUNG_ZU_RAUM_STR = " : Reservierungen zu einem Raum anzeigen";
    // private static final String RAUM_ANZEIGEN_STR = " : Alle Raeume und Reservierungen anzeigen";
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

        // uhrzeitArr = new Uhrzeit[MAX_GROESSE];
        // mitarbeiterArr = new Mitarbeiter[MAX_GROESSE];
        // raumArr = new Raum[MAX_GROESSE];
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
                ZAHLEN_MANUEL_GEBEN        + ZAHLEN_MANUEL_GEBEN_STR        + "\n" +
                ZAHLEN_RANDOM_GEBEN        + ZAHLEN_RANDOM_GEBEN_STR        + "\n" +
                ZAHLEN_ARRAY_ZEIGEN        + ZAHLEN_ARRAY_ZEIGEN_STR        + "\n" +
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

        if(befehl > ZAHLEN_ARRAY_ZEIGEN || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch (befehl) {
                case ZAHLEN_MANUEL_GEBEN:
                    zahlenManuelGeben();
                    break;
                case ZAHLEN_RANDOM_GEBEN:
                    zahlenRandomGenerieren();
                    break;
                case ZAHLEN_ARRAY_ZEIGEN:
                    arrayAnzeigen();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }

    /**
     * 
     */
    public void zahlenManuelGeben() {

        // Eingabe des Groesse des Array
        System.out.println("Anzahl von zahlen, die Sie eingeben moechten : ");
        int floatZahlenGroesse = input.nextInt();
        input.nextLine();

        floatZahlenArr = new float[floatZahlenGroesse];


        for(int i = 0; i < floatZahlenGroesse; i++){
            System.out.println("Geben Sie der " + (i + 1) + " float zahl ein : ");
            float floatZahl = input.nextFloat();
            input.nextLine();

            floatZahlenArr[i] = floatZahl;
            
            
        }
    }


    public void zahlenRandomGenerieren(){

        // Eingabe des Groesse des Array
        System.out.println("Anzahl von zahlen, die Sie eingeben moechten : ");
        int floatZahlenGroesse = input.nextInt();
        input.nextLine();

        floatZahlenArr = new float[floatZahlenGroesse];

        for(int i = 0; i < floatZahlenGroesse; i++){
            Random randomZahl = new Random();
            float randomFloat = randomZahl.nextFloat(0,100);

            floatZahlenArr[i] = randomFloat;
        } 
    }


    public void arrayAnzeigen(){
        System.out.print("[");
        for(int i = 0; i < (floatZahlenArr.length - 1); i++){
            System.out.print(floatZahlenArr[i] + ", ");
        }
        System.out.print(floatZahlenArr[floatZahlenArr.length - 1] + "]");
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args argumenten Array
     */
    public static void main(String[] args) {
        new Dialog().dialogStart();
    }
}