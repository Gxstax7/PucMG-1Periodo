#include <stdio.h>
#include <math.h>

int main (){

    char j1, j2, j3, j4, j5, j6;
    int vit = 0, der = 0;

    scanf ("%c", &j1);
    if (j1 == 'V'){
    vit++;
    }else{
    der++;
    }

    scanf (" %c", &j2);
    if (j2 == 'V'){
    vit++;
    }else{
    der++;
    }

    scanf (" %c", &j3);
    if (j3 == 'V'){
    vit++;
    }else{
    der++;
    }

    scanf (" %c", &j4);
    if (j4 == 'V'){
    vit++;
    }else{
    der++;
    }

    scanf (" %c", &j5);
    if (j5 == 'V'){
    vit++;
    }else{
    der++;
    }

    scanf (" %c", &j6);
    if (j6 == 'V'){
    vit++;
    }else{
    der++;
    }

    if (vit == 5 || vit == 6){
        printf ("Grupo 1");
    }else if (vit == 3 || vit == 4){
        printf ("Grupo 2");
    }else if (vit == 1 || vit == 2){
        printf ("Grupo 3");
    }else if (vit == 0){
        printf ("-1");
    }
}
