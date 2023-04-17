import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() throws Exception {
        person = new Person("John", "Doe");
    }

    @Test
    public void testGetVorname() {
        assertEquals("John", person.getVorname());
    }

    @Test
    public void testGetNachname() {
        assertEquals("Doe", person.getNachname());
    }

    @Test
    public void testToString() {
        assertEquals("John Doe", person.toString());
    }

    @Test
    public void testEmptyVorname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("", "Doe"));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testEmptyNachname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("John", ""));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testNullVorname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person(null, "Doe"));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testNullNachname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("John", null));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testWhitespaceVorname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("  ", "Doe"));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }

    @Test
    public void testWhitespaceNachname() {
        Exception exception = assertThrows(PersonException.class, () -> new Person("John", "  "));
        assertEquals("Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen", exception.getMessage());
    }
}