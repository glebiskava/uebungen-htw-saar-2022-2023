/**
 * Dies ist die Implementierung der Methoden für die Berechnung geradliniger Bewegungen
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
*/

#include <stdio.h>
#include "geradlinigerBewegungen.h"


Strecke berechneGleichfoermigenBewegung(Geschwindigkeit v, Zeit t, Zeit t0) {
    return v * (t * t0);
}
Strecke berechneGleichmaessigBeschleunigtenBewegung(Geschwindigkeit v, Geschwindigkeit v0, Beschleunigung a) {
    return (v * v - v0 * v0) / (2 * a);
}
Geschwindigkeit berechneGeschwindigkeitGleichmaessigBeschlaunigtenBewegung(Beschleunigung a, Zeit t, Zeit t0, Geschwindigkeit v0) {
    return a * (t - t0) + v0;
}

int input;

Strecke leichformen;
Strecke GleichmaessigB;
Geschwindigkeit GeschwindigkeitGB;

void main(){
    menuAusgeben();
}

/*
Dies ist die Menuausgabe
*/
void menuAusgeben(){
    printf("\n\n1. Automatischer Test\n");
    printf("2. Gleichforige bewegung berechnen (s = v * (t * t0))\n");
    printf("3. Gleichmaessig beschleunigten bewegung berechen (s = (v * v - v0 * v0) / (2 * a))\n");
    printf("4. Geschwindigkeit berechnen (v = a * (t - t0) + v0)\n");
    printf("0. Programm beenden\n");
    printf("Bitte geben Sie eine Zahl ein: ");

    methodenRuf();
}

/*
Diese Methode kümmert sich um die Eingabe der Zahl
*/
int inputBekommer(void){
    scanf("%d", &input);
    if (input < 0){
        printf("Bitte geben Sie eine naturliche Zahl ein: ");
        inputBekommer();
    }
    return input;
}

/*
Diese Methode ruft die jeweilige Methode auf
*/
void methodenRuf(){
    int v, t, t0, v0, a;
    input = inputBekommer();
    // printf("input: %d\n", input);
    
    while (input != 0){

        switch (input){
            case 1:
                printf("Automatischer Test\n");
                printf("Gleichformigen bewegung berechen (s = v * (t * t0)), v=10, t=5, t0=7, s=350 erwartet\n");
                leichformen = berechneGleichfoermigenBewegung(10, 5, 7);
                printf("Geschwindigkeit (v = s/t): %f\n\n", leichformen);

                printf("Gleichmaessig beschleunigten bewegung berechen (s = (v * v - v0 * v0) / (2 * a)), v=10, v0=5, a=7, s=5.357143 erwartet\n");
                GleichmaessigB = berechneGleichmaessigBeschleunigtenBewegung(10, 5, 7);
                printf("beschleuningung (a = v/t): %f\n\n", GleichmaessigB);

                printf("Geschwindigkeit gleichmaessig beschlaunigten bewegung berechen (a * (t - t0) + v0), a=10, t=5, t0=7, v0=9, v=-11 erwartet\n");
                GeschwindigkeitGB = berechneGeschwindigkeitGleichmaessigBeschlaunigtenBewegung(10, 5, 7, 9);
                printf("impuls: %f\n\n", GeschwindigkeitGB);

                printf("Gleichformigen bewegung berechen (s = v * (t * t0)), v=5, t=9, t0=7, s=315 erwartet\n");
                leichformen = berechneGleichfoermigenBewegung(5, 9, 7);
                printf("Geschwindigkeit (v = s/t): %f\n\n", leichformen);

                printf("Gleichmaessig beschleunigten bewegung berechen (s = (v * v - v0 * v0) / (2 * a)), v=10, v0=5, a=7, s=5.357143 erwartet\n");
                GleichmaessigB = berechneGleichmaessigBeschleunigtenBewegung(10, 5, 7);
                printf("beschleuningung (a = v/t): %f\n\n", GleichmaessigB);

                printf("Geschwindigkeit gleichmaessig beschlaunigten bewegung berechen (a * (t - t0) + v0), a=2, t=4, t0=6, v0=8, v=4 erwartet\n");
                GeschwindigkeitGB = berechneGeschwindigkeitGleichmaessigBeschlaunigtenBewegung(2, 4, 6, 8);
                printf("impuls: %f\n\n", GeschwindigkeitGB);

                break;
            case 2:
                printf("Geben Sie eine Zahl fuer v ein: ");
                v = inputBekommer();
                printf("Geben Sie eine Zahl fuer t ein: ");
                t = inputBekommer();
                printf("Geben Sie eine Zahl fuer t0 ein: ");
                t0 = inputBekommer();

                leichformen = berechneGleichfoermigenBewegung(v, t, t0);
                printf("Gleichformigen bewegung berechen %f\n", leichformen);
                break;
            case 3:
                printf("Geben Sie eine Zahl fuer v ein: ");
                v = inputBekommer();
                printf("Geben Sie eine Zahl fuer v0 ein: ");
                v0 = inputBekommer();
                printf("Geben Sie eine Zahl fuer a ein: ");
                a = inputBekommer();

                GleichmaessigB = berechneGleichmaessigBeschleunigtenBewegung(v, v0, a);
                printf("Gleichmaessig beschleunigten bewegung berechen %f\n", GleichmaessigB);
                break;
            case 4:
                printf("Geben Sie eine Zahl fuer m ein: ");
                a = inputBekommer();
                printf("Geben Sie eine Zahl fuer v ein: ");
                t = inputBekommer();
                printf("Geben Sie eine Zahl fuer v0 ein: ");
                v0 = inputBekommer();
                printf("Geben Sie eine Zahl fuer t0 ein: ");
                t0 = inputBekommer();

                GeschwindigkeitGB = berechneGeschwindigkeitGleichmaessigBeschlaunigtenBewegung(a, t, v0, t0);
                printf("Geschwindigkeit gleichmaessig beschlaunigten bewegung berechen %f\n", GeschwindigkeitGB);
                break;
        }
        menuAusgeben();
    }
}