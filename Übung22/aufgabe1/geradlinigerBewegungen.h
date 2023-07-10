/**
 * Dies ist die libary für die Berechnung geradliniger Bewegungen
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
*/

#define aufgabelB

#include "mechanicherGroesse.h"

Strecke berechneGleichfoermigenBewegung(Geschwindigkeit v, Zeit t, Zeit t0);
Strecke berechneGleichmaessigBeschleunigtenBewegung(Geschwindigkeit v, Geschwindigkeit v0, Beschleunigung a);
Geschwindigkeit berechneGeschwindigkeitGleichmaessigBeschlaunigtenBewegung(Beschleunigung a, Zeit t, Zeit t0, Geschwindigkeit v0);
