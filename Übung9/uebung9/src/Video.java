import java.util.Objects;

public class Video extends Artikel{

    private String titel;
    private int spieldauer;
    private int jahr;

    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, "Medien", bestand, preis);
        setTitel(titel);
        setSpieldauer(spieldauer);
        setJahr(jahr);
    }

    public String getTitel() {
        return titel;
    }

    public int getSpieldauer() {
        return spieldauer;
    }

    public int getJahr() {
        return jahr;
    }

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
    @Override
    public String getBeschreibung() {
        return titel;
    }

    @Override
    public String toString() {
        return super.toString() + ", titel: " + titel + ", spieldauer: " + spieldauer + ", jahr: " + jahr;
    }

    /**
     * generiert einen hashcode fuer ein Objekt
     * @return hashcode des Objekts
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), titel, spieldauer, jahr);
    }
}