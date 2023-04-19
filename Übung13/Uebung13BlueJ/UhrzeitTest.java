import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UhrzeitTest {

    private Uhrzeit uhrzeit;
    
    @Test
    public void test_uhrzeit_mit_null_werten_nichts_erwartet() {
        uhrzeit = new Uhrzeit(0, 0);
    }
    
    @Test
    public void test_uhrzeit_ohne_problem_nichts_erwartet() {
        uhrzeit = new Uhrzeit(12, 30);
    }
    
    @Test
    public void test_uhrzeit_mit_24_als_stunde_exception_erwartet() {
        Exception e = assertThrows(ErrorCheck.class, () -> {uhrzeit = new Uhrzeit(24, 0);});
        assertEquals("Geben Sie eine Stunde zwischen 0 und 23 ein!", e.getMessage());
    }
    
    @Test
    public void test_uhrzeit_mit_60_als_minute_exception_erwartet() {
        Exception e = assertThrows(ErrorCheck.class, () -> {uhrzeit = new Uhrzeit(12, 60);});
        assertEquals("Geben Sie eine Minute zwischen 0 und 59 ein!", e.getMessage());
    }
}