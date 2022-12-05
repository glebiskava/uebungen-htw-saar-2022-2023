import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class LagerDialog {
    public static Artikel artikel;
    private final Scanner input;
    private Lager lager;

    /**
     * Benutzer soll anhand von Zahlen die gewuenschten input aus.
     * Dazu werden Konstanten zu jeder Methoden und zu jedem Setter erstellt,
     * um den Code uebersichtlich zu strukturieren.
     *
     * static: wird von allen Objekten der gleichen Klasse geteilt.
     * final: einmal die Variable initialisiert kann sie nicht mehr geaendert werden.
     */
    private static final int LAGER_ANLEGEN = 1;
    private static final int STANDARD_LAGER_ANLEGEN = 2;
    private static final int OBJEKT_ANLEGEN_MIT_BESTAND = 3;
    private static final int OBJEKT_ANLEGEN_OHNE_BESTAND = 4;
    private static final int OBJEKT_LOESCHEN = 5;
    private static final int BUCHE_ZUGANG = 6;
    private static final int BUCHE_ABGANG = 7;
    private static final int PREIS_AENDERN_EINES_ARTIKELS = 8;
    private static final int PREIS_AENDERN_ALLER_ARTIKELS = 9;
    private static final int GET_ARTIKEL = 10;
    private static final int TO_STRING = 11;
    private static final int GET_ARTIKEL_ANZAHL = 12;
    private static final int GET_LAGER_GROESSE = 13;
    private static final int PROGRAMM_ENDE = 0;

    /**
     * Erstellen von leeren Objekten und einem Scannerobjekt zum Einlesen der
     * Werte des Benutzers
     */
    public LagerDialog() {
        input = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Dialogs mit dem Benutzer zum Starten des Programms.
     * Fehlerhafte Eingaben werden hier aufgefangen
     */
    public void dialogStart() {
        artikel = null;
        int befehl = 0;

        do {
            try {
                menue();
                befehl = funktionVerarbeitung();
                funktionAusfuehrung(befehl);

            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println("Geben Sie einen Wert ein des gewollten Datentypen ein.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (befehl != PROGRAMM_ENDE);

    }

    /**
     * Gibt das Menue aus
     */
    public void menue() {
        System.out.print("\n\n" +
                LAGER_ANLEGEN                   + ": Lager anlegen\n" +
                STANDARD_LAGER_ANLEGEN          + ": Lager mit Standardgroesse 10 anlegen\n" +
                OBJEKT_ANLEGEN_MIT_BESTAND      + ": Artikel anlegen mit Bestandsattribut\n" +
                OBJEKT_ANLEGEN_OHNE_BESTAND     + ": Artikel anlegen ohne Bestandsattribut\n" +
                OBJEKT_LOESCHEN                 + ": Artikel loeschen\n" +
                BUCHE_ZUGANG                    + ": Artikelbestand eines bestimmten Artikels erhoehen\n" +
                BUCHE_ABGANG                    + ": Artikelbestand eines bestimmten Artikels vermindern\n" +
                PREIS_AENDERN_EINES_ARTIKELS    + ": Preis eines bestimmten Artikels aendern\n" +
                PREIS_AENDERN_ALLER_ARTIKELS    + ": Preis aller Artikel aendern\n" +
                GET_ARTIKEL                     + ": Einen bestimmten Artikel ermitteln\n" +
                GET_ARTIKEL_ANZAHL              + ": Anzahl aller Artikel bestimmen\n" +
                GET_LAGER_GROESSE               + ": Groesse des Lagers anzeigen\n" +
                PROGRAMM_ENDE                   + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }

    /**
     * Verarbeitet Eingabe des Benutzers und gibt den Wert als Int zurueck
     * @return Nummer des Befehls wieder
     */
    public int funktionVerarbeitung() {
        int befehl = input.nextInt();
        input.nextLine();
        return befehl;
    }

    /**
     * Fuehrt die jeweilige Funktion aus, die vom Benutzer gewaehlt wurde.
     *
     * @param befehl Nummer des jeweiligen Befehls
     */
    public void funktionAusfuehrung(int befehl) {
        if (befehl > GET_LAGER_GROESSE || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Nummer ein!");
        } else {
            switch (befehl) {
                case LAGER_ANLEGEN:
                    System.out.println("bite");
                    break;
                case STANDARD_LAGER_ANLEGEN:
                    System.out.println("bite2");
                    break;
                case OBJEKT_ANLEGEN_MIT_BESTAND:
                    artikelAnlegen();
                    break;
            }
        }
    }

    public void artikelAnlegen() {
        System.out.println("Artikelnummer: ");
        int artikelNr = input.nextInt();
        input.nextLine();

        System.out.println("Artikelart (Beschreibung): ");
        String artikelArt = input.next();
        input.nextLine();

        System.out.println("Artikelbestand: ");
        int artikelBestand = input.nextInt();
        input.nextLine();

        System.out.println("Artikelpreis: ");
        double artikelPreis = input.nextDouble();
        input.nextLine();

        artikel = new Artikel(artikelNr, artikelArt, artikelBestand, artikelPreis);
    }

    public static void main (String args[]) {

        new LagerDialog().dialogStart();
    }


}