// ---------------------------------------------------------------------------------------------------- //
//Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <string.h>
#include <stdbool.h>
#include<time.h>

int logComp = 0;
int logMov = 0;

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
//Prototipos das fun��es
SHOW * ler(int*);
SHOW separa(char*);
char** splitArrays(char*);
char** ordenaArrays(char**);
Date converteDATA(char*);
void imprimirShow(SHOW);
SHOW clone (SHOW*, char*);
void liberarShow(SHOW);
void shellSort (SHOW*, int);
void inserirShell (SHOW*, int);
void swap (SHOW*,int,int);
bool pesquisaBinaria (SHOW*, char*, int, int);
void createLog(double);
int verificaMov(SHOW, SHOW);

// ---------------------------------------------------------------------------------------------------- //
// ---------------------------------------------------------------------------------------------------- //
//Main
int main(){

    int numShow = 0; //Variavel criada para futuro desalocamento de memoria
    SHOW * show = ler(&numShow);
    SHOW * clonado = NULL;

    char idDesejado[10];

    fgets(idDesejado, 10, stdin);
    idDesejado[strcspn(idDesejado, "\n")] = '\0';
    int tam = 0;

    while(strcmp(idDesejado, "FIM") != 0){


        clonado = realloc(clonado, (tam + 1) * sizeof(SHOW));

        clonado [tam] = clone(show, idDesejado);

        fgets(idDesejado, 10, stdin);
        idDesejado[strcspn(idDesejado, "\n")] = '\0';
        tam++;
    }

    clock_t inicioTempo = clock();
    shellSort(clonado, tam);
    clock_t fimTempo = clock();

    double duracao = ((double)(fimTempo-inicioTempo))/CLOCKS_PER_SEC;

    for(int i = 0; i < tam; i++){
        imprimirShow(clonado[i]);
        printf("\n");
    }

    //Desalocamento de memoria
    for (int i = 0; i < numShow; i++) {
        liberarShow(show[i]);
    }

    for (int i = 0; i < tam; i++) {
        liberarShow(clonado[i]);
    }

    free(clonado);
    free(show);

    createLog(duracao);

    return 0;
}



//+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+Fun��es +-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+


// ---------------------------------------------------------------------------------------------------- //
//Fun��o para realizar a leitura do arquivo
SHOW * ler(int *quantidade){

    SHOW * show;
    FILE *arq = fopen("/tmp/disneyplus.csv", "rb");
    char texto[4000];
    int aux = 0, tam = 0;

    //Verifia se o arquivo foi aberto com sucesso
    if(arq == NULL){
        printf("Erro na leitura!!\n");
        exit(1);
    }else{
        while(fgets(texto,sizeof(texto), arq) != NULL){
            //Ignora a primeira linha (nome das categorias)
            if(aux >= 1){
                show = realloc(show, (tam + 1) * sizeof(SHOW));
                show[tam] = separa(texto);
                tam++;
            }else{
                show = NULL;
            }

            aux++;
        }
    }

    *quantidade = aux - 1;
    fclose(arq);

    return show;

}

// ---------------------------------------------------------------------------------------------------- //
//Fun��o para separar a linha
SHOW separa(char *linha) {
    SHOW show;
    int i = 0;
    char separa[11][1000];
    int indexSepara = 0;

    while (i < strlen(linha) && indexSepara < 11) {

        //Tratamento de campos com "
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

            //Atribui NaN para campo vazio
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

    //Atribui��o para os campos da struct
    strncpy(show.SHOW_ID, separa[0], sizeof(show.SHOW_ID) - 1);
    strncpy(show.TYPE, separa[1], sizeof(show.TYPE) - 1);
    strncpy(show.TITLE, separa[2], sizeof(show.TITLE) - 1);
    strncpy(show.DIRECTOR, separa[3], sizeof(show.DIRECTOR) - 1);
    show.CAST = splitArrays(separa[4]);
    strncpy(show.COUNTRY, separa[5], sizeof(show.COUNTRY) - 1);
    show.DATA = converteDATA(separa[6]);
    show.RELEASE_YEAR = atoi(separa[7]);
    strncpy(show.RATING, separa[8], sizeof(show.RATING) - 1);
    strncpy(show.DURATION, separa[9], sizeof(show.DURATION) - 1);
    show.LISTED_IN = splitArrays(separa[10]);

    return show;

}

// ---------------------------------------------------------------------------------------------------- //
//Fun��o para realizar a separa��o dos campos com arrays de string

char ** splitArrays(char* linha){

    char **separado = NULL;
    int i = 0, count = 0, tam = 0;

    //Retorna apenas NaN caso n�o tenha atributos
    if(strcmp(linha,"NaN") == 0){
        separado = (char**) malloc (2 * sizeof(char*));
        separado[0] = malloc (4*sizeof(char));
        strcpy(separado[0], "NaN");
        separado[1] = NULL;
        return separado;
    }

    //Separa a cada virgula  os atributos
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

    //Coloca Null no final para controle de exibi��o
    separado = realloc(separado, (tam + 1) * sizeof(char*));
    separado[tam] = NULL;
    separado = ordenaArrays(separado);

    return separado;

}

// ---------------------------------------------------------------------------------------------------- //
//Fun��o para realizar a ordena��o do array de string

char** ordenaArrays(char** array) {
    int tam = 0;
    while (array[tam] != NULL) {
        tam++;
    }

    // Aloca array de ponteiros
    char** ordenado = (char**)malloc((tam + 1) * sizeof(char*));

    // Copia o array para o novo que sera retornado
    for (int i = 0; i < tam; i++) {
        ordenado[i] = (char*)malloc(strlen(array[i]) + 1);
        strcpy(ordenado[i], array[i]);
    }
    ordenado[tam] = NULL;

    // Ordena o array copiado
    for (int i = 0; i < tam - 1; i++) {
        for (int j = i + 1; j < tam; j++) {
            if (strcmp(ordenado[i], ordenado[j]) > 0) {
                char* temp = ordenado[i];
                ordenado[i] = ordenado[j];
                ordenado[j] = temp;
            }
        }
    }

    return ordenado;
}

// ---------------------------------------------------------------------------------------------------- //
//Preencher a DATA do show de acordo com os padr�es da struct

Date converteDATA(char* DATAPadrao){

    Date DATAConvertida;
    int i = 0;

    //Caso receba NaN (campo vazio), retorna a DATA como March 1, 1900
    if(strcmp(DATAPadrao,"NaN") == 0){
        DATAConvertida.ano = 1900;
        DATAConvertida.dia = 1;
        DATAConvertida.dia = 1;
        DATAConvertida.mes = malloc(6 * sizeof(char));
        strcpy(DATAConvertida.mes, "March");
        return DATAConvertida;
    }

    while(i < strlen(DATAPadrao)){
            int j = 0;

            //Atribui o mes, lendo at� o espa�o, de acordo com o padr�o do arquivo
            char aux[100] = "";
            while(i < strlen(DATAPadrao) && DATAPadrao[i] != ' '){
                aux[j] = DATAPadrao[i];
                i++;
                j++;
            }
            DATAConvertida.mes = malloc((strlen(aux) + 1) * sizeof(char));
            strcpy(DATAConvertida.mes,aux);
            i++;
            j = 0;


            //Atribui o dia, lendo at� a virgula, de acordo com o padr�o do arquivo
            char auxDia[4] = {0};
            while(i < strlen(DATAPadrao) && DATAPadrao[i] != ','){
                auxDia[j] = DATAPadrao[i];
                i++;
                j++;
            }
            i++;
            j = 0;

            // Converte para inteiro
            DATAConvertida.dia = atoi(auxDia);


            //Atribui o ano
            char auxAno[5] = {0};
            while(i < strlen(DATAPadrao)){
                auxAno[j] = DATAPadrao[i];
                i++;
                j++;
            }
            auxAno[j] = '\0';

            // Converte para inteiro
            DATAConvertida.ano = atoi(auxAno);
            }

    return DATAConvertida;

}

// ---------------------------------------------------------------------------------------------------- //
//Fun��o para imprimir o show

void imprimirShow(SHOW show){

    printf("=> %s ## %s ## %s ## %s ## [",
           show.SHOW_ID,
           show.TITLE,
           show.TYPE,
           show.DIRECTOR);

    //Imprimi o elenco
    for(int i = 0; show.CAST[i] != NULL; i++){
        //Verifica se � o ultimo para n�o adicionar ,
        if(show.CAST[i+1] == NULL){
            printf("%s", show.CAST[i]);
        }else{
            printf("%s, ", show.CAST[i]);
        }
    }

    printf("] ## %s ## %s %d, %d ## %d ## %s ## %s ## [",
           show.COUNTRY,
           show.DATA.mes, show.DATA.dia, show.DATA.ano,
           show.RELEASE_YEAR,
           show.RATING,
           show.DURATION);

    //Imprimi o listed_in
    for(int i = 0; show.LISTED_IN[i] != NULL; i++){
        //Verifica se � o ultimo para n�o adicionar ,
        if(show.LISTED_IN[i+1] == NULL){
            printf("%s", show.LISTED_IN[i]);
        }else{
            printf("%s, ", show.LISTED_IN[i]);
        }
    }

    printf("] ##");
}

// ---------------------------------------------------------------------------------------------------- //
//Fun��o para retornar um clone do objeto

SHOW clone(SHOW * show, char* idChar){

    SHOW clonado;
    int id, i = 1, j = 0;
    char aux[10]= "";

    //Transforma o id em int para acesso ao index do show
    while(i < strlen(idChar)){
        aux[j] = idChar[i];
        j++;
        i++;
    }
    id = atoi(aux) - 1;

    //Clona os campos simples
    clonado.DATA.dia = show[id].DATA.dia;
    clonado.DATA.ano = show[id].DATA.ano;
    clonado.DATA.mes = (char*)malloc(strlen(show[id].DATA.mes) + 1);
    strcpy(clonado.DATA.mes, show[id].DATA.mes);
    strcpy(clonado.COUNTRY, show[id].COUNTRY);
    strcpy(clonado.DIRECTOR, show[id].DIRECTOR);
    strcpy(clonado.DURATION, show[id].DURATION);
    strcpy(clonado.RATING, show[id].RATING);
    clonado.RELEASE_YEAR = show[id].RELEASE_YEAR;
    strcpy(clonado.SHOW_ID, show[id].SHOW_ID);
    strcpy(clonado.TITLE, show[id].TITLE);
    strcpy(clonado.TYPE, show[id].TYPE);


    //Clona o cast
    int castTam = 0;
    while (show[id].CAST[castTam] != NULL){
        castTam++;
    }
    clonado.CAST = (char**)malloc((castTam + 1) * sizeof(char*));

    for (int i = 0; i < castTam; i++) {
        clonado.CAST[i] = (char*)malloc(strlen(show[id].CAST[i]) + 1);
        strcpy(clonado.CAST[i], show[id].CAST[i]);
    }
    clonado.CAST[castTam] = NULL;


    //Clona o LISTED_IN
    int listedInTam = 0;
    while (show[id].LISTED_IN[listedInTam] != NULL){
        listedInTam++;
    }
    clonado.LISTED_IN = (char**)malloc((listedInTam + 1) * sizeof(char*));

    for (int i = 0; i < listedInTam; i++) {
        clonado.LISTED_IN[i] = (char*)malloc(strlen(show[id].LISTED_IN[i]) + 1);
        strcpy(clonado.LISTED_IN[i], show[id].LISTED_IN[i]);
    }
    clonado.LISTED_IN[listedInTam] = NULL;

    return clonado;

}

void liberarShow(SHOW show) {
    // Libera o CAST
    for (int i = 0; show.CAST[i] != NULL; i++) {
        free(show.CAST[i]);
    }
    free(show.CAST);

    // Libera o LISTED_IN
    for (int i = 0; show.LISTED_IN[i] != NULL; i++) {
        free(show.LISTED_IN[i]);
    }
    free(show.LISTED_IN);

    // Libera o m�s (Date.mes)
    free(show.DATA.mes);
}

void swap (SHOW * show, int i, int menor){

    SHOW temp = show[i];
    show[i] = show [menor];
    show[menor] = temp;

    logMov += 3;

}

void shellSort(SHOW * show, int n){

    int gap = 1;

    while(gap < n) gap = (gap * 3) + 1;

    while (gap > 0) {

        gap /= 3;
        for(int i = 0; i < gap; i++){
            for(int j = i + gap; j < n; j += gap){
                SHOW tmp = show[j];
                int k = j - gap;

                while(k >= 0 && verificaMov(show[k], tmp) > 0){
                    show[k + gap] = show [k];
                    k -= gap;
                    logMov++;
                }
                show[k + gap] = tmp;
                logMov++;
            }
        }

    }

}

int verificaMov(SHOW show1, SHOW tmp){

    int comp = strcasecmp(show1.TYPE, tmp.TYPE);
    int compTitle = strcasecmp(show1.TITLE, tmp.TITLE);

    if(comp != 0){
        return comp;
    }else if (comp == 0){
        return compTitle;
    }

}


void createLog(double tempo){

    FILE* arq = fopen("866018_shellsort.txt", "w");

    if(arq == NULL){
        printf("Falha na cria��o do log!!");
    }else{
        fprintf (arq, "Matricula: 866018\tTempo: %lf\tCompara��es: %d\tMovimenta��es: %d", tempo, logComp, logMov);
    }

}
