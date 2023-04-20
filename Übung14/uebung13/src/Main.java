import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist ein Programm, welches entweder Wörter aus einer Datei liest und dann prüft, ob es
 * ein Palindrom ist oder es bekommt ein Argument (ein Wort) über die Konsole mitgegeben
 */
public class Main {
    public static void main(String[] args) {

        String dateiname = "input.txt";

        Palindrom palindromRek =  new PalindromRekursiv();
        Palindrom palindromIte =  new PalindromIterativ();

        if (args.length == 0) {
            throw new IllegalArgumentException(
                    """
                            Nicht genügend Argumente. \nVerwendung: java PalindromMain [r/i]
                            oder
                            java PalindromMain [r/i] [wort]"""
            );
        }
         /*
        - jede Zeile wird singles und der erste String der dem Regex pattern entspricht wird in einem
        - Array gespeichert
        - das Array wird durch iteriert und jedes wort wird getestet
        - je nachdem was mein eingegeben hat als parameter vorher wird es entweder rekursiv oder iterativ berechnet
        - Fehler beim Einlesen der Datei werden abgefangen
         */

        else if (args.length == 1) {
            try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] woerter = line.split("\\s+");

                    for (String wort : woerter) {
                        if (args[0].equals("r")) {
                            if (palindromRek.istPalindrom(wort)) {
                                System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist ein Palindrom.\n");
                            } else {
                                System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist kein Palindrom.\n");

                            }
                        } else if (args[0].equals("i")) {
                            if (palindromIte.istPalindrom(wort)) {
                                System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist ein Palindrom.\n");
                            } else {
                                System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist kein Palindrom.\n");
                            }
                        } else {
                            throw new IllegalArgumentException("Diesen Parameter gibt es nicht: " + args[0]);

                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        /*
        - wenn nur ein Argument über die Konsole mitgegeben wird dann wird dieses Wort getestet
        - wenn nicht, dann nimmt das programm die Wörter aus der Datei
        - gibt mann als erstes Argument r oder i ein wird es rekursiv oder iterativ berechnet
         */
        else {
            try {
                String wort = args[1];
                if (args[0].equals("r")) {
                    if (palindromRek.istPalindrom(wort)) {
                        System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist ein Palindrom.\n");
                    } else {
                        System.out.println("Rekursiv >>> Das Wort \"" + wort + "\" ist kein Palindrom.\n");

                    }
                } else if (args[0].equals("i")) {
                    if (palindromIte.istPalindrom(wort)) {
                        System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist ein Palindrom.\n");
                    } else {
                        System.out.println("Iterativ >>> Das Wort \"" + wort + "\" ist kein Palindrom.\n");
                    }
                } else {
                    throw new IllegalArgumentException("Diesen Parameter gibt es nicht: " + args[0]);

                }
            } catch (IllegalArgumentException e) {
                System.err.println("Fehler: " + e.getMessage());
            }
        }
    }
}