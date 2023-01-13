public class Buch extends Artikel{

    private String titel;
    private String author;
    private String verlag;

    public Buch(int artikelNr, String art, int bestand, double preis, String titel, String author, String verlag) {
        super(artikelNr, art, bestand, preis);
        setTitel(titel);
        setAuthor(author);
        setVerlag(verlag);
    }

    public String getTitel() {
        return titel;
    }

    public String getAuthor() {
        return author;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    @Override
    public String getBeschreibung() {
        return author + ":" + titel;
    }
}
