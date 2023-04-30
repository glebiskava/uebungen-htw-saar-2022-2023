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
     * Float Array erstellen
     */
    private float[] floatZahlenArr;
    private float[] speichernArr;

    /**
     * Variablen fuer die laengeerfassung der arrays
     */
    private int floatZahlenGroesse;

    /**
     * Für die Durchführung der Operationen
     */
    private NumberCruncherTopLevel cruncher;

    /**
     * Konstanten anlegen fuer einfache zahlen menueeingabe im terminal
     */
    private static final int ZAHLEN_MANUEL_GEBEN  = 1;
    private static final int ZAHLEN_RANDOM_GEBEN  = 2;
    private static final int ZAHLEN_ARRAY_ZEIGEN  = 3;
    private static final int SELBE_ARRAY_EINGEBEN = 4;
    private static final int SUM                  = 5;
    private static final int SWIRL                = 6;
    private static final int DIVIDE               = 7;
    private static final int SUBSTRACT            = 8;
    private static final int AVERAGE              = 9;
    private static final int PROGRAMM_ENDE        = 0;

    /**
     * String konstanten fuer jeden Menue punkt --> uebersichtlichkeit im code
     */
    private static final String ZAHLEN_MANUEL_GEBEN_STR = " : Zahlen manuel eingeben";
    private static final String ZAHLEN_RANDOM_GEBEN_STR = " : Random zahlen generieren";
    private static final String ZAHLEN_ARRAY_ZEIGEN_STR = " : Float array anzeigen";
    private static final String SELBE_ARRAY_EINGEBEN_STR = " : Selbe array wieder benutzen";
    // private static final String SUM_STR                 = " : Die summe von die Elemente des Arrays rechnen";
    // private static final String SWIRL_STR               = " : n zufällige Vertauschungen der Datenfelder durchfuehren";
    // private static final String DIVIDE_STR              = " : Die n/2 groeßten Werte im Array durch die n/2 Kleinsten teilen";
    // private static final String SUBSTRACT_STR           = " : Die substraction von die Elemente des Arrays rechnen";
    // private static final String AVERAGE_STR             = " : Den Durchschnitt aller Werte im Array bestimmen";
    private static final String SUM_STR                 = " : Sum";
    private static final String SWIRL_STR               = " : Swirl";
    private static final String DIVIDE_STR              = " : Divide";
    private static final String SUBSTRACT_STR           = " : Substract";
    private static final String AVERAGE_STR             = " : Average";
    private static final String PROGRAMM_ENDE_STR       = " : Programm beenden";

    /**
     * Scanner objekt erstellen des Typs Input
     */
    public Dialog(){
        input = new Scanner(System.in);
    }

    /**
     * do while schleife zum starten des Programms
     */
    public void dialogStart(){
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
                SELBE_ARRAY_EINGEBEN       + SELBE_ARRAY_EINGEBEN_STR       + "\n===\n" +
                SUM                        + SUM_STR                        + "\n" +
                SWIRL                      + SWIRL_STR                      + "\n" +
                DIVIDE                     + DIVIDE_STR                     + "\n" +
                SUBSTRACT                  + SUBSTRACT_STR                  + "\n" +
                AVERAGE                    + AVERAGE_STR                    + "\n" +
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
     * @param befehl ist der nummer der zu eine rufe von methode fuehrt
     */
    public void funktionAusfuehrung(int befehl){
        if(befehl > AVERAGE || befehl < PROGRAMM_ENDE) {
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
                    arrayAnzeigen(floatZahlenArr);
                    break;
                case SELBE_ARRAY_EINGEBEN:
                    selbeArrayWiederBenutzen();
                    break;
                case SUM:
                    summe();
                    break;
                case SWIRL:
                    swirl();
                    break;
                case DIVIDE:
                    divide();
                    break;
                case SUBSTRACT:
                    substract();
                    break;
                case AVERAGE:
                    average();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }

    /**
     * Methode die fragt der User um den array mit float Zahlen einzufuehlen
     */
    public void zahlenManuelGeben() {
        if(floatZahlenArr == null){
            // Eingabe des Groesse des Array
            System.out.println("Anzahl von zahlen, die Sie eingeben moechten : ");
            floatZahlenGroesse = input.nextInt();
            input.nextLine();

            floatZahlenArr = new float[floatZahlenGroesse];
            speichernArr = new float[floatZahlenGroesse];

            // Eingabe des float zahen die des Arrays einfuellen werden
            for(int i = 0; i < floatZahlenGroesse; i++){
                System.out.println("Geben Sie der " + (i + 1) + " float zahl ein : ");
                float floatZahl = input.nextFloat();
                input.nextLine();

                speichernArr[i] = floatZahl;
                floatZahlenArr[i] = floatZahl;
            }
            System.out.println("Das Array die hergestelt wurde : ");
            arrayAnzeigen(floatZahlenArr);

        } else {
            // Eingabe zum wissen ob das Array ueberschreiben soll oder nicht
            System.out.println("Es existiert schon eine Array, wollen Sie es überschreiben ? [Y/n] : ");
            String antwortArrayUberschreiben = input.next();
            input.nextLine();

            if(antwortArrayUberschreiben.equals("Y")){
                floatZahlenArr = null;
                zahlenManuelGeben();
            } else {
                System.out.println("Das Array wurde nicht uebergeschrieben");
            }
        }
    }

    /**
     * Methode die fragt der User der groesse des Arrays, und fuehlt die mit Random float zahlen zwischen 0 und 100
     */
    public void zahlenRandomGenerieren(){
        if(floatZahlenArr == null){
            
            // Eingabe des Groesse des Array
            System.out.println("Anzahl von zahlen, die werden generiert und in das Array gegeben : ");
            floatZahlenGroesse = input.nextInt();
            input.nextLine();

            floatZahlenArr = new float[floatZahlenGroesse];
            speichernArr = new float[floatZahlenGroesse];

            // Generation von random float Zahlen die des Arrays fuehlen werden
            for(int i = 0; i < floatZahlenGroesse; i++){
                Random randomZahl = new Random();
                float randomFloat = randomZahl.nextFloat(0,100);

                speichernArr[i] = randomFloat;
                floatZahlenArr[i] = randomFloat;
            } 
            System.out.println("Das Array die hergestelt wurde : ");
            arrayAnzeigen(floatZahlenArr);

        } else {
            // Eingabe zum wissen ob das Array ueberschreiben soll oder nicht
            System.out.println("Es existiert schon eine Array, wollen Sie es überschreiben ? [Y/n] : ");
            String antwortArrayUberschreiben = input.next();
            input.nextLine();

            if(antwortArrayUberschreiben.equals("Y")){
                floatZahlenArr = null;
                zahlenRandomGenerieren();
            } else {
                System.out.println("Das Array wurde nicht uebergeschrieben");
            }
        }
    }

    public void selbeArrayWiederBenutzen(){

        floatZahlenArr = new float[floatZahlenGroesse];
        for(int i = 0; i < floatZahlenGroesse; i++){
            floatZahlenArr[i] = speichernArr[i];
        }
        System.out.println("Die letzte Array die Sie eingegeben oder generieren haben, wurde wieder gestelt : ");
        arrayAnzeigen(floatZahlenArr);
    }

    
    /**
     * Methode die die Methode Sum in das NumberCruncherTopLevel datei ruft und 
     * die Summe dis elemente des Array rechnet
     */

    public void summe(){
        // Summe in NumberCruncherTopLevel rechnen
        NumberCruncherTopLevel.Sum sum = new NumberCruncherTopLevel(floatZahlenArr).new Sum();
        sum.crunch(floatZahlenArr);

        operationsErgebnis(floatZahlenArr);
    }
    
    /**
     * Methode die die Methode Swirl in das NumberCruncherTopLevel datei ruft und 
     * die die platz von den element das Array tauscht
     */
    public void swirl(){
        // Swirl in NumberCruncherTopLevel rechnen
        NumberCruncherTopLevel.Swirl swirl = new NumberCruncherTopLevel(floatZahlenArr).new Swirl();
        swirl.crunch(floatZahlenArr);

        operationsErgebnis(floatZahlenArr);
    }

    /**
     * Methode die die Methode divide in das NumberCruncherTopLevel datei ruft und 
     * die die n/2 groeßten Werte im Array durch die n/2 Kleinsten teilen (wo n die lange des Array ist)
     */
    public void divide(){
        // Divide in NumberCruncherTopLevel rechnen
        NumberCruncherTopLevel.Divide divide = new NumberCruncherTopLevel(floatZahlenArr).new Divide();
        divide.crunch(floatZahlenArr);

        operationsErgebnis(floatZahlenArr);
    }

    /**
     * Methode die die Methode substract in das NumberCruncherTopLevel datei ruft und 
     * die elemente des Arrays subraiert
     */
    public void substract(){
        // Substract in NumberCruncherTopLevel rechnen
        NumberCruncherTopLevel.Substract substract = new NumberCruncherTopLevel(floatZahlenArr).new Substract();
        substract.crunch(floatZahlenArr);

        operationsErgebnis(floatZahlenArr);
    }

    /**
     * Methode die die Methode average in das NumberCruncherTopLevel datei ruft und 
     * das average von die elemente in das Array rechnet
     */
    public void average(){
        // Average in NumberCruncherTopLevel rechnen
        NumberCruncherTopLevel.Average average = new NumberCruncherTopLevel(floatZahlenArr).new Average();
        average.crunch(floatZahlenArr);

        operationsErgebnis(floatZahlenArr);
        
        float cruncherAverage = average.getAverage();
        System.out.println("Und das Average Zahl ist : " + cruncherAverage);
    }


    /**
     * Methode die zeigt jedes item des Arrays
     */
    public void arrayAnzeigen(float[] array){
        System.out.print("[");
        for(int i = 0; i < (array.length - 1); i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }

    /**
     * Methode die das ergebnis bekommt und mittels arrayAnzeigen ausgibt
     */
    public void operationsErgebnis(float[] array){
        cruncher = new NumberCruncherTopLevel(floatZahlenArr);
        float[] cruncherZahlen = cruncher.getNumbers();
        System.out.println("Die Array ausgabe ist : ");
        arrayAnzeigen(cruncherZahlen);
    }
    /**
     * Funktion zum Starten des Dialogs
     * @param args argumenten Array
     */
    public static void main(String[] args) {
        new Dialog().dialogStart();
    }
}