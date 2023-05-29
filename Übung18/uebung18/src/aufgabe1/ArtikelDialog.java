package aufgabe1;

import aufgabe1.Artikel;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class ArtikelDialog {
    public static Artikel artikel;
    private Scanner input;

    /**
     * Benutzer soll anhand von Zahlen die gewuenschten input aus.
     * Dazu werden Konstanten zu jeder Methoden und zu jedem Setter erstellt,
     * um den Code uebersichtlich zu strukturieren.
     *
     * static: wird von allen Objekten der gleichen Klasse geteilt.
     * final: einmal die Variable initialisiert kann sie nicht mehr geaendert werden.
     */
    private static final int OBJEKT_ANLEGEN = 1;
    private static final int BUCHE_ZUGANG = 2;
    private static final int BUCHE_ABGANG = 3;
    private static final int TO_STRING = 4;
    private static final int SET_ART = 5;
    private static final int SET_BESTAND = 6;
    private static final int SET_PREIS = 7;
    private static final int PROGRAMM_ENDE = 0;

    /**
     * Erstellen von leeren Objekten und einem Scannerobjekt zum Einlesen der
     * Werte des Benutzers
     */
    public ArtikelDialog() {
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
                OBJEKT_ANLEGEN + ": Artikel anlegen\n" +
                BUCHE_ZUGANG + ": Artikelbestand erhoehen\n"    +
                BUCHE_ABGANG + ": Artikelbestand vermindern\n"  +
                TO_STRING + ": Artikel als Zeichenkette ausgeben\n" +
                SET_ART + ": Art(Beschreibung) des Artikels eingeben/bearbeiten\n" +
                SET_BESTAND + ": Bestand aktualisieren\n" +
                SET_PREIS + ": Preis aktualisieren\n" +
                PROGRAMM_ENDE + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }

    /**
     * Verarbeitet Eingabe des Benutzers und gibt den Wert als Int zurueck
     * @return gibt die jeweilige Nummer des Befehls wieder
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
        if(befehl > SET_PREIS || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Keine gueltige Eingabe!");
        } else {
            switch(befehl) {
                case OBJEKT_ANLEGEN:
                    artikelAnlegen();
                    break;
                case BUCHE_ZUGANG:
                    bucheZugang();
                    break;
                case BUCHE_ABGANG:
                    bucheAbgang();
                    break;
                case TO_STRING:
                    artikelAusgeben();
                    break;
                case SET_ART:
                    eingabeArtikelArt();
                    break;
                case SET_BESTAND:
                    eingabeArtikelBestand();
                    break;
                case SET_PREIS:
                    eingabeArtikelPreis();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }

    /**
     * legt einen neuen Artikel an mit den selbstgewaehlten Werten des Benutzers.
     */
    public void artikelAnlegen() {
        if(artikel != null) {
            System.out.println("Es existiert schon ein Artikel.");
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
        }
    }

    /**
     * Erhoeht Artikelbestand um eine vom Nutzer selbst ausgewaehlte Menge
     */
    public void bucheZugang() {
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie einen Wert ein: ");
            int menge = input.nextInt();
            artikel.bucheZugang(menge);
        }
    }

    /**
     * Vermindert Artikelbestand um eine vom Nutzer selbst ausgewaehlte Menge
     */
    public void bucheAbgang() {
        if (artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie einen Wert ein: ");
            int menge = input.nextInt();
            artikel.bucheAbgang(menge);
        }
    }

    /**
     * Gibt Artikel als Zeichenkette wieder
     */
    public void artikelAusgeben() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println(artikel.toString());
        }
    }

    /**
     * Bearbeitung der Beschreibung (Art) des Artikels
     */
    public void eingabeArtikelArt() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie eine Beschreibung ein: ");
            String artikelArt = input.next();
            artikel.setArt(artikelArt);
        }
    }

    /**
     * Aktualisiert Artikelbestand zum Beispiel bei einer Inventur eines Lagers
     */
    public void eingabeArtikelBestand() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie einen Wert ein: ");
            int artikelBestand = input.nextInt();
            artikel.setBestand(artikelBestand);
        }
    }

    /**
     * funktion zum eingeben des Preises eines artikels
     */
    public void eingabeArtikelPreis() {
        if(artikel == null) {
            System.out.println("Es existiert noch kein Artikel. Legen Sie einen neuen an.");
        } else {
            System.out.println("Geben Sie einen Wert ein: ");
            int artikelPreis = input.nextInt();
            artikel.setPreis(artikelPreis);
        }
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args
     */
    public static void main(String[] args) {

        new ArtikelDialog().dialogStart();
    }
}