#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int alunos, monitores;
    scanf ("%d %d", &alunos, &monitores);
    if (alunos + monitores <= 50){
        printf ("S");
    }else{
        printf ("N");
    }
}