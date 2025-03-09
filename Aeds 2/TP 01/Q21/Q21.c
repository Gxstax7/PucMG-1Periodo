#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* inverteString(char* frase, int i, char* fraseInvertida) {
    if (i == strlen(frase)) {
        fraseInvertida[strlen(frase)] = '\0';
        return fraseInvertida;
    } else {
        fraseInvertida[i] = frase[strlen(frase) - i - 1];
        return inverteString(frase, i + 1, fraseInvertida);
    }
}

int main()
{
    char fraseInvertida[100], frase[100];
    fgets(frase, 100, stdin);
    frase[strcspn(frase, "\n")] = '\0';
   while (strcmp(frase, "FIM") != 0){
        printf("%s\n", inverteString(frase, 0, fraseInvertida));
        fgets(frase, 100, stdin);
        frase[strcspn(frase, "\n")] = '\0';
    }
    return 0;
}