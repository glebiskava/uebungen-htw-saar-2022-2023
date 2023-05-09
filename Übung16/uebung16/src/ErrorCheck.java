import java.util.ArrayList;

/**
 * @author Léopold Mittelberger, Elisee Brand
 * @version 1.0
 *
 * Diese Klasse ist eine einfache ErroCheck klasse
 */

public class ErrorCheck {

    /**
     * check, ob ein String leer ist
     * @param str String der gecheckt wird
     */
    public static void checkStringEmpty(String str) {
        if (str.strip().isEmpty()) {
            throw new IllegalArgumentException("Die Eingabe darf nicht leer sein");
        }
    }

    /**
     * check, ob ein Integer größer als Null ist
     * @param zahl String der gecheckt wird
     */
    public static void checkIntegerEmpty(Integer zahl) {
        if (zahl <= 0) {
            throw new IllegalArgumentException("Die Zahl muss größer als Null sein!");
        }
    }

    /**
     * check, ob ein Double größer als Null ist
     * @param zahl String der gecheckt wird
     */
    public static void checkDoubleEmpty(Double zahl) {
        if (zahl <= 0.0) {
            throw new IllegalArgumentException("Die Zahl muss größer als Null sein!");
        }
    }

    /**
     * chekct ob eine ArrayList leer ist
     * @param arrayList arraylist die gecheckt wird
     */
    public static void checkArrayEmpty(ArrayList<Getraenkeautomat<? extends Getraenk>> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Es gibt noch keinen Automaten. Legen Sie erst einen an!");
        }
    }

    /**
     * check ob ArrayList voll ist
     * @param arrayList arrayList die gecheckt wird
     */
    public static void checkArrayFull(ArrayList<Getraenkeautomat<? extends Getraenk>> arrayList, int kapazitaet) {
        if (arrayList.size() > kapazitaet) {
            System.out.println("Der Automat ist voll. Geben Sie eine Flasche aus oder legen Sie einen neuen an!");
        }
    }







}