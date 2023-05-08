import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Léopold Mittelberger Elisee Brand
 * @version 1.0
 *
 * Dies ist eine Klasse zum interaktiven Testen des Getränkeautomaten
 */

public class Dialog {

    /**
     * Scanner objekt initialisieren fuer das einlesen der eingabe im terminal
     */
    private final Scanner input;

    /**
     * Konstanten für die Menüpunkte und für die wiederaufkehrenden Strings
     */
    private static final int GETRAENKEAUTOMAT_INT                   = 1;
    private static final int GETRAENKEAUTOMAT_ALKOHOLISCH_INT       = 2;
    private static final int GETRAENKEAUTOMAT_ALKOHOLFREIE_INT      = 3;
    private static final int GETRAENKEAUTOMAT_WASSER_INT            = 4;
    private static final int GETRAENKEAUTOMAT_SOFTDRINK_INT         = 5;
    private static final int GETRAENKEAUTOMAT_BIER_INT              = 6;
    private static final int GETRAENKEAUTOMAT_WEIN_INT              = 7;
    private static final int GETRAENKEAUTOMAT_ROTWEIN_INT           = 8;
    private static final int GETRAENKEAUTOMAT_WEISSWEIN_INT         = 9;
    private static final int FLASCHE_EINLEGEN_INT                   = 10;
    private static final int FLASCHE_AUSGEBEN_INT                   = 11;
    private static final int GETRAENKE_AUSGEBEN_INT                 = 12;
    private static final int PROGRAMM_ENDE                          = 0;

    private static final String GETRAENKEAUTOMAT_STR                = " : Getraenkeautomat anlegen";
    private static final String GETRAENKEAUTOMAT_ALKOHOLISCH_STR    =
            " : Getraenkeautomat mit alkoholischen Getraenken anlegen";
    private static final String GETRAENKEAUTOMAT_ALKOHOLFREIE_STR   =
            " : Getraenkeautomat mit alkoholfreien Getraenken anlegen";
    private static final String GETRAENKEAUTOMAT_WASSER_STR         = " : Getraenkeautomat mit Wasser anlegen";
    private static final String GETRAENKEAUTOMAT_SOFTDRINK_STR      = " : Getraenkeautomat mit Softdrinks anlegen";
    private static final String GETRAENKEAUTOMAT_BIER_STR           = " : Getraenkeautomat mit Bier anlegen";
    private static final String GETRAENKEAUTOMAT_WEIN_STR           = " : Getraenkeautomat mit Wein anlegen";
    private static final String GETRAENKEAUTOMAT_ROTWEIN_STR        = " : Getraenkeautomat mit Rotwein anlegen";
    private static final String GETRAENKEAUTOMAT_WEISSWEIN_STR      = " : Getraenkeautomat mit Weisswein anlegen";
    private static final String FLASCHE_EINLEGEN_STR                =
            " : Eine Flasche in den Getraenkeautomat einlegen";
    private static final String FLASCHE_AUSGEBEN_STR                =
            " : Eine Flasche aus dem Getraenkeautomat ausgeben";
    private static final String GETRAENKE_AUSGEBEN_STR              = " : Die Getraenke im Getraenkeautomat ausgeben";
    private static final String PROGRAMM_ENDE_STR                   = "ENDE";

    /**
     * erstellen der verschiedenen Getränkeautomaten
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
     * Scanner objekt erstellen des Typs Input
     */
    public Dialog(){
        input = new Scanner(System.in);
    }

    /**
     * do while schleife zum starten des Programms
     */
    public void dialogStart() {
        int befehl = 0;

        do {
            try {
                menueAnzeigen();
                befehl = funktionVerarbeitung();
                funktionAusfuehrung(befehl);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println("Geben Sie eine gueltige Zahl des gewollten Datentypen ein!");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (befehl != PROGRAMM_ENDE);
    }

    /**
     * Methode zeigt das Menue an
     */
    public void menueAnzeigen() {

        System.out.print("\n\n\n" +
                GETRAENKEAUTOMAT_INT                + GETRAENKEAUTOMAT_STR                  + "\n" +
                GETRAENKEAUTOMAT_ALKOHOLISCH_INT    + GETRAENKEAUTOMAT_ALKOHOLISCH_STR      + "\n" +
                GETRAENKEAUTOMAT_ALKOHOLFREIE_INT   + GETRAENKEAUTOMAT_ALKOHOLFREIE_STR     + "\n" +
                GETRAENKEAUTOMAT_WASSER_INT         + GETRAENKEAUTOMAT_WASSER_STR           + "\n" +
                GETRAENKEAUTOMAT_SOFTDRINK_INT      + GETRAENKEAUTOMAT_SOFTDRINK_STR        + "\n" +
                GETRAENKEAUTOMAT_BIER_INT           + GETRAENKEAUTOMAT_BIER_STR             + "\n" +
                GETRAENKEAUTOMAT_WEIN_INT           + GETRAENKEAUTOMAT_WEIN_STR             + "\n" +
                GETRAENKEAUTOMAT_ROTWEIN_INT        + GETRAENKEAUTOMAT_ROTWEIN_STR          + "\n" +
                GETRAENKEAUTOMAT_WEISSWEIN_INT      + GETRAENKEAUTOMAT_WEISSWEIN_STR        + "\n" +
                FLASCHE_EINLEGEN_INT                + FLASCHE_EINLEGEN_STR                  + "\n" +
                FLASCHE_AUSGEBEN_INT                + FLASCHE_AUSGEBEN_STR                  + "\n" +
                GETRAENKE_AUSGEBEN_INT              + GETRAENKE_AUSGEBEN_STR                + "\n" +
                PROGRAMM_ENDE                       + PROGRAMM_ENDE_STR                     + "\n" +
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
     * @param befehl nummer des befehls
     */
    public void funktionAusfuehrung(int befehl) {
        if (befehl > GETRAENKE_AUSGEBEN_INT || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch (befehl) {
                case GETRAENKEAUTOMAT_INT:
                    getraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_ALKOHOLISCH_INT:
                    alkoholischenGetraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_ALKOHOLFREIE_INT:
                    alkoholfreienGetraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_WASSER_INT:
                    wasserGetraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_SOFTDRINK_INT:
                    softdrinkGetraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_BIER_INT:
                    bierGetraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_WEIN_INT:
                    weinGetraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_ROTWEIN_INT:
                    rotweinGetraenkeautomatErstellen();
                    break;
                case GETRAENKEAUTOMAT_WEISSWEIN_INT:
                    weinGetraenkeautomatErstellen();
                    break;
                case FLASCHE_EINLEGEN_INT:
                    flaschEinlegen();
                    break;
                case FLASCHE_AUSGEBEN_INT:
                    flascheAusgeben();
                    break;
                case GETRAENKE_AUSGEBEN_INT:
                    getraenkeAusgeben();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
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
