// ---------------------------------------------------------------------------------------------------- //
//Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <string.h>
#include <stdbool.h>

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
SHOW * ler(int*);
SHOW separa(char*);
char** splitArrays(char*);
char** ordenaArrays(char**);
Date converteData(char*);
void imprimirShow(SHOW);
SHOW clone (SHOW*, char*);
void liberarShow(SHOW);
void ordenaShows(SHOW*, int);
void swap (SHOW*,int,int menor);
bool pesquisaBinaria (SHOW * show, char * titulo, int comeco, int fim);

// ---------------------------------------------------------------------------------------------------- //
// ---------------------------------------------------------------------------------------------------- //
//Main
int main(){

    int numShow = 0; //Variavel criada para futuro desalocamento de memoria
    SHOW * show = ler(&numShow);
    SHOW * clonado = NULL;

    char idDesejado[10];
    char tituloDesejado[1000];

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

    ordenaShows(clonado, tam);

    fgets(tituloDesejado, 1000, stdin);
    tituloDesejado[strcspn(tituloDesejado, "\n")] = '\0';

    while(strcmp(tituloDesejado, "FIM") != 0){

        printf(pesquisaBinaria(clonado, tituloDesejado, 0, tam) ? "SIM\n" : "NAO\n");
        fgets(tituloDesejado, 1000, stdin);
        tituloDesejado[strcspn(tituloDesejado, "\n")] = '\0';

    }

    //Desalocamento de memoria
    for (int i = 0; i < numShow; i++) {
        liberarShow(show[i]);
    }

    free(clonado);
    free(show);

    return 0;
}



//+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+Funções +-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+-+-+-+--+-+-+-+


// ---------------------------------------------------------------------------------------------------- //
//Função para realizar a leitura do arquivo
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
//Função para separar a linha
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

// ---------------------------------------------------------------------------------------------------- //
//Função para realizar a separação dos campos com arrays de string

char ** splitArrays(char* linha){

    char **separado = NULL;
    int i = 0, count = 0, tam = 0;

    //Retorna apenas NaN caso não tenha atributos
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

    //Coloca Null no final para controle de exibição
    separado = realloc(separado, (tam + 1) * sizeof(char*));
    separado[tam] = NULL;
    separado = ordenaArrays(separado);

    return separado;

}

// ---------------------------------------------------------------------------------------------------- //
//Função para realizar a ordenação do array de string

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
//Preencher a data do show de acordo com os padrões da struct

Date converteData(char* dataPadrao){

    Date dataConvertida;
    int i = 0;

    //Caso receba NaN (campo vazio), retorna a data como March 1, 1900
    if(strcmp(dataPadrao,"NaN") == 0){
        dataConvertida.ano = 1900;
        dataConvertida.dia = 1;
        dataConvertida.dia = 1;
        dataConvertida.mes = malloc(6 * sizeof(char));
        strcpy(dataConvertida.mes, "March");
        return dataConvertida;
    }

    while(i < strlen(dataPadrao)){
            int j = 0;

            //Atribui o mes, lendo até o espaço, de acordo com o padrão do arquivo
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


            //Atribui o dia, lendo até a virgula, de acordo com o padrão do arquivo
            char auxDia[3];
            while(i < strlen(dataPadrao) && dataPadrao[i] != ','){
                auxDia[j] = dataPadrao[i];
                i++;
                j++;
            }
            i++;
            j = 0;

            // Converte para inteiro
            dataConvertida.dia = atoi(auxDia);


            //Atribui o ano
            char auxAno[5];
            while(i < strlen(dataPadrao)){
                auxAno[j] = dataPadrao[i];
                i++;
                j++;
            }
            auxAno[j] = '\0';

            // Converte para inteiro
            dataConvertida.ano = atoi(auxAno);
            }

    return dataConvertida;

}

// ---------------------------------------------------------------------------------------------------- //
//Função para imprimir o show

void imprimirShow(SHOW show){

    printf("=> %s ## %s ## %s ## %s ## [",
           show.SHOW_ID,
           show.TITLE,
           show.TYPE,
           show.DIRECTOR);

    //Imprimi o elenco
    for(int i = 0; show.CAST[i] != NULL; i++){
        //Verifica se é o ultimo para não adicionar ,
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
        //Verifica se é o ultimo para não adicionar ,
        if(show.LISTED_IN[i+1] == NULL){
            printf("%s", show.LISTED_IN[i]);
        }else{
            printf("%s, ", show.LISTED_IN[i]);
        }
    }

    printf("] ##");
}

// ---------------------------------------------------------------------------------------------------- //
//Função para retornar um clone do objeto

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

    // Libera o mês (Date.mes)
    free(show.DATA.mes);
}

void swap (SHOW * show, int i, int menor){

    SHOW temp = show[i];
    show[i] = show [menor];
    show[menor] = temp;

}

void ordenaShows(SHOW * show, int tam){

    int i = 0, j;
    SHOW menor;
    int indexMenor;

    while(i < tam-1){

        j = i + 1;
        menor = show [i];
        indexMenor = i;

        for(; j < tam; j++){
            if(strcmp(menor.TITLE, show[j].TITLE) > 0){
                menor = show[j];
                indexMenor = j;
            }
        }
        swap(show, i, indexMenor);
        i++;
    }

}

bool pesquisaBinaria (SHOW * show, char * titulo, int comeco, int fim){

    if(comeco > fim) {
        return false;
    }

    int meio = (comeco + fim) / 2;

    if(strcmp(show[meio].TITLE, titulo) == 0){
        return true;
    }else{
        if(strcmp(show[meio].TITLE, titulo) > 0){
            return pesquisaBinaria(show, titulo, comeco, meio-1);
        }else{
            return pesquisaBinaria(show, titulo, meio + 1, fim);
        }
    }

}
