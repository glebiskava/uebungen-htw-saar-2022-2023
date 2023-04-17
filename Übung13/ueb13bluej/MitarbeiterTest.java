import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MitarbeiterTest {

    private Mitarbeiter mitarbeiter;

    @BeforeEach
    public void setup() throws Exception {
        mitarbeiter = new Mitarbeiter("Kylian", "Mbappe", "Kylian.mbappe@gmail.com");
    }

    //test ueber vorname
    @Test
    public void test_getVorname() {
        assertEquals("Kylian", mitarbeiter.getVorname());
    }

    //test ueber nachname
    @Test
    public void test_getNachname() {
        assertEquals("Mbappe", mitarbeiter.getNachname());
    }

    //@Test
    //public void testToString() {
    //    assertEquals("Kylian Mbappe", person.toString());
    //}
    
    //test ueber mail 
    @Test
    public void test_getEmail() {
        assertEquals("kylian.mbappe@gmail.com", mitarbeiter.getEmail());
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_ohne_zeichnen_nach_at() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            "Antoine.griezmann@");});
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_ohne_zeichnen_vor_at() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            "@gmail.com");});
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_mit_leeres_zeichen_davor_at() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            " @");});
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_mit_leeres_zeichen_danach_at() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            "@ ");});
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_ohne_at() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            "Antoine.griezmann.gmail.com");});
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_nur_mit_at() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            "@");});
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_leer() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            "");});
    }
    
    @Test
    public void test_mitarbeiter_anlegen_mail_leeres_zeichnen() {
        assertThrows(ErrorCheck.class, () -> {mitarbeiter = new Mitarbeiter("Antoine", "Griezmann",
            " ");});
    }
}