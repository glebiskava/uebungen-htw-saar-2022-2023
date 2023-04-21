import javax.swing.*;
import java.io.*;

public class Messung {

    public static void main(String[] args) throws IOException {

//        JFrame frame = new JFrame("ma fenetre");

        String wort;
        // GnuPlotProcess gp = new GnuPlotProcess();
        // Création d’un fileWriter pour écrire dans un fichier
        FileWriter fileWriter = new FileWriter("messungen.txt", false);

        // Création d’un bufferedWriter qui utilise le fileWriter
        BufferedWriter writer = new BufferedWriter(fileWriter);

        if (args.length > 0) {
            // Eingabestring als Argument übergeben
            wort = args[0];
        } else {
            // Eingabestring aus Datei lesen
            String dateiname = "input.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
                while ((wort = br.readLine()) != null) {

                    Palindrom palindromRek = new PalindromRekursiv();
                    Palindrom palindromIte = new PalindromIterativ();

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

                    // ajout d’un texte à notre fichier
                    writer.write(wort + " : " + zeitRekNanoSecond + ", " + zeitIteNanoSecond);

                    // Retour à la ligne
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
            }

            writer.close();

        }
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
