#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int a, b, c, l, h;
    scanf ("%d %d %d %d %d", &a, &b, &c, &l, &h);
    if (a + b <= l + h || b + c <= l + h){
        printf ("S");
        }else{
        printf ("N");
        }
}