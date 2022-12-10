import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class ArtikelTest {

    /**
     * Test für den ersten Konstruktor und ob die korrekte Artikelnummer uebergeben wurde
     */
    @Test
    public void test_erster_Konstruktor_And_Check_For_Artikelnummer() {
        // Erstellen eines neuen Artikelobjekts mithilfe des ersten Konstruktors
        Artikel artikel = new Artikel(1000, "Test artikel", 10, 10.0);

        // Pruefen, ob die Attribute des Objekts korrekt gesetzt sind
        assertEquals(1000, artikel.getArtikelNr());
        assertEquals("Test artikel", artikel.getArt());
        assertEquals(10, artikel.getBestand());
        assertEquals(10.0, artikel.getPreis());
    }

    /**
     * Test für den Konstruktor und ob die korrekte Artikelnummer uebergeben wurde
     */
    @Test
    public void test_zweiten_Konstruktor_And_Check_For_Artikelnummer() {
        // Erstellen eines neuen Artikelobjekts mithilfe des zweiten Konstruktors
        Artikel artikel = new Artikel(1000, "Test artikel", 0, 0.0);

        // Pruefen, ob die Attribute des Objekts korrekt gesetzt sind
        assertEquals(1000, artikel.getArtikelNr());
        assertEquals("Test artikel", artikel.getArt());
        assertEquals(0, artikel.getBestand());
        assertEquals(0.0, artikel.getPreis());

    }

    /**
     * Test fuer korrekten Zugang
     */
    @Test
    public void test_Buche_Zugang() {
        // Artikel anlegen neues Artikel-Objekt mit Artikel-Startbestand von 10
        Artikel artikel = new Artikel(1000, "Test artikel", 10, 10.0);

        // Verwenden der Methode bucheZugang, um den Lagerbestand um 5 zu erhöhen
        artikel.bucheZugang(5);

        // Feststellen, dass der neue Lagerbestand gleich 15 ist
        assertEquals(15, artikel.getBestand());
    }

    /**
     * Test fuer korrekten Abgang
     */
    @Test
    public void test_Buche_Abgang() {
        // Artikel anlegen neues Artikel-Objekt mit Artikel-Startbestand von 10
        Artikel artikel = new Artikel(1000, "Test artikel", 10, 10.0);

        // Verwenden der Methode bucheAbgang, um den Lagerbestand um 5 zu verringern.
        artikel.bucheAbgang(5);

        // Feststellen, dass der neue Lagerbestand gleich 5 ist
        assertEquals(5, artikel.getBestand());
    }


}
