#include "physics.h"

Weg berechneGleichförmigeBewegung(Weg x0, Geschwindigkeit v, Zeit t, Zeit t0) {
    return v * (t - t0);
}

Weg berechneGleichmäßigBeschleunigteBewegung(Weg x0, Geschwindigkeit v0, Beschleunigung a, Zeit t, Zeit t0) {
    return ((v0 * v0) + (2 * a * (t - t0))) / 2;
}

Geschwindigkeit berechneGeschwindigkeitGleichmäßigBeschleunigteBewegung(Geschwindigkeit v0, Beschleunigung a, Zeit t, Zeit t0) {
    return (a * (t - t0)) + v0;
}
