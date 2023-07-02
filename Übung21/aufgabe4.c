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

    return 0;
}
