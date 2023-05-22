import java.util.function.Predicate;

@FunctionalInterface
public interface FunctionalesInterface extends MyFunction{
    default MyFunction conditionateInput(Predicate predicat){ // prédicat en argument
        MyFunction result = x -> predicat.test(x) ? this.apply(x) : 0;
        return result;
        // return result;
        //return résultat de la méthode apply de l'interface
    }

    default MyFunction conditionateOutput(Predicate predicat){ // prédicat en argument
        MyFunction result = x -> predicat.test(apply(x)) ? this.apply(x) : 0;
        return result;
    }
}
/**
 * Implémentez une interface fonctionnelle qui étend l'interface utilisée dans la tâche 1a. 
 * Cette interface doit comporter les deux posséder les méthodes supplémentaires suivantes avec une implémentation par défaut :
 i conditionateInput : Cette méthode prend un prédicat en argument et renvoie une expression lambda.
 L'expression lambda vérifie pour une valeur entière donnée si celle-ci satisfait au prédicat.
 Si le prédicat est rempli, le résultat de la méthode apply de l'interface est renvoyé, sinon 0 est renvoyé.

 ii conditionateOutput : Cette méthode prend également un prédicat en argument et renvoie une expression lambda.
 L'expression lambda vérifie si le résultat de la méthode apply satisfait le prédicat. Si le prédicat est rempli,
 le résultat est renvoyé, sinon 0.

 */