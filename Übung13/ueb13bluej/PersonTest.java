import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() throws Exception {
        person = new Person("Kylian", "Mbappe");
    }

    @Test
    public void testGetVorname() {
        assertEquals("Kylian", person.getVorname());
    }

    @Test
    public void testGetNachname() {
        assertEquals("Mbappe", person.getNachname());
    }

    @Test
    public void testToString() {
        assertEquals("Kylian Mbappe", person.toString());
    }

    @Test
    public void testEmptyVorname() {
        Exception exception = assertThrows(ErrorCheck.class, () -> new Person("", "Mbappe"));
        assertEquals("*msg d'erreur a renvoyer", exception.getMessage());
    }
    
    @Test
    public void testEmptyNachname() {
        Exception exception = assertThrows(ErrorCheck.class, () -> new Person("Kylian", ""));
        assertEquals("*msg d'erreur a renvoyer", exception.getMessage());
    }

}