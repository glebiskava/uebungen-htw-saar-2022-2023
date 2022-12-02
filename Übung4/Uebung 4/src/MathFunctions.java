/**
 * Dies ist eine Klasse MathFunctions, die aehnlich wie die Klasse java.lang.Math Funktionen in
 * Form von Klassenmethoden anbietet
 * @author Elisee Brand, Leopold Mittelberger
 */

public class MathFunctions {

    private static final double EPSILON = 0.0E-11;
    /**
     * Die Methode berechnet die Teilersumme einer natuerlichen Zahl.
     * @param zahl Wert der entgegengenommen wird, und sollte < 0 sein
     */
    public static long berechneTeilersumme (long zahl) {

        ErrorCheck.checkIsNumberNull(zahl);
        ErrorCheck.checkIsNumberNegative(zahl);

        long result = 0;
        if (zahl == 1){
            return 1;
        }
        else if(isPrimeNumber(zahl)){
            return 1 + zahl;
        }
        for (int i = 4; i <= Math.sqrt(zahl); i++) {
            if (zahl % i == 0) {
                if (i == (zahl / i)) {
                    result += i;
                } else {
                    result += (i + zahl / i);
                }
            }
        }
        zahl += 1;
        return (result + zahl);
    }

    /**
     * prueft eine Zahl, ob es eine Primzahl ist
     * @param zahl Wert der übernommen wird
     */
    public static boolean isPrimeNumber(long zahl) {

        ErrorCheck.checkIsNumberNull(zahl);
        ErrorCheck.checkIsNumberNegative(zahl);

        if (zahl <= 3){
            return true;
        }
        if (zahl % 2 == 0 || zahl % 3 == 0){
            return false;
        }
        for (int i = 5; i * i <= zahl; i = i + 6){
            if (zahl % i == 0 || zahl % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * berechnet die Pruefziffer einer ISBN-10 Nummer und gibt diese als String aus.
     * @param isbn Zahl die entgegengenommen wird
     */
    public static String berechneChecksummeIsbn(long isbn) {

        ErrorCheck.checkIsNumberNull(isbn);
        ErrorCheck.checkIsbn(isbn);

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
        double delta = (p / (2 * 2) - q);
        double p2 = -(p/2);
        double sqrt = Math.sqrt(delta);
        if (delta <= EPSILON && -EPSILON <= delta){
            double x1 = -(p/2);
            output = "Doppelte Nullstelle: " + x1;
        } else if (delta < 0){
            output = "Komplexe Nullstellen";
        } else if(delta > 0){
            double x1 = p2 + sqrt;
            double x2 = p2 - sqrt;
            output = "Zwei Nullstellen: " + x1 + "|" + x2;
        }
        return output;
    }
    /**
     * Diese Methode prüft zu einer natürlichen Zahl, ob es natürliche
     * Zahlen a, b, c gibt, sodass gilt zahl = a4 + b3 + c2
     * dabei wird die Zahl erst in einen Double konvertiert, weil die Funktion sqrt, cbrt etc. nur double werte entgegennimmt.
     * Dann wird die Zahl wieder in einen Long umgewandelt.
     * @param zahl Wird Nutzer durch den Dialog entgegengenommen
     */
    public static boolean istSummeVonPotenzen (long zahl) {

        ErrorCheck.checkIsNumberNull(zahl);
        ErrorCheck.checkIsNumberNegative(zahl);

        double zahlAlsDouble = (double) zahl;

        double quadratWurzelVonZahlDouble = Math.sqrt(zahlAlsDouble);
        double kubikWurzelVonZahlDouble = Math.cbrt(zahlAlsDouble);
        double vierteWurzelVonZahlDouble = Math.sqrt(quadratWurzelVonZahlDouble);

        long quadratWurzelLong = (long) quadratWurzelVonZahlDouble;
        long kubikWurzelLong = (long) kubikWurzelVonZahlDouble;
        long vierteWurzelLong = (long) vierteWurzelVonZahlDouble;

        for (long x = 1; x <= vierteWurzelLong; x++) {
            for (long y = 1; y <= kubikWurzelLong; y++) {
                for (long z = 1; z <= quadratWurzelLong; z++) {

                    double a = Math.pow((double) x, 4.0);

                    double b = Math.pow((double) y, 3.0);

                    double c = Math.pow((double) z, 2.0);

                    double rechnung = a + b + c;

                    if ((long) rechnung == zahl) {
                        return true;
                    }
                }
            }
        } return false;
    }

    /**
     * berechnet die Pruefziffer einer ISBN-10 Nummer und gibt diese als String aus.
     * @param zahl1 Zahl die entgegengenommen wird
     * @param zahl2 Zahl die entgegengenommen wird
     */
    public static int berechneGgt(int zahl1, int zahl2){

        ErrorCheck.checkIsNumberNull(zahl1);
        ErrorCheck.checkIsNumberNegative(zahl1);
        ErrorCheck.checkIsNumberNull(zahl2);
        ErrorCheck.checkIsNumberNegative(zahl2);

        int output = 0;
        for(int i=1; i <= zahl1 && i <= zahl2; i++)
        {
            if(zahl1% i==0 && zahl2%i==0)
                output = i;
        }
        return output;
    }

    /**
     * bestimmt Nullstellen einer quadratischen Gleichung und gibt diese als aufbereiteten String aus
     * @param zahl P-Wert der entgegengenommen wird
     */
    public static long berechneFakultaet(int zahl) {

        ErrorCheck.checkIsNumberNull(zahl);
        ErrorCheck.checkIsNumberNegative(zahl);

        long output = zahl;

        for(int i = 1; i < zahl; i++){
            output *= i;
        }
        return output;
    }

    /**
     * berechnet eine Reihensumme zu einer uebergebenen Zahl anzahl und einem Wert x die folgende mathematische Funktion
     * und gibt das Ergebnis zurueck: (x-1)^anzahl / anzahl*x^anzahl
     * @param anzahl anzahl der Iteration
     * @param x ein Wert der uebernommen wird
     */
    public static double berechneReihensumme(int anzahl, double x) {

        ErrorCheck.checkIsNumberNull(anzahl);
        ErrorCheck.checkIsNumberNegative(anzahl);
        ErrorCheck.checkIsNumberNull((long)x);
        ErrorCheck.checkIsNumberNegative((long)x);

        double output = 0.0;
        double x1 = (x - 1);

        for(int i = 1; i < anzahl; i++){
            output = (Math.pow(x1, i))/ (i * Math.pow(x, i));
        }
        return output;
    }

}