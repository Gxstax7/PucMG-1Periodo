#include <stdio.h>

int main()
{

    int n, cont = 0, soma = 0;
    scanf ("%d", &n);
    int vet[n];
    
    for (int i = 0; i< n; i++){
        scanf ("%d", &vet[i]);
        if (vet[i] < 0){
            cont ++;
        }else{
            soma += vet [i];
        }
    }
    
    printf ("%d %d", cont, soma);
    
    return 0;
}