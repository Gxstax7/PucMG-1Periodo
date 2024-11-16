#include <stdio.h>
#include <stdlib.h>

typedef struct pessoa{

    float salario;
    int idade;

}pessoa;

float salario(pessoa* pes){

    float aux = 0;
    int ind;
    for (int i = 0; i < 3; i++){
        if (pes[i].salario > aux){
            aux = pes[i].salario;
            ind = i;
        }
    }

    return pes[ind].salario;

}

int main (){

    pessoa pes[3];
    for (int i = 0; i < 3; i++){
        printf ("Digite a idade: ");
        scanf ("%d", &pes[i].idade);
        printf ("Digite o salario: ");
        scanf ("%f", &pes[i].salario);
    }

    float maiorSalario;
    maiorSalario = salario(pes);

    printf ("\n\n O maior salario e: %.2f", maiorSalario);
}
