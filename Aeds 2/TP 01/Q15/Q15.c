#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void abrirArquivo(int quant){

    FILE * arq = fopen ("saidas.txt", "w");
   
    for (int i = 0; i < quant; i++){
        double valor;
        scanf ("%lf", &valor);
        fwrite( &valor, sizeof(valor), 1, arq);
    }
    
    fclose (arq);
}

void exibirValores(int quant){
    
    double valor = 0.0;
    FILE* arq = fopen("saidas.txt", "r" );

    fseek(arq, 0, SEEK_END );
    double tam = ftell(arq);
    for ( int i = 0; i < quant; i++){
        fseek(arq, tam - (i + 1) * sizeof(valor), SEEK_SET);
        fread( &valor, sizeof(valor), 1, arq);
        printf ("%g\n", valor);
    }

}

int main()
{
    int quant;
    scanf ("%d", &quant);
    abrirArquivo(quant);
    exibirValores(quant);

    return 0;
}