import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaumTest {

    private Raum raum;
    
    @Test
    public void test_raum_anlegen_mit_null_geb_zahl_nichts_erwartet() {
        raum = new Raum(0, 5, 5);
    }
    
    @Test
    public void test_raum_anlegen_mit_negative_geb_zahl_exception_erwartet() {
        Exception e = assertThrows(ErrorCheck.class, () -> {raum = new Raum(-5, 5, 5);});
        assertEquals("Die Eingabe darf nicht negativ sein!", e.getMessage());
    }
    
    @Test
    public void test_raum_anlegen_mit_negative_raum_zahl_exception_erwartet() {
        Exception e = assertThrows(ErrorCheck.class, () -> {raum = new Raum(5, 5, -5);});
        assertEquals("Die Eingabe darf nicht negativ sein!", e.getMessage());
    }
}