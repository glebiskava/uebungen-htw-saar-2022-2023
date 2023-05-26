import java.util.Objects;

/**
 * Dies ist eine Unterklasse Buch von der Klasse Artikel welche
 */

public class Buch extends Artikel{

    /**
     * attribute: selbsterklaerend
     */
    private String titel;
    private String author;
    private String verlag;

    /**
     * Konstruktor Buch
     * @param artikelNr nummer des Artikels (Buch)
     * @param bestand bestand des artikels im Lager
     * @param preis preis des Artikels
     * @param titel titel des Buchs
     * @param author author des Buchs
     * @param verlag verlag des Buchs
     */

    public Buch(int artikelNr, int bestand, double preis, String titel, String author, String verlag) {
        super(artikelNr, "Medien", bestand, preis);
        setTitel(titel);
        setAuthor(author);
        setVerlag(verlag);
    }

    /**
     * getter fuer jedes Attribut
     */
    public String getTitel() {
        return titel;
    }

    public String getAuthor() {
        return author;
    }

    public String getVerlag() {
        return verlag;
    }

    /**
     * setter fuer jedes Attribute
     */
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

    /**
     * equals methode vergleicht zwei Objekte, um festzustellen, ob sie gleich sind
     * @param object welches verglichen wird
     */
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

    /**
     * erzeugt eine Beschreibung als String
     */
    @Override
    public String getArt() {
        return author + ": " + titel;
    }

    /**
     * bereitet ein Objekt als String auf
     */
    @Override
    public String toString() {
        return super.toString() + ", titel: " + titel + ", author: " + author + ", verlag: " + verlag;
    }
}