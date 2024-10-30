#include <stdio.h>
#include <stdbool.h>

int compara (int* x, int n){
  if (*x == n){
    return true;
  }else {
  return false;
  }

}


int main() {

  int x = 10;
  int n;

  int *px = &x;
  int *pn = &n;

  scanf ("%d", &n);

  if (compara (px, n)){
    printf ("Verdade");
  }else{
  printf ("Falso");
  }


  return 0;
}
