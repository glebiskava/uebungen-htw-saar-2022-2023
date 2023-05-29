package aufgabe2;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author leopold mittelberger, elisee brand
 * @version 1.0
 * Dies ist eine Klasse zum Testen der Klasse Funktionen
 */

public class FunktionenTest {

    private Funktionen f;

    @BeforeEach
    void setUp() {
        f = new Funktionen();
    }


    /**
     *  Tests fuer quadrad Lambda & Anonym
     */
    @Test
    public void test_quadrad_Lambda_mit_10_ewartet_100() {
        int ergebnis = f.quadradLambda.apply(10);
        Assertions.assertEquals(100, ergebnis);
    }

    @Test
    public void test_quadrad_Lambda_mit_32767_ewartet_100_erwartet_1073676289() {
        int ergebnis = f.quadradLambda.apply(32767);
        Assertions.assertEquals(1073676289, ergebnis);
    }

    @Test
    public void test_quadrad_Anonym_mit_10_ewartet_100() {
        int ergebnis = f.quadradAnonym.apply(10);
        Assertions.assertEquals(100, ergebnis);
    }

    @Test
    public void test_quadrad_Anonym_mit_32767_erwartet_1073676289() {
        int ergebnis = f.quadradAnonym.apply(32767);
        Assertions.assertEquals(1073676289, ergebnis);
    }


    /**
     *  Tests fuer factoriel Lambda, Anonym, Top Level & Static Nested
     */
    @Test
    public void test_faktoriel_Lambda_mit_4_ewartet_24() {
        int ergebnis = f.faktorielLambda.apply(4);
        Assertions.assertEquals(24, ergebnis);
    }

    @Test
    public void test_Factoriel_Anonym_mit_4_ewartet_24() {
        int ergebnis = f.faktorielAnonym.apply(4);
        Assertions.assertEquals(24, ergebnis);
    }

    @Test
    public void test_Factoriel_TopLevel_mit_4_ewartet_24() {
        int ergebnis = f.FactorielAnonymZugang(4);
        Assertions.assertEquals(24, ergebnis);
    }

    /**
     *  Test fuer produkt Lambda & anonym
     */
    @Test
    public void test_produkt_lambda_mit_5_ewartet_30() {
        int ergebnis = f.produktLambda.apply(5);
        Assertions.assertEquals(30, ergebnis);
    }

    @Test
    public void test_produkt_lambda_mit_32767_ewartet_1073676289() {
        int ergebnis = f.produktLambda.apply(32767);
        Assertions.assertEquals(1073709056, ergebnis);
    }

    @Test
    public void test_produkt_Anonym_mit_5_ewartet_30() {
        int ergebnis = f.produktAnonym.apply(5);
        Assertions.assertEquals(30, ergebnis);
    }

    @Test
    public void test_produkt_Anonym_mit_32767_ewartet_1073676289() {
        int ergebnis = f.produktLambda.apply(32767);
        Assertions.assertEquals(1073709056, ergebnis);
    }


    /**
     *  Test fuer fibonacci Lambda & Anonym
     */
    @Test
    public void test_fibonacci_lambda_mit_10_ewartet_55() {
        int ergebnis = f.fibonacciLambda.apply(10);
        Assertions.assertEquals(55, ergebnis);
    }

    @Test
    public void test_fibonacci_lambda_mit_32767_ewartet_727447837() {
        int ergebnis = f.fibonacciLambda.apply(32767);
        Assertions.assertEquals(727447837, ergebnis);
    }

    @Test
    public void test_fibonacci_Anonym_mit_10_ewartet_55() {
        int ergebnis = f.fibonacciAnonym.apply(10);
        Assertions.assertEquals(55, ergebnis);
    }

    @Test
    public void test_fibonacci_Anonym_mit_32767_ewartet_727447837() {
        int ergebnis = f.fibonacciAnonym.apply(32767);
        Assertions.assertEquals(727447837, ergebnis);
    }



    /**
     *  Test fuer gerade quadrat lambda
     */
    @Test
    public void test_gerade_quadrat_lambda_mit_8_ewartet_64() {
        int ergebnis = f.geradeQuadrat.apply(8);
        Assertions.assertEquals(64, ergebnis);
    }

    @Test
    public void test_gerade_quadrat_lambda_mit_32767_ewartet_32767() {
        int ergebnis = f.geradeQuadrat.apply(32767);
        Assertions.assertEquals(32767, ergebnis);
    }


    /**
     *  Test fuer ungerade quadrat Lambda
     */
    @Test
    public void test_ungerade_quadrat_fakultaet_mit_3_ewartet_6() {
        int ergebnis = f.ungeradeFakultaet.apply(3);
        Assertions.assertEquals(6, ergebnis);
    }

    @Test
    public void test_ungerade_quadrat_lambda_mit_4_ewartet_0() {
        int ergebnis = f.ungeradeFakultaet.apply(4);
        Assertions.assertEquals(0, ergebnis);
    }

}