public class Video extends Artikel{

    public String titel;
    public int spieldauer;
    public int jahr;

    public Video(int artikelNr, String art, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, art, bestand, preis);
        this.titel = titel;
        this.spieldauer = spieldauer;
        this.jahr = jahr;
    }
}
