#include <stdio.h>
#include <stdlib.h>

int main (){

    int p1, p2;
    scanf ("%d %d", &p1, &p2);

    if (p1 > 0 && p2 > 0){
        printf ("primeiro");
    }else if (p1 > 0 && p2 < 0){
        printf ("quarto");
    }else if (p1 < 0 && p2 < 0){
        printf ("terceiro");
    }else if (p1 < 0 && p2 > 0){
        printf ("segundo");
    }
    return 0;
}
