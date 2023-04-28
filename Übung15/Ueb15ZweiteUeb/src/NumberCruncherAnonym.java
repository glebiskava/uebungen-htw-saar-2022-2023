import java.util.Random;

import javax.management.OperationsException;

public class NumberCruncherAnonym {
    /**
     * erstellen des Arrays
     */
    private float[] Zahlen;
    private int langeArray;

    NumberCruncherAnonym(float[] zahlen) {
        this.zahlen = zahlen;
        // this.langeArray = langue

    }

    public void crunch(String[] Operations){
        for (String operations : Operations){
            switch(operations) {
                case "sum":
                    anonymousSum();
                    break;
                case "swirl":
                    anonymousSwirl();
                    break;
                case "divide":
                    anonymousDivide();
                    break;
                case "substract":
                    anonymousSubstract(); 
                    break;
                case "average":
                    anonymousAverage();
                    break;
                default:
                    System.out.println("Diese operation ist nicht machtbar: " + operations);
                    break;
            }
        }
    }

    public void anonymousSum(){
        CrunchOperation sum = new CrunchOperation(){
            public void crunch(float[] Zahlen){
                for(int i = 0; i < Zahlen.length ; i++){
                    Zahlen[i + 1] = Zahlen[i] + Zahlen[i + 1];
                }
            }
        };
        sum.crunch(Zahlen);
    }

    public void anonymousSwirl(){
        CrunchOperation swirl = new CrunchOperation(){
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
        };
        swirl.crunch(Zahlen);
    }

    public void anonymousDivide(){
        CrunchOperation divide = new CrunchOperation(){
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
                }

                for(int i = 0; i < zahlenLength; i++){
                    Zahlen[zahlenLength - 1 - i] /= Zahlen[i];
                }

            }
        };
        divide.crunch(Zahlen);
    }

    public void anonymousSubstract(){
        CrunchOperation substract = new CrunchOperation(){
            public void crunch(float[] Zahlen){
                for(int i = 0; i < Zahlen.length ; i++){
                    Zahlen[i + 1] = Zahlen[i] - Zahlen[i + 1];
                }
            }
        };
        substract.crunch(Zahlen);
    }

    public void anonymousAverage(){
        CrunchOperation average = new CrunchOperation(){
            public void crunch(float[] Zahlen){
                int summe = 0;
                for(int i = 0; i < Zahlen.length ; i++){
                    summe += Zahlen[i];
                }
                summe /= Zahlen.length;
            }
        };
        average.crunch(Zahlen);
    }

    public float[] getNumbers(){
        return Zahlen;
    }
}
