#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void preencheValor (int*, int);
void preencheQuant (int* v, int* q, int n, int* soma);
int relatorio (int*v, int* q, int n, int* s);

int main (){

    int valor[3], quant[3], soma[3];

    for (int i=0;i<3;i++){
        preencheValor(valor, i);
        preencheQuant(quant, valor, i, soma);
    }

    for (int i =0; i<3; i++){
        printf ("\n");
        relatorio(valor, quant, i, soma);
    }

}

void preencheValor (int* v, int n){
    printf ("Qual o valor do %d produto: ", n+1);
    scanf ("%d", &v[n]);
}

void preencheQuant (int* v, int* q, int n, int* soma){
    printf ("Qual a quantidade vendida do %d produto: ", n+1);
    scanf ("%d", &v[n]);
    printf ("\n");
    soma [n] = v[n] * q[n];
}

int relatorio (int*v, int* q, int n, int* s){
    printf ("O valor unitario do produto %d seria %d\n", n+1, v[n]);
    printf ("A quantidade vendida do produto %d seria %d\n", n+1, q[n]);
    printf ("A soma de valores do produto %d seria %d\n", n+1, s[n]);
}
