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
    public int[] zahlen;

    private int indexArray = zahlen.length;


    /** Konstruktoren
     * erster Konstruktor fuer Artikel(artikelNr, art und Bestand)
     * Aufruf der Funktion zum Pruefen der Eingaben beim Anlegen eines Objektes
     */
    public Lager(int Array_Dim) {
        checkArtikelAttribute(Array_Dim);
    }

    /**
     * weiter Konstruktor für Artikel(artikelNr und art)
     */
    //public Lager(int Array_Dim) {
    //    this(10);
    //}

    public static void legeAnArtikel(Artikel artikel){
        zahlen = new int[Array_Dim];

        zahlen[indexArray + 1] = artikel.artikelNr;
    }

    public int entferneArtikel(int artikelNr){
        zahlen = new int[Array_Dim];
        for(int i = 0; i < indexArray; i++){
            if(artikelNr == zahlen[i]){
                if(zahlen[i + 1] == 0 || i == (indexArray - 1)){
                    zahlen[i] = 0;
                } else {
                    zahlen[i] = zahlen[i + 1];
                }
            }
        }
    return zahlen[0];
    }


    /**
     * Diese Funktion prueft auf fehlerhafte Eingaben
     */
    public void checkArtikelAttribute(int Array_Dim) {
        if(Array_Dim <= 0) {
            throw new IllegalArgumentException("Keine gültige Eingabe. Der Zahl soll eine int groesser als 0 sein.");
        }
        this.Array_Dim = Array_Dim;
    }
}
