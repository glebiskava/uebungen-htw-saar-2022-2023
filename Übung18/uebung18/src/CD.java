import java.util.Objects;

/**
 * deis ist eine Unterklasse CD der Oberklasse Artikel
 */

public class CD extends Artikel{

    /**
     * Attribute:
     * interpret = Interpret des Musiktitels --> darf nicht leer sein
     * titel = Titel der Musik --> darf nicht leer sein
     * anzahlTitel = Anzahl der Musiktitel --> muss größer 0 sein
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
     * getter feur jedes Attribut
     */
    public String getInterpret() {
        return interpret;
    }

    public String getTitel() {
        return titel;
    }

    public int getAnzahlTitel() {
        return anzahlTitel;
    }

    /**
     * setter fuer jedes Attribut
     */
    public void setInterpret(String interpret) {
        ErrorCheck.checkStringNichtLeer(interpret);
        this.interpret = interpret;
    }

    public void setTitel(String titel) {
        ErrorCheck.checkStringNichtLeer(titel);
        this.titel = titel;
    }

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
        return artikelNr == cd.artikelNr &&
                bestand == cd.bestand &&
                Double.compare(cd.preis, preis) == 0 &&
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