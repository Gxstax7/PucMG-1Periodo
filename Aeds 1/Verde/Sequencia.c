#include <stdio.h>
#include <stdlib.h>

int main (){

    int n1, n2, soma;

    scanf ("%d %d", &n1, &n2);

    if (n1 > n2){
        for (n2; n1 >= n2; n2++){
            printf ("%d ", n2);
            soma = soma + n2;
        }
        printf ("Soma = %d", soma);
    }else if (n2 > n1){
        for (n1; n2 >= n1; n1++){
            printf ("%d ", n1);
            soma = soma + n1;
        }
        printf ("Soma = %d", soma);
    }

    return 0;
}
