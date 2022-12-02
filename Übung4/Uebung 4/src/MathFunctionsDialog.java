import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Dialogklasse zum interaktiven Testen der Klasse Mathematikklasse
 * @author Elisee Brand, Leopold Mittelberger
 */

public class MathFunctionsDialog {
    private final Scanner input;
    private static final int TEILER_SUMME            = 1;
    private static final int ISBN                    = 2;
    private static final int QUADRATISCHE_GLEICHUNG  = 3;
    private static final int SUMME_VON_POTENZ        = 4;
    private static final int GGT                     = 5;
    private static final int FAKULTAET               = 6;
    private static final int REIHENSUMME             = 7;
    private static final int PROGRAMM_ENDE           = 0;

    /**
     * Erstellen von Scannerobjekt zum Einlesen der
     * Werte des Benutzers
     */
    public MathFunctionsDialog() {

        input = new Scanner(System.in);
    }


    /**
     * Hauptschleife des Dialogs mit dem Benutzer zum Starten des Programms.
     * Fehlerhafte Eingaben werden hier aufgefangen
     */
    public void dialogStart() {
        int befehl = 0;
        do {
            try {
                menueAnzeigen();
                befehl = funktionVerarbeitung();
                funktionAusfuehrung(befehl);

            } catch(IllegalArgumentException e) {
                System.out.println(e);

            } catch(InputMismatchException e) {
                System.out.println("Geben Sie eine gueltige Zahl des gewollten Datentypen ein!");
                input.nextLine();

            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);

            }
        } while (befehl != PROGRAMM_ENDE);

    }

    /**
     * Gibt das Menue aus
     */
    public void menueAnzeigen(){
        System.out.print("\n" +
                TEILER_SUMME             + ": Teilersumme berechnen\n" +
                ISBN                     + ": ISBN Check\n" +
                QUADRATISCHE_GLEICHUNG   + ": Quadratische Gleichung berechnen\n" +
                SUMME_VON_POTENZ         + ": Summe von Potenz berechnen\n" +
                GGT                      + ": GGT berechnen\n" +
                FAKULTAET                + ": Fakultaet berechnen\n" +
                REIHENSUMME              + ": Reihensumme berechnen\n" +
                PROGRAMM_ENDE            + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }

    /**
     * Verarbeitet Eingabe des Benutzers und gibt den Wert als Int zurueck
     * @return gibt die jeweilige Nummer des Befehls wieder
     */
    public int funktionVerarbeitung() {
        int befehl = input.nextInt();
        return befehl;
    }

    /**
     * Fuehrt die jeweilige Funktion aus, die vom Benutzer gewaehlt wurde.
     * @param befehl ist die Nummer des jeweiligen Befehls
     */
    public void funktionAusfuehrung(int befehl) {
        if(befehl > REIHENSUMME || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case TEILER_SUMME:
                    berechneTeilersummeAusfuerhung();
                    break;
                case ISBN:
                    berechneChecksummeIsbnAusfuehrung();
                    break;
                case QUADRATISCHE_GLEICHUNG:
                    berechneNullstellenAusfuehrung();
                    break;
                case SUMME_VON_POTENZ:
                    istSummeVonPotenzenAusfuerhung();
                    break;
                case GGT:
                    berechneGgtAusfuehrung();
                    break;
                case FAKULTAET:
                    berechneFakultaetAusfuehrung();
                    break;
                case REIHENSUMME:
                    berechneReihensummeAusfuehrung();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }
    /**
     * Nimmt Eingabe des Benutzers entgegen und ruft die Funktion "berechneTeilersumme" auf
     */
    public void berechneTeilersummeAusfuerhung() {

        System.out.println("Geben Sie eine Zahl ein: ");
        long inputZahl = input.nextLong();

        System.out.println(MathFunctions.berechneTeilersumme(inputZahl));
    }

    /**
     * Nimmt Eingabe des Benutzers entgegen und ruft die Funktion "berechneChecksummeIsbn" auf
     */
    public void berechneChecksummeIsbnAusfuehrung () {
        System.out.println("Geben Sie Ihre ISBN ein: ");
        long isbn = input.nextLong();

        System.out.println(MathFunctions.berechneChecksummeIsbn(isbn));
    }

    /**
     * Nimmt 3 Zahlen des Benutzers entgegen und ruft die Funktion "berechneNullstellen"
     * mit diesen Zahlen als Parameter auf
     */
    public void berechneNullstellenAusfuehrung() {
        System.out.println("Bitte waehlen sie die werte von p und q ein:");
        System.out.println("x**2 + px + q = 0");

        System.out.println("Geben Sie einen Wert fuer p ein: ");
        double p = input.nextDouble();

        System.out.println("Geben Sie einen Wert fuer q ein: ");
        double q = input.nextDouble();

        System.out.println(MathFunctions.berechneNullstellen(p, q));
    }
    /**
     * Nimmt Eingabe des Benutzers entgegen und ruft die Funktion "berechneTeilersumme" auf
     */
    public void istSummeVonPotenzenAusfuerhung() {
        System.out.println("Geben Sie eine Zahl ein: ");
        long inputZahl = input.nextLong();

        System.out.println(MathFunctions.istSummeVonPotenzen(inputZahl));
    }

    /**
     * Nimmt Eingabe des Benutzers entgegen und ruft die Funktion "berechneGgt" auf
     */
    public void berechneGgtAusfuehrung () {
        System.out.println("Geben Sie 2 zahlen ein (int): ");
        int zahl1 = input.nextInt();
        int zahl2 = input.nextInt();
        System.out.println(MathFunctions.berechneGgt(zahl1, zahl2));
    }

    /**
     * Nimmt 3 Zahlen des Benutzers entgegen und ruft die Funktion "berechneFakultaet"
     * mit diesen Zahlen als Parameter auf
     */
    public void berechneFakultaetAusfuehrung() {
        System.out.println("Geben Sie ein zahl ein (int): ");
        int zahl = input.nextInt();
        System.out.println(MathFunctions.berechneFakultaet(zahl));
    }

    /**
     * Nimmt Eingabe des Benutzers entgegen und ruft die Funktion "berechneReihensumme" auf
     */
    public void berechneReihensummeAusfuehrung() {
        System.out.println("Bitte waehlen sie die werte von anzahl (int) und x (zahl ein:");
        int anzahl = input.nextInt();
        double x = input.nextDouble();

        System.out.println(MathFunctions.berechneReihensumme(anzahl, x));
    }

    /**
     * Starten des Dialogs
     */
    public static void main(String args[]) {
        new MathFunctionsDialog().dialogStart();
    }
}