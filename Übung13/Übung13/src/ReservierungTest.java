import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservierungTest {

    private Mitarbeiter mitarbeiter;
    private Raum raum;
    
    @BeforeEach
    public void setup() throws Exception {
        mitarbeiter = new Mitarbeiter("Kylian", "Mbappe", "Kylian.mbappe@gmail.com");
        raum = new Raum(0, 5, 5);
    }
    
    @Test
    public void test_reservierung_mit_mitarbeiter_und_raum_nichts_erwartet() {
        Uhrzeit start = new Uhrzeit(12, 30);
        Uhrzeit ende = new Uhrzeit(13, 30);
        String bemerkung = "Porgrammierung2";
        mitarbeiter.reserviere(raum, start, ende, bemerkung);
    }
}