import org.junit.jupiter.api.Test;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

/**
 * dies ist eine Klasse zum testen der Klasse Artikel
 */

public class ArtikelTests {

    /**
     * test ob Konstruktor alle Eigenschaften uebernimmt ohne fehler
     */
    @Test
    public void test_konstruktor_mit_allen_eigenschaften_ohne_fehler() {
        Artikel a = new Artikel(1001, "Ball", 10, 0.5);
        assertEquals(1001, a.getArtikelNr());
        assertEquals("Ball", a.getArt());
        assertEquals(10, a.getBestand());
        assertEquals(0.5, a.getPreis(), 0.01);
    }

    /**
     * test Konstruktor mit nur zwei Eigenschaften ohne fehler
     */
    @Test
    public void test_konstruktor_mit_artikelnummer_und_art_ohne_fehler() {
        Artikel a = new Artikel(2022, "Auto");
        assertEquals(2022, a.getArtikelNr());
        assertEquals("Auto", a.getArt());
        assertEquals(0, a.getBestand());
        assertEquals(0, a.getPreis(), 0.01);
    }

    /**
     * test konstruktor mit allen eigenschaften mit fehler
     */
    @Test
    public void test_konstruktor_mit_allen_eigenschaften_mit_fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Artikel(-1, "Socke", 100, 3.0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(1, "Schuh", 0, 3.0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(10000, "ball", 0, 3.0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(9999, "Auto", -12, 3.0));
    }

    /**
     * test Konstruktor mit nur zwei Eigenschaften mit fehler
     */
    @Test
    public void test_konstruktor_mit_artikelnummer_und_art_mit_fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Artikel(-1, "Socke", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(1, "Schuh", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(10000, "ball", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Artikel(999, "Auto", 0, 0));
    }

    /**
     * Test Buche zugang ohne fehler
     */
    @Test
    public void test_buche_zugang_ohne_fehler() {
        Artikel artikel = new Artikel(3222, "Fußball", 5, 0.3);
        artikel.bucheZugang(3);
        assertEquals(8, artikel.getBestand());
    }

    /**
     * Test Buche zugang mit fehler
     */
    @Test
    public void test_buche_zugang_mit_fehler() {
        Artikel artikelTest = new Artikel(1000, "Schuh", 10, 5.0);
        assertEquals(10, artikelTest.getBestand());

        assertThrows(IllegalArgumentException.class, () -> artikelTest.bucheZugang(-1000000000));
        assertThrows(IllegalArgumentException.class, () -> artikelTest.bucheZugang(-1));
        assertThrows(IllegalArgumentException.class, () -> artikelTest.bucheZugang(-100));
    }

    /**
     * Test Buche abgang ohne fehler
     */
    @Test
    public void test_buche_abgang_ohne_fehler() {
        Artikel artikel = new Artikel(3453, "Fußball", 5, 0.3);
        artikel.bucheAbgang(3);
        assertEquals(2, artikel.getBestand());
    }

    /**
     * Test Buche abgang mit fehler
     */
    @Test
    public void test_buche_abgang_mit_fehler() {
        Artikel artikelTest = new Artikel(2382, "Schuh", 10, 5.0);
        assertEquals(10, artikelTest.getBestand());

        assertThrows(IllegalArgumentException.class, () -> artikelTest.bucheZugang(-1000000000));
        assertThrows(IllegalArgumentException.class, () -> artikelTest.bucheZugang(-1));
        assertThrows(IllegalArgumentException.class, () -> artikelTest.bucheZugang(-100));
    }

    /**
     * test setArt ohne fehler
     */
    @Test
    public void test_setArt_ohne_fehler() {
        Artikel artikelTest1 = new Artikel(1245, "ball", 10, 5.0);
        assertEquals("ball", artikelTest1.getArt());

        artikelTest1.setArt("Schuh");
        assertEquals("Schuh", artikelTest1.getArt());

        Artikel artikelTest2 = new Artikel(2000, "Kugel", 20, 10.0);
        assertEquals("Kugel", artikelTest2.getArt());

        artikelTest2.setArt("Pfeil");
        assertEquals("Pfeil", artikelTest2.getArt());
    }

    /**
     * Test setArt mit fehler
     */
    @Test
    public void test_setArt_mit_fehler() {
        Artikel artikelTest = new Artikel(1000, "Tisch", 10, 5.0);
        assertEquals("Tisch", artikelTest.getArt());

        assertThrows(IllegalArgumentException.class, () -> artikelTest.setArt(""));
        assertThrows(IllegalArgumentException.class, () -> artikelTest.setArt(" "));
    }

    /**
     * Test setBestand ohne fehler
     */
    @Test
    public void test_setBestand_ohne_fehler() {
        Artikel artikelTest = new Artikel(1233, "Stuhl", 7, 30.0);
        assertEquals(7, artikelTest.getBestand());

        artikelTest.setBestand(20);
        assertEquals(20, artikelTest.getBestand());

        Artikel artikel2 = new Artikel(2000, "Tellerschrank", 12323, 456.0);
        assertEquals(12323, artikel2.getBestand());

        artikel2.setBestand(3022);
        assertEquals(3022, artikel2.getBestand());
    }

    /**
     * Test setBestand mit fehler
     */
    @Test
    public void test_setBestand_mit_fehler() {
        Artikel artikelTest = new Artikel(1232, "Kleiderschrank", 613, 5333.0);
        assertEquals(613, artikelTest.getBestand());

        assertThrows(IllegalArgumentException.class, () -> artikelTest.setBestand(-1));
        assertThrows(IllegalArgumentException.class, () -> artikelTest.setBestand(-100));
    }

    /**
     * Test setPreis ohne fehler
     */
    @Test
    public void test_setPreis_ohne_fehler() {
        Artikel artikelTest1 = new Artikel(1233, "Bett", 333, 65.5);
        assertEquals(65.5, artikelTest1.getPreis());

        artikelTest1.setPreis(0.0);
        assertEquals(0.0, artikelTest1.getPreis());

        Artikel artikelTest2 = new Artikel(1233, "Flasche", 324, 130.0);
        assertEquals(130.0, artikelTest2.getPreis());

        artikelTest2.setPreis(20.0);
        assertEquals(20.0, artikelTest2.getPreis());
    }

    /**
     * Test setPreis mit fehler
     */
    @Test
    public void test_setPreis_mit_fehler() {
        Artikel artikelTest = new Artikel(4563, "Sack", 12, 56.0);
        assertEquals(56.0, artikelTest.getPreis());

        assertThrows(IllegalArgumentException.class, () -> artikelTest.setPreis(-1));
        assertThrows(IllegalArgumentException.class, () -> artikelTest.setPreis(-100000));
    }

    /**
     * Test ob String methode funktioniert
     */
    @Test
    public void test_ob_ToString_funktioniert() {
        Artikel artikelTest = new Artikel(5673, "Maus", 100000, 5.0);
        assertEquals("Artikel: 5673, Art: Maus, Bestand: 100000, Preis: 5.0", artikelTest.toString());
    }

    /**
     * Test ob equals funktion funktioniert
     */
    @Test
    public void test_ob_Equals_funktioniert() {
        Artikel artikelTest1 = new Artikel(1233, "Blatt", 10, 5.0);
        Artikel artikelTest2 = new Artikel(1233, "Blatt", 10, 5.0);
        Artikel artikelTest3 = new Artikel(1200, "Magnet", 10, 5.5);
        Artikel artikelTest4 = new Artikel(1002, "Ohrringe", 11, 5.0);
        Artikel artikelTest5 = new Artikel(1111, "Armband", 10, 5.0);
        Artikel artikelTest6 = new Artikel(1000, "Uhr", 10, 5.0);

        // Test ob artikelTest1 0 artikelTest2
        assertEquals(artikelTest1, artikelTest2);

        // Test ob alle anderen artikel verschieden von artikelTest1 sind
        assertNotEquals(artikelTest1, artikelTest3);
        assertNotEquals(artikelTest1, artikelTest4);
        assertNotEquals(artikelTest1, artikelTest5);
        assertNotEquals(artikelTest1, artikelTest6);
    }

    /**
     * Test ob hash methode richtig funktioniert
     */
    @Test
    public void test_ob_hash_funktioniert(){
        Artikel artikelTest = new Artikel(1234, "Ball", 10, 5.0);
        assertEquals(Objects.hash(1234, "Ball", 10, 5.0), artikelTest.hashCode());
    }

}
