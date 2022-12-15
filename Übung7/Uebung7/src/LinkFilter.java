import java.util.Scanner;

public class LinkFilter {

    private Scanner input;

    public LinkFilter () {
        input = new Scanner(System.in);
    }

    public void funktionsStart() {

        // Zählvariablen für Links und Zeilen
        int linkCount = 0;
        int lineCount = 0;

        // Solange noch Text in der Eingabe ist,
        // lesen wir eine Zeile ein und suchen nach Links
        while (input.hasNextLine()) {
            System.out.println("Geben Sie Ihren HTML ein: ");
            String line = input.nextLine();
            lineCount++;

            // Verwenden Sie die Methode indexOf() der Klasse String,
            // um die Position des Wortes "href" zu finden
            int hrefIndex = line.indexOf("href");

            // Wenn hrefIndex einen Wert ungleich -1 hat,
            // gibt es einen Link in dieser Zeile
            if (hrefIndex != -1) {
                linkCount++;

                // Verwenden Sie die Methode substring() der Klasse String,
                // um den Link aus der Zeile zu extrahieren
                String link = line.substring(hrefIndex);

                // Verwenden Sie die Methode replace() der Klasse String,
                // um die Anführungszeichen aus dem Link zu entfernen
                link = link.replace("\"", "");

                // Verwenden Sie die Methode split() der Klasse String,
                // um den Link und den Linktext zu trennen
                String[] parts = link.split(">");

                // Der Link selbst befindet sich im ersten Teil des Arrays
                String linkUrl = parts[0];

                // Der Linktext befindet sich im zweiten Teil des Arrays
                String linkText = parts[1];

                // Verwenden Sie die Methode length() der Klasse String,
                // um die Länge der URL zu bestimmen
                int linkUrlLength = linkUrl.length();

                // Verwenden Sie die String-Formatierung,
                // um das Ergebnis in einem lesbaren Format auszugeben
                System.out.printf("%s: %s, Anzahl Zeichen: %d\n",
                        linkText, linkUrl, linkUrlLength);
            }
        }

        // Zum Schluss geben wir noch die Gesamtzahl der Links und Zeilen aus
        System.out.printf("%d Links wurden in %d Zeilen gefunden.\n",
                linkCount, lineCount);
    }

    public static void main(String args[]) {
        new LinkFilter().funktionsStart();
    }
}