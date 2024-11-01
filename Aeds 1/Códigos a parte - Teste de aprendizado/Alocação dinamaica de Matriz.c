#include <stdio.h>
#include <stdlib.h>

int ** preencheMatriz (int linhas, int colunas){
    int ** matriz;
    matriz = (int*) malloc (linhas * sizeof (int*));
    for (int i = 0; i < linhas; i++)
        matriz[i] = (int*) malloc (colunas * sizeof(int));

    for (int i = 0; i < linhas; i++){
        for (int j = 0; j < colunas; j++){
            printf ("Digite o conteudo da posicao Linha[%d] Coluna [%d]: ", i+1, j+1);
            scanf ("%d", &matriz[i][j]);
    }
    }

    return matriz;
}

int main (){

    int linhas, colunas;
    printf ("Digite o numero de linhas e de colunas:\n");
    scanf ("%d %d", &linhas, &colunas);
    int ** matriz;

    printf ("\n");
    matriz = preencheMatriz (linhas, colunas);


    for (int i = 0; i < linhas; i++){
        for (int j = 0; j < colunas; j++)
            printf ("%d  ", matriz[i][j]);

        printf ("\n");
    }
}
