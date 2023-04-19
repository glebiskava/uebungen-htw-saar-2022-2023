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
    public void test_getVorname() {
        assertEquals("Kylian", person.getVorname());
    }

    @Test
    public void test_getNachname() {
        assertEquals("Mbappe", person.getNachname());
    }

    @Test
    public void test_toString() {
        assertEquals("Kylian Mbappe", person.toString());
    }

    @Test
    public void test_empty_vorname() {
        Exception e = assertThrows(ErrorCheck.class, () -> new Person("", "Mbappe"));
        assertEquals("Eingabe darf nicht leer sein!", e.getMessage());
    }
    
    @Test
    public void test_empty_nachname() {
        Exception e = assertThrows(ErrorCheck.class, () -> new Person("Kylian", ""));
        assertEquals("Eingabe darf nicht leer sein!", e.getMessage());
    }
    
    @Test
    public void test_leeres_zeichnen_vorname() {
        Exception e = assertThrows(ErrorCheck.class, () -> new Person(" ", " "));
        assertEquals("Eingabe darf nicht leer sein!", e.getMessage());
    }
    
    @Test
    public void test_leeres_zeichnen_nachname() {
        Exception e = assertThrows(ErrorCheck.class, () -> new Person("Kylian", ""));
        assertEquals("Eingabe darf nicht leer sein!", e.getMessage());
    }

}