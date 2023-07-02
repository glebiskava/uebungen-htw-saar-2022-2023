#include <stdio.h>

int i=333; 

void modify(void) {
   printf("[modify] i: %d\n",i); 
   i = 111;   
   printf("[modify] i: %d\n",i);  
}

int main(void) {
   int i = 444;
   printf("[main] i: %d\n",i); 
   modify();
   printf("[main] i: %d\n",i); 
   return 0;
}