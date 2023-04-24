import java.io.IOException;
import java.util.InputMismatchException;

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
    public  int ggT(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            return a;
        } else {
            return ggT(b, a % b);
        }
    }

    /**
     * Diese Methode prüft die Argumente, ob diese positiv sind und ob genug eingegeben wurden
     * @param args array mit argumenten
     * @throws IllegalArgumentException
     */
    public void checkNumber(String[] args) throws IllegalArgumentException{
        try {
            if (args.length != 2) {
                throw new RuntimeException("Geben Sie genau zwei positive Zahlen ein!");
            }

            String aStr = args[0];
            String bStr = args[1];

            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);

            if (a < 0 || b < 0) {
                throw new IllegalArgumentException("Geben Sie zwei positive Zahlen ein!");
            }

            System.out.println("Der größte gemeinsame Teiler für " + a + " und " + b + " ist : " + ggT(a, b));

        } catch (RuntimeException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    /**
     * Main Methode zum Starten des Programms
     * @param args Array mit Argumenten
     */
    public static void main(String[] args) {
        GGT ggt = new GGT();
        ggt.checkNumber(args);
    }
}
