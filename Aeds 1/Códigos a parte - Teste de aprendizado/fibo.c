//receber k e n e calcular k^n
#include <stdio.h>

int fibo (int);

int main (void){
    int a, result;
    printf ("Digite qual termo da sequencia de fibonacci deseja saber:");
    scanf ("%d", &a);
    result = fibo (a);
    printf ("O %d termo seria: %d", a, result);
}

int fibo (int a){

    if (a == 0 || a == 1){
        return a;
    }else{
        return (fibo(a - 1 ) + fibo(a - 2));
    }
}
