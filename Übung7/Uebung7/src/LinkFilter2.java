import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Die ist ein Java-Programm, das aus HTML-Dateien die Hypertextlinks herausfiltert und
 * ausgibt, sowie die Anzahl der Zeichen in den Link zaehlt
 *
 * @author Elisee Brand, Leopold Mittelberger
 */

public class LinkFilter2 {

    /**
     * Scanner objekt erstellen zum einlesen
     * Regex pattern als Konstante, aendert sich ja nicht
     */
    Scanner scanner = new Scanner(System.in);
    private static final String REGEX = "<a\\s+href\\s*=\\s*\"([^\"]*)\"[^>]*>(.*?)</a>";
    int lineCount = 0;
    int linkCount = 0;

    /**
     * Lesen des HTML-Codes von der Standardeingabe dabei verwenden wir
     * regulären Ausdruecke, um Links zu finden
     * Zaehlen der Zeilen und Links
     * Ausgabe der Links, der Zusatzinformationen und der Anzahl der Links und Zeilen als String
     *
     */
    public void funktionsStart() {
        String html = "";

        while (scanner.hasNextLine()) {
            html += scanner.nextLine();
        }

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            linkCount++;
            String linkUrl = matcher.group(1);
            String linkText = matcher.group(2);
            int urlLaenge = linkUrl.length();

            System.out.printf("%s: %s, Anzahl Zeichen: %d%n", linkText, linkUrl, urlLaenge);
            lineCount += matcher.group().split("\n").length;
        }

        System.out.printf("%d Links wurden in %d Zeilen gefunden.%n", linkCount, lineCount);
    }

    /**
     * Funktion zum Starten des Programms
     */
    public static void main(String args[]) {
        new LinkFilter2().funktionsStart();
    }
}