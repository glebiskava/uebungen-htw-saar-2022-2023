
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Diese Klasse ist eine test klasse des NumberCruncherTopLevel klasse
 */

public class NumberCruncherTopLevelTest {
    /**
     * Für die Durchführung der Operationen
     */
    private NumberCruncherTopLevel cruncher;

    // private float[] floatZahlenArr = new float[4];
    @beforeEach
    public void Setup(){
//         float[] floatZahlenArr = new float[4];
    }

    @Test
    public void test_Ob_Divide_Still_Funktioniert_Nach_Swirl_Nichts_Erwartet() {
        // private float[] floatZahlenArr = new float[4];
        float[] floatZahlenArr = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] ergebnis = {1.0f, 2.0f, 1.5f, 4.0f};

        NumberCruncherTopLevel.Divide divide = new NumberCruncherTopLevel(floatZahlenArr).new Divide();
        divide.crunch(floatZahlenArr);

        cruncher = new NumberCruncherTopLevel(floatZahlenArr);
        float[] cruncherZahlen = cruncher.getNumbers();

        Assert.assertArrayEquals(ergebnis, cruncherZahlen);

        // private float[] floatZahlenArr = new float[4];
        float[] floatZahlenArr2 = {2.0f, 1.0f, 4.0f, 3.0f};
        float[] ergebnis2 = {2.0f, 1.0f, 4.0f, 1.5f};

        divide.crunch(floatZahlenArr);

        cruncher = new NumberCruncherTopLevel(floatZahlenArr);
        cruncherZahlen = cruncher.getNumbers();

        Assert.assertArrayEquals(ergebnis2, cruncherZahlen);
    }

    @Test
    public void test_Ob_Average_Still_Funktioniert_Nach_Swirl_Nichts_Erwartet() {
        // private float[] floatZahlenArr = new float[4];
        float[] floatZahlenArr = {1.0f, 2.0f, 3.0f, 4.0f};

        NumberCruncherTopLevel.Average average = new NumberCruncherTopLevel(floatZahlenArr).new Average();
        average.crunch(floatZahlenArr);

        cruncher = new NumberCruncherTopLevel(floatZahlenArr);
        float averageErgebnis = average.getAverage();

        Assert.assertArrayEquals(2.5, averageErgebnis);

        // private float[] floatZahlenArr = new float[4];
        float[] floatZahlenArr2 = {2.0f, 1.0f, 4.0f, 3.0f};

        average.crunch(floatZahlenArr);

        cruncher = new NumberCruncherTopLevel(floatZahlenArr);
        averageErgebnis = average.getAverage();

        Assert.assertArrayEquals(2.5, averageErgebnis);
    }
}