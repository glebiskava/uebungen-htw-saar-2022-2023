import java.util.Random;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Diese Klasse enthält verschiedene Methoden zur Verarbeitung von Float-Arrays 
 */

public class NumberCruncherTopLevel {
    /**
     * erstellen des Arrays
     */
    private float[] Zahlen;

    /**
     * Konstruktor
     * @param zahlen die eine Float array ist
     */
    NumberCruncherTopLevel(float[] zahlen) {
        this.Zahlen = zahlen;        
    }

    /**
     * Klasse Sum
     * 
     * Diese Klasse implementiert die crunch-Methode der Schnittstellenklasse CrunchOperation.
     * Die Methode berechnet die Summe aller Elemente im Array.
     */
    public class Sum implements CrunchOperation {
        @Override
        public void crunch(float[] Zahlen) {
            for (int i = 1; i < Zahlen.length; i++) {
                Zahlen[i] += Zahlen[i-1];
            }
        }
    }

    /**
     * Klasse Swirl
     * 
     * Diese Klasse implementiert die crunch-Methode der Schnittstellenklasse CrunchOperation.
     * Die Methode ordnet die Elemente des Arrays zufällig an.
     */
    public class Swirl implements CrunchOperation {
        @Override
        public void crunch(float[] Zahlen){
                Random random = new Random();
                int zahlenLength = Zahlen.length;
                for(int i = 0; i < Zahlen.length ; i++){
                    int randomInt = random.nextInt(zahlenLength);
                    float temp = Zahlen[randomInt];
                    Zahlen[randomInt] = Zahlen[i];
                    Zahlen[i] = temp;
                }
            }
    }

    /**
     * Klasse Divide
     * 
     * Diese Klasse implementiert die crunch-Methode der Schnittstellenklasse CrunchOperation.
     * Die Methode dividiert die n/2 größten Werte im Array durch die n/2 kleinsten Werte und 
     * speichert den neuen Wert im Datenfeld des jeweils größeren Wertes. 
     */
    public class Divide implements CrunchOperation {
        @Override
         public void crunch(float[] Zahlen){

            //Array sort
            int zahlenLength = Zahlen.length;
            float[] sortedArrayZahlen = new float[zahlenLength];
            for (int i = 0; i < zahlenLength; i++) {
                sortedArrayZahlen[i] = Zahlen[i];
            }
            for(int i = 0; i < zahlenLength; i++){
                int minZahl = i;
                for(int j = i+1; j < zahlenLength; j++){
                    if(sortedArrayZahlen[j] < sortedArrayZahlen[minZahl]){
                        minZahl = j;
                    }
                }
                float tmp = sortedArrayZahlen[minZahl];
                sortedArrayZahlen[minZahl] = sortedArrayZahlen[i];
                sortedArrayZahlen[i] = tmp;
            }

            int zahlenLengthDivideBy2 = 0;

            zahlenLengthDivideBy2 = (int)Math.ceil((zahlenLength / 2) );
            //divide
            for(int i = 0; i < zahlenLengthDivideBy2; i++){
                for(int j = 0; j < zahlenLength; j++){
                    if(sortedArrayZahlen[zahlenLength - 1 - i] == Zahlen[j]){
                        Zahlen[j] /= sortedArrayZahlen[i];
                    }
                }
                // Zahlen[zahlenLength - 1 - i] /= sortedArrayZahlen[i];
            }
        }
    }

    /**
     * Klasse Subtract
     *
     * Die Klasse Subtract implementiert ebenfalls die CrunchOperation-Schnittstelle 
     * Die Methode die ein Array von float-Werten als Eingabe erhält und 
     * die Differenz zwischen dem aktuellen Wert und dem vorherigen Wert im Array berechnet.
     */
    public class Substract implements CrunchOperation {
        @Override
        public void crunch(float[] Zahlen){
            for(int i = 0; i < (Zahlen.length - 1) ; i++){
                Zahlen[i + 1] -= Zahlen[i];
            }
        }
    }
    
    /**
     * Klasse Average
     *      
     * Die Klasse Average implementiert ebenfalls die CrunchOperation-Schnittstelle 
     * Die Methode die ein Array von float-Werten als Eingabe erhält und den Durchschnitt aller Werte im Array berechnet und 
     * in der privaten Variable average speichert. Die Methode getAverage gibt den Durchschnittswert zurück.
     */

    public class Average implements CrunchOperation {
        private float average;

        @Override
        public void crunch(float[] Zahlen){
            // float average = 0;
            for(int i = 0; i < Zahlen.length ; i++){
                average += Zahlen[i];
            }
            average /= Zahlen.length;
        }

        /**
         * Dies ist eine Get Methode die das average von jeder float zahl des Array zurueckgibt
         * @return average die ein float ist
         */
        public float getAverage(){
            return average;
        }
    }

    /**
     * Dies ist eine Get Methode die Zahlen als Float array zurueckgibt
     * @return Zahlen die eine Float Array ist
     */
    public float[] getNumbers(){
        return Zahlen;
    }
}
