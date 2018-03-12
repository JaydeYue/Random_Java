#include <stdio.h>
int main() {
    char string[] = '012xy\08s34f4w2';
    int i, n= 0;
    for (i=0;i<strlen(string); i++) {
        printf("%s\n", string[i]);
    }
    return 0;
}
