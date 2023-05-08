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
    ArrayList<Getraenkeautomat<? extends Getraenk>> getraenkeautomatArray = new ArrayList<>();


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
    private static final int PROGRAMM_ENDE        = 0;

    /**
     * String konstanten fuer jeden Menue punkt --> uebersichtlichkeit im code
     */
    private static final String GETRAENKAUTOMAT_INSTANZIIEREN_STR   = " : GetraenkAutomat instanziieren";
    private static final String GETRAENKAUTOMATEN_ZEIGEN_STR        = " : GetraenkeAutomat Flotten zeigen";
    private static final String GETRAENKAUTOMAT_FUELLEN_STR         = " : GetraenkeAutomat von Flasche fuellen";
    private static final String GETRAENK_BESTELLEN_STR              = " : Getraenk bestellen";
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
                    getraenkeautomatenZeigen();
                    break;
                case GETRAENKAUTOMAT_FUELLEN:
                    
                    break;
                case GETRAENK_BESTELLEN:
                    
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
                    break;
                case ALKOHOLISCHES_GA:
                    alkoholfreieGetraenkeautomat = new Getraenkeautomat<AlkoholfreiesGetraenk>(kapazitaet);
                    getraenkeautomatArray.add(alkoholfreieGetraenkeautomat);
                    break;
                case WASSER_GA:
                    wasserGetraenkeautomat = new Getraenkeautomat<Wasser>(kapazitaet);
                    getraenkeautomatArray.add(wasserGetraenkeautomat);
                    break;
                case SOFTDRINK_GA:
                    softdrinkGetraenkeautomat = new Getraenkeautomat<Softdrink>(kapazitaet);
                    getraenkeautomatArray.add(softdrinkGetraenkeautomat);
                    break;
                case BIER:
                    bierGetraenkeautomat = new Getraenkeautomat<Bier>(kapazitaet);
                    getraenkeautomatArray.add(bierGetraenkeautomat);
                    break;
                case WEIN:
                    weinGetraenkeautomat = new Getraenkeautomat<Wein>(kapazitaet);
                    getraenkeautomatArray.add(weinGetraenkeautomat);
                    break;
                case ROTWEIN:
                    rotweinGetraenkeautomat = new Getraenkeautomat<Rotwein>(kapazitaet);
                    getraenkeautomatArray.add(rotweinGetraenkeautomat);
                    break;
                case WEISWEIN:
                    weissweinGetraenkeautomat = new Getraenkeautomat<Weisswein>(kapazitaet);
                    getraenkeautomatArray.add(weissweinGetraenkeautomat);
                    break;
            }
        }
    }


    public int GAutomatKapazitaetAusgeben(){
        System.out.println("Geben sie die Kapazitaet des Getraekautomat als naturlische zahl ein :");
        int kapazitaet = input.nextInt();
        input.nextLine();
        return kapazitaet;
    }

    public void getraenkeautomatenZeigen(){
        for(int i = 0; i < getraenkeautomatArray.size(); i++){
            System.out.println(getraenkeautomatArray.get(i).toString());
        }
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args argumenten Array
     */
    public static void main(String[] args) {
        new Dialog().dialogStart(1);
    }
}