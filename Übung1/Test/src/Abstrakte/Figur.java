package Abstrakte;

import java.rmi.server.RemoteRef;

public abstract class Figur {

    public abstract double berechneFlaeche();

    public abstract double berechneUmfang();


    public static void main(String[] args) {

        Kreis kreis = new Kreis(3.0);
        kreis.start();
    }

    public void start() {
        Figur[] figuren = new Figur[3];
        figuren[0] = new Kreis(3.0);
        figuren[1] = new Rechteck(2.0, 3.0);
        figuren[2] = new Quadrat(2.0);

        double gessamtFlaeche = 0.0;

        for (int i = 0; i < figuren.length; i++) {
            System.out.println("figurTab[" + i + "].berechneFlaeche(): " + figuren[i].berechneFlaeche());
            System.out.println("figurTab[" + i + "].berechneUmfang(): " + figuren[i].berechneUmfang());

            gessamtFlaeche += figuren[i].berechneFlaeche();
        }
        System.out.println("Gesamtflaeche: " + gessamtFlaeche);
    }
}
