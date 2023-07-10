/*
Dies ist ein Programm, das die Grenzen der Datentypen char, short, int, unsigned char, unsigned short und unsigned int ausgibt.
@autor: Elisee BRAND & Leopold MITTELBERGER
@Version: 1.0
*/

#include <stdio.h>
#include <limits.h>

int main() {
    // char
    printf("char: Min = %d, Max = %d\n", CHAR_MIN, CHAR_MAX);

    // short
    printf("short: Min = %d, Max = %d\n", SHRT_MIN, SHRT_MAX);

    // int
    printf("int: Min = %d, Max = %d\n", INT_MIN, INT_MAX);

    // unsigned char
    printf("unsigned char: Min = 0, Max = %u\n", UCHAR_MAX);

    // unsigned short
    printf("unsigned short: Min = 0, Max = %u\n", USHRT_MAX);

    // unsigned int
    printf("unsigned int: Min = 0, Max = %u\n", UINT_MAX);



    // Datentypen deklarieren
    char c;
    short s;
    int i;
    unsigned char uc;
    unsigned short us;
    unsigned int ui;

    // Maximale Werte berechnen
    char max_char = (char)(((unsigned char)1 << (sizeof(char)*8 - 1)) - 1);
    short max_short = (short)(((unsigned short)1 << (sizeof(short)*8 - 1)) - 1);
    int max_int = (int)(((unsigned int)1 << (sizeof(int)*8 - 1)) - 1);
    unsigned char max_uchar = (unsigned char)-1;
    unsigned short max_ushort = (unsigned short)-1;
    unsigned int max_uint = (unsigned int)-1;

    // Minimale Werte berechnen
    char min_char = -(max_char) - 1;
    short min_short = -(max_short) - 1;
    int min_int = -(max_int) - 1;
    unsigned char min_uchar = 0;
    unsigned short min_ushort = 0;
    unsigned int min_uint = 0;

    // Ausgabe der berechneten Werte
    printf("Berechnete Werte:\n");
    printf("char: %d bis %d\n", min_char, max_char);
    printf("short: %d bis %d\n", min_short, max_short);
    printf("int: %d bis %d\n", min_int, max_int);
    printf("unsigned char: %u bis %u\n", min_uchar, max_uchar);
    printf("unsigned short: %u bis %u\n", min_ushort, max_ushort);
    printf("unsigned int: %u bis %u\n", min_uint, max_uint);
    return 0;
}