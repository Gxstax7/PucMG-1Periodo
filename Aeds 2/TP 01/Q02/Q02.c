#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
   
  bool isPalindromo (char * texto) {
      bool resp = true;
      for (int i = 0; i < strlen(texto) / 2; i++) {
          if (texto[i] != texto[(strlen(texto) - i - 1)]) {
              resp = false;
              break;
          }
      }
      return resp;
  }
    
  
    int main() {
      char texto[1000];
      fgets(texto, 1000, stdin);
      texto[strcspn(texto, "\n")] = '\0';
      while(strcmp (texto, "FIM") != 0){
      if (isPalindromo(texto)){
        printf("SIM\n");
      }else{
        printf("NAO\n");
      }
      fgets(texto, 1000, stdin);
      texto[strcspn(texto, "\n")] = '\0';
      }
      return 0;
  }
 