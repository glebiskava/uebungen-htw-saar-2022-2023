import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class LagerDialog {
    private static Artikel artikel;
    private static Scanner input;
    private static Lager lager;

    /**
     * Benutzer soll anhand von Zahlen die gewuenschten input aus.
     * Dazu werden Konstanten zu jeder Methoden und zu jedem Setter erstellt,
     * um den Code uebersichtlich zu strukturieren.
     * static: wird von allen Objekten der gleichen Klasse geteilt.
     * final: einmal die Variable initialisiert kann sie nicht mehr geaendert werden.
     */
    private static final int LAGER_ANLEGEN                 = 1;
    private static final int ARTIKEL_ANLEGEN               = 2;
    private static final int ARTIKEL_ENTFERNEN             = 3;
    private static final int BUCHE_ZUGANG                  = 4;
    private static final int BUCHE_ABGANG                  = 5;
    private static final int PREIS_ARTIKELS_AENDERN        = 6;
    private static final int PREIS_ALLER_ARTIKELS_AENDERN  = 7;
    private static final int GET_ARTIKEL                   = 8;
    private static final int TO_STRING                     = 9;
    private static final int GET_ARTIKEL_ANZAHL            = 10;
    private static final int GET_LAGER_GROESSE             = 11;
    private static final int PROGRAMM_ENDE                 = 0;

    /**
     * Erstellen von leeren Objekten und einem 1
     * Scannerobjekt zum Einlesen der
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
        lager = null;
        int befehl = 0;

        do {
            try {
                menue();
                befehl = funktionVerarbeitung();
                funktionAusfuehrung(befehl);

            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
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
    public void menue(){
        System.out.print("\n\n\n" +
                LAGER_ANLEGEN                   + ": Lager anlegen\n" +
                ARTIKEL_ANLEGEN                 + ": Artikel anlegen\n" +
                ARTIKEL_ENTFERNEN               + ": Artikel entfernen\n"    +
                BUCHE_ZUGANG                    + ": Zugang buchen\n" +
                BUCHE_ABGANG                    + ": Abgang buchen\n"  +
                PREIS_ARTIKELS_AENDERN          + ": Preis des Artikels aendern\n" +
                PREIS_ALLER_ARTIKELS_AENDERN    + ": Preis aller Artikeln aendern\n" +
                GET_ARTIKEL                     + ": Get Artikel, als string\n" +
                TO_STRING                       + ": Ausgabe als String\n" +
                GET_ARTIKEL_ANZAHL              + ": Get artikel anzahl\n" +
                GET_LAGER_GROESSE               + ": Get lager groesse\n" +
                PROGRAMM_ENDE                   + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }

    /**
     * Verarbeitet Eingabe des Benutzers und gibt den Wert als Int zurueck
     */
    public int funktionVerarbeitung() {
        int befehl = input.nextInt();
        input.nextLine();
        return befehl;
    }

    /**
     * Fuehrt die jeweilige Funktion aus, die vom Benutzer gewaehlt wurde.
     * @param befehl ist die Nummer des jeweiligen Befehls
     */
    public void funktionAusfuehrung(int befehl) {
        if(befehl > GET_LAGER_GROESSE || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case LAGER_ANLEGEN:
                    lagerAnlegen();
                    break;
                case ARTIKEL_ANLEGEN:
                    artikelAnlegen();
                    break;
                case ARTIKEL_ENTFERNEN:
                    artikelEntfernen();
                    break;
                case BUCHE_ZUGANG:
                    bucheZugang();
                    break;
                case BUCHE_ABGANG:
                    bucheAbgang();
                    break;
                case PREIS_ARTIKELS_AENDERN:
                    aenderePreisEinesArtikels();
                    break;
                case PREIS_ALLER_ARTIKELS_AENDERN:
                    aenderePreisAllerArtikel();
                    break;
                case GET_ARTIKEL:
                    artikelAusgeben();
                    break;
                case TO_STRING:
                    alsString();
                    break;
                case GET_ARTIKEL_ANZAHL:
                    getArtikelAnzahl();
                    break;
                case GET_LAGER_GROESSE:
                    getLagerGroesse();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }

    /**
     * legt ein neues Lager an
     */
    public static void lagerAnlegen() {
        if(lager != null) {
            System.out.println("Es existiert schon ein Lager. Nutzen Sie es!");
        } else {
            System.out.println("Geben sie die Laenge des Lagers ein: ");
            int size = input.nextInt();
            input.nextLine();

            if (size <= 0){
                lager = new Lager();
            } else {
                lager = new Lager (size);
            }
            Lager.legeAnArtikel(artikel);
        }
    }
    /**
     * legt einen neuen Artikel an mit den selbstgewaehlten Werten des Benutzers.
     */
    public void artikelAnlegen() {
        if(lager == null) {
            System.out.println("Es existiert noch kein Lager. Legen Sie eins an!");
        } else {
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

            Lager.legeAnArtikel(artikel);
        }
    }

    /**
     * entfernt einen Artikel
     */
    public void artikelEntfernen() {
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie erst einen neuen an.");
        } else {
            System.out.println("Geben Sie einen die Artikelnummer ein von \n" +
                    "dem Artikel den sie loeschen wollen: ");
            int artikelNr = input.nextInt();
            Lager.entferneArtikel(artikelNr);
        }
    }

    /**
     * erhoeht Artikelbestand um eine vom Nutzer selbst ausgewaehlte Menge
     */
    public void bucheZugang(){
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie die Artikelnummer an: ");
            int artikelNr = input.nextInt();

            System.out.println("Wie viel soll abgebucht werden?\n" +
                    "Geben Sie einen Wert ein: ");
            int zugang = input.nextInt();

            Lager.bucheZugang(artikelNr, zugang);
        }
    }
    /**
     * Vermindert Artikelbestand um eine vom Nutzer selbst ausgewaehlte Menge
     */
    public void bucheAbgang() {
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie die Artikelnummer an: ");
            int artikelNr = input.nextInt();

            System.out.println("Wie viel soll abgebucht werden?\n" +
                    "Geben Sie einen Wert ein:  ");
            int abgang = input.nextInt();

            Lager.bucheAbgang(artikelNr, abgang);
        }
    }

    /**
     * erhoeht Preis eines bestimmten artikels
     */
    public void aenderePreisEinesArtikels() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie die Artikelnummer an: ");
            int artikelNr = input.nextInt();

            System.out.println("Um wei viel Prozent soll der Preis erhoeht werden?\n" +
                    "Geben Sie einen Wert ein: ");
            double prozent = input.nextDouble();

            Lager.aenderePreisEinesArtikels(artikelNr, prozent);
        }
    }

    /**
     * erhoeht Preis aller Artikel um einen bestimmten Prozentsatz
     */
    public void aenderePreisAllerArtikel() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Um wie viel Prozent soll der Preis erhoeht werden?\n" +
                    "Geben Sie einen Wert ein: ");
            double prozent = input.nextDouble();
            Lager.aenderePreisAllerArtikel(prozent);
        }
    }

    /**
     * gibt einen Artikel als String aus
     */
    public void artikelAusgeben() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie einen Index ein: ");

            int index = input.nextInt();
            System.out.println(Lager.getArtikel(index));
        }
    }

    /**
     * verarbeitet und gibt alle Artikel als String aus
     */
    public void alsString() {

        System.out.println(lager.toString());
    }

    /**
     * gibt die anzahl der im Lager vorhandenen Artikel wieder
     */
    public void getArtikelAnzahl() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Anzahl der Artikel im Lager : " + Lager.getArtikelAnzahl());

        }
    }

    /**
     * gibt die Groessse des Lagers wieder
     */
    public void getLagerGroesse(){
        System.out.println("Groesse des Lagers: " + Lager.getLagerGroesse());
    }

    /**
     * Funktion zum Starten des Dialogs
     */
    public static void main(String args[]) {
        new LagerDialog().dialogStart();
    }
}