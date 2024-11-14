#include <stdio.h>
#include <stdlib.h>

typedef struct carros {

    int ano;
    char modelo[20];
    char tipo[20];
    float motor;
    char cor[20];

}carros;

typedef struct carros carros;

carros cadastraCarro (void);
int menu (void);

int main (){

    int n, opc;
    puts ("Digite a quantidade desejada de carros: ");
    scanf ("%d", &n);
    carros carro[n];
    system ("cls");

    for (int i = 0; i < n; i++)
        carro[i] = cadastraCarro();

    opc = menu();

     while (opc == 3 || opc == 4){
        system ("cls");
        printf ("Desculpe, essa opcao nao esta disponivel");
        sleep (3);
        system ("cls");
        opc = menu ();
     }

    if (opc == 1){
        //listarcarros (carro);
    }


    if (opc == 2){
        //buscaModelo (carro);
    }

}

int menu (void){

    int opc;
    puts("Digite a opcao desejada\n");
    puts ("(1) - Listar todos os carros\n");
    puts ("(2) - Buscar por modelo\n");
    puts ("(3) - Buscar por ano (Indisponivel)\n");
    puts ("(4) - Buscar por cor (Indisponivel)\n");
    scanf ("%d", &opc);

    return opc;

}

carros cadastraCarro(void){

    carros carro;
    fflush (stdin);
    puts ("Digite o modelo do carro: ");
    fgets (carro.modelo, 20, stdin);
    fflush (stdin);
    puts ("Digite o ano do carro");
    scanf ("%d", &carro.ano);
    fflush (stdin);
    puts ("Digite o tipo de direcao do carro: ");
    fgets (carro.tipo, 20, stdin);
    fflush (stdin);
    puts ("Digite a potencia do motor: ");
    scanf ("%f", &carro.motor);
    fflush (stdin);
    system ("cls");
    printf ("------------------Carro Cadastrado------------------");
    sleep (1);
    system ("cls");
    return carro;
}
