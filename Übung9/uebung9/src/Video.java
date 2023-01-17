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
        this.titel = titel;
    }

    public void setSpieldauer(int spieldauer) {
        this.spieldauer = spieldauer;
    }
    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Video video = (Video) object;

        return Objects.equals(titel, video.titel) &&
                spieldauer == video.spieldauer &&
                jahr == video.jahr;
    }
    @Override
    public String getBeschreibung() {
        return titel;
    }

    @Override
    public String toString() {
        return "Video: " + super.toString() + ", Titel: " + titel + ", Spieldauer: " + spieldauer + ", Jahr: " + jahr;
    }
}
