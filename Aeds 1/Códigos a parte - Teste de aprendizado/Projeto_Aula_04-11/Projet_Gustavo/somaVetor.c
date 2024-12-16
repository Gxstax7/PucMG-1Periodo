#include <stdio.h>
#include <stdlib.h>

int main (){

    int n;
    scanf ("%d", &n);

    int vet3[n];
    int* vet1;
    int* vet2;
    vet1 = (int*) malloc (n * sizeof (int));
    vet2 = (int*) malloc (n * sizeof (int));

    for (int i = 0; i < n; i++){
        scanf ("%d", &vet1[i]);
    }

    for (int i = 0; i < n; i++){
        scanf ("%d", &vet2[i]);
    }

    for (int i = 0; i < n; i++){
        vet3[i] = vet1[i] + vet2[i];
    }

    for (int i = 0; i < n; i++){
        printf ("%d ", vet3[i]);
    }
}
