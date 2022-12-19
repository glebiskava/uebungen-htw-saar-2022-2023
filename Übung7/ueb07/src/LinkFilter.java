import java.util.Scanner;

public class LinkFilter {

    private Scanner input;

    public LinkFilter () {
        input = new Scanner(System.in);
    }

    public void funktionsStart() {

        // private static final REGEX_LINK = '<a href=[]';
        // Zählvariablen für Links und Zeilen
        int linkCount = 0;
        int lineCount = 0;

        // Solange noch Text in der Eingabe ist,
        // lesen wir eine Zeile ein und suchen nach Links
        while (input.hasNextLine()) {
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

                // split again
                String[] parts1 = link.split(">");

                // put it in a String
                String parts11 = parts1[1];

                // split again 
                String[] linkText = parts11.split("<.*?/.*?[a-z]");

                // Verwenden Sie die Methode split() der Klasse String,
                // um den Link und den Linktext zu trennen
                String[] parts = link.split("=");

                // Der Linktext befindet sich im zweiten Teil des Arrays
                //String linkText = parts[1];
                String[] parts2 = parts[1].split(">");

                // put it in a String
                String linkUrl = parts2[0];

                // Verwenden Sie die Methode length() der Klasse String,
                // um die Länge der URL zu bestimmen
                int linkUrlLength = linkUrl.length();

                // Verwenden Sie die String-Formatierung,
                // um das Ergebnis in einem lesbaren Format auszugeben
                //System.out.printf(linkText[0] + ":\t\t" + linkUrl + " Anzahl Zeichen: " + linkUrlLength + "\n");
                System.out.printf("%s:\t\t %s :\t\t Anzahl Zeichen: %d \n", linkText[0], linkUrl, linkUrlLength);
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