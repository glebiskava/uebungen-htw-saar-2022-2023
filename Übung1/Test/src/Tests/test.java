package Tests;

import org.jetbrains.annotations.Contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
/*
        new test().rechnen(17, 34);
*/
        /*new test().leapYearTest();*/

        /*new test().faculty();*/

/*
        new test().viererfolge(new int[]{1,2,3,3,3,3,4,4,4,4,5,5,5,6,6});
*/
/*
        new test().arrayZahlen(new int[]{1, 3, 7, 2, 7, 3, 8, 9, 6, 2}, 0, 6);
*/

        /*new test().lotto();*/
        /*System.out.println(zaehleZiffern(456));
        System.out.println(dreheUm(4567));
        System.out.println(distanzMinimumMaximum(new int[] {3,4,5,6,2}));*/
        /*new test().rechnen(2,1);*/
/*
        System.out.println(Arrays.toString(arrayZahlen(new int[] {8,3,7,5,6,7,8})));
*/


    }

    /*public static void rechnen(int a, int b) {
        int begin = b;
        do {
            a = Math.abs(a/2);
            b *= 2;
        } while(a > 1);
        System.out.println(begin + b);
    }*/

    /*public static int rechnen(int zahl1, int zahl2) {
        int summe = 0;
        if (zahl1 < 0 || zahl2 < 0) {
            throw new IllegalArgumentException("Die Zahlen muessen positiv sein.");
        }
        while (zahl1 > 0) {
            if (zahl1 % 2 != 0) {
                summe = summe + zahl2;
            }
            zahl1 = zahl1 / 2;
            zahl2 = zahl2 * 2;
        }
        System.out.println(summe);
        return summe;
    }*/

    /*public static int arrayZahlen(int[] zahlen, int min, int max) {
        int anzahl = 0;

        for(int zahl : zahlen) {
            if (zahl >= min && zahl <= max && zahl % 2 != 0) {
                anzahl++;
            }
        }
        System.out.println(anzahl);
        return anzahl;
    }*/

   /* public static boolean viererfolge(int[] zahlen) {
        int anzahl = 1;
        boolean viererfolge = false;
        for (int i = 0; i < zahlen.length - 3; i++) {
            if (zahlen[i] == zahlen[i + 1]) {
                if (zahlen[i + 1] == zahlen[i + 2]) {
                    if (zahlen[i + 2] == zahlen[i + 3]) {
                        viererfolge = true;
                    }
                }
            }
        }
        System.out.println(viererfolge);
        return viererfolge;
    }*/

    /*public String leapYearTest() {

        int i;

        for (i = 1999; i <= 2030; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 !=0)) {
                System.out.println(i + ": " + true);
            } else System.out.println(i + ": " + false);
        } return "";
    }*/

    /*public void test2() {
        int w = 100;
        int dw = 100;

        System.out.println("Runterzaehlen von 100 bis 50 in 5er Schritten mit for-Schleife: ");
        for (int i = 100; i >= 50; i -= 5) {
            System.out.println(i);
        }

        System.out.println("Runterzaehlen von 100 bis 50 in 5er Schritten mit while-Schleife: ");
        while (w >= 50) {
            System.out.println(w);
            w -= 5;
        }

        System.out.println("Runterzaehlen von 100 bis 50 in 5er Schritten mit do-while-Schleife: ");
        do {
            System.out.println(dw);
            dw -= 5;
        } while (dw >= 50);
    }*/

    /*public void faculty() {
        int x = 1;
        *//*BigInteger x = new BigInteger("1");*//*
        double res = 1;

        for (int i = 1; i <= x; i++) {
            res *= i;
            if (x == 21) {
                break;
            }
            System.out.println(x + "! = " + res);
            x++;
        }
    }*/

    /*public void test3() {
        *//*double sum = 0;
        double total = 0;

        for (int i = 2; i <= 30; i++) {
            sum += 1.0/(i*i);
            total += sum;
            System.out.println(i + " : " + sum);
        }
        System.out.println("total sum: " + total);*//*

        var x = new int[100];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            int rand = Math.abs(random.nextInt());
            Arrays.fill(x, i, i+1, rand);
        }

        for (int item : x) {
            System.out.println(item);
        }
    }*/

    /*public void numberSum(int n1, int n2) {
        if(n1 >= 0 && n2 >= 0) {
            System.out.println(n1+n2);
        } else {
            throw new IllegalArgumentException("eine der beiden Zahl ist kleiner oder gleich null.");
        }
    }*/

    /*public static int zaehleZiffern(int zahl) {
    // Variablen 1
        int stellenZaehler = 0;
        int temp = zahl;
    // Schleife mit Berechnung 3
        while (temp != 0) {
            temp = temp / 10;
            stellenZaehler++;
        }
        return stellenZaehler;
    }*/

    /*public static long dreheUm(int zahl) {
        int stellenZaehler = 0;
        long produkt = 0;
    // Aufruf 1
        stellenZaehler = zaehleZiffern(zahl);
    // + 1
        stellenZaehler--;
    // 1
        while (zahl != 0) {
    // 1
            int ziffer = zahl % 10;
    // 1
            zahl = zahl / 10;
    // 1
            produkt = produkt + ziffer * (long)Math.pow(10, stellenZaehler);
    // 1
            stellenZaehler--;
        }
        return produkt;
    }*/

    /*public static int distanzMinimumMaximum(int[] zahlen) {

        int min = zahlen[0];
        int max = zahlen[0];

        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] <= min) {
                min = zahlen[i];
            }
            if (zahlen[i] >= max) {
                max = zahlen[i];
            }
        } return max - min;
    }*/

    /*public static int[] arrayZahlen(int[] zahlen) {
        for (int item = 0; item < zahlen.length; item++) {
            if (zahlen[item] <= 0) {
                throw new IllegalArgumentException("Es gibt negative Zahlen im Array");
            }
            if (zahlen[item] % 2 == 0) {
                zahlen[item] *= 2;
            } else {
                zahlen[item] *= 3;
            }
        } return zahlen;
    }*/



}
