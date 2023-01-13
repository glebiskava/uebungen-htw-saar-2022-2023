public class Buch extends Artikel{

    public String titel;
    public String author;
    public String verlag;

    public Buch(int artikelNr, String art, int bestand, double preis, String titel, String author, String verlag) {
        super(artikelNr, art, bestand, preis);
        this.titel = titel;
        this.author = author;
        this.verlag = verlag;
    }
}
