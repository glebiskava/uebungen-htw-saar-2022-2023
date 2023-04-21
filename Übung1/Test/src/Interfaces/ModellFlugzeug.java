package Interfaces;

public class ModellFlugzeug implements Flugzeug {

    @Override
    public void starten() {
        System.out.println("Ich starte das Modellflugzeug.");
    }

    @Override
    public void landen() {
        System.out.println("Ich lande das Modellflugzeug.");
    }

    @Override
    public double getAktuelleHoehe() {
        return 50;
    }

    @Override
    public double getAktuelleGeschwindigkeit() {
        return 100.5;
    }
}
