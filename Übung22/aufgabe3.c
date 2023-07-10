/**
 * Dies ist ein Programm, das ein zeichen ausgibt
 * @autor: Elisee BRAND & Leopold MITTELBERGER
 * @version: 1.0
*/

#include <stdio.h>
void main (){
    int input;
    int test = 0;

    printf("Geben Sie eine Zahl ein: ");
    scanf("%d", &input);
    if (input <= 0){
        printf("Zahl muss groesser als 0 sein\n");
    } else if (input >= 1){
        for(int i=0; i<input; i++){
            for (int j=0; j<input; j++){
                if(j == i || j == (input-i-1)){
                    printf("*");
                } else {
                    printf("-");
                }
            }
            printf("\n");
        }
    }
}