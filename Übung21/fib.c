/*
Dies ist ein Programm, das die Fibonacci-Zahlen berechnet.
@autor: Elisee BRAND & Leopold MITTELBERGER
@Version: 1.0
*/
#include <stdio.h>

int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
	
    int n;

    printf("Geben Sie eine positive Zahl ein : ");
    scanf("%d", &n);

    if (n < 0) {
        printf("Geben Sie eine Zahl größer als 0 ein!");
    } else {
        int result = fibonacci(n);
        printf("Fibonacci fuer %d ==> %d\n", n, result);
    }

    return 0;
    
}


