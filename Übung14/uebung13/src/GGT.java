/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Die ist eine Klasse mit einer Methode die den größten gemeinsamen Teiler zweier natürlichen
 * rekursiv berechnet
 */
public class GGT {
    /**
     * Funktion zum Berechnen des Ggt mit dem Algorithmus von Euklid
     */
    public  int ggT(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return ggT(b, a % b);
        }
    }
}
