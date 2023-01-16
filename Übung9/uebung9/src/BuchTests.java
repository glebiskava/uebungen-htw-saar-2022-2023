import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * dies ist eine Klasse zum Testen der Klasse Buch
 */
public class BuchTests {

    /**
     * Testen der GetMethoden
     */
    @Test
    public void test_getter() {
        Buch buch = new Buch(1223, 1, 20.0,
                "Die Lilie", "Krista Lindberg", "Neumann");
        assertEquals("Die Lilie", buch.getTitel());
        assertEquals("Krista Lindberg", buch.getAuthor());
        assertEquals("Neumann", buch.getVerlag());
    }

    /**
     * Konstruktor check ohne fehler
     */
    @Test
    public void test_konstructor_ohne_fehler() {
        Buch buch = new Buch(1234, 22, 2.25,
                "Die Playlist", "Fitzek", "Neumann");

        assertEquals(1234, buch.getArtikelNr());
        assertEquals(22, buch.getBestand());
        assertEquals(2.25, buch.getPreis());
        assertEquals("Die Playlist", buch.getTitel());
        assertEquals("Fitzek", buch.getAuthor());
        assertEquals("Neumann", buch.getVerlag());
    }

    /**
     * Konstruktor check mit fehler
     */
    @Test
    public void test_konstructor_mit_fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Buch(221, 2, 100,
                "Die Playlist", "Fitzek", "Neumann"));
        assertThrows(IllegalArgumentException.class, () -> new Buch(-2221, 2, 100,
                "Die Playlist", "Fitzek", "Neumann"));
        assertThrows(IllegalArgumentException.class, () -> new Buch(99999, 2, -100,
                "Die Playlist", "Fitzek", "Neumann"));
        assertThrows(IllegalArgumentException.class, () -> new Buch(0, -23, 100, "" +
                "Die Playlist", "Fitzek", "Neumann"));
    }

    /**
     * Test SetTitel ohne fehler
     */
    @Test
    public void test_setTitel_ohne_fehler() {
        Buch buch = new Buch(1233, 12, 22, "Im kleinen Hirn",
                "Cerebellum", "Neumann");

        buch.setTitel("Bein Bein");
        assertEquals("Bein Bein", buch.getTitel());

        buch.setTitel("444");
        assertEquals("444", buch.getTitel());
    }

    /**
     * Test setTitel mit Fehler
     */
    @Test
    public void test_setTitel_mit_fehler() {
        Buch buch = new Buch(1234, 11, 211, "Nervensystem Strickleiter",
                "Bull Bus", "Neumann");

        assertThrows(IllegalArgumentException.class, () -> {
            buch.setTitel("");
        });
    }

    /**
     * Test setAuthor ohne fehler
     */
    @Test
    public void test_setAuthor_ohne_fehler() {
        Buch buch = new Buch(1234, 222, 2222, "motorische Zentren",
                "Septum", "Neumann");

        buch.setAuthor("Rolf");
        assertEquals("Rolf", buch.getAuthor());

        buch.setAuthor("4eee");
        assertEquals("4eee", buch.getAuthor());
    }

    /**
     * test setAuthor mit Fehler.
     */
    @Test
    public void test_setAuthor_mit_fehler() {
        Buch buch = new Buch(1232, 111, 2234,
                "abgewandelter Aufbau", "kortex", "neumann");

        assertThrows(IllegalArgumentException.class, () -> {
            buch.setAuthor(" ");
        });
    }

    /**
     * test setverlag ohne fehler
     */
    @Test
    public void test_setVerlag_ohne_Fehler() {
        Buch buch = new Buch(1111, 1, 2, "Donnerstag", "Leonie", "neumann");

        buch.setVerlag("rehine");
        assertEquals("rehine", buch.getVerlag());

        buch.setVerlag("eeeee");
        assertEquals("eeeee", buch.getVerlag());
    }

    /**
     * Test setVerlag mit fehler
     */
    @Test
    public void test_setVerlag_mit_fehler() {
        Buch buch = new Buch(1312, 1, 2, "Mittwoch", "Rolf", "habeert");

        assertThrows(IllegalArgumentException.class, () -> {
            buch.setVerlag("");
        });
    }

    /**
     * test ob getBeschreibung richtig funktioniert
     */
    @Test
    public void test_getBeschreibung() {
        Buch buch = new Buch(1111, 1, 2, "Wochenende", "ronny", "cool");

        assertEquals("ronny: Wochenende", buch.getBeschreibung());
    }

    /**
     * test fuer richtiges format bei ausgabe von toString
     */
    @Test
    public void test_toString() {
        Buch buchTest1 = new Buch(1234, 12, 22, "Bevoelkerung", "John", "Long");
        assertEquals("Artikel: 1234, Art: Medien, Bestand: 12, Preis: 22.0, titel: Bevoelkerung, " +
                "author: John, verlag: Long", buchTest1.toString());

        Buch buchTest2 = new Buch(1233, 123, 123, "abend", "hans", "reier");
        assertEquals("Artikel: 1233, Art: Medien, Bestand: 123, Preis: 123.0, titel: abend, author: hans, " +
                "verlag: reier", buchTest2.toString());
    }

    /**
     * test fuer equals methode
     */
    @Test
    public void test_equals_ob_korrekt_sollte_richtig_sein() {

        Buch buchTest1 = new Buch(1234, 12, 2332,
                "Montag", "Friedrich", "Neunamm");
        Buch buchTest2 = new Buch(1234, 12, 2332,
                "Montag", "Friedrich", "Neunamm");
        Buch buchTest3 = new Buch(1232, 222, 23454,
                "Dienstag", "Walter", "Anggaaa");
        Buch buchTest4 = new Buch(1435, 221, 2453,
                "Mittwoch", "hannes", "Beta");
        Buch buchTest5 = new Buch(2456, 122, 2535,
                "Donnerstag", "robin", "Theta");
        Buch buchTest6 = new Buch(7855, 22222, 22425,
                "Freitag", "Altor", "Epsylon");
        Buch buchTest7 = new Buch(3455, 122, 23453,
                "Samstag", "Leo", "Delta");
        Buch buchTest8 = new Buch(7488, 12, 33454,
                "Sonntag", "Linda", "Pi");

        assertEquals(buchTest1, buchTest2);

        assertNotEquals(buchTest1, buchTest3);
        assertNotEquals(buchTest1, buchTest4);
        assertNotEquals(buchTest1, buchTest5);
        assertNotEquals(buchTest1, buchTest6);
        assertNotEquals(buchTest1, buchTest7);
        assertNotEquals(buchTest1, buchTest8);
    }
}
