package Interfaces;

public class Kampfflugzeug implements Flugzeug {

    @Override
    public void starten() {
        System.out.println("Ich starte das Kampfflugzeug.");
    }

    @Override
    public void landen() {
        System.out.println("Ich lande das Kampfflugzeug.");
    }

    public void schiessen() {
        System.out.println("Peng Peng");
    }

    @Override
    public double getAktuelleHoehe() {
        return 5000;
    }

    @Override
    public double getAktuelleGeschwindigkeit() {
        return 10000.5;
    }
}
