#include <stdio.h>

int main()
{
    int N[20];
    for (int i = 0; i < 20; i++){
        scanf ("%d", &N[i]);
    }
    
    for (int i = 19, j = 0; i > 0, j < 20; i--, j++){
        printf ("N[%d] = %d\n", j, N[i]);
    }
    
    return 0;
}