import java.util.Objects;

/**
 * deis ist eine Unterklasse CD der Oberklasse Artikel
 */

public class CD extends Artikel{

    /**
     * Attribute
     */
    private String interpret;
    private String titel;
    private int anzahlTitel;

    /**
     * Konstruktor CD
     * @param artikelNr nummer des Artikels (Buch)
     * @param bestand bestand des artikels im Lager
     * @param preis preis des Artikels
     * @param interpret name des kuenstlers
     * @param titel name des albums
     * @param anzahlTitel anzhal der titel in einem Album
     */

    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, "Medien", bestand, preis);
        setInterpret(interpret);
        setTitel(titel);
        setAnzahlTitel(anzahlTitel);
    }

    /**
     * getter feur Interpret
     * @return interpret name des kuenstlers
     */
    public String getInterpret() {
        return interpret;
    }

    /**
     * getter fuer Titel
     * @return titel name des albums
     */
    public String getTitel() {
        return titel;
    }

    /**
     * getter fuer AnzahlTitel
     * @return anzahlTitel anzhal der titel in einem Album
     */
    public int getAnzahlTitel() {
        return anzahlTitel;
    }

    /**
     * setter fuer Interpret
     * @param interpret name des kuenstlers
     */
    public void setInterpret(String interpret) {
        ErrorCheck.checkStringNichtLeer(interpret);
        this.interpret = interpret;
    }

    /**
     * setter fuer Titel
     * @param titel name des albums
     */
    public void setTitel(String titel) {
        ErrorCheck.checkStringNichtLeer(titel);
        this.titel = titel;
    }

    /**
     * setter fuer AnzahlTitel
     * @param anzahlTitel anzhal der titel in einem Album
     */
    public void setAnzahlTitel(int anzahlTitel) {
        ErrorCheck.checkGroesserAlsNull(anzahlTitel);
        this.anzahlTitel = anzahlTitel;
    }

    /**
     * equals methode vergleicht zwei Objekte, um festzustellen, ob sie gleich sind
     * @param object welches verglichen wird
     */
    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CD cd = (CD) object;
        return getArtikelNr() == cd.getArtikelNr() &&
                getBestand() == cd.getBestand() &&
                Double.compare(cd.getPreis(), getPreis()) == 0 &&
                Objects.equals(interpret, cd.interpret) &&
                Objects.equals(titel, cd.titel);
    }

    /**
     * erzeugt eine Beschreibung als String
     */
    public String getBeschreibung() {
        return interpret + ": " + titel;
    }

    /**
     * bereitet ein Objekt als String auf
     */
    @Override
    public String toString() {
        return super.toString() + ", interpret: " + interpret + ", titel: " + titel + ", anzahlTitel: " +
                anzahlTitel;
    }
}