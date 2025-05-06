// ---------------------------------------------------------------------------------------------------- //
// Imports
import java.util.*;
import java.io.*;
import java.time.*;

// ---------------------------------------------------------------------------------------------------- //
// Início da classe
class SHOW {

    private static Log log = new Log();

    private String SHOW_ID, TITLE, TYPE, DIRECTOR, COUNTRY, RATING, DURATION, DATE_ADDED;
    private ArrayList<String> CAST = new ArrayList<>();
    private ArrayList<String> LISTED_IN = new ArrayList<>();
    private int RELEASE_YEAR;

// ---------------------------------------------------------------------------------------------------- //
// Construtores, getters e setters
    public SHOW() {
        setID("");
        setTITLE("");
        setTYPE("");
        setDIRECTOR("");
        setCOUNTRY("");
        setRATING("");
        setDURATION("");
        setDATE("");
        setRELEASE_YEAR(-1);
        setCAST(new ArrayList<String>());
        setLISTED_IN(new ArrayList<String>());
    }

    public SHOW(String SHOW_ID, String TITLE, String TYPE, String DIRECTOR, ArrayList<String> CAST,
                String COUNTRY, String DATE_ADDED, int RELEASE_YEAR, String RATING,
                String DURATION, ArrayList<String> LISTED_IN) {
        setID(SHOW_ID);
        setTITLE(TITLE);
        setTYPE(TYPE);
        setDIRECTOR(DIRECTOR);
        setCAST(CAST);
        setCOUNTRY(COUNTRY);
        setDATE(DATE_ADDED);
        setRELEASE_YEAR(RELEASE_YEAR);
        setRATING(RATING);
        setDURATION(DURATION);
        setLISTED_IN(LISTED_IN);
    }

    public String getID() { return SHOW_ID; }
    public void setID(String SHOW_ID) { this.SHOW_ID = SHOW_ID; }

    public String getDATE() { return DATE_ADDED; }
    public void setDATE(String DATE_ADDED) { this.DATE_ADDED = DATE_ADDED; }

    public String getTITLE() { return TITLE; }
    public void setTITLE(String TITLE) { this.TITLE = TITLE; }

    public String getTYPE() { return TYPE; }
    public void setTYPE(String TYPE) { this.TYPE = TYPE; }

    public String getDIRECTOR() { return DIRECTOR; }
    public void setDIRECTOR(String DIRECTOR) { this.DIRECTOR = DIRECTOR; }

    public String getCOUNTRY() { return COUNTRY; }
    public void setCOUNTRY(String COUNTRY) { this.COUNTRY = COUNTRY; }

    public String getRATING() { return RATING; }
    public void setRATING(String RATING) { this.RATING = RATING; }

    public String getDURATION() { return DURATION; }
    public void setDURATION(String DURATION) { this.DURATION = DURATION; }

    public ArrayList<String> getCAST() { return CAST; }
    public void setCAST(ArrayList<String> CAST) { this.CAST = CAST; }

    public ArrayList<String> getLISTED_IN() { return LISTED_IN; }
    public void setLISTED_IN(ArrayList<String> LISTED_IN) { this.LISTED_IN = LISTED_IN; }

    public int getRELEASE_YEAR() { return RELEASE_YEAR; }
    public void setRELEASE_YEAR(int RELEASE_YEAR) { this.RELEASE_YEAR = RELEASE_YEAR; }

// ---------------------------------------------------------------------------------------------------- //
// Função responsável por clonar e retornar um novo objeto com os mesmos atributos
    public SHOW clone() {
        SHOW clone = new SHOW();
        clone.setID(getID());
        clone.setTITLE(getTITLE());
        clone.setTYPE(getTYPE());
        clone.setDIRECTOR(getDIRECTOR());
        clone.setCAST(new ArrayList<>(getCAST()));
        clone.setCOUNTRY(getCOUNTRY());
        clone.setDATE(getDATE());
        clone.setRELEASE_YEAR(getRELEASE_YEAR());
        clone.setRATING(getRATING());
        clone.setDURATION(getDURATION());
        clone.setLISTED_IN(new ArrayList<>(getLISTED_IN()));
        return clone;
    }

// ---------------------------------------------------------------------------------------------------- //
// Imprime show pelo ID
    public static void imprimir(ArrayList<SHOW> show, String IdDesejado) {
        SHOW escolhido = new SHOW();
        int i = 0;

        while (i < show.size()) {
            if (IdDesejado.equals(show.get(i).getID())) {
                escolhido = show.get(i).clone();
                break;
            }
            i++;
        }

        if (i == show.size()) {
            System.out.println("Id nao encontrado");
        } else {
            System.out.println("=> " + escolhido.getID() + " ## " + escolhido.getTITLE() + " ## " + escolhido.getTYPE()
                    + " ## " + escolhido.getDIRECTOR() + " ## " + escolhido.getCAST() + " ## " + escolhido.getCOUNTRY()
                    + " ## " + escolhido.getDATE() + " ## " + escolhido.getRELEASE_YEAR() + " ## " + escolhido.getRATING()
                    + " ## " + escolhido.getDURATION() + " ## " + escolhido.getLISTED_IN() + " ##");
        }
    }

// ---------------------------------------------------------------------------------------------------- //
// Tratamento de campos entre aspas
    public static ArrayList<String> splitArrays(String frase) {
        ArrayList<String> separado = new ArrayList<>();
        int i = 0;

        while (i < frase.length()) {
            if (frase.equals("NaN")) {
                separado.add("NaN");
                break;
            } else {
                StringBuilder aux = new StringBuilder();
                while (i < frase.length() && frase.charAt(i) != ',') {
                    aux.append(frase.charAt(i));
                    i++;
                }
                separado.add(aux.toString());
            }
            i += 2;
        }

        Collections.sort(separado);
        return separado;
    }

// ---------------------------------------------------------------------------------------------------- //
// Processa linha do CSV
    public static SHOW atribuiValores(String linha) {
        int i = 0;
        SHOW show = new SHOW();
        ArrayList<String> separa = new ArrayList<>();

        while (i < linha.length()) {
            if (linha.charAt(i) == '"') {
                i++;
                StringBuilder aux = new StringBuilder();
                while (i + 1 < linha.length()) {
                    if (linha.charAt(i) == '"' && linha.charAt(i + 1) == ',') {
                        i++;
                        break;
                    }
                    aux.append(linha.charAt(i));
                    i++;
                }
                separa.add(aux.toString());
            } else {
                if (i < linha.length() && linha.charAt(i) == ',') {
                    if (linha.charAt(i + 1) == ',') {
                        separa.add("NaN");
                    }
                    i++;
                } else {
                    StringBuilder aux = new StringBuilder();
                    while (i < linha.length() && linha.charAt(i) != ',') {
                        aux.append(linha.charAt(i));
                        i++;
                    }
                    separa.add(aux.toString());
                }
            }
        }

        show.setID(separa.get(0));
        show.setTYPE(separa.get(1));
        show.setTITLE(separa.get(2));
        show.setDIRECTOR(separa.get(3));
        show.setCAST(splitArrays(separa.get(4)));
        show.setCOUNTRY(separa.get(5));
        show.setDATE(separa.get(6));
        show.setRELEASE_YEAR(Integer.parseInt(separa.get(7)));
        show.setRATING(separa.get(8));
        show.setDURATION(separa.get(9));
        show.setLISTED_IN(splitArrays(separa.get(10)));

        return show;
    }

// ---------------------------------------------------------------------------------------------------- //
// Leitura do arquivo
    public static ArrayList<SHOW> ler() {
        String linha;
        int aux = 0;
        ArrayList<SHOW> show = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/tmp/disneyplus.csv"));
            while ((linha = br.readLine()) != null) {
                if (aux >= 1) {
                    show.add(atribuiValores(linha));
                }
                aux++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro!!");
        }

        return show;
    }

// ---------------------------------------------------------------------------------------------------- //
// Swap
    public static void swapShows(ArrayList<SHOW> show, int i, int menor) {
        SHOW temp = show.get(i).clone();
        show.set(i, show.get(menor));
        show.set(menor, temp);
        log.addMov(3);
    }

// ---------------------------------------------------------------------------------------------------- //
// Pesquisa sequencial
    public static boolean pesquisaSequencial(ArrayList<SHOW> show, String title) {
        for (int i = 0; i < show.size(); i++) {
            log.addComp();
            if (show.get(i).getTITLE().equals(title)) {
                return true;
            }
        }
        return false;
    }

// ---------------------------------------------------------------------------------------------------- //
// Ordenação por seleção (baseada em TITLE)
    public static void ordenaSelecao(ArrayList<SHOW> show) {
        int length = show.size();

        for (int i = 0; i < length - 1; i++) {
            String menorShow = show.get(i).getTITLE();
            int indexMenor = i;

            for (int j = i + 1; j < length; j++) {
                log.addComp();
                if (menorShow.compareToIgnoreCase(show.get(j).getTITLE()) > 0) {
                    menorShow = show.get(j).getTITLE();
                    indexMenor = j;
                }
            }

            swapShows(show, i, indexMenor);
        }
    }

// ---------------------------------------------------------------------------------------------------- //
// Ordenação por inserção (por TYPE e, em empate, por TITLE)
    public static void ordenaInsercao(ArrayList<SHOW> show) {
        int length = show.size();

        for (int i = 1; i < length; i++) {
            SHOW aux = show.get(i);
            int j = i - 1;

            log.addComp();
            while (j >= 0 && (
                    aux.getTYPE().compareToIgnoreCase(show.get(j).getTYPE()) < 0 ||
                    (aux.getTYPE().equalsIgnoreCase(show.get(j).getTYPE()) &&
                     aux.getTITLE().compareToIgnoreCase(show.get(j).getTITLE()) < 0)
            )) {
                show.set(j + 1, show.get(j));
                j--;
                log.addMov();
            }

            show.set(j + 1, aux);
            log.addMov();
        }
    }


// ---------------------------------------------------------------------------------------------------- //
// Ordenação por countingSort (por RELEASED_YEAR e, em empate, por TITLE)
	
    public static void countingSort(ArrayList<SHOW> show){
    	
	//Encontra os anos minimo e maximo
	int anoMin = show.get(0).getRELEASE_YEAR();
	int anoMax = show.get(0).getRELEASE_YEAR();

	for(SHOW aux : show){

		if(aux.getRELEASE_YEAR() > anoMax) anoMax = aux.getRELEASE_YEAR();
		if(aux.getRELEASE_YEAR() < anoMin) anoMin = aux.getRELEASE_YEAR();
		log.addComp(2);
	}

	int n = anoMax - anoMin + 1;
	int array[] = new int [n];

	ArrayList<ArrayList<SHOW>> arrayShows = new ArrayList<>(n);

	for (int i = 0; i < n; i++){
		arrayShows.add(new ArrayList<>());
	}

	for(SHOW aux : show){
		int index = aux.getRELEASE_YEAR() - anoMin;
		array[index]++;
		arrayShows.get(index).add(aux);
		log.addMov();
	}

	for (ArrayList <SHOW> grupos : arrayShows) {
		if(!grupos.isEmpty()) ordenaSelecao(grupos);
	}

	show.clear();
	for (int i = 0; i < n; i++){
		show.addAll(arrayShows.get(i));
		log.addMov(arrayShows.get(i).size());
	}

    }

// ---------------------------------------------------------------------------------------------------- //
// Função main
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SHOW> show = ler();
        ArrayList<SHOW> showClonado = new ArrayList<>();
        String idDesejado = sc.nextLine();

        Timer timer = new Timer();

        while (!idDesejado.equals("FIM")) {
            for (int i = 0; i < show.size(); i++) {
                if (show.get(i).getID().equals(idDesejado)) {
                    showClonado.add(show.get(i).clone());
                }
            }
            idDesejado = sc.nextLine();
        }

        timer.start();
        countingSort(showClonado);
        timer.stop();

        for (SHOW s : showClonado) {
            imprimir(showClonado, s.getID());
        }

        try {
            log.createLog("866018_countingsort.txt", timer);
        } catch (IOException e) {
            System.out.println("Erro na criação do log!!");
        }

        sc.close();
    }
}

// ---------------------------------------------------------------------------------------------------- //
// Timer e Log
class Timer {
    private Instant fim, inicio;

    Timer() {}

    public void start() { this.inicio = Instant.now(); }
    public void stop() { this.fim = Instant.now(); }
    public double getTime() { return Duration.between(inicio, fim).toMillis() / 1000.0; }
}

class Log {
    private int comp, mov;

    Log() {
        comp = 0;
        mov = 0;
    }

    Log(int comp, int mov) {
        this.comp = comp;
        this.mov = mov;
    }

    public void addComp() { this.comp++; }
    public void addMov() { this.mov++; }
    public void addComp(int comp) { this.comp += comp; }
    public void addMov(int mov) { this.mov += mov; }

    public void setComp(int comp) { this.comp = comp; }
    public int getComp() { return comp; }

    public void createLog(String nameFile, Timer timer) throws IOException {
        PrintWriter writer = new PrintWriter(nameFile, "UTF-8");
        writer.println("Matricula: 866018" + "\t" +
                       "Tempo: " + timer.getTime() + "\t" +
                       "Comparações: " + this.comp + "\t" +
                       "Movimentações: " + mov);
        writer.close();
    }
}

