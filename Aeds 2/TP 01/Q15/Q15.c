#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// metodo para abrir o arquivo e escrever os valores de forma binaria (fwrite) 
void abrirArquivo(int quant){

    FILE * arq = fopen ("saidas.txt", "w");
   
    for (int i = 0; i < quant; i++){
        double valor;
        scanf ("%lf", &valor);
        fwrite(&valor, sizeof(valor), 1, arq);
    }
    
    fclose (arq);
}

// metodo para exibir os valores ao contrario controlando o fseek a partir do final (SEEK_END) e lendo os valores de forma binaria (fread)
void exibirValores(int quant){
    
    double valor = 0.0;
    FILE* arq = fopen("saidas.txt", "r" );
    fseek(arq, 0, SEEK_END );
    double tam = ftell(arq);

    for ( int i = 0; i < quant; i++){
        fseek(arq, tam - (i + 1) * sizeof(valor), SEEK_SET);
        fread(&valor, sizeof(valor), 1, arq);
        printf ("%g\n", valor); // não é necessario controlar int pois %g ja reduz para menor quantidade de casas decimais possivel
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
