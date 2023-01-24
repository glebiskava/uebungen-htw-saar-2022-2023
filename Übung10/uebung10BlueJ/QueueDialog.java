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
    private static final int ADD_OBJEKT_ENDE               = 3;
    private static final int REMOVE_OBJEKT_ANFANG          = 4;
    private static final int REMOVE_OBJEKT_ENDE            = 5;
    private static final int WARTESCHLANGE_ANZEIGEN        = 6;
    private static final int GET_ANZAHL_OBJEKT             = 7;
    private static final int GET_ELEMENT_WITH_INDEX        = 8;
    private static final int IST_QUEUE_LEER                = 9;
    private static final int IST_QUEUE_VOLL                = 10;
    private static final int PROGRAMM_ENDE                 = 0;

    /**
     * Erstellen von leeren Objekten und einem
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
                PERSON_QUEUE_ANLEGEN          + ": Person Queue anlegen\n" +
                STRING_QUEUE_ANLEGEN          + ": String Queue anlegen\n" +
                ADD_OBJEKT_ENDE               + ": Objekt hinten anfuegen\n" +
                REMOVE_OBJEKT_ANFANG          + ": erstes Objekt entfernen\n" +
                REMOVE_OBJEKT_ENDE            + ": letztes Objekt entfernen\n" + // extra Methode
                WARTESCHLANGE_ANZEIGEN        + ": Queue ausgeben\n" +
                GET_ANZAHL_OBJEKT             + ": Anzahl angefuegter Objekte ausgeben\n" +
                GET_ELEMENT_WITH_INDEX        + ": Das i'te Element zurueckgeben\n" +
                IST_QUEUE_LEER                + ": Ist die Queue leer ?\n" +
                IST_QUEUE_VOLL                + ": Ist die Queue voll ?\n" +
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
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case PERSON_QUEUE_ANLEGEN:
                    personQueueAnlegen();
                    break;
                case STRING_QUEUE_ANLEGEN:
                    stringQueueAnlegen();
                    break;
                case ADD_OBJEKT_ENDE:
                    objektEndeAnlegen();
                    break;
                case REMOVE_OBJEKT_ANFANG:
                    objektAnfangEntfernen();
                    break;
                case REMOVE_OBJEKT_ENDE:// extra Methode
                    objektEndeEntfernen();
                    break;
                case WARTESCHLANGE_ANZEIGEN:
                    personWarteschlangeZeigen();
                    break;
                case GET_ANZAHL_OBJEKT:
                    objektAnzahlGeben();
                    break;
                case GET_ELEMENT_WITH_INDEX:
                    gibtElementAnhandIndexWieder();
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
     * legt eine neue PersonQueue an mit Standard Groesse 10 und prueft, ob es schon eins gibt
     */
    public void personQueueAnlegen() {
        if(queue == null){
            queue = new PersonQueue();
            System.out.println("Die Queue wurde mit einer Groesse von 10 angelegt");
        }else {
            System.out.println("Es existiert schon eine Queue, benutzen sie diese !");
        }
    }

    /**
     * legt eine neue StringQueue an mit Standard Groesse 10 und prueft, ob es schon eins gibt
     */
    public void stringQueueAnlegen() {
        if(queue == null){
            queue = new StringQueue();
            System.out.println("Die Queue wurde mit einer Groesse von 10 angelegt");
        } else {
            System.out.println("Es existiert schon eine Queue, benutzen sie diese !");
        }
    }


    /**
     * fuegt eines neues Objekt an das Ende des Arrays an und prueft, ob es noch keins gibt
     */
    public void objektEndeAnlegen() {
        if(queue == null){
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            if(!queue.full()){
                if(queue instanceof PersonQueue){
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
            } else {
                throw new IllegalArgumentException("Die Queue ist voll!");
            }
        }
    }

    /**
     * loescht das erste Objekt am anfang des Arrays und prueft, ob es mindestens ein element in das array gibt
     * und ob es noch kein Queue gibt
     */
    public void objektAnfangEntfernen() {
        if (queue == null) {
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            if (queue.size() < 1) {
                System.out.println("Es gibt kein Element im Queue, fuegen sie eins hinzu !");
            } else {
                System.out.print("Erstes Element wird gelöscht => " + queue.removeFirst());
            }
        }
    }

    /**
     * loescht das letzte Objekt am Ende des Arrays und prueft, ob es mindestens ein element in das array gibt
     * und ob es noch kein Queue gibt
     */
    public void objektEndeEntfernen() {
        if (queue == null){
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            if(queue.size() < 1) {
                System.out.println("Es gibt kein Element im Queue, fuegen sie eins hinzu !");
            } else{
                System.out.print("Letztes Element wird gelöscht => " + queue.removeLast());
            }
        }
    }

    /**
     * gibt das i'te element anhand des Indexes wieder und prueft ob noch kein Queue gibt und ob es ein Element an der
     * i'ten Stelle gibt
     */
    public void gibtElementAnhandIndexWieder() {
        if(queue == null) {
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            if(queue instanceof PersonQueue) {
                System.out.println("Was ist der index der Person die sie brauchen ? geben sie ein zahl ein: ");
                int indexPerson = input.nextInt();
                input.nextLine();
                if(queue.size() - 1 < indexPerson) {
                    System.out.println("Es gibt kein Element an dieser stelle");
                } else{
                    System.out.println(queue.get(indexPerson));
                }
            } else {
                System.out.println("Was ist der index der String die sie brauchen ? geben sie ein zahl ein: ");
                int indexString = input.nextInt();
                input.nextLine();
                if(queue.size() - 1 < indexString){
                    System.out.println("Es gibt kein Element an dieser stelle");
                } else{
                    System.out.println(queue.get(indexString));
                }
            }
        }
    }

    /**
     * gibt die Anzahl der Elemente im Array zurueck
     */
    public void objektAnzahlGeben() {
        if(queue == null) {
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            System.out.println("Es gibt genau " + queue.size() + " Element(e) im Queue");
        }
    }

    /**
     * checkt, ob die Queue leer ist
     */
    public void istQueueLeer() {
        if(queue == null) {
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            System.out.println("Ist die Queue leer ? Antwort : " + queue.empty());
        }
    }

    /**
     * checkt, ob die Queue voll ist
     */
    public void istQueueVoll() {
        if (queue == null) {
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            System.out.println("Ist die Queue voll ? Antwort : " + queue.full());
        }
    }

    /**
     * gibt die Queue aus und prueft, ob es noch kein Element im Array gibt
     */
    public void personWarteschlangeZeigen() {
        if(queue == null) {
            System.out.println("Es gibt zurzeit noch kein Queue, legen Sie zuerst eins an !");
        } else {
            if (queue.size() < 1) {
                System.out.println("Es gibt noch kein Element im Queue");
            } else {
                queue.print(queue);
            }
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