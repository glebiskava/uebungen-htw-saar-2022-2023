import java.util.function.Predicate;


/**
 * @author leopold mittelberger, elisee brand
 * @version 1.0
 * Dies ist ein einfaches funktionales Interface welches das interface aus Aufgabe 1a erweitert
 */
@FunctionalInterface
public interface FunktionalesInterface extends MyFunction {

    /**
     * Diese Methode nimmt ein Prädikat als Argument entgegen und
     * gibt einen Lambda-Ausdruck zurück. Der Lambda-Ausdruck prüft für einen gegebenen
     * Integer-Wert, ob dieser das Prädikat erfüllt. Ist das Prädikat erfüllt, wird das Ergebnis der
     * apply-Methode des Interfaces zurückgegeben, ansonsten wird 0 zurückgegeben.
     * @param predicate prädikat dass entgegengenommen wird
     * @return prädikat
     */
    default MyFunction conditionateInput(Predicate<Integer> predicate) {
        return x -> predicate.test(x) ? apply(x) : 0;
    }

    /**
     * Diese Methode nimmt ebenfalls ein Prädikat als Argument ent-
     * gegen und gibt einen Lambda-Ausdruck zurück. Der Lambda-Ausdruck prüft, ob das
     * Ergebnis der apply-Methode das Prädikat erfüllt. Ist das Prädikat erfüllt, wird das Ergeb-
     * nis zurückgegeben, ansonsten 0
     * @param predicate prädikat dass entgegengenommen wird
     * @return prädikat
     */
    default MyFunction conditionateOutput(Predicate<Integer> predicate) {
        return x -> {
            int result = apply(x);
            return predicate.test(result) ? result : 0;
        };
    }
}

