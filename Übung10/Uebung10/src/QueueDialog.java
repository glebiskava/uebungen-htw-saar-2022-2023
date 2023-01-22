import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dies ist eine Klasse die zur Interaktion mit einem Benutzer dient.
 * Der Benutzer kann ein Objekt bearbeiten in dem er mit Zahlen verschiedene Methoden/Setter auswaehlt
 * @author Elisee Brand, Leopold Mittelberger
 */

public class QueueDialog {
    private Queue queue;
    private Scanner input;

    /**
     * Benutzer soll anhand von Zahlen die gewuenschten input aus.
     * Dazu werden Konstanten zu jeder Methoden und zu jedem Setter erstellt,
     * um den Code uebersichtlich zu strukturieren.
     *
     * static: wird von allen Objekten der gleichen Klasse geteilt.
     * final: einmal die Variable initialisiert kann sie nicht mehr geaendert werden.
     */
    private static final int PERSON_QUEUE_ANLEGEN          = 1;
    private static final int STRING_QUEUE_ANLEGEN          = 2;
    private static final int ADD_PERSON_ANFANG             = 3;
    private static final int ADD_PERSON_ENDE               = 4;
    private static final int REMOVE_PERSON_ANFANG          = 5;
    private static final int REMOVE_PERSON_ENDE            = 6;
    private static final int REMOVE_PERSON_NR              = 7;
    private static final int PATIENTENWARTESCHlANGE_ZEIGEN = 8;
    private static final int GET_ANZAHL_PERSON             = 9;
    private static final int GET_PERSON_INDEX              = 10;
    private static final int IST_QUEUE_LEER                = 11;
    private static final int IST_QUEUE_VOLL                = 12;
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
                PERSON_QUEUE_ANLEGEN          + ": PERSON_QUEUE_ANLEGEN\n" +
                STRING_QUEUE_ANLEGEN          + ": STRING_QUEUE_ANLEGEN\n" +
                /*ADD_PERSON_ANFANG             + ": Person am Anfang anlegen\n" +*/ // ne pas suprimer les comments j'en parle a vice lundi
                ADD_PERSON_ENDE               + ": Person am Ende anlegen\n" +
                REMOVE_PERSON_ANFANG          + ": Person am Anfang entfernen\n" +
                /*REMOVE_PERSON_ENDE            + ": Person am Ende entfernen\n" +*/
                /*REMOVE_PERSON_NR              + ": Person bei PersonNr entfernen\n"  +*/
                PATIENTENWARTESCHlANGE_ZEIGEN + ": Patienten warteschlange Zeigen\n" +
                GET_ANZAHL_PERSON             + ": Anzahl patienten ausgeben\n" +
                GET_PERSON_INDEX              + ": Get Person data bei Index\n" +
                IST_QUEUE_LEER                + ": IST_QUEUE_LEER ?\n" +
                IST_QUEUE_VOLL                + ": IST_QUEUE_VOLL ?\n" +
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
        if(befehl > IST_QUEUE_VOLL || befehl < PROGRAMM_ENDE) {
            throw new IllegalArgumentException("Geben Sie eine der angebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case PERSON_QUEUE_ANLEGEN:
                    personQueueAnlegen();
                    break;
                case STRING_QUEUE_ANLEGEN:
                    stringQueueAnlegen();
                    break;
                case ADD_PERSON_ANFANG:
                    /*personAnfangAnlegen();*/
                    break;
                case ADD_PERSON_ENDE:
                    personEndeAnlegen();
                    break;
                case REMOVE_PERSON_ANFANG:
                    personAnfangEntfernen();
                    break;
                case REMOVE_PERSON_ENDE:
                    /*personEndeEntfernen();*/
                    break;
                case REMOVE_PERSON_NR:
                    /*personNrEntfernen();*/
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
                case IST_QUEUE_LEER :
                    istQueueLeer();
                    break;
                case IST_QUEUE_VOLL:
                    istQueueVoll();
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
    public void personQueueAnlegen() {
        if(queue == null){
            System.out.println("Groesse : ");
            int Groesse = input.nextInt();
            queue = new PersonQueue(Groesse);
            System.out.println("Das Queue wurde gut angelegt");
        }else {
            System.out.println("Es existiert schon eine Queue");
        }
    }
    public void stringQueueAnlegen() {
        if(queue == null){
            System.out.println("Groesse : ");
            int Groesse = input.nextInt();
            queue = new StringQueue(Groesse);
            System.out.println("Das Queue wurde gut angelegt");
        } else {
            System.out.println("Es existiert schon eine Queue");
        }
    }

    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelNr der aertikel nummer
     */
    // à garder en mémoire je demande à Vice lundi
    /*public void personAnfangAnlegen() {
        System.out.println("Vorname: ");
        String personVorname = input.next();
        input.nextLine();

        System.out.println("Nachname: ");
        String personNachname = input.next();
        input.nextLine();

        queue.addFirst(new Person(personVorname, personNachname));
    }*/
    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelBestand der artikel bestand
     */
    public void personEndeAnlegen() {
        //pruefen ob voll ist oder nicht
        System.out.println("Vorname: ");
        String personVorname = input.next();
        input.nextLine();

        System.out.println("Nachname: ");
        String personNachname = input.next();
        input.nextLine();

        queue.addLast(new Person(personVorname, personNachname));
    }
    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelPreis der artikel preis
     */
    public void personAnfangEntfernen() {
        if(queue.size() < 1){
            System.out.println("Es gibt kein personne / string in das queue, legen sie eine an !");
        } else{
            System.out.println("Erste person wird gelöscht");
            queue.removeFirst();
        }
    }

    /**
     * liegt ein cd-artikel an
     */
    public void personIndexGeben(){
        System.out.println("Was ist der index der Person die sie brauchen ? geben sie ein zahl ein: ");
        int indexPerson = input.nextInt();
        input.nextLine();
        if(queue.size() - 1 < indexPerson){ //a tester
            System.out.println("Es gibt keine personnen / string an diese stelle");
        } else{
            System.out.println(queue.get(indexPerson));
        }

    }
    public void personAnzahlGeben(){
        System.out.println("Es gibt genau " + queue.size() + " personnen in das queue");
    }
    public void istQueueLeer(){
        System.out.println("ist die queue leer ? antwort : " + queue.empty());
    }
    public void istQueueVoll(){
        System.out.println("ist die queue voll ? antwort : " + queue.full());
    }
    public void personWarteschlangeZeigen() {
        if(queue.size() < 1){
            System.out.println("Es gibt noch kein personnen / String");
        } else {
            System.out.format("%-8s%-8s%-8s", "index", "Vorname", "Nachname", "\n");
            System.out.format("----------------------------------------------\n");
            for (int i = 0; i < queue.size(); i++) {
                Object name = queue.queueZeigen(queue, i);
                if(name != null){
                    System.out.format("%-8d%8s", i, name);
                    System.out.format("\n");
                }
            }
            System.out.format("----------------------------------------------------------------------\n");

        }
    }
    /**
     * Funktion zum Starten des Dialogs
     * @param args
     */
    public static void main(String args[]) {
        new QueueDialog().dialogStart();
    }
}