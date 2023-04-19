import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String wort;
        if (args.length > 0) {
            // Eingabestring als Argument übergeben
            wort = args[0];
        } else {
            // Eingabestring aus Datei lesen
            String dateiname = "input.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
                wort = br.readLine();
            } catch (IOException e) {
                System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
                return;
            }
        }

        // Palindrom-Tests
        Palindrom[] algorithmen = {
                new PalindromRekursiv(),
                new PalindromIterativ()
        };

        for (Palindrom p : algorithmen) {
            if (p.istPalindrom(wort)) {
                System.out.println("Das Wort \"" + wort + "\" ist ein Palindrom.");
            } else {
                System.out.println("Das Wort \"" + wort + "\" ist kein Palindrom.");
            }
        }
    }
}