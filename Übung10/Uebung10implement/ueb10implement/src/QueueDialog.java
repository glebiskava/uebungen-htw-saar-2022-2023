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
    private static final int ADD_OBJEKT_ANFANG             = 3;
    private static final int ADD_OBJEKT_ENDE               = 4;
    private static final int REMOVE_OBJEKT_ANFANG          = 5;
    private static final int REMOVE_OBJEKT_ENDE            = 6;
    private static final int PATIENTENWARTESCHlANGE_ZEIGEN = 7;
    private static final int GET_ANZAHL_OBJEKT             = 8;
    private static final int GET_DATA_INDEX                = 9;
    private static final int IST_QUEUE_LEER                = 10;
    private static final int IST_QUEUE_VOLL                = 11;
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
                /*ADD_OBJEKT_ANFANG             + ": Objekt am Anfang anlegen\n" +*/ // facultatif
                ADD_OBJEKT_ENDE               + ": Objekt am Ende anlegen\n" +
                REMOVE_OBJEKT_ANFANG          + ": Objekt am Anfang entfernen\n" +
                /*REMOVE_OBJEKT_ENDE            + ": Objekt am Ende entfernen\n" +*/ // facultatif
                PATIENTENWARTESCHlANGE_ZEIGEN + ": Patienten warteschlange Zeigen\n" +
                GET_ANZAHL_OBJEKT             + ": Anzahl objekten ausgeben\n" +
                GET_DATA_INDEX                + ": Get data in queue bei Index\n" +
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
                case ADD_OBJEKT_ANFANG: // facultatif
                    /*objektAnfangAnlegen();*/
                    break;
                case ADD_OBJEKT_ENDE:
                    objektEndeAnlegen();
                    break;
                case REMOVE_OBJEKT_ANFANG:
                    objektAnfangEntfernen();
                    break;
                case REMOVE_OBJEKT_ENDE:// facultatif
                    /*objektEndeEntfernen();*/
                    break;
                case PATIENTENWARTESCHlANGE_ZEIGEN:
                    personWarteschlangeZeigen();
                    break;
                case GET_ANZAHL_OBJEKT:
                    objektAnzahlGeben();
                    break;
                case GET_DATA_INDEX:
                    indexGeben();
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
            System.out.println("Es existiert schon eine Queue, benutzen sie es !");
        }
    }
    public void stringQueueAnlegen() {
        if(queue == null){
            System.out.println("Groesse : ");
            int Groesse = input.nextInt();
            queue = new StringQueue(Groesse);
            System.out.println("Das Queue wurde gut angelegt");
        } else {
            System.out.println("Es existiert schon eine Queue, benutzen sie es !");
        }
    }

    
    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelBestand der artikel bestand
     */
    public void objektEndeAnlegen() {

        if(queue == null){
            System.out.println("Es gibt zurzeit kein queue ein, legen sie zuerst eine an !");
        } else {
            if(queue instanceof PersonQueue){
                //pruefen, ob voll ist oder nicht avec get size
                System.out.println("Vorname: ");
                String personVorname = input.next();
                input.nextLine();

                System.out.println("Nachname: ");
                String personNachname = input.next();
                input.nextLine();

                queue.addLast(new Person(personVorname, personNachname));
            } else {
                System.out.println("String: ");
                String stringData = input.next();
                input.nextLine();

                queue.addLast(stringData);
            }
        }
    }
    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelPreis der artikel preis
     */
    public void objektAnfangEntfernen() {
        if(queue == null){
            System.out.println("Es gibt zurzeit kein queue ein, legen sie zuerst eine an !");
        } else {
            if(queue.size() < 1){ // prueft, ob es mindestens ein element in das array gibt
                System.out.println("Es gibt kein objekt in das queue, legen sie eine an !");
            } else{
                System.out.println("Erste objekt wird gelöscht");
                queue.removeFirst();
            }
        }
    }

    /**
     * liegt ein cd-artikel an
     */
    public void indexGeben(){
        if(queue == null){
            System.out.println("Es gibt zurzeit kein queue ein, legen sie zuerst eine an !");
        } else {
            if(queue instanceof PersonQueue){
                System.out.println("Was ist der index der Person die sie brauchen ? geben sie ein zahl ein: ");
                int indexPerson = input.nextInt();
                input.nextLine();
                if(queue.size() - 1 < indexPerson){ //a tester
                    System.out.println("Es gibt keine personnen / string an diese stelle");
                } else{
                    System.out.println(queue.get(indexPerson));
                }
            } else {
                System.out.println("Was ist der index der String die sie brauchen ? geben sie ein zahl ein: ");
                int indexString = input.nextInt();
                input.nextLine();
                if(queue.size() - 1 < indexString){ //a tester
                    System.out.println("Es gibt keine personnen / string an diese stelle");
                } else{
                    System.out.println(queue.get(indexString));
                }
            }
        }
    }
    public void objektAnzahlGeben(){
        System.out.println("Es gibt genau " + queue.size() + " objekt in das queue");
    }
    public void istQueueLeer(){
        System.out.println("ist die queue leer ? antwort : " + queue.empty());
    }
    public void istQueueVoll(){
        System.out.println("ist die queue voll ? antwort : " + queue.full());
    }
    public void personWarteschlangeZeigen() {
        if(queue.size() < 1){
            System.out.println("Es gibt noch kein objekt in das queue");
        } else {
            queue.print(queue);
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