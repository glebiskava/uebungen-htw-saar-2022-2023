import java.util.function.Predicate;

@FunctionalInterface
public interface FunctionalesInterface extends MyFunction{
    default MyFunction conditionateInput(Predicate<Integer> predicate) {
        return x -> predicate.test(x) ? apply(x) : 0;
    }

    default MyFunction conditionateOutput(Predicate<Integer> predicate) {
        return x -> {
            int result = apply(x);
            return predicate.test(result) ? result : 0;
        };
    }
}