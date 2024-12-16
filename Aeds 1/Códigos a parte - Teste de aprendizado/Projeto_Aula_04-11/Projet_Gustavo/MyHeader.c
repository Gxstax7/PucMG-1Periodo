#include <stdio.h>
#include <stdlib.h>

int soma (int a, int b){

    return a+b;

}

int multiplica (int a, int b){

    return a*b;

}

void preencheVetor (int* vetor, int size){
    for (int i = 0; i < size; i++)
    vetor [i] = rand () % 100+1;
}

int* preencheVetor2 (int size){
    int* vetor = (int *) malloc (size * sizeof (int));
    for (int i = 0; i < size; i++){
        *(vetor+i) = rand () % 100+1;
    }
    return vetor;

}

void imprimirVetor (int* vetor, int size){
    for (int i = 0; i < size; i++)
        printf ("%d\n", vetor[i]);
}

int somaVetor (int* vetor, int size){
    int soma = 0;
    for (int i = 0; i < size; i++)
        soma += vetor[i];
    return soma;
}

int menorElemento (int* vetor, int size){
    int aux = vetor[0];
    for (int i = 0; i < size; i++){
        if (aux >= vetor[i])
            aux = vetor[i];
    }
    return aux;
}

int recorrenciaString (char caracter){

}
