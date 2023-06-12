import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

/**
 * Dies ist eine Klasse zum Testen der Klasse DoppeltVerketteteListe
 */

public class DoppeltVerketteteListeTest {

    private DoppeltVerketteteListe<Integer> list;

    @BeforeEach
    public void SetUp(){
        list = new DoppeltVerketteteListe<>();
        for ( int i = 1; i < 5; i++ ) {
            list.add(i);
        }
    }

    @Test
    public void test_Add_Nichts_Erwartet() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(list.toString(), "[1, 2, 3, 4]");
    }

    @Test
    public void test_Size1() {
        assertEquals(list.size(), 4);
    }

    @Test
    public void testSize2() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();

        // Überprüfe die Größe einer leeren Liste
        assertEquals(0, liste.size());

        // Füge Elemente hinzu und überprüfe die Größe
        liste.add("Element 1");
        liste.add("Element 2");
        liste.add("Element 3");
        assertEquals(3, liste.size());

        // Entferne ein Element und überprüfe erneut die Größe
        liste.remove("Element 2");
        assertEquals(2, liste.size());

        // Füge weitere Elemente hinzu
        liste.add("Element 4");
        liste.add("Element 5");
        assertEquals(4, liste.size());

        // Entferne alle Elemente und überprüfe die Größe
        liste.clear();
        assertEquals(0, 0);
    }

    @Test
    public void testIsEmptyTrue() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testContains() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();

        // Überprüfe eine leere Liste
        assertFalse(liste.contains("Element 1"));

        // Füge Elemente hinzu
        liste.add("Element 1");
        liste.add("Element 2");
        liste.add("Element 3");

        // Überprüfe enthaltene Elemente
        assertTrue(liste.contains("Element 1"));
        assertTrue(liste.contains("Element 2"));
        assertTrue(liste.contains("Element 3"));

        // Überprüfe ein nicht enthaltenes Element
        assertFalse(liste.contains("Element 4"));

        // Entferne ein Element und überprüfe erneut
        liste.remove("Element 2");
        assertFalse(liste.contains("Element 2"));
    }

    @Test
    public void testAdd_Mit_Fehler() {
        Assertions.assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    public void test_Remove_Nichts_Erwartet() {
        list.remove(2);
        assertEquals(list.toString(), "[1, 2, 4]");
    }

    @Test
    public void test_Remove_Mit_Fehler() {
        DoppeltVerketteteListe<Integer> list = new DoppeltVerketteteListe<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> list.remove(null));
        Assertions.assertThrows(NoSuchElementException.class, () -> list.remove(0));;
    }

    @Test
    public void Test_Get_Mit_Fehler() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(10));
    }

    @Test
    public void Test_Set_Mit_Fehler() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.list.set(3543, 40));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.list.set(-1, 3));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.list.set(53, 3214));
    }

    @Test
    public void test_Remove_everything_Nichts_Erwartet() {
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(list.toString(), "[]");
    }

    @Test
    public void test_Contains_Nichts_Erwartet() {

        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    @Test
    public void test_Clear_Nichts_Erwartet() {
        list.clear();
        assertEquals(list.toString(), "[]");
    }

    @Test
    public void test_Get_Nichts_Erwartet() {
        assertEquals(list.get(2), 3);
    }

    @Test
    public void test_Set_Nichts_Erwartet() {
        list.set(2, 5);
        assertEquals(list.toString(), "[1, 2, 5, 4]");
    }

    @Test
    public void test_IndexOf_Nichts_Erwartet() {
        assertEquals(list.indexOf(2), 1);
    }

    @Test
    public void test_Add_int_E_Nichts_Erwartet() {
        list.add(2, 5);
        assertEquals(list.toString(), "[1, 2, 5, 3, 4]");
    }

    @Test
    public void testEmptyListGet() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testEmptyListSet() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "element"));
    }

    @Test
    public void testEmptyListRemove() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        assertThrows(NoSuchElementException.class, () -> list.remove(0));
    }

    @Test
    public void testAddAll() {
        DoppeltVerketteteListe<String> liste = new DoppeltVerketteteListe<>();

        // Erstelle eine andere Liste mit Elementen
        List<String> otherList = new ArrayList<>(Arrays.asList("Element 1", "Element 2", "Element 3"));

        // Füge Elemente mit addAll() hinzu
        assertTrue(liste.addAll(otherList));

        // Überprüfe, ob die Elemente korrekt hinzugefügt wurden
        assertEquals(otherList.size(), liste.size());

        // Überprüfe jeden einzelnen Wert aus otherList
        for (String element : otherList) {
            assertTrue(liste.contains(element));
        }
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
    }

    @Test
    public void testAddAtIndexOutOfBounds() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "element"));
    }

    @Test
    public void testRemoveEmptyList() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        assertThrows(NoSuchElementException.class, () -> list.remove(0));
    }

    @Test
    public void testUnsupportedOperations() {
        DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<>();
        assertThrows(UnsupportedOperationException.class, () -> list.lastIndexOf("element"));
        assertThrows(UnsupportedOperationException.class, () -> list.retainAll(Collections.emptyList()));
        assertThrows(UnsupportedOperationException.class, () -> list.removeAll(Collections.emptyList()));
        assertThrows(UnsupportedOperationException.class, () -> list.containsAll(Collections.emptyList()));
        assertThrows(UnsupportedOperationException.class, () -> list.addAll(0, Collections.emptyList()));
        assertThrows(UnsupportedOperationException.class, () -> list.listIterator(0));
        assertThrows(UnsupportedOperationException.class, () -> list.subList(0, 0));
    }
}