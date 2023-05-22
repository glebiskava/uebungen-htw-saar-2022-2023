import java.util.function.Predicate;

public class Lambda {
    //b
    public void applyAndPrint(int arg1, MyFunction function){
        System.out.println(function.apply(arg1));
        System.out.println(function.apply(arg1));
    }

    public MyFunction quadrad = x -> x * x;
    public MyFunction factoriel = x -> {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    };
    public MyFunction puissanceXplus1 = x -> (int)Math.pow(x, x+1);
    public MyFunction fibonacci = x -> {
        int result = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i < x; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    };

    static class FibonacciFunktion implements MyFunction{
        @Override
        public int apply(int i){
            int result = 0;
            int a = 0;
            int b = 1;
            for (int j = 2; j < i; j++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }
    }

    //d

    //) Implementieren Sie ein Prädikat odd und ein Prädikat even. Die Prädikate sollen prüfen, ob
    // ein gegebener Integer-Wert gerade bzw. ungerade ist. Implementieren Sie das odd-Prädikat
    // als anonyme Klasse und das even-Prädikat als Lambda-Ausdruck.
    Predicate<Integer> even = x -> x % 2 == 0;

    Predicate<Integer> odd = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer % 2 != 0;
        }
    };

    //Rufen Sie die Methode applyAndPrint mit einem Lambda-Ausdruck auf, welcher für gerade
    //Zahlen die Quadratzahl berechnet.
    MyFunction evenQuadrat = x -> {
        if(even.test(x)){
            return x * x;
        } else {
            return x;
        }
    };
    //f
    MyFunction fakultatOdd = x -> {
        int xFacto = factoriel.apply(x);
        if(odd.test(xFacto)){
            return xFacto;
        } else {
            return 0;
        }
    };

    //e mais ca marche pas
    // applyAndPrint(2, evenQuadrat);



}