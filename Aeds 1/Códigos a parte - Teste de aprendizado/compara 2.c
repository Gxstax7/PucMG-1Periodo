#include <stdio.h>
#include <stdbool.h>

int compara (int* x, int j, int i){
  if (x[i] == x[j]){
    return true;
  }else {
    return false;
  }
}


int main() {

  int x[10] = {1,1,2,2,2,3,4,5,5,9};
  int n = 10;


  for (int i = 0; i < n; i++){
    for (int j = 0; j < 10; j++){
    if (compara (x,j,i)){
        printf ("O valor %d se encontra na posicao %d\n", x[i], j);
      }
    }
  }

  return 0;
}
