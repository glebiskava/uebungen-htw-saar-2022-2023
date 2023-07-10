#include "physics.h"

Geschwindigkeit berechneGeschwindigkeit(Weg ds, Zeit dt) {
    return ds / dt;
}

Beschleunigung berechneBeschleunigung(Geschwindigkeit dv, Zeit dt) {
    return dv / dt;
}

Impuls berechneImpuls(Masse m, Geschwindigkeit v) {
    return m * v;
}
