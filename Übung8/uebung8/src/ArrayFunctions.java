public class ArrayFunctions {
    public static Mittelwert berechneMittelwert(double[] messwerte){

        double messewerteLength = messwerte.length;
        double summe = 0;

        for(int i = 0; i < messewerteLength; i++){
            summe += messwerte[i];
        }
        double mittelwert = summe / messewerteLength;

        double nahesterWert = Double.MAX_VALUE;
        double entferntesterWert = Double.MIN_VALUE;

        for(int j = 0; j < messewerteLength; j++){
            if(messwerte[j] < nahesterWert){
                nahesterWert = messwerte[j];
            }
            if(messwerte[j] > entferntesterWert){
                entferntesterWert = messwerte[j];
            }
        }
        return new Mittelwert(mittelwert, nahesterWert, entferntesterWert);
    }
}