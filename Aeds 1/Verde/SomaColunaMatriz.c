#include <stdio.h>
#include <stdlib.h>

int ** preencheMatriz (int linha, int coluna){

    int ** matriz;
    matriz = (int *) malloc (linha * sizeof (int*));

    for (int i = 0; i < linha; i++)
        matriz [i] = (int *) malloc (coluna * sizeof (int));

    for (int i = 0; i < linha; i++){
        for (int j = 0; j < coluna; j++)
            scanf ("%d", &matriz[i][j]);
    }

    return matriz;

}

int calculaColuna (int** matriz, int linha, int coluna){

    int soma = 0;
    for (int i = 0; i < linha; i++){
        soma = soma + matriz[i][coluna];
    }
    return soma;
}

int main (){

    int linha, coluna;
    int ** matriz;
    scanf ("%d %d", &linha, &coluna);
    matriz = preencheMatriz (linha, coluna);

    int * vetorResultante = (int) malloc (coluna * sizeof (int));

    for (int i = 0; i < coluna; i++){
        vetorResultante[i] = calculaColuna(matriz, linha, i);
    }

    for (int i = 0; i < coluna; i++){
        printf ("%d ", vetorResultante[i]);
    }
}
