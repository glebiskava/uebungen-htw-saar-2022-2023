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
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        queue.addLast(person1);
        assertEquals(1, queue.size());
        assertEquals(person1, queue.get(0));

        queue.addLast(person2);
        assertEquals(2, queue.size());
        assertEquals(person2, queue.get(1));
    }

    /**
     * test fuer removeFirst funktion
     */
    @Test
    public void testRemoveFirstStringQueue() {
        StringQueue queue = new StringQueue();
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        queue.addLast(person1);
        queue.addLast(person2);

        assertEquals(person1, queue.removeFirst());
        assertEquals(1, queue.size());
        assertEquals(person2, queue.get(0));
    }

    /**
     * test fuer removeLast funktion
     */
    @Test
    public void testRemoveLastStringQueue() {
        StringQueue queue = new StringQueue();
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        queue.addLast(person1);
        queue.addLast(person2);

        assertEquals(person2, queue.removeLast());
        assertEquals(1, queue.size());
        assertEquals(person1, queue.get(0));
    }

    /**
     * test fuer full funktion
     */
    @Test
    public void testFullStringQueue() {
        StringQueue queue = new StringQueue();
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");
        Person person3 = new Person("Bob", "Johnson");
        Person person4 = new Person("Samantha", "Williams");
        Person person5 = new Person("Michael", "Jones");
        Person person6 = new Person("Emily", "Brown");
        Person person7 = new Person("Jacob", "Davis");
        Person person8 = new Person("Madison", "Miller");
        Person person9 = new Person("Joshua", "Wilson");
        Person person10 = new Person("Ashley", "Moore");
        Person person11 = new Person("Matthew", "Taylor");

        queue.addLast(person1);
        queue.addLast(person2);
        queue.addLast(person3);
        queue.addLast(person4);
        queue.addLast(person5);
        queue.addLast(person6);
        queue.addLast(person7);
        queue.addLast(person8);
        queue.addLast(person9);
        queue.addLast(person10);

        assertTrue(queue.full());

        try {
            queue.addLast(person11);
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
        Person person1 = new Person("John", "Doe");

        assertTrue(queue.empty());

        queue.addLast(person1);
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
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        queue.addLast(person1);
        queue.addLast(person2);

        assertEquals(person1, queue.get(0));
        assertEquals(person2, queue.get(1));

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
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        queue.addLast(person1);
        queue.addLast(person2);

        queue.print(queue);
    }
}