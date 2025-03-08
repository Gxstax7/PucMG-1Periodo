#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

    bool isPalindromo(char * frase, int i, int j){
		if (j < i){
			return true;
		}else{
			if (frase[i] == frase[j]){
				return isPalindromo (frase, i+1, j-1);
			}else{
				return false;
			}
		}
	}

	int main (void){
		char frase[1000];
		fgets(frase, 1000, stdin);
		frase[strcspn(frase, "\n")] = '\0';
    	while(strcmp (frase, "FIM") != 0){
    	    printf (isPalindromo(frase, 0, strlen(frase) - 1) ? "SIM" : "NAO");
    	    printf ("\n");
    	    fgets(frase, 1000, stdin);
    	    frase[strcspn(frase, "\n")] = '\0';
    	}
	}