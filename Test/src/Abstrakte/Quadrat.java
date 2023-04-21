package Abstrakte;

public class Quadrat extends Figur{

    private double breite;

    public Quadrat(double breite) {
        this.breite = breite;
    }

    public double berechneFlaeche() {
        return breite*breite;
    }

    public double berechneUmfang() {
        return 4*breite;
    }

    public double getBreite() {
        return breite;
    }
}
