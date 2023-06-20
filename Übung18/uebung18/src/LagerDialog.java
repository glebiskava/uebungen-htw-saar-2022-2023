
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class LagerDialog {
    private Artikel artikel;
    private final Scanner input;
    private Lager lager;
    private final Ueb18Fassade fassade = new Ueb18Fassade();

    /**
     * Benutzer soll anhand von Zahlen die gewuenschten input aus.
     * Dazu werden Konstanten zu jeder Methoden und zu jedem Setter erstellt,
     * um den Code uebersichtlich zu strukturieren.
     *
     * static: wird von allen Objekten der gleichen Klasse geteilt.
     * final: einmal die Variable initialisiert kann sie nicht mehr geaendert werden.
     */
    private static final int LAGER_ANLEGEN                  = 1;
    private static final int ARTIKEL_ANLEGEN                = 2;
    private static final int ARTIKEL_ENTFERNEN              = 3;
    private static final int BUCHE_ZUGANG                   = 4;
    private static final int BUCHE_ABGANG                   = 5;
    private static final int PREIS_ARTIKELS_AENDERN         = 6;
    private static final int PREIS_ALLER_ARTIKELS_AENDERN   = 7;
    private static final int GET_ARTIKEL                    = 8;
    private static final int TO_STRING                      = 9;
    private static final int BESCHREIBUNG_ALS_STRING        = 10;
    private static final int GET_ARTIKEL_ANZAHL             = 11;
    private static final int GET_LAGER_GROESSE              = 12;
    private static final int UEB_18_DIALOGUE                = 13;

    private static final int PROGRAMM_ENDE                  = 0;



    private static final int CD_ANLEGEN                     = 1;
    private static final int VIDEO_ANLEGEN                  = 2;
    private static final int BUCH_ANLEGEN                   = 3;
    private static final int ANDERE_ARTIKEL_ANLEGEN         = 4;

    private static final int DIALOG_ARTIKEL_ENDE            = 0;
    
    
    private static final int UEB18_AUFGABE_C_I              = 1;
    private static final int UEB18_AUFGABE_C_II             = 2;
    private static final int UEB18_AUFGABE_C_III            = 3;
    private static final int UEB18_AUFGABE_C_IV             = 4;
    private static final int UEB18_AUFGABE_H_I              = 5;
    private static final int UEB18_AUFGABE_H_II             = 6;
    private static final int UEB18_AUFGABE_H_III            = 7;
    private static final int UEB18_AUFGABE_H_IV             = 8;
    private static final int UEB18_AUFGABE_H_V              = 9;
    private static final int UEB18_AUFGABE_H_VI             = 10;
    private static final int UEB18_TO_STRING_ARTIKEL        = 11;
    
    private static final int UEB18_DIALOGUE_BEENDEN         = 0;


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
        artikel = null;
        int befehl = 0;

        do {
            try {
                menueLager();
                befehl = funktionVerarbeitung();
                funktionLagerAusfuehrung(befehl);
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
    public void menueLager(){
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
                BESCHREIBUNG_ALS_STRING         + ": Beschreibung als String\n" +
                GET_ARTIKEL_ANZAHL              + ": Get artikel anzahl\n" +
                GET_LAGER_GROESSE               + ": Get lager groesse\n\n" +
                UEB_18_DIALOGUE                 + ": Ueb18 dialogue \n\n" +
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
    public void funktionLagerAusfuehrung(int befehl) {
        if(befehl > UEB_18_DIALOGUE || befehl < PROGRAMM_ENDE) {
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
                case BESCHREIBUNG_ALS_STRING:
                    beschreibungAlsString();
                    break;
                case GET_ARTIKEL_ANZAHL:
                    getArtikelAnzahl();
                    break;
                case GET_LAGER_GROESSE:
                    getLagerGroesse();
                    break;
                case UEB_18_DIALOGUE:
                    ueb18DialogueAnzeigen();
                    break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }
        }
    }


    /**
     * gibt das Menü für die Artikel aus
     */
    public void menueArtikel(){
        System.out.print("\n\n\n" +
                CD_ANLEGEN              + ": CD anlegen\n"    +
                VIDEO_ANLEGEN           + ": Video anlegen\n" +
                BUCH_ANLEGEN            + ": Buch anlegen\n"  +
                ANDERE_ARTIKEL_ANLEGEN  + ": Andere artikel anlegen\n"  +
                DIALOG_ARTIKEL_ENDE     + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }

    /**
     * Fuehrt die jeweilige Funktion aus, die vom Benutzer gewaehlt wurde, und das um ein Artikel anzulegen.
     * @param befehl ist die Nummer des jeweiligen Befehls
     */
    public void funktionArtikelAusfuehrung(int befehl) {
        if(befehl > GET_LAGER_GROESSE || befehl < DIALOG_ARTIKEL_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case CD_ANLEGEN:
                    cdAnlegen();
                    break;
                case VIDEO_ANLEGEN:
                    videoAnlegen();
                    break;
                case BUCH_ANLEGEN:
                    buchAnlegen();
                    break;
                case ANDERE_ARTIKEL_ANLEGEN:
                    andereArtikelAnlegen();
                    break;
                case DIALOG_ARTIKEL_ENDE:
                    System.out.println("Hauptmenue, Geben Sie einen Nummer ein: ");
                    break;
            }
        }
    }

    /**
     * gibt das menü aus
     */
    public void menueUeb18(){
        System.out.print("\n\n\n" +
                UEB18_AUFGABE_C_I               + ": Artikel sortieren\n"   +
                UEB18_AUFGABE_C_II              + ": -10% rabat auf jeder artikel\n"  +
                UEB18_AUFGABE_C_III             + ": Suffix (Sonderangebot) an alle artikel hinzufugen\n" +
                UEB18_AUFGABE_C_IV              + ": -10% & suffix (Sonderangebot)\n"  +
                UEB18_AUFGABE_H_I               + ": +10% CD's preise\n"   +
                UEB18_AUFGABE_H_II              + ": bestand <= 2 ==> -5% rabat\n"  +
                UEB18_AUFGABE_H_III             + ": Preis bucher bestimmte Author ==> -5% rabat\n" +
                UEB18_AUFGABE_H_IV              + ": +10% CD's preise && bestand <= 2 ==> -5% rabat\n"  +
                UEB18_AUFGABE_H_V               + ": liste alle bucher die bei Author sortiert sind\n"   +
                UEB18_AUFGABE_H_VI              + ": Bucher filtern bestimmte Author && preis bestimmten bereich liegt\n"  +
                UEB18_TO_STRING_ARTIKEL         + ": Ausgabe als String\n"  +

                DIALOG_ARTIKEL_ENDE             + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }
    /**
     * Fuehrt die jeweilige Funktion aus, die vom Benutzer gewaehlt wurde, und die aufgabe der 18. ueb zu pruefen.
     * @param befehl ist die Nummer des jeweiligen Befehls
     */
    public void funktionUeb18Ausfuehrung(int befehl) {
        if(befehl > UEB18_TO_STRING_ARTIKEL || befehl < UEB18_DIALOGUE_BEENDEN) {
            throw new IllegalArgumentException("Geben Sie eine der angebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case UEB18_AUFGABE_C_I:
                    fassade.aufgabe_c_i(lager);
                    alsString();
                    break;
                case UEB18_AUFGABE_C_II:
                    fassade.aufgabe_c_ii(lager);
                    break;
                case UEB18_AUFGABE_C_III:
                    fassade.aufgabe_c_iii(lager);
                    break;
                case UEB18_AUFGABE_C_IV:
                    fassade.aufgabe_c_iv(lager);
                    break;
                case UEB18_AUFGABE_H_I:
                    fassade.aufgabe_h_i(lager);
                    break;
                case UEB18_AUFGABE_H_II:
                    fassade.aufgabe_h_ii(lager);
                    break;
                case UEB18_AUFGABE_H_III:
                    ueb18AufgabeHIII();
                    
                    break;
                case UEB18_AUFGABE_H_IV:
                    fassade.aufgabe_h_iv(lager);
                    break;
                case UEB18_AUFGABE_H_V:
                    fassade.aufgabe_h_v(lager);
                    alsString();
                    break;
                case UEB18_AUFGABE_H_VI:
                    ueb18AufgabeHIII();
                    break;
                case UEB18_TO_STRING_ARTIKEL:
                    alsString();
                    break;
                case UEB18_DIALOGUE_BEENDEN:
                    System.out.println("Hauptmenue, Geben Sie einen Nummer ein: ");
                    break;
            }
        }
    }

    

    /**
     * legt ein neues Lager an
     */
    public void lagerAnlegen() {
        ErrorCheck.checkSchonLager(lager);

        System.out.println("Geben sie die Laenge des Lagers ein: ");
        int size = input.nextInt();
        input.nextLine();

        if (size <= 0){
            lager = new Lager();
            System.out.println("Sie haben keinen korrekten Wert angegeben, der Standardwert 10 wurde angegeben.");
        } else {
            lager = new Lager(size);
        }
    }
    /**
     * legt einen neuen Artikel an mit den selbstgewaehlten Werten des Benutzers.
     */
    public void artikelAnlegen() {
        ErrorCheck.checkLagerExistiert(lager);

        int artikelBefehl = 0;
        do {
            try {
                menueArtikel();
                artikelBefehl = funktionVerarbeitung();
                funktionArtikelAusfuehrung(artikelBefehl);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (artikelBefehl != DIALOG_ARTIKEL_ENDE);
    }

    /**
     * liegt ein cd-artikel an
     */
    public void cdAnlegen(){
        System.out.println("Artikelnummer: ");
        int artikelNr = input.nextInt();
        input.nextLine();

        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkAlreadyInLager(artikelNr, Lager.lager);

        System.out.println("Artikelbestand: ");
        int artikelBestand = input.nextInt();
        input.nextLine();

        ErrorCheck.checkBestand(artikelBestand);

        System.out.println("Artikelpreis: ");
        double artikelPreis = input.nextDouble();
        input.nextLine();

        ErrorCheck.checkPreis(artikelPreis);

        System.out.println("Interpret: ");
        String artikelInterpret = input.next();
        input.nextLine();

        ErrorCheck.checkStringNichtLeer(artikelInterpret);

        System.out.println("Titel:");
        String artikelTitel = input.next();
        input.nextLine();

        ErrorCheck.checkStringNichtLeer(artikelTitel);

        System.out.println("Anzahl der Musiktitel: ");
        int artikelAnzahlTitel = input.nextInt();
        input.nextLine();

        ErrorCheck.checkGroesserAlsNull(artikelAnzahlTitel);

        CD Cd = new CD(artikelNr, artikelBestand, artikelPreis, artikelInterpret, artikelTitel, artikelAnzahlTitel);

        lager.legeAnArtikel(Cd);
    }

    /**
     * liegt ein video-artikel an
     */
    public void videoAnlegen(){
        System.out.println("Artikelnummer: ");
        int artikelNr = input.nextInt();
        input.nextLine();

        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkAlreadyInLager(artikelNr, Lager.lager);

        System.out.println("Artikelbestand: ");
        int artikelBestand = input.nextInt();
        input.nextLine();

        ErrorCheck.checkBestand(artikelBestand);

        System.out.println("Artikelpreis: ");
        double artikelPreis = input.nextDouble();
        input.nextLine();

        ErrorCheck.checkPreis(artikelPreis);

        System.out.println("Titel:");
        String artikelTitel = input.next();
        input.nextLine();

        ErrorCheck.checkStringNichtLeer(artikelTitel);

        System.out.println("Spiel dauer: ");
        int artikelSpieldauer = input.nextInt();
        input.nextLine();

        ErrorCheck.checkGroesserAlsNull(artikelSpieldauer);

        System.out.println("Jahr: ");
        int artikelJahr = input.nextInt();
        input.nextLine();

        ErrorCheck.checkZwischen1900und2022(artikelJahr);

        Video Video = new Video(artikelNr, artikelBestand, artikelPreis, artikelTitel, artikelSpieldauer, artikelJahr);
        lager.legeAnArtikel(Video);
    }

    /**
     * liegt ein buch-artikel an
     */
    public void buchAnlegen(){
        System.out.println("Artikelnummer: ");
        int artikelNr = input.nextInt();
        input.nextLine();

        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkAlreadyInLager(artikelNr, Lager.lager);

        System.out.println("Artikelbestand: ");
        int artikelBestand = input.nextInt();
        input.nextLine();

        ErrorCheck.checkBestand(artikelBestand);

        System.out.println("Artikelpreis: ");
        double artikelPreis = input.nextDouble();
        input.nextLine();

        ErrorCheck.checkPreis(artikelPreis);

        System.out.println("Titel:");
        String artikelTitel = input.next();
        input.nextLine();

        ErrorCheck.checkStringNichtLeer(artikelTitel);

        System.out.println("Author: ");
        String artikelAuthor = input.next();
        input.nextLine();

        ErrorCheck.checkStringNichtLeer(artikelAuthor);

        System.out.println("Verlag: ");
        String artikelVerlag = input.next();
        input.nextLine();

        ErrorCheck.checkStringNichtLeer(artikelVerlag);

        Buch Buch = new Buch(artikelNr, artikelBestand, artikelPreis, artikelTitel, artikelAuthor, artikelVerlag);
        lager.legeAnArtikel(Buch);
    }

    /**
     * liegt anderen/weiteren artikel an
     */
    public void andereArtikelAnlegen(){
        System.out.println("Artikelnummer: ");
        int artikelNr = input.nextInt();
        input.nextLine();

        ErrorCheck.checkArtikelNr(artikelNr);
        ErrorCheck.checkAlreadyInLager(artikelNr, Lager.lager);

        System.out.println("Artikelart (Beschreibung): ");
        String artikelArt = input.next();
        input.nextLine();

        System.out.println("Artikelbestand: ");
        int artikelBestand = input.nextInt();
        input.nextLine();

        ErrorCheck.checkBestand(artikelBestand);

        System.out.println("Artikelpreis: ");
        double artikelPreis = input.nextDouble();
        input.nextLine();

        ErrorCheck.checkPreis(artikelPreis);

        artikel = new Artikel(artikelNr, artikelArt, artikelBestand, artikelPreis);

        lager.legeAnArtikel(artikel);
    }
    /**
     * entfernt einen Artikel
     */
    public void artikelEntfernen() {
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Geben Sie einen die Artikelnummer ein von \n" +
                "dem Artikel den sie loeschen wollen: ");
        int artikelNr = input.nextInt();
        lager.entferneArtikel(artikelNr);

    }

    /**
     * erhoeht Artikelbestand um eine vom Nutzer selbst ausgewaehlte Menge
     */
    public void bucheZugang(){
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Geben Sie die Artikelnummer an: ");
        int artikelNr = input.nextInt();

        System.out.println("Wie viel soll abgebucht werden?\n" +
                "Geben Sie einen Wert ein: ");
        int zugang = input.nextInt();

        lager.bucheZugang(artikelNr, zugang);
    }
    /**
     * Vermindert Artikelbestand um eine vom Nutzer selbst ausgewaehlte Menge
     */
    public void bucheAbgang() {
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Geben Sie die Artikelnummer an: ");
        int artikelNr = input.nextInt();

        System.out.println("Wie viel soll abgebucht werden?\n" +
                "Geben Sie einen Wert ein:  ");
        int abgang = input.nextInt();

        lager.bucheAbgang(artikelNr, abgang);
    }

    /**
     * erhoeht Preis eines bestimmten artikels
     */
    public void aenderePreisEinesArtikels() {
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Geben Sie die Artikelnummer an: ");
        int artikelNr = input.nextInt();

        System.out.println("Um wei viel Prozent soll der Preis erhoeht werden?\n" +
                "Geben Sie einen Wert ein: ");
        double prozent = input.nextDouble();

        lager.aenderePreisEinesArtikels(artikelNr, prozent);
    }

    /**
     * erhoeht Preis aller Artikel um einen bestimmten Prozentsatz
     */
    public void aenderePreisAllerArtikel() {
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Um wie viel Prozent soll der Preis erhoeht werden?\n" +
                "Geben Sie einen Wert ein: ");
        double prozent = input.nextDouble();
        lager.aenderePreisAllerArtikel(prozent);
    }

    /**
     * gibt einen Artikel als String aus
     */
    public void artikelAusgeben() {
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Geben Sie einen Index ein: ");

        int index = input.nextInt();
        System.out.println(lager.getArtikel(index));
    }

    /**
     * verarbeitet und gibt alle Artikel als String aus
     */
    public void alsString() {
        ErrorCheck.checkLagerExistiert(lager);
        System.out.println(lager.toString());
    }

    /**
     * gibt das gesamte Lager als String aufbereitet wieder
     */
    public void beschreibungAlsString() {
        double GesamtWert = 0;
        System.out.format("%-6s%-43s%-9s%-9s%6s", "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt\n");
        System.out.format("---------------------------------------------------------------------------\n");
        for (int i = 0; i < Lager.lager.length; i++) {
            if (Lager.lager[i] != null) {
                int ArtNr = Lager.lager[i].getArtikelNr();
                String Art = Lager.lager[i].getArt();
                double Preis = Lager.lager[i].getPreis();
                int Bestand = Lager.lager[i].getBestand();
                double GesamtPreis = Preis * Bestand;
                GesamtWert += GesamtPreis;

                System.out.format("%-6d%-43s%-9s%-9d%-6s", ArtNr, Art, Preis, Bestand, GesamtPreis);
                System.out.format("\n");
            }
        }
        System.out.format("---------------------------------------------------------------------------\n");
        System.out.format("Gesamtwert%62s", GesamtWert);
    }

    /**
     * gibt die anzahl der im Lager vorhandenen Artikel wieder
     */
    public void getArtikelAnzahl() {
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Anzahl der Artikel im Lager : " + lager.getArtikelAnzahl());
    }

    /**
     * gibt die Groessse des Lagers wieder
     */
    public void getLagerGroesse(){
        ErrorCheck.checkLagerExistiert(lager);
        System.out.println("Groesse des Lagers: " + lager.getLagerGroesse());
    }


    /**
     * zeigt den dialog für ueb18 an
     */
    public void ueb18DialogueAnzeigen(){
        ErrorCheck.checkLagerExistiert(lager);

        int ueb18Befehl = 0;
        do {
            try {
                menueUeb18();
                ueb18Befehl = funktionVerarbeitung();
                funktionUeb18Ausfuehrung(ueb18Befehl);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (ueb18Befehl != UEB18_DIALOGUE_BEENDEN);
    }

    /**
     * Methode reduziert alle Bücher eines gegebenen Autors um 5%.
     */
    public void ueb18AufgabeHIII(){
        System.out.println("GesuchterAuthor: ");
        String gesuchterAuthor = input.next();
        input.nextLine();
        boolean richtigeAuthor = false;
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
            if(lager.getArtikel(i) instanceof Buch){
                if(((Buch) lager.getArtikel(i)).getAuthor().equals(gesuchterAuthor)){
                    richtigeAuthor = true;
                    fassade.aufgabe_h_iii(lager, gesuchterAuthor);
                }
            }
        }
        if(!richtigeAuthor){
            System.out.println("Diese Author haben wir in unserem Lager nicht.");
        } else {
            System.out.println("Das author ist richtig, die preis wird -5% rabat");
        }
    }

    /**
     * Funktion zum Starten des Dialogs
     */
    public static void main(String[] args) {
        new LagerDialog().dialogStart();
    }
}