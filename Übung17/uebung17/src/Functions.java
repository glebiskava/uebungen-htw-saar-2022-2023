import java.util.function.Predicate;

public class Functions {

    //a
    public static void applyAndPrint(int i, int j, MyFunction f) {
        for (int x = i; x <= j; x++) {
            int result = f.apply(x);
            System.out.println(result);
        }
    }

    //b
    // (i) f(x) = x^2
    MyFunction squareLambda = x -> x * x;
    MyFunction squareAnonymous = new MyFunction() {
        public int apply(int i) {
            return i * i;
        }
    };

    // (ii) f(x) = x!
    MyFunction factorialLambda = x -> {
        int result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    };

    MyFunction factorialAnonymous = new MyFunction() {
        public int apply(int i) {
            int result = 1;
            for (int j = 2; j <= i; j++) {
                result *= j;
            }
            return result;
        }
    };

    public static class Factorial implements MyFunction {
        public int apply(int x) {
            int result = 1;
            for (int i = 2; i <= x; i++) {
                result *= i;
            }
            return result;
        }
    }

    // Statische Nested-Klasse
    public static class FactorialStaticNested implements MyFunction {
        public int apply(int x) {
            int result = 1;
            for (int i = 2; i <= x; i++) {
                result *= i;
            }
            return result;
        }
    }

    // (iii) f(x) = x(x+1)
    MyFunction productLambda = x -> x * (x + 1);
    MyFunction productAnonymous = new MyFunction() {
        public int apply(int i) {
            return i * (i + 1);
        }
    };

    // (iv) f(x) = fib(x) (Fibonacci-Folge)
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
    MyFunction fibonacciAnonymous = new MyFunction() {
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


    //d
    Predicate<Integer> even = x -> x % 2 == 0;

    Predicate<Integer> odd = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer % 2 != 0;
        }
    };

    MyFunction evenQuadrat = x -> {
        if(even.test(x)){
            return x * x;
        } else {
            return x;
        }
    };

    //f
    MyFunction fakultatOdd = x -> {
        int xFacto = factorialAnonymous.apply(x);
        if(odd.test(x)){
            return xFacto;
        } else {
            return 0;
        }
    };
}