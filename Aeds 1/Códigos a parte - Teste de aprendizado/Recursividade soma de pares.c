#include <stdio.h>

int soma (int);

int main (void){

    int numero, resultado;
    scanf ("%d", &numero);
    resultado = soma (numero);
    printf ("A soma dos pares e: %d", resultado);
}

int soma (int a){
    if (a % 2 != 0){
        a = a-1;
    }
    if (a == 0){
        return 0;
    }else{
        return a + soma (a - 2);
    }
}
