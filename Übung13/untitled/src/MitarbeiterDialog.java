import java.util.InputMismatchException;
import java.util.Scanner;

public class MitarbeiterDialog {
    // public static Mitarbeiter mitarbeiter;
    private final Scanner input;

    // private Mitarbeiter mitarbeiter;

    private static final int PROGRAMM_ENDE = 0;
    private static final int MITARBEITER_ANLEGEN = 1;
    private static final int RAUM_ANLEGEN = 2;
    private static final int RESERVIEREN = 3;
    // private static final int MITARBEITER_ANLEGEN = 1;
    // private static final int MITARBEITER_ANLEGEN = 1;



    public MitarbeiterDialog(){
        input = new Scanner(System.in);
    }

    public void dialogStart(){
        // mitarbeiter = null;
        int befehl = 0;
        do{
            try{
                menueAnzeigen();
                befehl = funktionVerarbeitung();
                funktionAusfuehrung(befehl);
            } catch (IllegalArgumentException e){
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Geben Sie eine gueltige Zahl des gewollten Datentypen ein!");
                input.nextLine();
            } catch (Exception e){
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        } while (befehl != PROGRAMM_ENDE);
    }

    public void menueAnzeigen(){
        System.out.print("\n\n\n" +
                RESERVIEREN       + ": Reservieren\n"    +
                PROGRAMM_ENDE     + ": Dialog beenden\nGeben Sie einen Nummer ein: ");
    }
    public int funktionVerarbeitung(){
        int befehl = input.nextInt();
        return befehl;
    }

    public void funktionAusfuehrung(int befehl){
        if(befehl > RESERVIEREN || befehl < PROGRAMM_ENDE){
            throw new IllegalArgumentException("Geben Sie eine der angegebenen Zahlen ein!");
        } else {
            switch(befehl){
                // case MITARBEITER_ANLEGEN:
                //     MitarbeiterAnlegen();
                //     break;
                // case RAUM_ANLEGEN:
                //     RaumAnlegen();
                //     break;
                case RESERVIEREN:
                    Reservieren();
                    break;
                // case MITARBEITER_ANLEGEN:
                //     MitarbeiterAnlegen();
                //     break;
                case PROGRAMM_ENDE:
                    System.out.println("ENDE");
                    break;
            }

        }

    }
    // public void UhrZeitAnlegen(){
    //     System.out.println("Geben Sie eine Uhr ein und dann die Minuten für das Begin der Reservierung ein: \n");

    //     System.out.println("Uhr: \n");
    //     int inputUhr = input.nextInt();

    //     System.out.println("Uhr: \n");
    //     int inputMin = input.nextInt();

    //     Uhrzeit uhrzeit = new Uhrzeit(inputUhr, inputMin);
    // }

    // public void MitarbeiterAnlegen(){
    //     System.out.println("Vorname: ");
    //     String mitarbeiterVorname = input.next();
    //     input.nextLine();

    //     System.out.println("Nachname: ");
    //     String mitarbeiterNachname = input.next();
    //     input.nextLine();

    //     System.out.println("Email: ");
    //     String mitarbeiterEmail = input.next();
    //     input.nextLine();

    //     // Mitarbeiter mitarbeiter = new Mitarbeiter(mitarbeiterVorname, mitarbeiterNachname, mitarbeiterEmail);
    //     //queue.addLast(new Person(personVorname, personNachname));
    //     // System.out.println(mitarbeiter);

    // }

    // public void RaumAnlegen(){
    //     System.out.println("Um den Raum anzulegen brauchen Sie den Gebaude, den Etage und der Nummer den Raum\n");
    //     System.out.println("Geb: ");
    //     int RaumGeb = input.nextInt();
    //     input.nextLine();

    //     System.out.println("Etage: ");
    //     int RaumEtage = input.nextInt();
    //     input.nextLine();

    //     System.out.println("Raum: ");
    //     int RaumRaum = input.nextInt();
    //     input.nextLine();

    //     Raum raum = new Raum(RaumGeb, RaumEtage, RaumRaum);
    // }

    public void Reservieren(){
        //mitarbeiter anlegen
        System.out.println("Mitarbeiter anlegen, mit vorname, name und email: ");
        System.out.println("Vorname: ");
        String mitarbeiterVorname = input.next();
        input.nextLine();

        System.out.println("Nachname: ");
        String mitarbeiterNachname = input.next();
        input.nextLine();

        System.out.println("Email: ");
        String mitarbeiterEmail = input.next();
        input.nextLine();

        Mitarbeiter mitarbeiter = new Mitarbeiter(mitarbeiterVorname, mitarbeiterNachname, mitarbeiterEmail);


        //Raum anlegen
        System.out.println("Um den Raum anzulegen brauchen Sie den Gebaude, den Etage und der Nummer den Raum\n");
        System.out.println("Geb: ");
        int RaumGeb = input.nextInt();
        input.nextLine();

        System.out.println("Etage: ");
        int RaumEtage = input.nextInt();
        input.nextLine();

        System.out.println("Raum: ");
        int RaumRaum = input.nextInt();
        input.nextLine();

        Raum raum = new Raum(RaumGeb, RaumEtage, RaumRaum);


        //Begin Uhr anelegen
        System.out.println("Geben Sie eine Uhr ein und dann die Minuten für das Begin der Reservierung ein: \n");
        System.out.println("Uhr: \n");
        int inputUhrBegin = input.nextInt();

        System.out.println("Uhr: \n");
        int inputMinBegin = input.nextInt();

        Uhrzeit uhrzeitBegin = new Uhrzeit(inputUhrBegin, inputMinBegin);


        //EndeUhr anlegen
        System.out.println("Geben Sie eine Uhr ein und dann die Minuten für das Ende der Reservierung ein: \n");
        System.out.println("Uhr: \n");
        int inputUhrEnde = input.nextInt();

        System.out.println("Uhr: \n");
        int inputMinEnde = input.nextInt();

        Uhrzeit uhrzeitEnde = new Uhrzeit(inputUhrEnde, inputMinEnde);

        //Name des kurse anlegen
        System.out.println("Geben Sie der Name des Kurse für die Reservierung ein: \n");
        System.out.println("Name der Kurs: \n");
        String nameKurs = input.next();

        mitarbeiter.reserviere(raum, uhrzeitBegin, uhrzeitEnde, nameKurs);
    }

    /**
     * Funktion zum Starten des Dialogs
     * @param args
     */
    public static void main(String args[]) {
        new MitarbeiterDialog().dialogStart();
    }
}
