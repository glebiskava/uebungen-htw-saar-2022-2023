public class Video extends Artikel{

    private String titel;
    private int spieldauer;
    private int jahr;

    public Video(int artikelNr, String art, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, art, bestand, preis);
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
    public String getBeschreibung() {
        return "Titel" + titel;
    }
}
