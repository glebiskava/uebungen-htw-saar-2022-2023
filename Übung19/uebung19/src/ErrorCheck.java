import java.util.NoSuchElementException;

public class ErrorCheck {
    public static void checkObObjektNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Das Objekt ist null. Es darf nicht null sein.");
        }
    }

    public static void checkObListeLeer(int size) {
        if (size == 0) {
            throw new NoSuchElementException("Es gibt kein Element in der List. Die Liste ist leer");
        }
    }


}
