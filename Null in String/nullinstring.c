#include <stdio.h>
#include <string.h>
/**/
int main() {
    // Single quotes are for single characters
    char string[] = "012xy\08s34f4w2";
    int i, n= 0;
    printf("Length of string: %d\n", strlen(string));
    for (i=0;i<strlen(string); i++) {
        // %c prints a character with sizeof(char)
        // %s prints to the pointer to a null terminated string sizeof(char*)
        printf("%c\n", string[i]);
    }
    return 0;
}
