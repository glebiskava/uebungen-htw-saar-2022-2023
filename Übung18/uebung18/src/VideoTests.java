
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * dies ist eine Klasse zum testen der Klasse Video
 */

public class VideoTests {

    /**
     * Testen der getter fuer Klasse Video
     */
    @Test
    public void test_getter_sollte_korrekt_sein(){
        Video videoTest = new Video(1234, 20, 220.0, "Star Wars", 1612, 2020);
        assertEquals("Star Wars", videoTest.getTitel());
        assertEquals(1612, videoTest.getSpieldauer());
        assertEquals(2020, videoTest.getJahr());
    }

    /**
     * testen des Konstruktors ohne fehler
     */
    @Test
    public void test_konstructor_ohne_fehler() {
        Video videoTest = new Video(2423, 12, 32, "jackass", 32, 2011);

        assertEquals(2423, videoTest.getArtikelNr());
        assertEquals(12, videoTest.getBestand());
        assertEquals(32, videoTest.getPreis());
        assertEquals("jackass", videoTest.getTitel());
        assertEquals(32, videoTest.getSpieldauer());
        assertEquals(2011, videoTest.getJahr());
    }

    /**
     * testen der setTitelmethode ohne fehler
     */
    @Test
    public void test_setTitel_ohne_fehler() {
        Video videoTest = new Video(3432, 12, 234, "Scicario", 233, 2000);

        videoTest.setTitel("Scicario2");
        assertEquals("Scicario2", videoTest.getTitel());

        videoTest.setTitel("3222");
        assertEquals("3222", videoTest.getTitel());
    }

    /**
     * testen der setTitel methode mit fehler
     */
    @Test
    public void test_setTitel_mit_fehler() {
        Video videotest = new Video(8567, 1212, 32, "Friends", 5553, 1994);

        assertThrows(IllegalArgumentException.class, () -> {
            videotest.setTitel(" ");
        });
    }

    /**
     * Testen der setSpieldauer methode ohne fehler
     */
    @Test
    public void test_setSpieldauer_ohne_fehler() {
        Video videoTest = new Video(2342, 21, 32, "Skyscraper", 343, 2022);

        videoTest.setSpieldauer(42);
        assertEquals(42, videoTest.getSpieldauer());

        videoTest.setSpieldauer(100222);
        assertEquals(100222, videoTest.getSpieldauer());
    }

    /**
     * Testen der setspieldauer methode mit fehler
     */
    @Test
    public void test_setSpieldauer_mit_fehler() {
        Video videotest = new Video(2324, 123, 342, "Moneyball", 33, 2022);

        assertThrows(IllegalArgumentException.class, () -> {
            videotest.setSpieldauer(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            videotest.setSpieldauer(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            videotest.setSpieldauer(-100000);
        });
    }

    /**
     * Testen der setjahr methode ohne fehler
     */
    @Test
    public void test_setJahr_ohne_fehler() {
        Video videoTest = new Video(8544, 124, 223, "TheWolfofWallStreet", 332, 2022);

        videoTest.setJahr(2002);
        assertEquals(2002, videoTest.getJahr());

        videoTest.setJahr(2022);
        assertEquals(2022, videoTest.getJahr());

        videoTest.setJahr(1900);
        assertEquals(1900, videoTest.getJahr());
    }

    /**
     * Testen der setjahr methode mit fehler
     */
    @Test
    public void test_setJahr_mit_fehler() {
        Video videoTest = new Video(5673, 122, 2234, "Scream", 323, 1900);

        assertThrows(IllegalArgumentException.class, () -> {
            videoTest.setJahr(1899);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            videoTest.setJahr(2023);
        });
    }

    /**
     * Testen fuer richtige formatausgabe bei toString methode
     */
    @Test
    public void test_toString_sollte_korrekt_sein() {
        Video videoTest1 = new Video(1234, 12, 2222, "fast", 3, 2022);
        assertEquals("Artikel: 1234, Art: Medien, Bestand: 12, Preis: 2222.0, titel: fast, spieldauer: 3, jahr: 2022", videoTest1.toString());

        Video videoTest2 = new Video(3456, 223, 323, "fast2", 4, 1900);
        assertEquals("Artikel: 3456, Art: Medien, Bestand: 223, Preis: 323.0, titel: fast2, spieldauer: 4, jahr: 1900", videoTest2.toString());
    }

    /**
     * Testen ob equals methode richtig ist
     */
    @Test
    public void test_equals() {
        Video videoTest1 = new Video(1111, 1, 2, "fast2", 23, 2022);
        Video videoTest2 = new Video(1111, 1, 2, "fast2", 23, 2022);
        Video videoTest3 = new Video(2342, 12, 22424,"fast3", 323, 2022);
        Video videoTest4 = new Video(2344, 2341, 24242, "fast4", 4876, 1902);
        Video videoTest5 = new Video(2433, 1234, 22424, "fast5", 3678, 1923);
        Video videoTest6 = new Video(7845, 22344, 4442, "tokiodrift", 7683, 1943);
        Video videoTest7 = new Video(5743, 1442, 24444, "unchained", 376, 1956);
        Video videoTest8 = new Video(5365, 1242, 3242, "bowling", 3678, 1999);

        assertEquals(videoTest1, videoTest2);

        assertNotEquals(videoTest1, videoTest3);
        assertNotEquals(videoTest1, videoTest4);
        assertNotEquals(videoTest1, videoTest5);
        assertNotEquals(videoTest1, videoTest6);
        assertNotEquals(videoTest1, videoTest7);
        assertNotEquals(videoTest1, videoTest8);
    }
}
