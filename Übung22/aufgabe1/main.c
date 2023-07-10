#include <stdio.h>
#include "physics.h"
#include "mechanik.h"
#include "bewegung.h"

int main() {
    // Testen der mechanischen Größen
    Weg ds = 10.0;
    Zeit dt = 2.5;

    Geschwindigkeit v = berechneGeschwindigkeit(ds, dt);
    printf("Geschwindigkeit: %.2f\n", v);

    Beschleunigung a = berechneBeschleunigung(v, dt);
    printf("Beschleunigung: %.2f\n", a);

    Masse m = 5.0;
    Impuls p = berechneImpuls(m, v);
    printf("Impuls: %.2f\n", p);

    // Testen der geradlinigen Bewegungen
    Weg x0 = 0.0;
    Geschwindigkeit v0 = 2.0;
    Zeit t = 3.0;
    Zeit t0 = 0.0;
    Beschleunigung a2 = 1.5;

    Weg s1 = berechneGleichförmigeBewegung(x0, v0, t, t0);
    printf("Gleichförmige Bewegung: %.2f\n", s1);

    Weg s2 = berechneGleichmäßigBeschleunigteBewegung(x0, v0, a2, t, t0);
    printf("Gleichmäßig Beschleunigte Bewegung: %.2f\n", s2);

    Geschwindigkeit v2 = berechneGeschwindigkeitGleichmäßigBeschleunigteBewegung(v0, a2, t, t0);
    printf("Geschwindigkeit Gleichmäßig Beschleunigte Bewegung: %.2f\n", v2);

    return 0;
}
