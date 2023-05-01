import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

/**
 * Dies ist eine Klasse zum Testen der Klasse PersonQueue
 */

public class PersonQueueTests {

    /**
     * test fuer addLast funktion
     */
    @Test
    public void testAddLastPersonQueue() {
        PersonQueue q = new PersonQueue();
        Person p = new Person("John", "Doe");
        q.addLast(p);
        assertEquals(p, q.get(0));
    }

    /**
     * test fuer removeFirst funktion
     */
    @Test
    public void testRemoveFirstPersonQueue() {
        PersonQueue q = new PersonQueue();
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Jane", "Doe");
        q.addLast(p1);
        q.addLast(p2);
        assertEquals(p1, q.removeFirst());
        assertEquals(1, q.size());
    }

    /**
     * test fuer removeLast funktion
     */
    @Test
    public void testRemoveLastPersonQueue() {
        PersonQueue q = new PersonQueue();
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Jane", "Doe");
        q.addLast(p1);
        q.addLast(p2);
        assertEquals(p2, q.removeLast());
        assertEquals(1, q.size());
    }

    /**
     * test fuer Get funktion
     */
    @Test
    public void testGetPersonQueue() {
        PersonQueue q = new PersonQueue();
        Person p = new Person("John", "Doe");
        q.addLast(p);
        assertEquals(p, q.get(0));
    }

    /**
     * test fuer empty funktion
     */
    @Test
    public void testEmptyPersonQueue() {
        PersonQueue q = new PersonQueue();
        assertTrue(q.empty());
        q.addLast(new Person("John", "Doe"));
        assertFalse(q.empty());
    }

    /**
     * test fuer full funktion
     */
    @Test
    public void testFullPersonQueue() {
        PersonQueue q = new PersonQueue();
        for (int i = 0; i < 10; i++) {
            q.addLast(new Person("John", "Doe"));
        }
        assertTrue(q.full());
    }

    /**
     * test fuer funktion size
     */
    @Test
    public void testSizePersonQueue() {
        PersonQueue q = new PersonQueue();
        assertEquals(0, q.size());
        q.addLast(new Person("John", "Doe"));
        assertEquals(1, q.size());
    }

    /**
     * test fuer print funktion
     */
    @Test
    public void testPrintPersonQueue() {
        PersonQueue queue = new PersonQueue();
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Smith");

        queue.addLast(person1);
        queue.addLast(person2);

        queue.print();
    }
}