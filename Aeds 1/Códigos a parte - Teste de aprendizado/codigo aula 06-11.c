#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct product{

    int id;
    char nome[50];
    float preco;
    int quantidade;

}product;

typedef struct product product;

product CadastroProduto (void){

    product prod;
    puts("Digite o id: ");
    scanf ("%d", &prod.id);
    fflush(stdin);
    puts("\nDigite o nome: ");
    fgets(prod.nome, 50, stdin);
    fflush(stdin);
    puts("\nDigite o preco: ");
    scanf ("%f", &prod.preco);
    fflush(stdin);
    puts("\nDigite a quantidade: ");
    scanf ("%d", &prod.quantidade);
    fflush(stdin);
    system ("cls");
    return prod;
}

void imprimiProduto (product prod){

    puts ("-------------- Produto cadastrado --------------\n");
    printf ("O id seria: %d\n", prod.id);
    printf ("O nome seria: %s", prod.nome);
    printf ("O preco seria: %.2f\n", prod.preco);
    printf ("A quantidade seria: %d\n\n", prod.quantidade);

}


int main (void){

    int quant;
    product prod;
    prod = CadastroProduto();
    imprimiProduto (prod);
    sleep (3);
    system("cls");
    puts ("Digite a quantidade desejada de produtos:");
    scanf ("%d", &quant);
    fflush (stdin);
    system ("cls");

    product products [quant];
    for (int i = 0; i < quant; i++)
        products [i] = CadastroProduto ();

    for (int i = 0; i < quant; i++){
        imprimiProduto (products[i]);
    }
}
