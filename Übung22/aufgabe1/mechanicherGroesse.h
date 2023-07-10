/**
 * Dies ist die libary für die Berechnung mechanischer Groesse
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
*/

#define aufgabel

typedef float Strecke;
typedef float Zeit;
typedef float Geschwindigkeit;
typedef float Beschleunigung;
typedef float Impuls;
typedef float Masse;

Geschwindigkeit berechneGeschwindigkeit(Strecke s, Zeit t);
Beschleunigung berechneBeschleunigung(Geschwindigkeit v, Zeit t);
Impuls berechneImpuls(Masse m, Geschwindigkeit v);
