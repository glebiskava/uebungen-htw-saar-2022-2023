/**
 * Dies ist eine Klasse ArrayFunctions fuer messewerte und String auswerten
 * @author Leopold Mittelberger, Elisee Brand
 * @version 2
 */

import java.util.*;

public class ArrayFunctions {
    /**
     * Berechnet das arithmetische Mittel und gibt Messwerte die am naechsten und am weitesten liegen
     * @param messwerte ist ein Array von double
     * @return ruft einen konstruktor an, um die daten einfacher zu bekommen
     */
    public static Mittelwert berechneMittelwert(double[] messwerte){

        Arrays.sort(messwerte);

        double summe = 0;
        int messewerteLength = messwerte.length;

        //berechnet die summe der double das Array
        for(int i = 0; i < messewerteLength; i++){
            summe += messwerte[i];
        }
        //berechnet das arithmetische Mittel
        double mittelwert = summe / messewerteLength;

        double nahesterWert = messwerte[0];
        double entferntesterWert = messwerte[0];

        // Sucht die naehester und die weiteste werte an
        for(int j = 0; j < messewerteLength; j++){
            if(Math.abs(mittelwert - messwerte[j]) < Math.abs(mittelwert - nahesterWert)){
                nahesterWert = messwerte[j];
            }
            if(Math.abs(mittelwert - messwerte[j]) > Math.abs(mittelwert - entferntesterWert)){
                entferntesterWert = messwerte[j];
            }
        }
        return new Mittelwert(mittelwert, nahesterWert, entferntesterWert);
    }

    /**
     * Sucht von ein Arrayder Anzahl von Strings in String die nur aus Grossbuchstaben oder nur aus Kleinbuchstaben
     * bestehen sind
     * @param strings ist ein Array von String
     * @return der Anzahl von Strings in String die nur aus Grossbuchstaben oder nur aus Kleinbuchstaben bestehen sind
     */
    public static int stringsAuswerten(String[] strings){
        //prueft, ob das Array lehr ist oder nicht
        ErrorCheck.checkLehrArray(strings);

        int ergebnis = 0;
        int stringLength = strings.length;

        for(int i = 0; i < stringLength; i++){

            int upper = 0;
            int lower = 0;

            String str = strings[i];
            int strLength = str.length();
            if(strLength > 1){
                for(int j = 0; j < strLength; j++){
                    char c = str.charAt(j);
                    if(Character.isUpperCase(c)){
                        upper += 1;
                    } else if(Character.isLowerCase(c)){
                        lower += 1;
                    }
                }
                if (upper == strLength || lower == strLength){
                    ergebnis += 1;
                }
            }
        }
        return ergebnis;
    }
}