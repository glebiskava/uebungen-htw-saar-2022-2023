/**
 * Dies ist die Menuausgabe für die Berechnung mechanischer Groesse
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
*/


#include <stdio.h>
#include "mechanicherGroesse.h"

Geschwindigkeit berechneGeschwindigkeit(Strecke s, Zeit t){
    return s/t;
}
Beschleunigung berechneBeschleunigung(Geschwindigkeit v, Zeit t){
    return v/t;
}
Impuls berechneImpuls(Masse m, Geschwindigkeit v){
    return m*v;
}

int input;

Geschwindigkeit geschwindigkeit;
Beschleunigung beschleuningung;
Impuls impuls;

void main(){
    menuAusgeben();
}

/*
Dies ist die Menuausgabe
*/
void menuAusgeben(){
    printf("\n\n1. Automatischer Test\n");
    printf("2. Geschwindigkeit berechnen (v = s/t)\n");
    printf("3. Beschleunigung berechnen (a = v/t)\n");
    printf("4. Impuls berechnen (p = m * v)\n");
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
    int s, t, v, m;
    input = inputBekommer();
    // printf("input: %d\n", input);
    
    while (input != 0){

        switch (input){
            case 1:
                printf("Automatischer Test\n");
                printf("Geschwindigkeit berechnen (v = s/t) s=10, t=5, v=2 erwartet\n");
                geschwindigkeit = berechneGeschwindigkeit(10, 5);
                printf("Geschwindigkeit (v = s/t): %f\n", geschwindigkeit);

                printf("Beschleunigung berechnen (a = v/t) v=10, t=5, a=2 erwartet\n");
                beschleuningung = berechneBeschleunigung(10, 5);
                printf("beschleuningung (a = v/t): %f\n", beschleuningung);

                printf("Impuls berechnen (p = m * v) m=10, v=5, p=50 erwartet\n");
                impuls = berechneImpuls(10, 5);
                printf("impuls: %f\n", impuls);

                break;
            case 2:
                printf("Geben Sie eine Zahl fuer s ein: ");
                s = inputBekommer();
                printf("Geben Sie eine Zahl fuer t ein: ");
                t = inputBekommer();

                geschwindigkeit = berechneGeschwindigkeit(s, t);
                printf("Geschwindigkeit (v = s/t): %f\n", geschwindigkeit);
                break;
            case 3:
                printf("Geben Sie eine Zahl fuer v ein: ");
                v = inputBekommer();
                printf("Geben Sie eine Zahl fuer t ein: ");
                t = inputBekommer();;

                beschleuningung = berechneBeschleunigung(v, t);
                printf("beschleuningung (a = v/t): %f\n", beschleuningung);
                break;
            case 4:
                printf("Geben Sie eine Zahl fuer m ein: ");
                m = inputBekommer();
                printf("Geben Sie eine Zahl fuer v ein: ");
                v = inputBekommer();

                impuls = berechneImpuls(m, v);
                printf("impuls (p = m * v): %f\n", impuls);
                break;
        }
        menuAusgeben();
    }
}