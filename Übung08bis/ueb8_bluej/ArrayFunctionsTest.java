import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ArrayFunctionsTest {
    @BeforeEach
    public void setup(){
        // Before each test ein Lager Groesse 10 anlegen (default value)
    //    Lager lager = new Lager();
    }
  
    /**
     *Test die Funktion berechneMittelwert mit int in der Array
     */
    @Test
    public void test_berechneMittelwert_mit_int_in_array_erwartet_3_3_und_5() {
        double[] messwerte = {1, 2, 3, 4, 5};
        Mittelwert moyenne = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEquals(3.0, moyenne.get_mittelwert());
        assertEquals(3.0, moyenne.get_nahesterWert());
        assertEquals(1.0, moyenne.get_entferntesterWert());
    }
    
    /**
     *Test die Funktion berechneMittelwert mit einen int in der Array
     */
    @Test
    public void test_berechneMittelwert_mit_int_in_array_erwartet_3_3_und_5komma1() {
        double[] messwerte = {1.0, 2.0, 3, 4.0, 5.1};
        Mittelwert moyenne = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEquals(3.02, moyenne.get_mittelwert());
        assertEquals(3.0, moyenne.get_nahesterWert());
        assertEquals(5.1, moyenne.get_entferntesterWert());
    }
    
    /**
     *Test die Funktion berechneMittelwert mit negativer double in der Array
     */
    @Test
    public void test_berechneMittelwert_mit_negativer_int_in_array_erwartet_minus3_minus3_und_minus5komma1() {
        double[] messwerte = {-1.0, -2.0, -3.0, -4.0, -5.1};
        Mittelwert moyenne = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEquals(-3.02, moyenne.get_mittelwert());
        assertEquals(-3.0, moyenne.get_nahesterWert());
        assertEquals(-5.1, moyenne.get_entferntesterWert());
    }
    
    /**
     *Test die Funktion berechneMittelwert mit mische Array
     */
    @Test
    public void test_berechneMittelwert_mit_mische_array_erwartet_3_3_und_5komma1() {
        double[] messwerte = {2.0, 5.1, 1.0, 4.0, 3.0};
        Mittelwert moyenne = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEquals(3.02, moyenne.get_mittelwert());
        assertEquals(3.0, moyenne.get_nahesterWert());
        assertEquals(5.1, moyenne.get_entferntesterWert());
    }

    /**
     *Test die Funktion berechneMittelwert mit double und negativer Zahl
     */
    @Test
    public void test_berechneMittelwert_mit_double_und_negativer_zahl_erwartet_komma_zahlen() {
        double[] messwerte = {-1.252, 25.365, 98.56};
        Mittelwert moyenne = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEquals(40.891, moyenne.get_mittelwert());
        assertEquals(25.365, moyenne.get_nahesterWert());
        assertEquals(98.56, moyenne.get_entferntesterWert());
    }
    
    
    /**
     * Test die Funktion stringsAuswerten mit zahl in der String
     */
    @Test
    public void test_stringsAuswerten_mit_zahl_in_array_erwartet_1() {
        String[] strings = {"HTW1", "ALTSB"};
        assertEquals(1, ArrayFunctions.stringsAuswerten(strings));
    }
    
    /**
     * Test die Funktion stringsAuswerten mit "-" in der Array
     */
    @Test
    public void test_stringsAuswerten_mit_array_erwartet_0() {
        String[] strings = {"ALT-SB"};
        assertEquals(0, ArrayFunctions.stringsAuswerten(strings));
    }
    
    /**
     * Test die Funktion stringsAuswerten mit einen Lehres Array
     */
    @Test
    public void test_stringsAuswerten_mit_Lehre_array_exception_erwartet() {
        String[] strings = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArrayFunctions.stringsAuswerten(strings);
        });
    }
    
    /**
     * Test die Funktion stringsAuswerten mit einen Lehres String in der Array
     */
    @Test
    public void test_stringsAuswerten_mit_Lehres_string_erwartet_0() {
        String[] strings = {""};
        assertEquals(0, ArrayFunctions.stringsAuswerten(strings));
    }


}