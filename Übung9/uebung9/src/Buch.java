import java.util.Objects;

public class Buch extends Artikel{

    private String titel;
    private String author;
    private String verlag;

    public Buch(int artikelNr, int bestand, double preis, String titel, String author, String verlag) {
        super(artikelNr, "Medien", bestand, preis);
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
        ErrorCheck.checkStringNichtLeer(titel);
        this.titel = titel;
    }

    public void setAuthor(String author) {
        ErrorCheck.checkStringNichtLeer(author);
        this.author = author;
    }

    public void setVerlag(String verlag) {
        ErrorCheck.checkStringNichtLeer(verlag);
        this.verlag = verlag;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Buch buch = (Buch) object;
        return artikelNr == buch.artikelNr &&
                bestand == buch.bestand &&
                Double.compare(buch.preis, preis) == 0 &&
                Objects.equals(titel, buch.titel) &&
                Objects.equals(author, buch.author) &&
                Objects.equals(verlag, buch.verlag);
    }
    @Override
    public String getBeschreibung() {
        return author + ": " + titel;
    }

    @Override
    public String toString() {
        return super.toString() + ", titel: " + titel + ", author: " + author + ", verlag: " + verlag;
    }

    /**
     * generiert einen hashcode fuer ein Objekt
     * @return hashcode des Objekts
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), titel, author, verlag);
    }
}