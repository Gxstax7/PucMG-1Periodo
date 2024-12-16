#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "MyHeader.h"

int main()
{
    int size;
    printf ("Qual o tamanho do vetor?\n");
    scanf ("%d", &size);
    printf ("\n\n");

    int vetor [size];
    preencheVetor (vetor, size);
    imprimirVetor (vetor, size);

    int resultado = somaVetor (vetor, size);
    int menorEleme = menorElemento(vetor, size);

    printf ("\nA soma seria %d", resultado);
    printf ("\nO menor elemento seria %d", menorEleme);
    printf ("\n");

    printf ("-----------------------------------------------------------------------");

    printf ("\n\nTeste de string \n\n");

    fflush(stdin);
    char caracter, string[50];
    printf ("Digite a frase: ");
    fgets (string, sizeof(string), stdin);
    printf ("Digite o caracter que sera verificado a recorrencia: ");
    scanf (" %c", &caracter);
    return 0;
}
