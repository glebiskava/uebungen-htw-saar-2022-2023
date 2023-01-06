public class ArrayFunctions {
    public static Mittelwert berechneMittelwert(double[] messwerte){

        double messewerteLength = messwerte.length;
        double summe = 0;

        for (double messwert : messwerte) {
            summe += messwert;
        }
        double mittelwert = summe / messewerteLength;

        double naehesteMessung = Double.MAX_VALUE;
        double weitesteMessung = Double.MIN_VALUE;

        for (double messwert : messwerte) {
            if (messwert < naehesteMessung) {
                naehesteMessung = messwert;
            }
            if (messwert > weitesteMessung) {
                weitesteMessung = messwert;
            }
        }
        return new Mittelwert(mittelwert, naehesteMessung, weitesteMessung);
    }
}