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
        this.titel = titel;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    /**
     * Checks if the provided object is equal to this book.
     * @param object the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || !(object instanceof Buch)) return false;
        if (!super.equals(object)) return false;
        Buch buch = (Buch) object;
        return Objects.equals(titel, buch.titel) &&
                Objects.equals(author, buch.author) &&
                Objects.equals(verlag, buch.verlag);
    }

    @Override
    public String getBeschreibung() {
        return author + ": " + titel;
    }

    @Override
    public String toString() {
        return "Buch: " + super.toString() + ", Titel: " + titel + ", Author: " + author + ", Verlag: " + verlag;
    }
}
