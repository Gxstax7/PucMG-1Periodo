#include <stdio.h>
#include <math.h>

int main()
{
    int m, a, b, c;
    scanf ("%d", &m);
    scanf ("%d", &a);
    scanf ("%d", &b);
    c = m-a-b;

    if (m <= 40 && m >= 110 || a >= 1 &&  a > m || b >= 1 &&  b > m || a == b){
        printf ("Valores invalidos");
        return 0;
    }

    if (a > b && a > c){
        printf ("%d", a);
    }else if (b > a && b > c){
        printf ("%d", b);
    }else{
        printf ("%d", c);
    }

    return 0;
}
