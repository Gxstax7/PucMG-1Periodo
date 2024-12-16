#include <stdio.h>
#include <stdlib.h>

char * imprimi(char str[], char antigo, char novo){

    for (int i = 0; str[i] != '\0'; i++){
        if (str[i] == antigo){
            str[i] = novo;
        }
    }

    printf ("%s", str);
    return str;
}

int main (){

    char frase[] = "teste";
    char antigo = 'e';
    char novo = 'a';
    imprimi (frase, antigo, novo);

}
