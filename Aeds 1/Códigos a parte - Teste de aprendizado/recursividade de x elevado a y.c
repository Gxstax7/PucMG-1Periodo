//receber k e n e calcular k^n
#include <stdio.h>

int soma (int);
int fat (int);

int main (void){
    int a, result1, result2; float total;
    scanf ("%d", &a);
    result1 = soma (a);
    result2 = fat (a);
    printf ("soma = %d, fat = %d", result1, result2);
    total = result2/result1;
    printf ("O resultado seria: %f", total);
}

int soma (int a){

    if (a == 0){
        return 0;
    }else{
        return a + soma (a-1);
    }
}

int fat (int a){

    if (a == 0){
        return 1;
    }else{
        return a * fat (a-1);
    }
}
