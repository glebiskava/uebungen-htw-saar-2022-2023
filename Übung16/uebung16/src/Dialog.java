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
    int automatWahl = 0;

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
    private static final int FLASCHE_EINLEGEN               = 3;
    private static final int GETRAENK_AUSGEBEN              = 4;
    private static final int PROGRAMM_ENDE                  = 0;

    /**
     * String konstanten fuer jeden Menue punkt --> uebersichtlichkeit im code
     */
    private static final String GETRAENKAUTOMAT_INSTANZIIEREN_STR   = " : GetraenkeAutomat anlegen";
    private static final String GETRAENKAUTOMATEN_ZEIGEN_STR        = " : Alle Getraenkeautomaten anzeigen";
    private static final String FLASCHE_EINLEGEN_STR                = " : Flasche einlegen";
    private static final String GETRAENK_AUSGEBEN_STR               = " : Flasche ausgeben";
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
    private static final int WEISSWEIN            = 9;

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
    private static final String GA_PROGRAMM_ENDE_STR     = " : Zurueck zur Hauptmenue";



    /**
     * Scanner objekt erstellen des Typs Input
     */
    public Dialog(){
        input = new Scanner(System.in);
    }

    /**
     * do while schleife zum Starten des Programms
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
                FLASCHE_EINLEGEN                + FLASCHE_EINLEGEN_STR                  + "\n" +
                GETRAENK_AUSGEBEN               + GETRAENK_AUSGEBEN_STR                 + "\n" +
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
                WEISSWEIN          + WEISWEIN_STR            + "\n" +
                PROGRAMM_ENDE      + GA_PROGRAMM_ENDE_STR    + "\n" +
                "Geben Sie eine der angegebenen Zahlen ein : "
        );
    }

    /**
     * Methode zum Einlesen der Nutzereingabe und Rueckgabe
     * @return Nutzer Eingabe befehl als Int
     */
    public int funktionVerarbeitung(){
        return input.nextInt();
    }

    /**
     * Methode zur Ausführung der Nutzereingabe der Menuepunkte
     * @param befehl nummer des Befehls
     */
    public void funktionAusfuehrung(int befehl){
        if(befehl > GETRAENK_AUSGEBEN || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch (befehl) {
                case GETRAENKAUTOMAT_INSTANZIIEREN:
                    dialogStart(2);
                    break;
                case GETRAENKAUTOMATEN_ZEIGEN:
                    getraenkeautomatenZeigen();
                    break;
                case FLASCHE_EINLEGEN:
                    flascheInBestimmtenAutomatEinlegen();
                    break;
                case GETRAENK_AUSGEBEN:
                    flascheAusgeben();
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
        if(befehl > WEISSWEIN || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else if (befehl == PROGRAMM_ENDE){
            System.out.println("Zurueck zur Hauptmenue");
        } else {
            int kapazitaet = GAutomatKapazitaetEingeben();
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
                case WEISSWEIN:
                    weissweinGetraenkeautomat = new Getraenkeautomat<Weisswein>(kapazitaet);
                    getraenkeautomatArray.add(weissweinGetraenkeautomat);
                    break;
            }
        }
    }

    /**
     * Methode zum Eingeben der Getränkautomatkapazität
     * @return kapazitaet des Automaten
     */
    public int GAutomatKapazitaetEingeben(){
        System.out.println("Geben sie die Kapazitaet des Getraekautomat als naturlische zahl ein :");
        int kapazitaet = input.nextInt();
        input.nextLine();
        return kapazitaet;
    }

    /**
     * Zeigt alle Automaten an mit den jeweiligen Flaschen
     */
    public void getraenkeautomatenZeigen() {
        for (int i = 0; i < getraenkeautomatArray.size(); i++) {
            System.out.println((i + 1) + ". " + getraenkeautomatArray.get(i).toString());
        }
    }

    /**
     * Methode zum Einlegen einer Flasche in einen bestimmten Automaten
     */
    public void flascheInBestimmtenAutomatEinlegen(){
        System.out.println("Geben sie eine zahl aus, ueber die flasche die sie einlegen moechten : ");
        System.out.println(
                        "1 : Wasser"        + "\n" +
                        "2 : Softdrink"     + "\n" +
                        "3 : Bier"          + "\n" +
                        "4 : Wein"          + "\n" +
                        "5 : Rotwein"       + "\n" +
                        "6 : Weisswein"     + "\n" +
                        ">>>>> ");
        int flascheWahl = input.nextInt();
        input.nextLine();

        if(flascheWahl > 6 || flascheWahl < 1) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch (flascheWahl) {
                case 1:
                    wasserAnlegen();
                    break;
                case 2:
                    softdrinkAnlegen();
                    break;
                case 3:
                    bierAnlegen();
                    break;
                case 4:
                    weinAnlegen();
                    break;
                case 5:
                    rotweinAnlegen();
                    break;
                case 6:
                    weissweinAnlegen();
                    break;
            }
        }
    }

    public void flascheAusgeben() {
        automatWahl();
        System.out.println(getraenkeautomatArray.get(automatWahl-1).flascheAusgeben());
    }

    public int  automatWahl() {
        getraenkeautomatenZeigen();
        System.out.println("Geben Sie die Zahl des gewollten Automaten ein : ");
        automatWahl = input.nextInt();
        input.nextLine();

        return automatWahl;
    }

    /**
     * Methode zum Anlegen einer Wasserflasche
     */
    public void wasserAnlegen() {
        String name = nameEingeben();
        double preis = preisEingeben();
        boolean istGesund = istGesundEingeben();
        String marke = markeEingeben();

        Wasser wasser = new Wasser(name, preis, istGesund, marke);
        Flasche<Wasser> wasserFlasche = new Flasche<>();
        wasserFlasche.fuellen(wasser);
        automatWahl();
        getraenkeautomatArray.get(automatWahl - 1).flascheEinlegen(wasserFlasche);
    }

    /**
     * Methode zum Anlegen einer Softdrinkflasche
     */
    public void  softdrinkAnlegen() {
        String name = nameEingeben();
        double preis = preisEingeben();
        boolean istGesund = istGesundEingeben();
        String geschmack = geschmackEingeben();

        Softdrink softdrink = new Softdrink(name, preis, istGesund, geschmack);
        Flasche<Softdrink> softdrinkFlasche = new Flasche<>();
        softdrinkFlasche.fuellen(softdrink);
        automatWahl();
        getraenkeautomatArray.get(automatWahl - 1).flascheEinlegen(softdrinkFlasche);
    }

    /**
     * Methode zum Anlegen einer Bierflasche
     */
    public void bierAnlegen() {
        String name = nameEingeben();
        double preis = preisEingeben();
        double alkGehalt = alkoholgehaltEingeben();

        Bier bier = new Bier(name, preis,  alkGehalt);
        Flasche<Bier> bierFlasche = new Flasche<>();
        bierFlasche.fuellen(bier);
        automatWahl();
        getraenkeautomatArray.get(automatWahl - 1).flascheEinlegen(bierFlasche);
    }

    /**
     * Methode zu Wein anlegen
     */
    public void weinAnlegen() {
        String name = nameEingeben();
        double preis = preisEingeben();
        double alkGehalt = alkoholgehaltEingeben();
        int jahrgang = jahrgangEingeben();

        Wein wein = new Wein(name, preis,  alkGehalt, jahrgang);
        Flasche<Wein> weinFlasche = new Flasche<>();
        weinFlasche.fuellen(wein);
        automatWahl();
        getraenkeautomatArray.get(automatWahl - 1).flascheEinlegen(weinFlasche);
    }

    /**
     * Methode zum Anlegen einer Rotweinflasche
     */
    public void rotweinAnlegen() {
        String name = nameEingeben();
        double preis = preisEingeben();
        double alkGehalt = alkoholgehaltEingeben();
        int jahrgang = jahrgangEingeben();

        Rotwein rotwein = new Rotwein(name, preis,  alkGehalt, jahrgang);
        Flasche<Rotwein> rotweinFlasche = new Flasche<>();
        rotweinFlasche.fuellen(rotwein);
        automatWahl();
        getraenkeautomatArray.get(automatWahl - 1).flascheEinlegen(rotweinFlasche);
    }

    /**
     * Methode zum Anlegen einer Weissweinflasche
     */
    public void weissweinAnlegen() {
        String name = nameEingeben();
        double preis = preisEingeben();
        double alkGehalt = alkoholgehaltEingeben();
        int jahrgang = jahrgangEingeben();
        boolean kaltGestellt = kaltGestelltEingeben();

        Weisswein weisswein = new Weisswein(name, preis,  alkGehalt, jahrgang, kaltGestellt);
        Flasche<Weisswein> weissweinFlasche = new Flasche<>();
        weissweinFlasche.fuellen(weisswein);
        automatWahl();
        getraenkeautomatArray.get(automatWahl - 1).flascheEinlegen(weissweinFlasche);
    }

    /**
     * Methode zum Eingeben des Alkoholgehalts
     */
    public float alkoholgehaltEingeben() {
        System.out.println("Geben sie eine Alkoholgehalt fuer diese Getraenk ein:");
        float alkoholgehaltEingabe = input.nextFloat();
        input.nextLine();

        return alkoholgehaltEingabe;
    }

    /**
     * Methode zum Eingeben des Namens
     */
    public String nameEingeben() {
        System.out.println("Geben sie eine name fuer diese Getraenk ein:");
        String nameEingabe = input.next();
        input.nextLine();

        return nameEingabe;
    }

    /**
     * Methode zum Eingeben des Preises
     */
    public Double preisEingeben() {
        System.out.println("Geben sie eine preis fuer diese Getraenk ein:");
        Double preisEingabe = input.nextDouble();
        input.nextLine();

        return preisEingabe;
    }

    /**
     * Methode zum Eingeben, ob das Getraenk gesund ist
     */
    public Boolean istGesundEingeben() {
        System.out.println("Geben sie eine istGesung fuer diese Getraenk ein:");
        Boolean istGesungEingabe = input.nextBoolean();
        input.nextLine();

        return istGesungEingabe;
    }

    /**
     * Methode zum Eingeben, ob das kaltgestellt ist
     */
    public Boolean kaltGestelltEingeben() {
        System.out.println("Geben sie eine kaltGestellt fuer diese Getraenk ein:");
        Boolean kaltGestelltEingabe = input.nextBoolean();
        input.nextLine();

        return kaltGestelltEingabe;
    }

    /**
     * Methode zum Eingeben des Jahrgangs
     */
    public int jahrgangEingeben() {
        System.out.println("Geben sie eine jahrgang fuer diese Getraenk ein:");
        int jahrgangEingabe = input.nextInt();
        input.nextLine();

        return jahrgangEingabe;
    }

    /**
     * Methode zum Eingeben des Geschmacks
     */
    public String geschmackEingeben() {
        System.out.println("Geben sie eine geschmack fuer diese Getraenk ein:");
        String geschmackEingabe = input.next();
        input.nextLine();

        return geschmackEingabe;
    }

    /**
     * Methode zum Eingeben der Marke
     */
    public String markeEingeben() {
        System.out.println("Geben sie eine marke fuer diese Getraenk ein:");
        String markeEingabe = input.next();
        input.nextLine();

        return markeEingabe;
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args argumenten Array
     */
    public static void main(String[] args) {
        new Dialog().dialogStart(1);
    }
}