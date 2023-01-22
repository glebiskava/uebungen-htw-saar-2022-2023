import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class QueueDialog {
    private Queue queue;
    /*private Queue queue;*/
    private Scanner input;

    /**
     * Benutzer soll anhand von Zahlen die gewuenschten input aus.
     * Dazu werden Konstanten zu jeder Methoden und zu jedem Setter erstellt,
     * um den Code uebersichtlich zu strukturieren.
     *
     * static: wird von allen Objekten der gleichen Klasse geteilt.
     * final: einmal die Variable initialisiert kann sie nicht mehr geaendert werden.
     */
    private static final int ADD_PERSON_ANFANG             = 1;
    private static final int ADD_PERSON_ENDE               = 2;
    private static final int REMOVE_PERSON_ANFANG          = 3;
    private static final int REMOVE_PERSON_ENDE            = 4;
    private static final int REMOVE_PERSON_NR              = 5;
    private static final int PATIENTENWARTESCHlANGE_ZEIGEN = 6;
    private static final int GET_ANZAHL_PERSON             = 7;
    private static final int GET_PERSON_INDEX              = 8;
    private static final int DER_NAECHSTE_BITTE            = 9;
    private static final int PROGRAMM_ENDE                 = 0;

    /**
     * Erstellen von leeren Objekten und einem 1
     * Scannerobjekt zum Einlesen der
     * Werte des Benutzers
     */
    public QueueDialog() {
        input = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Dialogs mit dem Benutzer zum Starten des Programms.
     * Fehlerhafte Eingaben werden hier aufgefangen
     */
    public void dialogStart() {
        queue = null;
        int befehl = 0;
        do {
            try {
                menuePerson();
                befehl = funktionVerarbeitung();
                funktionPersonAusfuehrung(befehl);
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
    public void menuePerson(){
        System.out.print("\n\n\n" +
                ADD_PERSON_ANFANG             + ": Person am Anfang anlegen\n" +
                ADD_PERSON_ENDE               + ": Person am Ende anlegen\n" +
                REMOVE_PERSON_ANFANG          + ": Person am Anfang entfernen\n" +
                REMOVE_PERSON_ENDE            + ": Person am Ende entfernen\n" +
                REMOVE_PERSON_NR              + ": Person bei PERSONNr entfernen\n"  +
                PATIENTENWARTESCHlANGE_ZEIGEN + ": Patienten warteschlange Zeigen\n" +
                GET_ANZAHL_PERSON             + ": Anzahl patienten ausgeben\n" +
                GET_PERSON_INDEX              + ": Get Person data bei Index\n" +
                DER_NAECHSTE_BITTE            + ": Der naechste bitte\n" +
                PROGRAMM_ENDE                 + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
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
    public void funktionPersonAusfuehrung(int befehl) {
        if(befehl > GET_ANZAHL_PERSON || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case ADD_PERSON_ANFANG:
                    personAnfangAnlegen();
                    break;
                case ADD_PERSON_ENDE:
                    personEndeAnlegen();
                    break;
                case REMOVE_PERSON_ANFANG:
                    personAnfangEntfernen();
                    break;
                case REMOVE_PERSON_ENDE:
                    personEndeEntfernen();
                    break;
                case REMOVE_PERSON_NR:
                    personNrEntfernen();
                    break;
                case PATIENTENWARTESCHlANGE_ZEIGEN:
                    personWarteschlangeZeigen();
                    break;
                case GET_ANZAHL_PERSON:
                    personAnzahlGeben();
                    break;
                case GET_PERSON_INDEX:
                    personIndexGeben();
                    break;
                case DER_NAECHSTE_BITTE:
                    derNaechsteBitte();
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
    public void lagerAnlegen() {
        if(queue == null){
            queue = new StringQueue();

        }
    }

    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelNr der aertikel nummer
     */
    public void personAnfangAnlegen() {
        System.out.println("Vorname: ");
        String personVorname = input.next();
        input.nextLine();

        System.out.println("Nachname: ");
        String personNachname = input.next();
        input.nextLine();

        queue.addFirst(new Person(personVorname, personNachname));
    }
    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelBestand der artikel bestand
     */
    public void personEndeAnlegen() {
        System.out.println("Vorname: ");
        String personVorname = input.next();
        input.nextLine();

        System.out.println("Nachname: ");
        String personNachname = input.next();
        input.nextLine();

        queue.addLast(new Person(personVorname, personNachname));
        ErrorCheck.checkBestand(artikelBestand);
        return artikelBestand;
    }
    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelPreis der artikel preis
     */
    public double gemeinsamAttributePreis() {
        System.out.println("Artikelpreis: ");
        double artikelPreis = input.nextDouble();
        input.nextLine();

        ErrorCheck.checkPreis(artikelPreis);
        return artikelPreis;
    }

    /**
     * liegt ein cd-artikel an
     */
    public void cdAnlegen(){
        int artikelNr = gemeinsamAttributeArtikelNr();
        int artikelBestand = gemeinsamAttributeBestand();
        double artikelPreis = gemeinsamAttributePreis();

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

        Lager.legeAnArtikel(Cd);
    }

    /**
     * liegt ein video-artikel an
     */
    public void videoAnlegen(){
        int artikelNr = gemeinsamAttributeArtikelNr();
        int artikelBestand = gemeinsamAttributeBestand();
        double artikelPreis = gemeinsamAttributePreis();

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
        Lager.legeAnArtikel(Video);
    }

    /**
     * liegt ein buch-artikel an
     */
    public void buchAnlegen(){
        int artikelNr = gemeinsamAttributeArtikelNr();
        int artikelBestand = gemeinsamAttributeBestand();
        double artikelPreis = gemeinsamAttributePreis();

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
        Lager.legeAnArtikel(Buch);
    }

    public void andereArtikelAnlegen(){
        int artikelNr = gemeinsamAttributeArtikelNr();
        int artikelBestand = gemeinsamAttributeBestand();
        double artikelPreis = gemeinsamAttributePreis();

        System.out.println("Artikelart (Beschreibung): ");
        String artikelArt = input.next();
        input.nextLine();

<<<<<<< Updated upstream
=======
        //ErrorCheck.checkArt(artikelArt);

        System.out.println("Artikelbestand: ");
        int artikelBestand = input.nextInt();
        input.nextLine();

        ErrorCheck.checkBestand(artikelBestand);

        System.out.println("Artikelpreis: ");
        double artikelPreis = input.nextDouble();
        input.nextLine();

        ErrorCheck.checkPreis(artikelPreis);

>>>>>>> Stashed changes
        artikel = new Artikel(artikelNr, artikelArt, artikelBestand, artikelPreis);

        Lager.legeAnArtikel(artikel);
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
        Lager.entferneArtikel(artikelNr);

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

        Lager.bucheZugang(artikelNr, zugang);
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

        Lager.bucheAbgang(artikelNr, abgang);
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

        Lager.aenderePreisEinesArtikels(artikelNr, prozent);
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
        Lager.aenderePreisAllerArtikel(prozent);
    }

    /**
     * gibt einen Artikel als String aus
     */
    public void artikelAusgeben() {
        ErrorCheck.checkLagerExistiert(lager);
        ErrorCheck.checkLagerLeer(Lager.lager);

        System.out.println("Geben Sie einen Index ein: ");

        int index = input.nextInt();
        System.out.println(Lager.getArtikel(index));
    }

    /**
     * verarbeitet und gibt alle Artikel als String aus
     */
    public void alsString() {
        ErrorCheck.checkLagerExistiert(lager);
        System.out.println(lager.toString());
    }
    public void beschreibungAlsString() {
        double GesamtWert = 0;
        System.out.format("%-6s%-43s%-9s%-9s%6s", "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt\n");
        System.out.format("---------------------------------------------------------------------------\n");
        for (int i = 0; i < Lager.lager.length; i++) {
            if (Lager.lager[i] != null) {
                int ArtNr = Lager.lager[i].getArtikelNr();
                String Art = Lager.lager[i].getBeschreibung();
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

        System.out.println("Anzahl der Artikel im Lager : " + Lager.getArtikelAnzahl());
    }

    /**
     * gibt die Groessse des Lagers wieder
     */
    public void getLagerGroesse(){
        ErrorCheck.checkLagerExistiert(lager);
        System.out.println("Groesse des Lagers: " + Lager. getLagerGroesse());
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args
     */
    public static void main(String args[]) {
        new LagerDialog().dialogStart();
    }
}