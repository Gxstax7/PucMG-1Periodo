#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int main (){

    int n;
    scanf ("%d", &n);
    int vet[n];
    srand (time(NULL));

    for (int i = 0; i < n; i++){
        vet[i] = rand () % 10000;
    }

    for (int i = 0; i < n; i++){
        printf ("%d ", vet[i]);
    }

}
