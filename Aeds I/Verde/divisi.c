#include <stdio.h>
#include <math.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "Portuguese");
    int a, b, c;
    scanf ("%d %d %d", &a, &b, &c);

    if (a % 3 == 0 && a % 5 == 0){
        printf ("Divisível por ambos\n");
    }else if (a % 3 == 0){
            printf ("Divisível por 3\n");
        }else if (a % 5 == 0){
                printf ("Divisível por 5\n");
            }else{
                    printf ("Não é divisível por 3 nem por 5\n");
        }

        if (b % 3 == 0 && b % 5 == 0){
        printf ("Divisível por ambos\n");
    }else if (b % 3 == 0){
            printf ("Divisível por 3\n");
        }else if (b % 5 == 0){
                printf ("Divisível por 5\n");
            }else{
                    printf ("Não é divisível por 3 nem por 5\n");
        }

            if (c % 3 == 0 && c % 5 == 0){
        printf ("Divisível por ambos\n");
    }else if (c % 3 == 0){
            printf ("Divisível por 3\n");
        }else if (c % 5 == 0){
                printf ("Divisível por 5\n");
            }else{
                    printf ("Não é divisível por 3 nem por 5\n");
        }
    return 0;
}
