public class debut {
    /**
     * berechnet die Pruefziffer einer ISBN-10 Nummer und gibt diese als String aus.
     * @param zahl1 Zahl die entgegengenommen wird
     * @param zahl2 Zahl die entgegengenommen wird
     */
    public static int berechneGgtIterativ(int zahl1, int zahl2){

        // ErrorCheck.checkIsNumberNull(zahl1);
        // ErrorCheck.checkIsNumberNegative(zahl1);
        // ErrorCheck.checkIsNumberNull(zahl2);
        // ErrorCheck.checkIsNumberNegative(zahl2);

        int output = 0;
        for(int i=1; i <= zahl1 && i <= zahl2; i++)
        {
            if(zahl1% i==0 && zahl2%i==0)
                output = i;
        }
        return output;
    }

    public int berechneGgtRekursiv(int zahl1, int zahl2, int index = 0){

        // ErrorCheck.checkIsNumberNull(zahl1);
        // ErrorCheck.checkIsNumberNegative(zahl1);
        // ErrorCheck.checkIsNumberNull(zahl2);
        // ErrorCheck.checkIsNumberNegative(zahl2);

        if(index == 0){
            if(zahl1 > zahl2){
                index = zahl2;
            } else {
                index = zahl1;
            }
        } else {
            if(zahl1%index == 0 && zahl2%index == 0){
                return index;
            } else {
                return berechneGgtRekursiv(zahl1, zahl2, index);
            }
        }


        // int output = 0;
        // for(int i=1; i <= zahl1 && i <= zahl2; i++)
        // {
        //     if(zahl1% i==0 && zahl2%i==0)
        //         output = i;
        // }
        // return output;
    }

    public static void main(String[] args){
        new debut();
        System.out.println(berechneGgtRekursiv(5, 6, 6));
    }

    @Override
    public String toString() {
        return "debut []";
    }

}
