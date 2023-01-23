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
    private static final int PERSON_QUEUE_ANLEGEN           = 1;
    private static final int STRING_QUEUE_ANLEGEN           = 2;
    /*private static final int ADD_OBJEKT_ANFANG             = 3;*/
    private static final int ADD_LAST                       = 3;
    private static final int REMOVE_FIRST                   = 4;
    /*private static final int REMOVE_OBJEKT_ENDE            = 6;*/
    private static final int GET_I                          = 5;
    private static final int EMPTY                          = 6;
    private static final int FULL                           = 7;
    private static final int GET_SIZE                       = 8;
    private static final int PRINT_QUEUE                    = 9;
    private static final int PROGRAMM_ENDE                  = 10;

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
                PERSON_QUEUE_ANLEGEN            + ": Personen Queue anlegen\n" +
                STRING_QUEUE_ANLEGEN            + ": String Queue anlegen\n" +
/*
                ADD_OBJEKT_ANFANG             + ": Objekt am Anfang anlegen\n" + // facultatif
*/
                ADD_LAST                        + ": Objekt hinten anfuegen\n" +
                REMOVE_FIRST                    + ": erstes Element entfernen und Referenz darauf zurueckgeben\n" +
/*
                REMOVE_OBJEKT_ENDE            + ": Objekt am Ende entfernen\n" + // facultatif
*/


                GET_I                           + ": Das i'te Element zurueckgeben\n" +
                EMPTY                           + ": Testen ob Queue leer ist\n" +
                FULL                            + ": Testen, ob noch Element einfuebar sind\n" +
                GET_SIZE                        + ": Anzahl eingefuegter Objekte\n" +
                PRINT_QUEUE                     + ": Ausgabe der Queue\n" +
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
    public void funktionPersonAusfuehrung(int befehl) {
        if(befehl > PROGRAMM_ENDE || befehl < PERSON_QUEUE_ANLEGEN) {
            throw new IllegalArgumentException("Geben Sie eine der angebenen Zahlen ein!");
        } else {
            switch(befehl) {
                case PERSON_QUEUE_ANLEGEN:
                    personQueueAnlegen();
                    break;
                case STRING_QUEUE_ANLEGEN:
                    stringQueueAnlegen();
                    break;
                /*case ADD_OBJEKT_ANFANG: // facultatif
                    *//*objektAnfangAnlegen();*//*
                    break;*/
                case ADD_LAST:
                    objektEndeAnlegen();
                    break;
                case REMOVE_FIRST:
                    objektAnfangEntfernen();
                    break;
                /*case REMOVE_OBJEKT_ENDE:// facultatif
                    *//*objektEndeEntfernen();*//*
                    break;*/
                case GET_I:
                    getItesElement();
                    break;
                case EMPTY:
                    istQueueLeer();
                    break;
                case FULL:
                    istQueueVoll();
                    break;
                case GET_SIZE:
                    objektAnzahlGeben();
                    break;
                case PRINT_QUEUE:
                    print(queue);
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
            System.out.println("Die Personen Queue wurde angelegt");
        }else {
            System.out.println("Es existiert schon eine Person Queue, benutzen Sie diese !");
        }
    }
    public void stringQueueAnlegen() {
        if(queue == null){
            System.out.println("Groesse : ");
            int Groesse = input.nextInt();
            queue = new StringQueue(Groesse);
            System.out.println("Die String Queue wurde angelegt");
        } else {
            System.out.println("Es existiert schon eine String Queue, benutzen Sie diese !");
        }
    }

    /**
     * ArtikelNr für die gemeinsamen attributes
     * @return artikelNr der aertikel nummer
     */
    // à garder
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
    public void objektEndeAnlegen() {
        if(queue == null) {
            System.out.println("Es gibt zurzeit keine Queue ein, legen Sie zuerst eine an !");
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
            System.out.println("Es gibt zurzeit keine Queue ein, legen Sie zuerst eine an !");
        } else {
            if(queue.size() < 1){ // prueft, ob es mindestens ein element in das array gibt
                System.out.println("Es gibt keine Elemente in der Queue, legen Sie welche an !");
            } else{
                System.out.println("Erstes Element wird gelöscht");
                queue.removeFirst();
            }
        }
    }

    /**
     * liegt ein cd-artikel an
     */
    public void getItesElement(){
        if(queue == null){
            System.out.println("Es gibt zurzeit keine Queue ein, legen Sie zuerst eine an !");
        } else {
            if(queue instanceof PersonQueue){
                System.out.println("An welchem Index befindet sich das gewollte Element? Geben sie die Zahl ein: ");
                int indexPerson = input.nextInt();
                input.nextLine();
                if(queue.size() - 1 < indexPerson){ //a tester
                    System.out.println("Es gibt keine Personen / Strings an diese stelle");
                } else{
                    System.out.println(queue.get(indexPerson));
                }
            } else {
                System.out.println("An welchem Index befindet sich das gewollte Element? Geben sie die Zahl ein: ");
                int indexString = input.nextInt();
                input.nextLine();
                if(queue.size() - 1 < indexString){ //a tester
                    System.out.println("Es gibt keine Personen / Strings an diese stelle");
                } else{
                    System.out.println(queue.get(indexString));
                }
            }
        }
    }

    public void objektAnzahlGeben(){
        System.out.println("Es gibt genau " + queue.size() + " Elemente in der Queue");
    }

    public void istQueueLeer(){
        System.out.println("Ist die Queue leer ? Antwort : " + queue.empty());
    }

    public void istQueueVoll(){
        System.out.println("Ist die Queue leer ? Antwort : " + queue.full());
    }

    public static void print(Queue q) {
        for (int i = 0; i < q.size(); i++) {
            System.out.println(q.get(i));
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
