import java.util.Random;
public class NumberCruncherTopLevel {
    /**
     * erstellen des Arrays
     */
    private float[] Zahlen;
    // private int langeArray;

    NumberCruncherTopLevel(float[] zahlen) {
        this.Zahlen = zahlen;
        // this.langeArray = langue
        
    }

    public class Sum implements CrunchOperation {
        @Override
        public void crunch(float[] Zahlen) {
            for (int i = 1; i < Zahlen.length; i++) {
                Zahlen[i] += Zahlen[i-1];
            }
        }
    }

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

    public class Divide implements CrunchOperation {
        @Override
         public void crunch(float[] Zahlen){

            //Array sort
            int zahlenLength = Zahlen.length;
            float[] sortedArrayZahlen = new float[zahlenLength];
            for (int i = 0; i < Zahlen.length; i++) {
                sortedArrayZahlen[i] = Zahlen[i];
            }
            for(int i = 0; i < Zahlen.length; i++){
                int minZahl = i;
                for(int j = i+1; j < zahlenLength; j++){
                    if(sortedArrayZahlen[j] < sortedArrayZahlen[minZahl]){
                        minZahl = j;
                    }
                }
                float tmp = sortedArrayZahlen[minZahl];
                sortedArrayZahlen[minZahl] = sortedArrayZahlen[i];
                sortedArrayZahlen[i] = tmp;
                System.out.println(sortedArrayZahlen[i]);
            }

            int zahlenLengthDivideBy2 = 0;
            // if(zahlenLength % 2 == 0){
            //     zahlenLengthDivideBy2 = (int)Math.ceil(zahlenLength / 2);
            // } else {
            //     zahlenLengthDivideBy2 = (int)Math.ceil((zahlenLength / 2) + 1);
            // }
            zahlenLengthDivideBy2 = (int)Math.ceil((zahlenLength / 2) );
            //divide
            for(int i = 0; i < zahlenLengthDivideBy2; i++){
                Zahlen[zahlenLength - 1 - i] /= sortedArrayZahlen[i];
            }
        }
    }

    public class Substract implements CrunchOperation {
        @Override
        public void crunch(float[] Zahlen){
            for(int i = 0; i < (Zahlen.length - 1) ; i++){
                Zahlen[i + 1] -= Zahlen[i];
            }
        }
    }

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
        
        public float getAverage(){
            return average;
        }
    }
    
    // public void crunch(String[] operations){

    // }

    public float[] getNumbers(){
        return Zahlen;
    }
}
