import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FunctionsTest {

    private Functions f;

    @BeforeEach
    void setUp() {
        f = new Functions();
    }

    // Test for square Lambda
    @Test
    public void test_Square_Lambda_mit_10_ewartet_100 {
        int ergebnis = f.squareLambda.apply(10);
        Assertion.assertequals(100, ergebnis);
    }

    // Test for square Anonymous
    @Test
    public void test_Square_Anonymous_mit_10_ewartet_100 {
        int ergebnis = f.squareAnonymous.apply(10);
        Assertion.assertequals(100, ergebnis);
    }


    // Test for factorial Lambda
    @Test
    public void test_Factorial_Lambda_mit_4_ewartet_24 {
        int ergebnis = f.factorialLambda.apply(4);
        Assertion.assertequals(24, ergebnis);
    }

    // Test for factorial Anonymous
    @Test
    public void test_Factorial_Anonymous_mit_4_ewartet_24 {
        int ergebnis = f.factorialAnonymous.apply(4);
        Assertion.assertequals(24, ergebnis);
    }

    // Test for factorial top Level
    @Test
    public void test_Factorial_TopLevel_mit_4_ewartet_24 {
        Functions f = new Functions();
        int ergebnis = f.applyAndPrint(4, new Functions.Factorial());
        // int ergebnis = f.factorialAnonymous.apply(4);
        Assertion.assertequals(24, ergebnis);
    }

    // Test for factorial Stati nested
    @Test
    public void test_Factorial_Static_Nested_mit_4_ewartet_24 {
        Functions f = new Functions();
        int ergebnis = f.applyAndPrint(4, new Functions.FactorialStaticNested());
        // int ergebnis = f.factorialAnonymous.apply(4);
        Assertion.assertequals(24, ergebnis);
    }


    // test for productLambda
    @Test
    public void test_product_lambda_mit_5_ewartet_30 {
        int ergebnis = f.fproductLambda.apply(5);
        Assertion.assertequals(30, ergebnis);
    }
    // test for product Anonymous
    @Test
    public void test_product_Anonymous_mit_5_ewartet_30 {
        int ergebnis = f.fproductAnonymous.apply(5);
        Assertion.assertequals(30, ergebnis);
    }


    // test for productLambda
    @Test
    public void test_fibonacci_lambda_mit_10_ewartet_55 {
        int ergebnis = f.fibonacciLambda.apply(10);
        Assertion.assertequals(55, ergebnis);
    }
    // test for product Anonymous
    @Test
    public void test_fibonacci_Anonymous_mit_10_ewartet_55 {
        int ergebnis = f.fibonacciAnonymous.apply(5);
        Assertion.assertequals(55, ergebnis);
    }

    // test for even quadrat
    @Test
    public void test_quadrat_even_mit_8_ewartet_64 {
        int ergebnis = f.evenQuadrat.apply(8);
        Assertion.assertequals(64, ergebnis);
    }
    // test for fakultat odd Lambda
    @Test
    public void test_fakultat_odd_lambda_mit_3_ewartet_6 {
        int ergebnis = f.evenQuadrat.apply(3);
        Assertion.assertequals(6, ergebnis);
    }
    // test for fakultat odd Lambda
    @Test
    public void test_fakultat_odd_lambda_mit_4_ewartet_0 {
        int ergebnis = f.evenQuadrat.apply(4);
        Assertion.assertequals(0, ergebnis);
    }
    
    
}
