package PACKAGE_NAME;public class ErrorCheck {
    private int Array_Dim;

    /**
     * Diese Funktion prueft auf fehlerhafte Eingaben
     */
    public static void checkArtikelAttribute(int Array_Dim) {
        if(Array_Dim <= 0) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Der Zahl soll eine int groesser als 0 sein.");
        }

    }
}
