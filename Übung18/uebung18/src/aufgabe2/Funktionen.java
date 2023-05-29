import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @author leopold mittelberger, elisee brand
 * @version 1.0
 * Dies ist eine Klasse mit verschiedenen Funktionen
 */

public class Funktionen {

    // private static Scanner input;
    
    /**
     * Aufgabe a)
     * Methode applyAndPrint, nimmt zwei natürliche Zahlen i und j sowie
     * eine Funktion f : N → N entgegen
     * Die Methode soll die übergebene Funktion auf alle
     * Zahlen zwischen i und j anwenden und das Ergebnis ausgeben
     * @param i anfang
     * @param j ende
     * @param f funktion
     */
    public static void applyAndPrint(int i, int j, MyFunction f) {
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("Bitte geben Sie eine Zahl größer als 0 ein!");
        }

        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }

        for (int x = i; x <= j; x++) {
            int result = f.apply(x);
            System.out.println(result);
        }
    }

    /**
     * Lambda ausdruck für erste funktion: (i) f(x) = x^2
     */
    MyFunction quadradLambda = x -> x * x;

    /**
     * Anonyme Implementierung für erste Funktion: (i) f(x) = x^2
     */
    MyFunction quadradAnonym = new MyFunction() {
        public int apply(int i) {
            return i * i;
        }
    };

    /**
     * Lambda Ausdruck für zweite Funktion: (ii) f(x) = x!
     */
    MyFunction faktorielLambda = x -> {
        int result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    };

    /**
     * Anonyme Implementierung für zweite Funktion: (ii) f(x) = x!
     */
    MyFunction faktorielAnonym = new MyFunction() {
        public int apply(int i) {
            int result = 1;
            for (int j = 2; j <= i; j++) {
                result *= j;
            }
            return result;
        }
    };

    /**
     * Top-Level Implentierung für zweite Funktion: (ii) f(x) = x!
     */
    public static class Factoriel implements MyFunction {
        public int apply(int x) {
            int result = 1;
            for (int i = 2; i <= x; i++) {
                result *= i;
            }
            return result;
        }
    }

    /**
     * Zugangsmethode für Top-Level Implementierung
     * @param x naturlische zahl
     * @return factoriel von x 
     */
    public int FactorielAnonymZugang (int x){
        Factoriel fAnonym = new Factoriel();
        
        return fAnonym.apply(x);
    }


    /**
     * Lambda Ausdruck für dritte Funktion: (iii) f(x) = x(x+1)
     */
    MyFunction produktLambda = x -> x * (x + 1);

    /**
     * Anonyme Implementierung für dritte Funktion: (iii) f(x) = x(x+1)
     */
    MyFunction produktAnonym = new MyFunction() {
        public int apply(int i) {
            return i * (i + 1);
        }
    };

    /**
     * Lambda Ausdruck für vierte Funktion: (iv) f(x) = fib(x) (Fibonacci-Folge)
     */
    MyFunction fibonacciLambda = x -> {
        if (x <= 1) {
            return x;
        } else {
            int prev = 0;
            int current = 1;
            for (int i = 2; i <= x; i++) {
                int next = prev + current;
                prev = current;
                current = next;
            }
            return current;
        }
    };

    /**
     * Anonyme Implementierung für vierte Funktion: (iv) f(x) = fib(x) (Fibonacci-Folge)
     */
    MyFunction fibonacciAnonym = new MyFunction() {
        public int apply(int i) {
            if (i <= 1) {
                return i;
            } else {
                int prev = 0;
                int current = 1;
                for (int j = 2; j <= i; j++) {
                    int next = prev + current;
                    prev = current;
                    current = next;
                }
                return current;
            }
        }
    };


    /**
     * Prädikat prüft, ob ein gegebener Integer-Wert gerade bzw. ungerade ist.
     * Hier als Anonyme Implementierung
     */
    Predicate<Integer> odd = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer % 2 != 0;
        }
    };

    /**
     * Prädikat prüft, ob ein gegebener Integer-Wert gerade bzw. ungerade ist.
     * Hier als Lambda Ausdruck
     */
    Predicate<Integer> even = x -> x % 2 == 0;


    /**
     * Aufruf der Methode applyAndPrint mit einem Lambda-Ausdruck, welcher für gerade
     * Zahlen die Quadratzahl berechnet.
     */
    MyFunction geradeQuadrat = x -> {
        if(even.test(x)){
            return x * x;
        } else {
            return x;
        }
    };

    /**
     * Aufruf der Methode applyAndPrint mit einem Lambda-Ausdruck, welcher prüft, ob die
     * Fakultät einer gegebenen Zahl ungerade ist. Ist dies der Fall, wird die Fakultät zurückgegeben,
     * ansonsten 0
     */
    MyFunction ungeradeFakultaet = x -> {
        int xFacto = faktorielAnonym.apply(x);
        if(odd.test(x)){
            return xFacto;
        } else {
            return 0;
        }
    };
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); 
        System.out.println("i: ");
        int i = input.nextInt();
        input.nextLine();

        System.out.println("j: ");
        int j = input.nextInt();
        input.nextLine();

        System.out.println("\n Test fuer FactorielAnonymZugang: \n");
        
        Factoriel fAnonym = new Factoriel();
        applyAndPrint(i, j, fAnonym::apply);
        
        
        System.out.println("\n Test fuer staticNestedFactoriel: \n");
        MyFunction fStatic = new staticNestedFactoriel.FactorielStatischNested();
        applyAndPrint(i, j, fStatic::apply);
    }
}