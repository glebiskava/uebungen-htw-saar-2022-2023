import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaumTest {

    private Raum raum;

    @BeforeEach
    public void setup() throws Exception {
        raum = new Raum(5, 5, 5);
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
    public void test_raum_anlegen_mit_negative_geb_zahl_exception_erwartet() {
        assertThrows(ErrorCheck.class, () -> {raum = new Raum(-5, 5, 5);});
    }
    
    @Test
    public void test_raum_anlegen_mit_negative_raum_zahl_exception_erwartet() {
        assertThrows(ErrorCheck.class, () -> {raum = new Raum(5, 5, -5);});
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