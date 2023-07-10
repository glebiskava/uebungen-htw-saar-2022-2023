#include <stdio.h>
#include <string.h>

#define MAX_AUTOS 100

typedef struct {
    char marke[21];
    int hoechstgeschwindigkeit;
    int tuerenanzahl;
    int abs;
    char sonderausstattung[10][101];
    struct {
        int ps;
        int zylinder;
        int hubraum;
    } motor;
} Auto;

Auto autohaus[MAX_AUTOS];
int anzahlAutos = 0;

Auto erstelleAuto(char marke[21], int hoechstgeschwindigkeit, int tuerenanzahl, int abs, char sonderausstattung[10][101], int ps, int zylinder, int hubraum) {
    Auto neuesAuto;
    strncpy(neuesAuto.marke, marke, 20);
    neuesAuto.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
    neuesAuto.tuerenanzahl = tuerenanzahl;
    neuesAuto.abs = abs;
    for (int i = 0; i < 10; i++) {
        strncpy(neuesAuto.sonderausstattung[i], sonderausstattung[i], 100);
    }
    neuesAuto.motor.ps = ps;
    neuesAuto.motor.zylinder = zylinder;
    neuesAuto.motor.hubraum = hubraum;
    return neuesAuto;
}

int schaetzeAutoWert(Auto aut) {
    int wert = aut.hoechstgeschwindigkeit * 50;
    wert *= aut.tuerenanzahl;
    if (aut.abs) {
        wert += 5000;
    }
    for (int i = 0; i < 10; i++) {
        if (strlen(aut.sonderausstattung[i]) > 0) {
            wert += 3000;
        }
    }
    if (strncmp(aut.marke, "Porsche", 20) == 0) {
        wert *= 2;
    }
    return wert;
}

void printAuto(Auto aut) {
    printf("Marke: %s\n", aut.marke);
    printf("Höchstgeschwindigkeit: %d km/h\n", aut.hoechstgeschwindigkeit);
    printf("Türenanzahl: %d\n", aut.tuerenanzahl);
    printf("ABS: %s\n", aut.abs ? "Ja" : "Nein");
    printf("Sonderausstattung:\n");
    for (int i = 0; i < 10; i++) {
        if (strlen(aut.sonderausstattung[i]) > 0) {
            printf("- %s\n", aut.sonderausstattung[i]);
        }
    }
    printf("Motor:\n");
    printf("  PS: %d\n", aut.motor.ps);
    printf("  Zylinder: %d\n", aut.motor.zylinder);
    printf("  Hubraum: %d\n", aut.motor.hubraum);
}

void autoHinzufuegen(Auto aut) {
    if (anzahlAutos < MAX_AUTOS) {
        autohaus[anzahlAutos++] = aut;
        printf("Auto erfolgreich hinzugefügt.\n");
    } else {
        printf("Das Autohaus ist voll. Es können keine weiteren Autos hinzugefügt werden.\n");
    }
}

void autoEntfernen(int index) {
    if (index >= 0 && index < anzahlAutos) {
        for (int i = index; i < anzahlAutos - 1; i++) {
            autohaus[i] = autohaus[i + 1];
        }
        anzahlAutos--;
        printf("Auto erfolgreich entfernt.\n");
    } else {
        printf("Ungültiger Index. Das Auto konnte nicht entfernt werden.\n");
    }
}

int main() {
    char marke[21];
    int hoechstgeschwindigkeit;
    int tuerenanzahl;
    int abs;
    char sonderausstattung[10][101];
    int ps;
    int zylinder;
    int hubraum;
    int eingabe;

    while (1) {
        printf("1 - Auto hinzufügen\n");
        printf("2 - Auto entfernen\n");
        printf("3 - Alle Autos anzeigen\n");
        printf("4 - Programm beenden\n");
        printf("Ihre Auswahl: ");
        scanf("%d", &eingabe);

        switch (eingabe) {
            case 1:
                getchar(); // Puffer leeren
                printf("\nAuto hinzufügen\n");
                printf("Marke: ");
                fgets(marke, 21, stdin);
                marke[strcspn(marke, "\n")] = '\0'; // Entferne Zeilenumbruch am Ende
                printf("Höchstgeschwindigkeit: ");
                scanf("%d", &hoechstgeschwindigkeit);
                printf("Türenanzahl: ");
                scanf("%d", &tuerenanzahl);
                printf("ABS (1 für Ja, 0 für Nein): ");
                scanf("%d", &abs);
                getchar(); // Puffer leeren

                printf("Sonderausstattung:\n");
                for (int i = 0; i < 10; i++) {
                    printf("  Ausstattungsmerkmal %d: ", i + 1);
                    fgets(sonderausstattung[i], 101, stdin);
                    sonderausstattung[i][strcspn(sonderausstattung[i], "\n")] = '\0'; // Entferne Zeilenumbruch am Ende
                }

                printf("Motor\n");
                printf("PS: ");
                scanf("%d", &ps);
                printf("Zylinder: ");
                scanf("%d", &zylinder);
                printf("Hubraum: ");
                scanf("%d", &hubraum);

                Auto neuesAuto = erstelleAuto(marke, hoechstgeschwindigkeit, tuerenanzahl, abs, sonderausstattung, ps, zylinder, hubraum);
                autoHinzufuegen(neuesAuto);
                break;

            case 2:
                printf("\nAuto entfernen\n");
                if (anzahlAutos > 0) {
                    int index;
                    printf("Position des zu entfernenden Autos: ");
                    scanf("%d", &index);
                    autoEntfernen(index - 1);
                } else {
                    printf("Es sind keine Autos vorhanden.\n");
                }
                break;

            case 3:
                printf("\nAutos im Autohaus:\n");
                if (anzahlAutos > 0) {
                    for (int i = 0; i < anzahlAutos; i++) {
                        printf("Auto %d:\n", i + 1);
                        printAuto(autohaus[i]);
                        printf("Wert: %d EUR\n", schaetzeAutoWert(autohaus[i]));
                        printf("\n");
                    }
                } else {
                    printf("Es sind keine Autos vorhanden.\n");
                }
                break;

            case 4:
                printf("\nDas Programm wird beendet.\n");
                return 0;

            default:
                printf("\nUngültige Auswahl. Bitte geben Sie eine gültige Zahl ein.\n");
        }
    }
}
