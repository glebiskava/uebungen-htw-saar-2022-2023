package Interfaces;

/**
 * double berechneGehalt();
 * int getBueroNr();
 + void klausurKontrollieren();
 */

public class HiWi implements Student, Mitarbeiter{

    @Override
    public double notendurchschnitt() {
        return 1.5;
    }

    @Override
    public void klausurSchreiben() {
        System.out.println("Ich schreibe eine Klausur.");
    }

    @Override
    public String getMatrikelNr() {
        return "1234";
    }

    @Override
    public double berechneGehalt() {
        return 5000.0;
    }

    @Override
    public int getBueroNr() {
        return 12;
    }

    @Override
    public void klausurKontrollieren() {
        System.out.println("Ich kontrolliere eine Klausur.");
    }

}
