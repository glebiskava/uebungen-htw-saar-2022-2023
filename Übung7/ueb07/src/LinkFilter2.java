import java.util.Scanner;

public class LinkFilter2 {

    private Scanner input;

    public LinkFilter2 () {
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

                String link = line.substring(hrefIndex);
                String[] premierSplit = link.split("href=[\"\']");
                String premierSplit1 = premierSplit[1];
                String[] secondSplit = premierSplit1.split("[\"\']");
                String linkUrl = secondSplit[0];
                System.out.printf("linkUrl = ", linkUrl);

                // Verwenden Sie die String-Formatierung,
                // um das Ergebnis in einem lesbaren Format auszugeben
                //System.out.printf(linkText[0] + ":\t\t" + linkUrl + " Anzahl Zeichen: " + linkUrlLength + "\n");
                //System.out.printf("%s:\t\t %s :\t\t Anzahl Zeichen: %d \n", linkText[0], linkUrl, linkUrlLength);
            }
        }

        // Zum Schluss geben wir noch die Gesamtzahl der Links und Zeilen aus
        // System.out.printf("%d Links wurden in %d Zeilen gefunden.\n",
        //         linkCount, lineCount);
    }

    public static void main(String args[]) {
        new LinkFilter().funktionsStart();
    }
}