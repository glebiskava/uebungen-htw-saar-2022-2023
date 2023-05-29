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
     * get fuer Titel
     * @return titel titel des Buchs
     */
    public String getTitel() {
        return titel;
    }

    /**
     * get fuer Author
     * @return author des Buchs
     */
    public String getAuthor() {
        return author;
    }

    /**
     * get fuer Verlag
     * @return verlag des Buchs
     */
    public String getVerlag() {
        return verlag;
    }

    /**
     * setter fuer titel    
     * @param titel titel des Buchs
     */
    public void setTitel(String titel) {
        ErrorCheck.checkStringNichtLeer(titel);
        this.titel = titel;
    }

    /**
     * setter fuer author
     * @param author author des Buchs
     */
    public void setAuthor(String author) {
        ErrorCheck.checkStringNichtLeer(author);
        this.author = author;
    }

    /**
     * setter fuer verlag
     * @param verlag verlag des Buchs
     */
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
        return getArtikelNr() == buch.getArtikelNr() &&
                getBestand() == buch.getBestand() &&
                Double.compare(buch.getPreis(), getPreis()) == 0 &&
                Objects.equals(titel, buch.titel) &&
                Objects.equals(author, buch.author) &&
                Objects.equals(verlag, buch.verlag);
    }

    /**
     * bereitet ein Objekt als String auf
     */
    @Override
    public String toString() {
        return super.toString() + ", titel: " + titel + ", author: " + author + ", verlag: " + verlag;
    }
}