import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Dies ist eine Klasse zum Testen der Klasse DoppeltVerketteteListe
 */

public class DoppeltVerketteteListeTest {

    /**
     * test fuer add funktion
     */
    @Test
    public void test_Add_Nichts_Erwartet() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        assertEquals(list.toString(), "[1, 2, 3, 4]");
    }

    

    @BeforeEach
    public void SetUp(){
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    /**
     * test fuer size funktion
     */
    @Test
    public void test_Size_Nichts_Erwartet() {
        assertEquals(list.size(), 4);
    }

    /**
     * test fuer remove funktion
     */
    @Test
    public void test_Remove_Nichts_Erwartet() {
        list.remove(2);
        assertEquals(list.toString(), "[1, 2, 4]");
    }
    @Test
    public void test_Remove_everything_Nichts_Erwartet() {
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(list.toString(), "[]");
    }

    /**
     * test fuer contains funktion
     */
    @Test
    public void test_Contains_Nichts_Erwartet() {
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    /**
     * test fuer clear funktion
     */
    @Test
    public void test_Clear_Nichts_Erwartet() {
        list.clear();
        assertEquals(list.toString(), "[]");
    }

    /**
     * test fuer get funktion
     */
    @Test
    public void test_Get_Nichts_Erwartet() {
        assertEquals(list.get(2), 3);
    }

    /**
     * test fuer set funktion
     */
    @Test
    public void test_Set_Nichts_Erwartet() {
        list.set(2, 5);
        assertEquals(list.toString(), "[1, 2, 5, 4]");
    }

    /**
     * test fuer indexOf funktion
     */
    @Test
    public void test_IndexOf_Nichts_Erwartet() {
        assertEquals(list.indexOf(2), 1);
    }

    /**
     * test fuer add(int, E) funktion
     */
    @Test
    public void test_Add_int_E_Nichts_Erwartet() {
        list.add(2, 5);
        assertEquals(list.toString(), "[1, 2, 5, 3, 4]");
    }
}