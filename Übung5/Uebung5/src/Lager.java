import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Elisee Brand, Leopold Mittelberger
 */

public class Lager {

    /**
     *
     */
    private int Array_Dim;


    private static Artikel[] lager;

    private final static int MAX_ANZAHL = 10;
   // private Lager lager;

    /** Konstruktoren
     * erster Konstruktor fuer Artikel(artikelNr, art und Bestand)
     * Aufruf der Funktion zum Pruefen der Eingaben beim Anlegen eines Objektes
     */
    public Lager(int ArrayDim) {
        lager = new Artikel[MAX_ANZAHL];
        PACKAGE_NAME.ErrorCheck.checkArtikelAttribute(ArrayDim);
        for (int i = 0; i < lager.length; i++) {
            lager[i] = null;
        }
    }

    /**
     * weiter Konstruktor für Artikel(artikelNr und art)
     */
    public Lager() {
        this(MAX_ANZAHL);
        for (int i = 0; i < lager.length; i++) {
            lager[i] = null;
        }
    }

    public static void legeAnArtikel(Artikel artikel){
        System.out.println("lager[0] " + lager[0]);
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] == null) {
                lager[i] = artikel;
                break;
            }
        }
        //lager[0] = artikel;
        /*for(int i = 0; i < MAX_ANZAHL; i++) {
            System.out.println("i = " + i);
            lager[i] = artikel;
        }*/
    }

    /*public static int entferneArtikel(int artikelNr){
        for(int i = 0; i < indexArray; i++){
            if(artikelNr == lager[i].getArtikelNr()){
                if(lager[(i + 1)] == null || i == (indexArray - 1)){
                    lager[i] = null;
                } else {
                    lager[i] = lager[i + 1];
                }
            }
        }
    return 0;
    }*/
}
