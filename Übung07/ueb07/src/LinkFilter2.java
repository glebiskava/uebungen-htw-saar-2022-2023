import java.util.Scanner;

public class LinkFilter2 {

    private Scanner input;

    public LinkFilter2 () {
        input = new Scanner(System.in);
    }

    public void funktionsStart2() {

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
                String[] premierSplit = link.split("href\s*=\s*[\"\']");
                String premierSplit1 = premierSplit[1];

                System.out.println("premierSplit1 = " + premierSplit1 +"\n");
                System.out.println("premierSplit[0] = " + premierSplit[0] + "\n");

                String[] secondSplit = premierSplit1.split("[\"\']\s*");
                String linkUrl = secondSplit[0];
                String secondSplit1 = secondSplit[1];

                System.out.println("linkUrl = " + linkUrl + "\n");
                System.out.println("secondSplit[1] = " + secondSplit[1] + "\n\n\n\n");

                String[] troisiemeSplit = secondSplit1.split(">");
                String troisiemeSplit1 = troisiemeSplit[1];

                String[] quatriemeSplit = troisiemeSplit1.split("<");
                String linkText = quatriemeSplit[0];

                int linkUrlLength = linkUrl.length();

                // Verwenden Sie die String-Formatierung,
                // um das Ergebnis in einem lesbaren Format auszugeben
                //System.out.printf(linkText[0] + ":\t\t" + linkUrl + " Anzahl Zeichen: " + linkUrlLength + "\n");
                System.out.printf("%s:\t\t %s :\t\t Anzahl Zeichen: %d \n", linkText, linkUrl, linkUrlLength);
            }
        }

        // Zum Schluss geben wir noch die Gesamtzahl der Links und Zeilen aus
        // System.out.printf("%d Links wurden in %d Zeilen gefunden.\n",
        //         linkCount, lineCount);
    }

    public static void main(String args[]) {
        new LinkFilter2().funktionsStart2();
    }
}