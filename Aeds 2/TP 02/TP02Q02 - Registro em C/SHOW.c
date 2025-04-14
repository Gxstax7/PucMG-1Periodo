// ---------------------------------------------------------------------------------------------------- //
//Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <string.h>

// ---------------------------------------------------------------------------------------------------- //
//Structs para SHOW e Date

typedef struct Date{

    int dia;
    int ano;
    char * mes;

} Date;

typedef struct SHOW{

    char SHOW_ID [10], TITLE [100], TYPE[100], DIRECTOR[1000], COUNTRY[100], RATING[1000], DURATION[100];
    char ** CAST;
    char ** LISTED_IN;
    int RELEASE_YEAR;
    Date DATA;

} SHOW;

// ---------------------------------------------------------------------------------------------------- //
//Prototipos das funções
Date converteData(char*);
char** splitArrays(char*);
SHOW separa(char*);
SHOW * ler();
void imprimirShow(SHOW);
SHOW clone (SHOW*, char*);


// ---------------------------------------------------------------------------------------------------- //
// ---------------------------------------------------------------------------------------------------- //
//Main
int main(){

    SHOW * show = ler();
    char idDesejado[10];
    fgets(idDesejado, 10, stdin);
    idDesejado[strcspn(idDesejado, "\n")] = '\0';

    while(strcmp(idDesejado, "FIM") != 0){
        clone(show, idDesejado);
        fgets(idDesejado, 10, stdin);
        idDesejado[strcspn(idDesejado, "\n")] = '\0';
    }

    return 0;
}



//+-+-+--+-+-+-+ Funções +-+-+--+-+-+-+


//+-+-+--+-+-+-+ Função para ordenar um array de Strings +-+-+--+-+-+-+
SHOW * ler(){

    SHOW * show;
    FILE *arq = fopen("disneyplus.csv", "rb");
    char texto[2000];
    int aux = 0, tam = 0;

    while(fgets(texto,sizeof(texto), arq) != NULL){
        if(aux >= 1){
            show = realloc(show, (tam + 1) * sizeof(SHOW));
            printf("%s", texto);
            show[tam] = separa(texto);
            tam++;
        }else{
            show = NULL;
        }

        aux++;
    }

    return show;

}

// ---------------------------------------------------------------------------------------------------- //
//Função para realizar a separação dos campos com arrays de string

char ** splitArrays(char* linha){

    char **separado = NULL;
    int i = 0, count = 0, tam = 0;

    //Retorna apenas NaN caso não tenha atributos
    if(strcmp(linha,"NaN") == 0){
        separado = (char**) malloc (1 * sizeof(char*));
        separado[0] = malloc (4*sizeof(char));
        strcpy(separado[0], "NaN");
        return separado;
    }

    //Separa a cada virgula os atributos
    while(i < strlen(linha)){
            separado = realloc(separado, (tam + 1) * sizeof(char*));
            int j = 0;
            char aux[100] = "";

            while(i < strlen(linha) && linha[i] != ','){
                aux[j] = linha[i];
                i++;
                j++;
            }

            if(linha[i] == ',')
                i+=2;

            separado[tam] = (char*) malloc ((strlen(aux) + 1) * sizeof(char));
            strcpy(separado[tam], aux);
            tam++;
    }

    //Coloca Null no final para controle de exibição
    separado = realloc(separado, (tam + 1) * sizeof(char*));
    separado[tam] = NULL;

    return separado;

}

// ---------------------------------------------------------------------------------------------------- //
//Função para separar a linha
SHOW separa(char *linha) {
    SHOW show;
    int i = 0;
    char separa[11][100];
    int indexSepara = 0;

    while (i < strlen(linha) && indexSepara < 11) {

        if (linha[i] == '"') {
            i++;
            int j = 0;
            char aux[1000];

            while (i + 1 < strlen(linha)) {
                char prox[3];

                prox[0] = linha[i];
                prox[1] = linha[i + 1];
                prox[2] = '\0';

                if(prox[0] == '"'){
                        if(prox[1] == ','){
                            i++;
                            break;
                        }
                }

                aux[j] = linha[i];
                j++;
                i++;
            }

            aux[j] = '\0';
            strcpy(separa[indexSepara], aux);
            indexSepara++;

        }else{

            if(i < strlen(linha) && linha[i] == ','){
                if(i + 1 < strlen(linha) && linha[i+1] == ','){
                    strcpy(separa[indexSepara], "NaN");
                    indexSepara++;
                }
                i++;
            }else{
                char aux[1000];
                int j = 0;

                while(linha[i] != ','){
                    aux[j] = linha[i];
                    i++;
                    j++;
                }

                aux[j] = '\0';
                strcpy(separa[indexSepara], aux);
                indexSepara++;
            }

        }

    }

    for (int index = 0; index < indexSepara; index++){
        printf("\n%s", separa[index]);
    }


    //Atribuição para os campos da struct
    strncpy(show.SHOW_ID, separa[0], sizeof(show.SHOW_ID) - 1);
    strncpy(show.TYPE, separa[1], sizeof(show.TYPE) - 1);
    strncpy(show.TITLE, separa[2], sizeof(show.TITLE) - 1);
    strncpy(show.DIRECTOR, separa[3], sizeof(show.DIRECTOR) - 1);
    show.CAST = splitArrays(separa[4]);
    strncpy(show.COUNTRY, separa[5], sizeof(show.COUNTRY) - 1);
    show.DATA = converteData(separa[6]);
    show.RELEASE_YEAR = atoi(separa[7]);
    strncpy(show.RATING, separa[8], sizeof(show.RATING) - 1);
    strncpy(show.DURATION, separa[9], sizeof(show.DURATION) - 1);
    show.LISTED_IN = splitArrays(separa[10]);

    return show;

}

Date converteData(char* dataPadrao){

    Date dataConvertida;
    int i = 0;

    if(strcmp(dataPadrao,"NaN") == 0){
        dataConvertida.ano = 1900;
        dataConvertida.dia = 1;
        dataConvertida.mes = "March";
        return dataConvertida;
    }

    while(i < strlen(dataPadrao)){
            int j = 0;

            char aux[100] = "";
            while(i < strlen(dataPadrao) && dataPadrao[i] != ' '){
                aux[j] = dataPadrao[i];
                i++;
                j++;
            }
            dataConvertida.mes = malloc((strlen(aux) + 1) * sizeof(char));
            strcpy(dataConvertida.mes,aux);
            i++;
            j = 0;


            char auxDia[3];
            while(i < strlen(dataPadrao) && dataPadrao[i] != ','){
                auxDia[j] = dataPadrao[i];
                i++;
                j++;
            }
            i++;
            dataConvertida.dia = atoi(auxDia);
            j = 0;


            char auxAno[5];
            while(i < strlen(dataPadrao)){
                auxAno[j] = dataPadrao[i];
                i++;
                j++;
            }
            auxAno[j] = '\0';
            dataConvertida.ano = atoi(auxAno);
            }

    return dataConvertida;

}

void imprimirShow(SHOW show){



}

SHOW clone(SHOW * show, char* idChar){

    SHOW clonado;
    int id, i = 1, j = 0;
    char aux[10]= "";

    while(i < strlen(idChar)){
        aux[j] = idChar[i];
        j++;
        i++;
    }
    id = atoi(aux) - 1;
    printf("\n\nShow clonado: %d\n", id);

    strcpy(clonado.COUNTRY, show[id].COUNTRY);
    clonado.DATA = show[id].DATA;
    strcpy(clonado.DIRECTOR, show[id].DIRECTOR);
    strcpy(clonado.DURATION, show[id].DURATION);
    strcpy(clonado.RATING, show[id].RATING);
    clonado.RELEASE_YEAR = show[id].RELEASE_YEAR;
    strcpy(clonado.SHOW_ID, show[id].SHOW_ID);
    strcpy(clonado.TITLE, show[id].TITLE);
    strcpy(clonado.TYPE, show[id].TYPE);

    //strcpy(clonado.LISTED_IN, show[id].LISTED_IN);
    //strcpy(clonado.CAST, show[id].CAST);

    return clonado;

}
