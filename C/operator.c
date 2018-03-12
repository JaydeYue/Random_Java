#include <stdio.h>
/*Test: does c executes the second operator when the first operator is enough

    Result: after c knows enough from the first part of comparison, it doesn't compare the second part.*/
int main() {
    int a=1, b=2, c=3, d=4;
    if ((a=2) || (b=1)) c=2;
    if ((c==3) && (d=-1)) a=5;
    printf("%d, %d, %d, %d\n", a, b, c, d);
    return 0;
}
