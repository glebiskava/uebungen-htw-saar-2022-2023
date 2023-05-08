import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

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
     * Getraekautomat Array erstellen 
     */
    // private Getraenkeautomat<?>[] getraenkeautomatArray = new Getraenkeautomat<?> [10];
    ArrayList<Getraenkeautomat<? extends Getraenk>> getraenkeautomatArray = new ArrayList<>();

    /**
     * Variablen fuer die laengeerfassung der arrays
     */
    // private int floatZahlenGroesse;

    /**
     * Für die Durchführung der Operationen
     */
    private Getraenkeautomat<Getraenk> getraenkeautomat;
    private Getraenkeautomat<AlkoholischesGetraenk> alkoholischeGetraenkeautomat;
    private Getraenkeautomat<AlkoholfreiesGetraenk> alkoholfreieGetraenkeautomat;
    private Getraenkeautomat<Wasser> wasserGetraenkeautomat;
    private Getraenkeautomat<Softdrink> softdrinkGetraenkeautomat;
    private Getraenkeautomat<Bier> bierGetraenkeautomat;
    private Getraenkeautomat<Wein> weinGetraenkeautomat;
    private Getraenkeautomat<Rotwein> rotweinGetraenkeautomat;
    private Getraenkeautomat<Weisswein> weissweinGetraenkeautomat;

    /**
     * Konstanten anlegen fuer einfache zahlen menueeingabe im terminal
     */
    private static final int GETRAENKAUTOMAT_INSTANZIIEREN  = 1;
    private static final int GETRAENKAUTOMATEN_ZEIGEN       = 2;
    private static final int GETRAENKAUTOMAT_FUELLEN        = 3;
    private static final int GETRAENK_BESTELLEN             = 4;
    // private static final int SUM                  = 5;
    // private static final int SWIRL                = 6;
    // private static final int DIVIDE               = 7;
    // private static final int SUBSTRACT            = 8;
    // private static final int AVERAGE              = 9;
    private static final int PROGRAMM_ENDE        = 0;

    /**
     * String konstanten fuer jeden Menue punkt --> uebersichtlichkeit im code
     */
    private static final String GETRAENKAUTOMAT_INSTANZIIEREN_STR   = " : GetraenkAutomat instanziieren";
    private static final String GETRAENKAUTOMATEN_ZEIGEN_STR        = " : GetraenkeAutomat Flotten zeigen";
    private static final String GETRAENKAUTOMAT_FUELLEN_STR         = " : GetraenkeAutomat von Flasche fuellen";
    private static final String GETRAENK_BESTELLEN_STR              = " : Getraenk bestellen";
    
    // private static final String SUM_STR                 = " : Getraenk trinken";
    // private static final String SWIRL_STR               = " : Swirl";
    // private static final String DIVIDE_STR              = " : Divide";
    // private static final String SUBSTRACT_STR           = " : Substract";
    // private static final String AVERAGE_STR             = " : Average";
    private static final String PROGRAMM_ENDE_STR                   = " : Programm beenden";
    
    
    
    /**
     * Konstanten anlegen fuer einfache zahlen menueeingabe im terminal
     */ 
    private static final int GA                   = 1;
    private static final int ALKOHOLFREIES_GA     = 2;
    private static final int ALKOHOLISCHES_GA     = 3;
    private static final int WASSER_GA            = 4;
    private static final int SOFTDRINK_GA         = 5;
    private static final int BIER                 = 6;
    private static final int WEIN                 = 7;
    private static final int ROTWEIN              = 8;
    private static final int WEISWEIN             = 9;

    /**
    * String konstanten fuer jeden Getraenkautomat Menue punkt --> uebersichtlichkeit im code
    */
    private static final String GA_STR                   = " : GetraenkAutomat anlegen";
    private static final String ALKOHOLFREIES_GA_STR     = " : Alkoholfreies GetraenkeAutomat anlegen";
    private static final String ALKOHOLISCHES_GA_STR     = " : Alkoholisches GetraenkeAutomat anlegen";
    private static final String WASSER_GA_STR            = " : Wasser GetraenkeAutomat anlegen";
    private static final String SOFTDRINK_GA_STR         = " : Softdrink GetraenkeAutomat anlegen";
    private static final String BIER_STR                 = " : Bier GetraenkeAutomat anlegen";
    private static final String WEIN_STR                 = " : Wein GetraenkeAutomat anlegen";
    private static final String ROTWEIN_STR              = " : Rotwein GetraenkeAutomat anlegen";
    private static final String WEISWEIN_STR             = " : Weisswein GetraenkeAutomat anlegen";
    private static final String GA_PROGRAMM_ENDE_STR        = " : Zurueck zur Hauptmenue";
    

    /**
    * Fuer die durchfuerung des operationen 
    */
    // private Getraenkeautomat<

    /**
     * Scanner objekt erstellen des Typs Input
     */
    public Dialog(){
        input = new Scanner(System.in);
    }

    /**
     * do while schleife zum starten des Programms
     */
    public void dialogStart(int dialogNumber){
        int befehl = 0;

        do{
            try{
                if(dialogNumber == 1){
                    menueAnzeigen();
                    befehl = funktionVerarbeitung();
                    funktionAusfuehrung(befehl);
                } else if(dialogNumber == 2){
                    GAutomatMenueAnzeigen();
                    befehl = funktionVerarbeitung();
                    GAutomatfunktionAusfuehrung(befehl);
                }
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
            GETRAENKAUTOMAT_INSTANZIIEREN   + GETRAENKAUTOMAT_INSTANZIIEREN_STR     + "\n" +
            GETRAENKAUTOMATEN_ZEIGEN        + GETRAENKAUTOMATEN_ZEIGEN_STR          + "\n" +
            GETRAENKAUTOMAT_FUELLEN         + GETRAENKAUTOMAT_FUELLEN_STR           + "\n" +
            GETRAENK_BESTELLEN              + GETRAENK_BESTELLEN_STR                + "\n" +
            PROGRAMM_ENDE                   + PROGRAMM_ENDE_STR                     + "\n" +
            "Geben Sie eine der angegebenen Zahlen ein : "
        );
    }
    /**
     * Methode zeigt das Getraenkautomat Menue an
     */
    public void GAutomatMenueAnzeigen(){

        System.out.print("\n\n\n" +
            GA                 + GA_STR                  + "\n" +
            ALKOHOLFREIES_GA   + ALKOHOLFREIES_GA_STR    + "\n" +
            ALKOHOLISCHES_GA   + ALKOHOLISCHES_GA_STR    + "\n" +
            WASSER_GA          + WASSER_GA_STR           + "\n" +
            SOFTDRINK_GA       + SOFTDRINK_GA_STR        + "\n" +
            BIER               + BIER_STR                + "\n" +
            WEIN               + WEIN_STR                + "\n" +
            ROTWEIN            + ROTWEIN_STR             + "\n" +
            WEISWEIN           + WEISWEIN_STR            + "\n" +
            PROGRAMM_ENDE      + GA_PROGRAMM_ENDE_STR    + "\n" +
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
        if(befehl > GETRAENK_BESTELLEN || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch (befehl) {
                case GETRAENKAUTOMAT_INSTANZIIEREN:
                    dialogStart(2);
                    break;
                case GETRAENKAUTOMATEN_ZEIGEN:
                    // zahlenRandomGenerieren();
                    break;
                case GETRAENKAUTOMAT_FUELLEN:
                    // arrayAnzeigen(floatZahlenArr);
                    break;
                case GETRAENK_BESTELLEN:
                    // selbeArrayWiederBenutzen();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }
    /**
     * Methode zur Ausführung der Nutzereingabe der Menuepunkte
     * @param befehl ist der nummer der zu eine rufe von methode fuehrt
     */
    public void GAutomatfunktionAusfuehrung(int befehl){
        if(befehl > WEISWEIN || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else if (befehl == PROGRAMM_ENDE){
            System.out.println("Zurueck zur Hauptmenue");
        } else {
            int kapazitaet = GAutomatKapazitaetAusgeben();
            switch (befehl) {
                case GA:
                    getraenkeautomat = new Getraenkeautomat<Getraenk>(kapazitaet);
                    getraenkeautomatArray.add(getraenkeautomat);
                    break;
                case ALKOHOLFREIES_GA:
                    alkoholischeGetraenkeautomat = new Getraenkeautomat<AlkoholischesGetraenk>(kapazitaet);
                    getraenkeautomatArray.add(alkoholischeGetraenkeautomat);
                    for(int i = 0; i < getraenkeautomatArray.size(); i++){
                        // System.out.println(getraenkeautomatArray.get(i));
                        System.out.println(getraenkeautomatArray.toString());
                        System.out.println("getType = " + getType(getraenkeautomatArray.get(i)));
                        
                    }
                    System.out.println(getraenkeautomatArray.toString());

                    break;
                case ALKOHOLISCHES_GA:
                    alkoholfreieGetraenkeautomat = new Getraenkeautomat<AlkoholfreiesGetraenk>(kapazitaet);
                    break;
                case WASSER_GA:
                    wasserGetraenkeautomat = new Getraenkeautomat<Wasser>(kapazitaet);
                    break;
                case SOFTDRINK_GA:
                    softdrinkGetraenkeautomat = new Getraenkeautomat<Softdrink>(kapazitaet);
                    break;
                case BIER:
                    bierGetraenkeautomat = new Getraenkeautomat<Bier>(kapazitaet);
                    break;
                case WEIN:
                    weinGetraenkeautomat = new Getraenkeautomat<Wein>(kapazitaet);
                    break;
                case ROTWEIN:
                    rotweinGetraenkeautomat = new Getraenkeautomat<Rotwein>(kapazitaet);
                    break;
                case WEISWEIN:
                    weissweinGetraenkeautomat = new Getraenkeautomat<Weisswein>(kapazitaet);
                    break;
            }
        }
    }

    public static String getType(Getraenkeautomat<?> automaten) {
        return automaten.getClass().getSimpleName();
    }

    public int GAutomatKapazitaetAusgeben(){
        System.out.println("Geben sie die Kapazitaet des Getraekautomat als naturlische zahl ein :");
        int kapazitaet = input.nextInt();
        input.nextLine();
        return kapazitaet;
    }
    /**
     * Methode die fragt der User um den array mit float Zahlen einzufuehlen
     */
    // public void GetraenkautomatIstanziieren() {
            


        // Getraenkeautomat<GAutomatTyp> automat = new Getraenkeautomat<>(20);
        // if(floatZahlenArr == null){
        //     // Eingabe des Groesse des Array
        //     System.out.println("Anzahl von zahlen, die Sie eingeben moechten : ");
        //     floatZahlenGroesse = input.nextInt();
        //     input.nextLine();

        //     floatZahlenArr = new float[floatZahlenGroesse];
        //     speichernArr = new float[floatZahlenGroesse];

        //     // Eingabe des float zahen die des Arrays einfuellen werden
        //     for(int i = 0; i < floatZahlenGroesse; i++){
        //         System.out.println("Geben Sie der " + (i + 1) + " float zahl ein : ");
        //         float floatZahl = input.nextFloat();
        //         input.nextLine();

        //         speichernArr[i] = floatZahl;
        //         floatZahlenArr[i] = floatZahl;
        //     }
        //     System.out.println("Das Array die hergestelt wurde : ");
        //     arrayAnzeigen(floatZahlenArr);

        // } else {
        //     // Eingabe zum wissen ob das Array ueberschreiben soll oder nicht
        //     System.out.println("Es existiert schon eine Array, wollen Sie es überschreiben ? [Y/n] : ");
        //     String antwortArrayUberschreiben = input.next();
        //     input.nextLine();

        //     if(antwortArrayUberschreiben.equals("Y")){
        //         floatZahlenArr = null;
        //         zahlenManuelGeben();
        //     } else {
        //         System.out.println("Das Array wurde nicht uebergeschrieben");
        //     }
        // }
    //}

    // /**
    //  * Methode die fragt der User der groesse des Arrays, und fuehlt die mit Random float zahlen zwischen 0 und 100
    //  */
    // public void zahlenRandomGenerieren(){
    //     if(floatZahlenArr == null){
            
    //         // Eingabe des Groesse des Array
    //         System.out.println("Anzahl von zahlen, die werden generiert und in das Array gegeben : ");
    //         floatZahlenGroesse = input.nextInt();
    //         input.nextLine();

    //         floatZahlenArr = new float[floatZahlenGroesse];
    //         speichernArr = new float[floatZahlenGroesse];

    //         // Generation von random float Zahlen die des Arrays fuehlen werden
    //         for(int i = 0; i < floatZahlenGroesse; i++){
    //             Random randomZahl = new Random();
    //             float randomFloat = randomZahl.nextFloat(0,100);

    //             speichernArr[i] = randomFloat;
    //             floatZahlenArr[i] = randomFloat;
    //         } 
    //         System.out.println("Das Array die hergestelt wurde : ");
    //         arrayAnzeigen(floatZahlenArr);

    //     } else {
    //         // Eingabe zum wissen ob das Array ueberschreiben soll oder nicht
    //         System.out.println("Es existiert schon eine Array, wollen Sie es überschreiben ? [Y/n] : ");
    //         String antwortArrayUberschreiben = input.next();
    //         input.nextLine();

    //         if(antwortArrayUberschreiben.equals("Y")){
    //             floatZahlenArr = null;
    //             zahlenRandomGenerieren();
    //         } else {
    //             System.out.println("Das Array wurde nicht uebergeschrieben");
    //         }
    //     }
    // }

    // public void selbeArrayWiederBenutzen(){

    //     floatZahlenArr = new float[floatZahlenGroesse];
    //     for(int i = 0; i < floatZahlenGroesse; i++){
    //         floatZahlenArr[i] = speichernArr[i];
    //     }
    //     System.out.println("Die letzte Array die Sie eingegeben oder generieren haben, wurde wieder gestelt : ");
    //     arrayAnzeigen(floatZahlenArr);
    // }

    
    // /**
    //  * Methode die die Methode Sum in das NumberCruncherTopLevel datei ruft und 
    //  * die Summe dis elemente des Array rechnet
    //  */

    // public void summe(){
    //     // Summe in NumberCruncherTopLevel rechnen
    //     NumberCruncherTopLevel.Sum sum = new NumberCruncherTopLevel(floatZahlenArr).new Sum();
    //     sum.crunch(floatZahlenArr);

    //     operationsErgebnis(floatZahlenArr);
    // }
    
    // /**
    //  * Methode die die Methode Swirl in das NumberCruncherTopLevel datei ruft und 
    //  * die die platz von den element das Array tauscht
    //  */
    // public void swirl(){
    //     // Swirl in NumberCruncherTopLevel rechnen
    //     NumberCruncherTopLevel.Swirl swirl = new NumberCruncherTopLevel(floatZahlenArr).new Swirl();
    //     swirl.crunch(floatZahlenArr);

    //     operationsErgebnis(floatZahlenArr);
    // }

    // /**
    //  * Methode die die Methode divide in das NumberCruncherTopLevel datei ruft und 
    //  * die die n/2 groeßten Werte im Array durch die n/2 Kleinsten teilen (wo n die lange des Array ist)
    //  */
    // public void divide(){
    //     // Divide in NumberCruncherTopLevel rechnen
    //     NumberCruncherTopLevel.Divide divide = new NumberCruncherTopLevel(floatZahlenArr).new Divide();
    //     divide.crunch(floatZahlenArr);

    //     operationsErgebnis(floatZahlenArr);
    // }

    // /**
    //  * Methode die die Methode substract in das NumberCruncherTopLevel datei ruft und 
    //  * die elemente des Arrays subraiert
    //  */
    // public void substract(){
    //     // Substract in NumberCruncherTopLevel rechnen
    //     NumberCruncherTopLevel.Substract substract = new NumberCruncherTopLevel(floatZahlenArr).new Substract();
    //     substract.crunch(floatZahlenArr);

    //     operationsErgebnis(floatZahlenArr);
    // }

    // /**
    //  * Methode die die Methode average in das NumberCruncherTopLevel datei ruft und 
    //  * das average von die elemente in das Array rechnet
    //  */
    // public void average(){
    //     // Average in NumberCruncherTopLevel rechnen
    //     NumberCruncherTopLevel.Average average = new NumberCruncherTopLevel(floatZahlenArr).new Average();
    //     average.crunch(floatZahlenArr);

    //     operationsErgebnis(floatZahlenArr);
        
    //     float cruncherAverage = average.getAverage();
    //     System.out.println("Und das Average Zahl ist : " + cruncherAverage);
    // }


    // /**
    //  * Methode die zeigt jedes item des Arrays
    //  */
    // public void arrayAnzeigen(float[] array){
    //     System.out.print("[");
    //     for(int i = 0; i < (array.length - 1); i++){
    //         System.out.print(array[i] + ", ");
    //     }
    //     System.out.println(array[array.length - 1] + "]");
    // }

    // /**
    //  * Methode die das ergebnis bekommt und mittels arrayAnzeigen ausgibt
    //  */
    // public void operationsErgebnis(float[] array){
    //     cruncher = new NumberCruncherTopLevel(floatZahlenArr);
    //     float[] cruncherZahlen = cruncher.getNumbers();
    //     System.out.println("Die Array ausgabe ist : ");
    //     arrayAnzeigen(cruncherZahlen);
    // }
    /**
     * Funktion zum Starten des Dialogs
     * @param args argumenten Array
     */
    public static void main(String[] args) {
        new Dialog().dialogStart(1);
    }
}