import java.util.Objects;

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

    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, "Medien", bestand, preis);
        setInterpret(interpret);
        setTitel(titel);
        setAnzahlTitel(anzahlTitel);
    }

    public String getInterpret() {
        return interpret;
    }

    public String getTitel() {
        return titel;
    }

    public int getAnzahlTitel() {
        return anzahlTitel;
    }

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

    public String getBeschreibung() {
        return interpret + ": " + titel;
    }

    @Override
    public String toString() {
        return super.toString() + ", interpret: " + interpret + ", titel: " + titel + ", anzahlTitel: " +
                anzahlTitel;
    }

    /**
     * generiert einen hashcode fuer ein Objekt
     * @return hashcode des Objekts
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interpret, titel, anzahlTitel);
    }
}