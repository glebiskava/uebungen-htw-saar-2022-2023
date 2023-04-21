package Abstrakte;

public class Rechteck extends Figur {

    private double breite;
    private double hoehe;

    public Rechteck(double breite, double hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public double berechneFlaeche() {
        return breite*hoehe;
    }

    public double berechneUmfang() {
        return 2*breite+2*hoehe;
    }

    public double getBreite() {
        return breite;
    }

    public double getHoehe() {
        return hoehe;
    }
}
