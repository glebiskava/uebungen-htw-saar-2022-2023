package aufgabe2;

/**
 * @author leopold mittelberger, elisee brand
 * @version 1.0
 * Dies ist ein klasse mit einer statischen inneren klasse, die die funktion f(x) = x! implementiert
 */
public class staticNestedFactoriel {
    /**
     * Static-Nested Implementierung für zweite Funktion: (ii) f(x) = x!
     */
    public static class FactorielStatischNested implements MyFunction {
        /**
         * Methode zur Berechnung der Fakultät einer Zahl
         * @param x Zahl, deren Fakultät berechnet werden soll
         * @return Fakultät der Zahl
         */
        public int apply(int x) {
            int result = 1;
            for (int i = 2; i <= x; i++) {
                result *= i;
            }
            return result;
        }
    }
}