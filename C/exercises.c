#include <stdio.h>
#include <limits.h>
#include <float.h>
/* Exercises I did while going through "The C Programming Language 2nd Edition" book */

/*  Exercise 2-1
    Write a program to determine the ranges of char, short, int, and long variables, both signed and unsigned, by
    printing appropriate values from standard headers and by direct computation. Harder if you compute them: determine
    the ranges of the various floating-point types.
*/
void determine_range_of_types();
void determine_range_of_types() {
    printf("Exercises 2-1\n");
    printf("Number of bits in a byte: %d\n", CHAR_BIT);
    printf("Ranges from standard headers limits.h and float.h:\n");
    printf("Range of signed char: %d to %d\n", SCHAR_MIN, SCHAR_MAX);
    printf("Range of signed short: %d to %d\n", SHRT_MIN, SHRT_MAX);
    printf("Range of signed int: %d to %d\n", INT_MIN, INT_MAX);
    printf("Range of signed long: %ld to %ld\n", LONG_MIN, LONG_MAX);
    printf("Range of unsigned char: 0 to %u\n", UCHAR_MAX);
    printf("Range of unsigned short: 0 to %u\n", USHRT_MAX);
    printf("Range of unsigned int: 0 to %u\n", UINT_MAX);
    printf("Range of unsigned long: 0 to %lu\n", ULONG_MAX);
    printf("Range of float: %e to %e\n", FLT_MIN, FLT_MAX);
    printf("Range of double: %e to %e\n", DBL_MIN, DBL_MAX);
    printf("Range of long double: %Le to %Le\n\n", LDBL_MIN, LDBL_MAX);

    printf("Ranges from computation:\n");
    // printf("Range of signed char: %d to %d\n", SCHAR_MIN, SCHAR_MAX);
    // printf("Range of signed short: %d to %d\n", SHRT_MIN, SHRT_MAX);
    // printf("Range of signed int: %d to %d\n", INT_MIN, INT_MAX);
    // printf("Range of signed long: %ld to %ld\n", LONG_MIN, LONG_MAX);
    // printf("Range of unsigned char: 0 to %u\n", UCHAR_MAX);
    // printf("Range of unsigned short: 0 to %u\n", USHRT_MAX);
    // printf("Range of unsigned int: 0 to %u\n", UINT_MAX);
    // printf("Range of unsigned long: 0 to %lu\n", ULONG_MAX);
    // printf("Range of float: %f to %f\n", FLT_MIN, FLT_MAX);
    // printf("Range of double: %lf to %lf\n", DBL_MIN, DBL_MAX);
    // printf("Range of long double: %Lf to %Lf\n", LDBL_MIN, LDBL_MAX);
}

/*  Exercise 2-3
    Write the function htoi(s), which converts a string of hexadecimal digits (including an optional 0x or 0X) into its equivalent integer value. The allowable digits are 0 through 9, a through f, and A through F.
*/
int htoi(char hex[]);


int main() {
    // Exercise 2-1
    determine_range_of_types();
    printf("------------------ End of Exercise 2-1 ------------------\n\n");

    // Exercise 2-3
    return 0;
}
