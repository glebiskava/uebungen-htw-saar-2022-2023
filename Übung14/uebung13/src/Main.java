public class Main {
    public static void main(String[] args) {
        System.out.println( ggT(256, 8));
    }

    /**
     * Funktion zum Berechnen des Ggt mit dem Algorithmus von Euklid
     */

    public static  int ggT(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return ggT(b, a % b);
        }
    }
}