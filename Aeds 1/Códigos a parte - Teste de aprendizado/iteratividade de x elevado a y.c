//receber k e n e calcular k^n
#include <stdio.h>

int elev (int, int);

int main (void){

    int a, b, result;
    scanf ("%d %d", &a, &b);
    result = elev (a, b);
    printf ("O resultado de %d elevado a %d seria: %d", a, b, result);
}

int elev (int a, int b){

    int aux = 1, aux2;
    for (b; 0<b; b--){
    aux = aux * a;
}
        return aux;
}
