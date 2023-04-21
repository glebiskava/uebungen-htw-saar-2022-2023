import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
<<<<<<< HEAD
 * Diese Methode misst die Ausführungsgeschwindigkeit der Berechnung eines Palindrom
=======
 *
>>>>>>> origin/main
 */

public class Messung {

    public static void main(String[] args) throws IOException {
        Messung messung = new Messung();

        messung.messen(args);
    }


    public void messen(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("messungen.txt", false);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        Palindrom palindromRek = new PalindromRekursiv();
        Palindrom palindromIte = new PalindromIterativ();

        if (isFile(args)) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String wort;
                String wortVorReplace;
                while ((wort = br.readLine()) != null) {

                    wortVorReplace = wort;
                    wort = wort.toLowerCase().replace(" ", "");

                    long nanoTime1Rek = System.nanoTime();
                    Boolean palindromeRekursive = palindromRek.istPalindrom(wort);
                    long nanoTime2Rek = System.nanoTime();

                    long zeitRekNanoSecond = nanoTime2Rek - nanoTime1Rek;
                    System.out.println("Zeit brauch um mit den Rekursive funktion zu berechen : " + zeitRekNanoSecond + " nano seconds");

                    long nanoTime1Ite = System.nanoTime();
                    Boolean palindromeIterative = palindromIte.istPalindrom(wort);
                    long nanoTime2Ite = System.nanoTime();

                    long zeitIteNanoSecond = nanoTime2Ite - nanoTime1Ite;
                    System.out.println("Zeit brauch um mit den Iterative funktion zu berechen : " + zeitIteNanoSecond + " nano seconds");

                    if (palindromeRekursive && palindromeIterative) {
                        System.out.println("Rekursiv >>> Das Wort \"" + wortVorReplace + "\" ist ein Palindrom.");
                        System.out.println("Iterativ >>> Das Wort \"" + wortVorReplace + "\" ist ein Palindrom.\n");
                    } else {
                        System.out.println("Rekursiv >>> Das Wort \"" + wortVorReplace + "\" ist kein Palindrom.");
                        System.out.println("Iterativ >>> Das Wort \"" + wortVorReplace + "\" ist kein Palindrom.\n");
                    }

                    writer.write(wort + " : " + zeitRekNanoSecond + ", " + zeitIteNanoSecond);

                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
            }
        } else {
            try {
                String wort = args[0];

                long nanoTime1Rek = System.nanoTime();
                Boolean palindromeRekursive = palindromRek.istPalindrom(wort);
                long nanoTime2Rek = System.nanoTime();

                long zeitRekNanoSecond = nanoTime2Rek - nanoTime1Rek;
                System.out.println("Zeit brauch um mit den Rekursive funktion zu berechen : " + zeitRekNanoSecond + " nano seconds");

                long nanoTime1Ite = System.nanoTime();
                Boolean palindromeIterative = palindromIte.istPalindrom(wort);
                long nanoTime2Ite = System.nanoTime();

                long zeitIteNanoSecond = nanoTime2Ite - nanoTime1Ite;
                System.out.println("Zeit brauch um mit den Iterative funktion zu berechen : " + zeitIteNanoSecond + " nano seconds");

                if (palindromeRekursive && palindromeIterative) {
                    System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist ein Palindrom.");
                    System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist ein Palindrom.\n");
                } else {
                    System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist kein Palindrom.");
                    System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist kein Palindrom.\n");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Fehler : " + e.getMessage());
            }
        }

        writer.close();

    }
    /**
     * Diese Methode testet, ob ein über gegebenes Argument ein File ist oder nicht
     * @param args Array
     * @return true, wenn es ein File ist false, wenn nicht
     */
    public boolean isFile(String[] args) {
        if(args.length == 0) {
            throw new IllegalArgumentException("Fehler! Verwendung: java PalindromRechner [wort] oder [file.txt]");
        }

        for(String arg: args) {
            File file = new File(arg);

            if(file.isFile()) {
                return true;
            }
        } return false;

    }
}