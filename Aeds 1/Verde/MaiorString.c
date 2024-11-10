#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main() {
    int tam, cont = 0;
    char frutas[20];

    // Lê a entrada do usuário
    fgets(frutas, sizeof(frutas), stdin);

    // Remove o caractere de nova linha, se presente
    frutas[strcspn(frutas, "\n")] = '\0';

    // Converte todos os caracteres para maiúsculas
    for (int i = 0; frutas[i] != '\0'; i++) {
        frutas[i] = toupper(frutas[i]);
    }

    // Conta as vogais na string
    for (int i = 0; frutas[i] != '\0'; i++) {
        if (frutas[i] == 'A' || frutas[i] == 'E' || frutas[i] == 'I' || frutas[i] == 'O' || frutas[i] == 'U') {
            cont++;
        }
    }

    // Exibe o número de vogais
    printf("A palavra tem %d vogais\n", cont);

    return 0;
}
