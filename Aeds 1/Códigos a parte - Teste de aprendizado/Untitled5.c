#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

comparaRepeticao (int* vetor, int valor, int size){

    for (int i = 0; i < size; i++){
            printf ("O valor e %d e ta sendo comparado com %d\n", valor, vetor[i]);
        if (valor == vetor[i]){
            return true;
        }
    }
    return true;
}

int main (){

    int n, count = 0;
    scanf ("%d", &n);

    int *vetor = (int*) malloc (n * sizeof(int));

    for (int i = 0; i < n; i++)
        scanf ("%d", &vetor[i]);

    for (int i = 0; i < n; i++){
        if (comparaRepeticao (vetor, vetor[i], n) == true){

        }else {
            count++;
        }
    }
    printf ("Tem %d numeros diferentes", count);
}
