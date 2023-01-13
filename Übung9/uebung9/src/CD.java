public class CD extends Artikel{

    /**
     * Attribute:
     * interpret = Interpret des Musiktitels --> darf nicht leer sein
     * titel = Titel der Musik --> darf nicht leer sein
     * anzahlTitel = Anzahl der Musiktitel --> muss größer 0 sein
     */
    public String interpret;
    public String titel;
    public int anzahlTitel;

    public CD(int artikelNr, String art, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, art, bestand, preis);
        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }



}
