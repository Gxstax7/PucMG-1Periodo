#include <stdio.h>
#include <stdlib.h>

int main () {

    int ddd;
    scanf ("%d", &ddd);
    switch (ddd){
    case 11:
        printf ("Brasilia");
        break;
    case 21:
        printf ("Rio de Janeiro");
        break;
    case 31:
        printf ("Belo Horizonte");
        break;
    case 27:
        printf ("Vitoria");
        break;
    case 35:
        printf ("Lavras");
        break;
    case 71:
        printf ("Salvador");
        break;
    case 19:
        printf ("Campinas");
        break;
    default:
        printf ("DDD nao cadastrado");
        break;
    } //end switch case
} //end main
