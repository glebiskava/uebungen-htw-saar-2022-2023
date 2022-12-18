import java.util.Scanner;

public class LinkFilterO {

    Scanner input = new Scanner(System.in);

    int linkCount = 0;
    int lineCount = 0;
    /**
     * Extracts links from the input and displays their text and URL.
     */
    public void funktionsStart() {

        // Solange noch Text in der Eingabe ist,
        // lesen wir eine Zeile ein und suchen nach Links
        while (input.hasNextLine()) {
            String line = input.nextLine();
            lineCount++;

            int hrefIndex = line.indexOf("href");

            // Wenn hrefIndex einen Wert ungleich -1 hat,
            // gibt es einen Link in dieser Zeile
            if (hrefIndex != -1) {

                String link = line.substring(hrefIndex);

                link = link.replace("\"", "");

                String[] parts1 = link.split(">");

                String parts11 = parts1[1];

                String[] linkText = parts11.split("</");

                String[] parts = link.split("=");

                // Der Linktext befindet sich im zweiten Teil des Arrays
                //String linkText = parts[1];
                String[] parts2 = parts[1].split(">");

                String linkUrl = parts2[0];

                //Die Texte in den Tags sind immer kleingeschrieben
                if (linkUrl.equals(linkUrl.toLowerCase())) {
                    linkCount++;

                    System.out.printf("%s: %s, Anzahl Zeichen: %d\n", linkText[0], linkUrl, linkUrl.length());
                }
            }
        }

        System.out.printf("%d Links wurden in %d Zeilen gefunden.\n",
                linkCount, lineCount);

        input.close();
    }

    /**
     * Main method for the LinkExtractor class.
     * @param args command line arguments
     */
    public static void main(String args[]) {
        new LinkFilterO().funktionsStart();
    }
}
