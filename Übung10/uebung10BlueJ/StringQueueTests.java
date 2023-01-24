import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Dies ist eine Klasse zum Testen der Klasse PersonQueue
 */

public class StringQueueTests {

    /**
     * test fuer addLast
     */
    @Test
    public void testAddLastStringQueue() {
        StringQueue queue = new StringQueue();
        String string1 = new String("John Doe");
        String string2 = new String("Jane Smith");

        queue.addLast(string1);
        assertEquals(1, queue.size());
        assertEquals(string1, queue.get(0));

        queue.addLast(string2);
        assertEquals(2, queue.size());
        assertEquals(string2, queue.get(1));
    }

    /**
     * test fuer removeFirst funktion
     */
    @Test
    public void testRemoveFirstStringQueue() {
        StringQueue queue = new StringQueue();
        String string1 = new String("John Doe");
        String string2 = new String("Jane Smith");

        queue.addLast(string1);
        queue.addLast(string2);

        assertEquals(string1, queue.removeFirst());
        assertEquals(1, queue.size());
        assertEquals(string2, queue.get(0));
    }

    /**
     * test fuer removeLast funktion
     */
    @Test
    public void testRemoveLastStringQueue() {
        StringQueue queue = new StringQueue();
        String string1 = new String("John Doe");
        String string2 = new String("Jane Smith");

        queue.addLast(string1);
        queue.addLast(string2);

        assertEquals(string2, queue.removeLast());
        assertEquals(1, queue.size());
        assertEquals(string1, queue.get(0));
    }

    /**
     * test fuer full funktion
     */
    @Test
    public void testFullStringQueue() {
        StringQueue queue = new StringQueue();
        String string1 = new String("John Doe");
        String string2 = new String("Jane Smith");
        String string3 = new String("Bob Johnson");
        String string4 = new String("Samantha Williams");
        String string5 = new String("Michael Jones");
        String string6 = new String("Emily Brown");
        String string7 = new String("Jacob Davis");
        String string8 = new String("Madison Miller");
        String string9 = new String("Joshua Wilson");
        String string10 = new String("Ashley Moore");
        String string11 = new String("Matthew Taylor");
        String string12 = new String("Mattheelor");

        queue.addLast(string1);
        queue.addLast(string2);
        queue.addLast(string3);
        queue.addLast(string4);
        queue.addLast(string5);
        queue.addLast(string6);
        queue.addLast(string7);
        queue.addLast(string8);
        queue.addLast(string9);
        queue.addLast(string10);

        assertTrue(queue.full());

        try {
            queue.addLast(string11);
            queue.addLast(string12);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Die Queue ist voll!", e.getMessage());
        }
    }

    /**
     * test fuer empty funktion
     */
    @Test
    public void testEmptyStringQueue() {
        StringQueue queue = new StringQueue();
        String string1 = new String("John Doe");

        assertTrue(queue.empty());

        queue.addLast(string1);
        assertFalse(queue.empty());

        queue.removeFirst();
        assertTrue(queue.empty());
    }

    /**
     * test fuer Get funktion
     */
    @Test
    public void testGetStringQueue() {
        StringQueue queue = new StringQueue();
        String string1 = new String("John Doe");
        String string2 = new String("Jane Smith");

        queue.addLast(string1);
        queue.addLast(string2);

        assertEquals(string1, queue.get(0));
        assertEquals(string2, queue.get(1));

        try {
            queue.get(2);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Index außerhalb des zulässigen Bereichs.", e.getMessage());
        }
    }

    /**
     * test fuer print funktion
     */
    @Test
    public void testPrintStringQueue() {
        StringQueue queue = new StringQueue();
        String string1 = new String("John Doe");
        String string2 = new String("Jane Smith");

        queue.addLast(string1);
        queue.addLast(string2);

        queue.print(queue);
    }
}