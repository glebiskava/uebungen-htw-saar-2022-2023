import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Dialogklasse zum interaktiven Testen der Klasse MathFunctions
 * @author Elisee Brand, Leopold Mittelberger

 */

public class MathFunctionsDialog {
    private final Scanner input;
    private static final int TEILER_SUMME = 1;
    private static final int ISBN = 2;
    private static final int QUADRATISCHE_GLEICHUNG = 3;
    private static final int PROGRAMM_ENDE = 0;

    /**
     * Erstellen von leeren Objekten und einem Scannerobjekt zum Einlesen der
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
                e.printStackTrace(System.out);
                break;
            } catch(InputMismatchException e) {
                System.out.println("Geben Sie eine gueltige Zahl ein!");
                e.printStackTrace(System.out);
                break;
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
                break;
            }
        } while (befehl != PROGRAMM_ENDE);

    }

    /**
     * Gibt das Menue aus
     */
    public void menueAnzeigen(){
        System.out.print("\n" +
                TEILER_SUMME + ": Teilersumme berechnen\n" +
                ISBN + ": ISBN Check\n" +
                QUADRATISCHE_GLEICHUNG + ": Quadratische Gleichung berechnen\n" +
                PROGRAMM_ENDE + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
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
        if(befehl > QUADRATISCHE_GLEICHUNG || befehl < PROGRAMM_ENDE) {
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
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }

    /**
     * Nimmt Eingabe des Benutzers entgegen und ruft die Funktion "berechneTeilersumme" auf
     * Prueft auf fehlerhafte Eingaben
     */
    public void berechneTeilersummeAusfuerhung() {
        System.out.println("Geben Sie eine Zahl ein: ");
        long inputZahl = input.nextLong();

        if (inputZahl < 0) {
            throw new IllegalArgumentException("Zahl darf nicht negativ sein!");
        }

        System.out.println(MathFunctions.berechneTeilersumme(inputZahl));
    }

    /**
     * Nimmt Eingabe des Benutzers entgegen und ruft die Funktion "berechneChecksummeIsbnAusfuehrung" auf
     * Prueft auf fehlerhafte Eingaben
     */
    public void berechneChecksummeIsbnAusfuehrung () {
        System.out.println("Geben Sie Ihre ISBN ein: ");
        long isbn = input.nextLong();

        if(isbn < 0) {
            throw new IllegalArgumentException("Zahl darf nicht negativ sein");
        } else if (String.valueOf(isbn).length() > 9 || String.valueOf(isbn).length() < 9) {
            throw new IllegalArgumentException("Zahl muss 9 Ziffern lang sein!");
        }
        System.out.println(MathFunctions.berechneChecksummeIsbn(isbn));
    }

    /**
     * Nimmt 3 Zahlen des Benutzers entgegen und ruft die Funktion "quadratischeGleichungFinden"
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
     * Funktion zum Starten des Dialogs
     */
    public static void main(String args[]) {

        new MathFunctionsDialog().dialogStart();
    }
}