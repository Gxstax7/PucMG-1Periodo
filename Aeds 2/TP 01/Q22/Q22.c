#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//metodo recursivo onde sempre recebe a divisão por 10 até o numero ser < 10
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
    scanf ("%s", numero); // le como string para receber o fim
    while(strcmp(numero, "FIM") != 0){
        numeroConvertido = atoi(numero); // converte para inteiro para somar os digits
        printf("%d\n", somaDigito(numeroConvertido));
        scanf ("%s", numero);
    }
    return 0;
}
