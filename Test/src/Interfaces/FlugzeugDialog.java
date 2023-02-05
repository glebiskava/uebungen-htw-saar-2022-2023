package Interfaces;

public class FlugzeugDialog {

    private Flugzeug[] flugzeuge;

    public void start() {
        flugzeuge = new Flugzeug[3];
        flugzeuge[0] = new ModellFlugzeug();
        flugzeuge[1] = new Kampfflugzeug();
        flugzeuge[2] = new ModellFlugzeug();

        for (Flugzeug flugzeug: flugzeuge) {
            /*flugzeug.starten();
            flugzeug.landen();*/
            System.out.println(flugzeug.getAktuelleHoehe());
            System.out.println(flugzeug.getAktuelleGeschwindigkeit());
        }
    }

    public static void main(String args[]) {
        new FlugzeugDialog().start();
    }
}
