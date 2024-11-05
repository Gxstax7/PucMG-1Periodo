#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

//Criação da struct
typedef struct pizza {
    char nome[50];
    float preco;
    char tamanho [15];
};

//Declaração para uso sem struct
typedef struct pizza pizza;

int main (void){
    setlocale (LC_ALL, "Portuguese");
    pizza p;

    //Recebe o nome, preço e tamanho
    puts ("Digite o nome da pizza: ");
    fgets (p.nome, 50, stdin);
    fflush (stdin);
    puts ("\nDigite o preço da pizza: ");
    scanf ("%f", &p.preco);
    fflush (stdin);
    puts ("\nDigite o tamanho da pizza: ");
    fgets (p.tamanho, 50, stdin);
    fflush (stdin);
    system("cls");

    printf ("--------------- Pizza informada ---------------\n");
    printf ("\tNome: %s", p.nome);
    printf ("\tPreço: %.2f\n", p.preco);
    printf ("\tTamanho: %s", p.tamanho);
}
