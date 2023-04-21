import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist ein Programm, welches entweder Wörter aus einer Datei liest und dann prüft, ob es
 * ein Palindrom ist oder es bekommt ein Argument (ein Wort) über die Konsole mitgegeben
 */
public class PalindromRechner {
    public static void main(String[] args) {
        PalindromRechner palindrom = new PalindromRechner();
        palindrom.isPalindrom(args);
    }

    /**
     * Diese Methode prüft ein oder mehrere Wörter, ob es ein Palindrom ist oder nicht
     * @param args array mit argumenten
     */
    public void isPalindrom(String[] args) {

        Palindrom palindromRek =  new PalindromRekursiv();
        Palindrom palindromIte =  new PalindromIterativ();

        if (isFile(args)) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String wort;
                String wortVorReplace;
                while ((wort = br.readLine()) != null) {
                    wortVorReplace = wort;
                    wort = wort.toLowerCase().replace(" ", "");
                    if (palindromRek.istPalindrom(wort)) {
                        System.out.println("Rekursiv >>> Das Wort \"" + wortVorReplace + "\" ist ein Palindrom.");
                    } else {
                        System.out.println("Rekursiv >>> Das Wort \"" + wortVorReplace + "\" ist kein Palindrom.");
                    }

                    if (palindromIte.istPalindrom(wort)) {
                        System.out.println("Iterativ >>> Das Wort \"" + wortVorReplace + "\" ist ein Palindrom.\n");
                    } else {
                        System.out.println("Iterativ >>> Das Wort \"" + wortVorReplace + "\" ist kein Palindrom.\n");
                    }
                }
            } catch (IOException e) {
                System.err.println("Fehler: " + e.getMessage());
            }
        } else {
            try {
                String wort = args[0];
                if (palindromRek.istPalindrom(wort)) {
                    System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist ein Palindrom.");
                } else {
                    System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist kein Palindrom.");

                }
                if (palindromIte.istPalindrom(wort)) {
                    System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist ein Palindrom.\n");
                } else {
                    System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist kein Palindrom.\n");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Fehler: " + e.getMessage());
            }
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