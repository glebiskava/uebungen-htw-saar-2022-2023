import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class CDTests {

    /**
     * Test fuer getter
     */
    @Test
    public void test_getter(){
        CD cd = new CD(1234, 12, 2.0, "Leonie","I will win TheVoice kids one day", 20);
        assertEquals("Leonie", cd.getInterpret());
        assertEquals("I will win TheVoice kids one day", cd.getTitel());
        assertEquals(20, cd.getAnzahlTitel());
    }

    /**
     * test fuer Konstruktor ohne Fehler
     */
    @Test
    public void test_konstruktor_ohne_fehler() {
        CD cd = new CD(1221, 111, 2111, "Barsch", "Forelle", 7);

        assertEquals(1221, cd.getArtikelNr());
        assertEquals(111, cd.getBestand());
        assertEquals(2111, cd.getPreis());
        assertEquals("Barsch", cd.getInterpret());
        assertEquals("Forelle", cd.getTitel());
        assertEquals(7, cd.getAnzahlTitel());
    }

    /**
     * Test fuer setInterpret ohne Fehler
     */
    @Test
    public void test_setInterpret_ohne_fehler() {
        CD cd = new CD(3456, 13, 32, "Schwimmblase", "Nahrung", 1003);

        cd.setInterpret("dasHerz");
        assertEquals("dasHerz", cd.getInterpret());

        cd.setInterpret("32");
        assertEquals("32", cd.getInterpret());
    }

    /**
     * Test fuer setInterpret mit fehler
     */
    @Test
    public void test_setInterpret_mit_fehler() {
        CD cd = new CD(3456, 11, 21, "Amniot", "Ich denke also bin ich", 12);

        assertThrows(IllegalArgumentException.class, () -> {
            cd.setInterpret(" ");
        });
    }

    /**
     * Test setTitel ohne fehler
     */
    @Test
    public void test_setTitel_ohne_fehler() {
        CD cd = new CD(2342, 12, 22, "Herz", "Leibniz", 12);

        cd.setTitel("pascal");
        assertEquals("pascal", cd.getTitel());

        cd.setTitel("4222");
        assertEquals("4222", cd.getTitel());
    }

    /**
     * test fuer setTitel mit fehler
     */
    @Test
    public void test_SetTitel_Mit_Fehler() {
        CD cd = new CD(1233, 111, 21, "Harald", "Bude", 12);

        assertThrows(IllegalArgumentException.class, () -> {
            cd.setTitel(" ");
        });
    }

    /**
     * test setanzahltitel ohne fehler
     */
    @Test
    public void test_setAnzahlTitel_ohne_fehler() {
        CD cd = new CD(3452, 12, 22, "Panitzsch", "entspannt", 111);

        cd.setAnzahlTitel(211);
        assertEquals(211, cd.getAnzahlTitel());

        cd.setAnzahlTitel(10011);
        assertEquals(10011, cd.getAnzahlTitel());
    }

    /**
     * Test setanzhalTitel mit fehler
     */
    @Test
    public void test_setAnzahlTitel_mit_fehler() {
        CD cd = new CD(9347, 111, 222, "Theis", "computer", 12);

        assertThrows(IllegalArgumentException.class, () -> {
            cd.setAnzahlTitel(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            cd.setAnzahlTitel(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            cd.setAnzahlTitel(-100);
        });
    }

    /**
     * Test feur richtige Beschreibung
     */
    @Test
    public void test_getBeschreibung() {
        CD cd = new CD(2344, 222, 2332, "cherry", "let it rip", 1);

        assertEquals("cherry: let it rip", cd.getBeschreibung());
    }

    /**
     * Test fuer richtiges Ausgabeformat bei toString methode
     */
    @Test
    public void test_toString_sollte_richtiges_ausgabeformat_sein() {
        CD cd1 = new CD(1234, 1222, 21212, "ABBA", "mamamia", 12);
        assertEquals("Artikel: 1234, Art: Medien, Bestand: 1222, Preis: 21212.0, interpret: ABBA, titel: mamamia, anzahlTitel: 12", cd1.toString());

        CD cd2 = new CD(3984, 2222, 35435, "Micheal", "Zombie", 91);
        assertEquals("Artikel: 3984, Art: Medien, Bestand: 2222, Preis: 35435.0, interpret: Micheal, titel: Zombie, anzahlTitel: 91", cd2.toString());
    }

    /**
     * Test fuer euqals methode
     */
    @Test
    public void test_equals_sollte_richtig_sein() {
        CD cd1 = new CD(1234, 12, 22, "Montag", "Dienstag", 2);
        CD cd2 = new CD(1234, 12, 22, "Montag", "Dienstag", 2);
        CD cd3 = new CD(3563, 343, 332,"Eins", "nein", 2657);
        CD cd4 = new CD(3565, 33, 245, "Zwei", "ja", 2234);
        CD cd5 = new CD(4563, 15, 2454, "Drei", "vielleicht", 12342);
        CD cd6 = new CD(3456, 24353, 2454, "Vier", "moeglich", 2234);
        CD cd7 = new CD(2344, 14353, 882, "Fuenf", "wahrscheinlich", 2324);
        CD cd8 = new CD(6877, 1453, 4563, "Sechs", "angbracht", 2324);

        // Test for equality
        assertEquals(cd1, cd2);

        // Test for inequality
        assertNotEquals(cd1, cd3);
        assertNotEquals(cd1, cd4);
        assertNotEquals(cd1, cd5);
        assertNotEquals(cd1, cd6);
        assertNotEquals(cd1, cd7);
        assertNotEquals(cd1, cd8);
    }

    /**
     * Test for hashCode.
     * Gets the hash code of the CD object and checks if the value is correct.
     */
    @Test
    public void test_hashCode_sollte_richtig_sein() {
        CD cd= new CD(1234, 12, 223, "Sam smith", "only me", 12);
        Artikel artikelTest = new Artikel(1234, "Medien",12, 223);

        assertEquals(Objects.hash(artikelTest.hashCode(), "Sam smith", "only me", 12), cd.hashCode());
    }
}

