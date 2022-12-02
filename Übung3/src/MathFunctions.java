/**
 * Dies ist eine Klasse MathFunctions, die aehnlich wie die Klasse java.lang.Math Funktionen in
 * Form von Klassenmethoden anbietet
 * @author Elisee Brand, Leopold Mittelberger
 */

public class MathFunctions {

    private static final double EPSILON = 0.000000000001;
    /**
     * Die Methode berechneTeilersumme(long zahl) berechnet die Teilersumme einer natuerlichen Zahl.
     * @param zahl Wert der entgegengenommen wird
     */
    public static long berechneTeilersumme(long zahl) {
        long teilersumme = zahl;
        if (zahl < 0) {
            throw new IllegalArgumentException("Nummer soll groesser als 0 sein");
        } else if(zahl > 0){
            while (zahl != 1) {
                zahl = (int) Math.round(zahl / 2.0);
                teilersumme += zahl;
            }
            return teilersumme;
        } else {
            throw new IllegalArgumentException("Nummer soll groesser als 0 sein");
        }
    }

    /**
     * berechnet die Pruefziffer einer ISBN-10 Nummer und gibt diese als String aus.
     * @param isbn Zahl die entgegengenommen wird
     */
    public static String berechneChecksummeIsbn(long isbn) {
        String output = "";
        int pruefziffer = 0;

        for (int i = 9; i > 0; i--) {
            pruefziffer += (isbn % 10) * i;
            isbn = isbn / 10;
        }

        if (pruefziffer % 11 == 10) {
            output += "X";
        } else {
            output += pruefziffer % 11;
        }
        return "Die Pruefziffer lautet: " + output;
    }

    /**
     * bestimmt Nullstellen einer quadratischen Gleichung und gibt diese als aufbereiteten String aus
     * @param p P-Wert der entgegengenommen wird
     * @param q Q-Wert der entgegengenommen wird
     */
    public static String berechneNullstellen (double p, double q) {
        String output = "";
        System.out.println("x**2 + " + p + "x + " + q + "  = 0");
        double delta = (Math.pow(p/2, 2)- q);

        if (delta < 0){
            output = "Komplexe Nullstellen";
        } else if (delta <= EPSILON && -EPSILON <= delta){
            double x1 = -(p/2);
            output = "Doppelte Nullstelle: " + x1;
        } else if(delta > 0){
            double x1 = (-(p/2) + Math.sqrt(delta));
            double x2 = (-(p/2) - Math.sqrt(delta));
            output = "Zwei Nullstellen: " + x1 + "|" + x2;
        }
        return output;
    }
}