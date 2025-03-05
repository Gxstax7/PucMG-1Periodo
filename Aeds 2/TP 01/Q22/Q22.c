/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int somaDigito (int numero){
    int soma = 0;
    if (numero <= 9){
        return numero;
    }else{
        return soma + numero % 10 + somaDigito(numero/10);
    }
    
}

int main()
{
    
    char numero[50];
    int numeroConvertido;
    scanf ("%s", numero);
    while(strcmp(numero, "FIM") != 0){
        numeroConvertido = atoi(numero);
        printf("%d\n", somaDigito(numeroConvertido));
        scanf ("%s", numero);
    }
    return 0;
}