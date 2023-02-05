package Abstrakte;

public class Kreis extends Figur {

    private double radius;

    public Kreis(double radius) {
        this.radius = radius;
    }

    public double berechneFlaeche() {
        return Math.PI*radius*radius;
    }

    public double berechneUmfang() {
        return 2*Math.PI*radius;
    }

    public double getRadius() {
        return radius;
    }
}
