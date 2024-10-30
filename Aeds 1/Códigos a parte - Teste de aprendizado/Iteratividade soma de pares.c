#include <stdio.h>

int soma (int);

int main (void){

    int numero, resultado;
    scanf ("%d", &numero);
    resultado = soma (numero);
    printf ("A soma dos pares e: %d", resultado);
}

int soma (int a){
    int aux;
    if (a % 2 != 0){
        a = a-1;
    }
    for (a;a>=0;a = a-2){
    aux = aux + a;
    }
    return aux;
}
