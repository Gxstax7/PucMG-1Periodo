#include <stdio.h>

void swap (int n){

    if (n % 10 <= 1){
    printf ("%d", n);
    }else{
    printf ("%d", n%10);
    return swap (n/10);
    }
}

int main (){

    int n;
    scanf ("%d", &n);
    swap (n);
}
