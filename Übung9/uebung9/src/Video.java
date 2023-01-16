import java.util.Objects;

/**
 * Dies ist eine Unterklasse Video von der Klasse Artikel welche
 */

public class Video extends Artikel{

    /**
     * attribute: selbsterklaerend
     */
    private String titel;
    private int spieldauer;
    private int jahr;

    /**
     * Konstruktor Video
     * @param artikelNr nummer des Artikels (Buch)
     * @param bestand bestand des artikels im Lager
     * @param preis preis des Artikels
     * @param titel titel des Videos
     * @param spieldauer spieldauer des videos in minuten
     * @param jahr veroeffentlichungsjahr
     */
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, "Medien", bestand, preis);
        setTitel(titel);
        setSpieldauer(spieldauer);
        setJahr(jahr);
    }

    /**
     * getter fuer jedes attribut
     */
    public String getTitel() {
        return titel;
    }

    public int getSpieldauer() {
        return spieldauer;
    }

    public int getJahr() {
        return jahr;
    }

    /**
     * setter fuer jedes Attribut
     * @param titel
     */
    public void setTitel(String titel) {
        ErrorCheck.checkStringNichtLeer(titel);
        this.titel = titel;
    }

    public void setSpieldauer(int spieldauer) {
        ErrorCheck.checkGroesserAlsNull(spieldauer);
        this.spieldauer = spieldauer;
    }
    public void setJahr(int jahr) {
        ErrorCheck.checkZwischen1900und2022(jahr);
        this.jahr = jahr;
    }

    /**
     * equals methode vergleicht zwei Objekte, um festzustellen, ob sie gleich sind
     * @param object welches verglichen wird
     */
    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Video video = (Video) object;
        return artikelNr == video.artikelNr &&
                bestand == video.bestand &&
                Double.compare(video.preis, preis) == 0 &&
                Objects.equals(titel, video.titel) &&
                Objects.equals(spieldauer, video.spieldauer) &&
                Objects.equals(jahr, video.jahr);
    }

    /**
     * erzeugt eine Beschreibung als String
     */
    @Override
    public String getBeschreibung() {
        return titel;
    }

    /**
     * bereitet ein Objekt als String auf
     */
    @Override
    public String toString() {
        return super.toString() + ", titel: " + titel + ", spieldauer: " + spieldauer + ", jahr: " + jahr;
    }
}