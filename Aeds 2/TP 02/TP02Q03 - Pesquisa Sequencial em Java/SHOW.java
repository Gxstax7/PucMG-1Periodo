// ---------------------------------------------------------------------------------------------------- //
//Imports
import java.util.*;
import java.io.*;
import java.time.*;

// ---------------------------------------------------------------------------------------------------- //
//Inicio da classe
class SHOW {

    private String SHOW_ID, TITLE, TYPE, DIRECTOR, COUNTRY, RATING, DURATION, DATE_ADDED;
    private ArrayList<String> CAST = new ArrayList<>();
    private ArrayList<String> LISTED_IN = new ArrayList<>();
    private int RELEASE_YEAR;

// ---------------------------------------------------------------------------------------------------- //
//Structs Construtores, getters e setters
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

    public String getID() {
        return SHOW_ID;
    }
    public void setID(String SHOW_ID) {
        this.SHOW_ID = SHOW_ID;
    }

    public String getDATE() {
        return DATE_ADDED;
    }
    public void setDATE(String DATE_ADDED) {
        this.DATE_ADDED = DATE_ADDED;
    }

    public String getTITLE() {
        return TITLE;
    }
    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getTYPE() {
        return TYPE;
    }
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getDIRECTOR() {
        return DIRECTOR;
    }
    public void setDIRECTOR(String DIRECTOR) {
        this.DIRECTOR = DIRECTOR;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }
    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getRATING() {
        return RATING;
    }
    public void setRATING(String RATING) {
        this.RATING = RATING;
    }

    public String getDURATION() {
        return DURATION;
    }
    public void setDURATION(String DURATION) {
        this.DURATION = DURATION;
    }

    public ArrayList<String> getCAST() {
        return CAST;
    }
    public void setCAST(ArrayList<String> CAST) {
        this.CAST = CAST;
    }

    public ArrayList<String> getLISTED_IN() {
        return LISTED_IN;
    }
    public void setLISTED_IN(ArrayList<String> LISTED_IN) {
        this.LISTED_IN = LISTED_IN;
    }

    public int getRELEASE_YEAR() {
        return RELEASE_YEAR;
    }
    public void setRELEASE_YEAR(int RELEASE_YEAR) {
        this.RELEASE_YEAR = RELEASE_YEAR;
    }

// ---------------------------------------------------------------------------------------------------- //
//Função responsavel por clonar e retornar um novo objeto com os mesmos atributos
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
//Função para imprimir os shows enquanto não receber FIM
    public static void imprimir(ArrayList<SHOW> show, String IdDesejado) {
        SHOW escolhido = new SHOW();
        int i = 0;

        //Encontra o show desejado
        while (i < show.size()) {
            if (IdDesejado.equals(show.get(i).getID())) {
                escolhido = show.get(i).clone();
                break;
            }
            i++;
        }

        //Imprimi o show
        if (i == show.size()) {
            System.out.println("Id nao encontrado");
        } else {
            System.out.println("=> " + escolhido.getID() + " ## " + escolhido.getTITLE() + " ## " + escolhido.getTYPE()
                    + " ## " + escolhido.getDIRECTOR() + " ## " + escolhido.getCAST() + " ## " + escolhido.getCOUNTRY()
                    + " ## " + escolhido.getDATE() + " ## " + escolhido.getRELEASE_YEAR() + " ## " + escolhido.getRATING()
                    + " ## " + escolhido.getDURATION() + " ## " + escolhido.getLISTED_IN() + " ##");
        }
    }

//Função responsavel por tratar campos entre aspas
    public static ArrayList<String> splitArrays(String frase) {
        ArrayList<String> separado = new ArrayList<>();
        int i = 0;

        //Atribui NaN para a primeira (e unica) posição do array caso receba NaN
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
	
        //Ordena o array
	    Collections.sort(separado);

        return separado;
    }

// ---------------------------------------------------------------------------------------------------- //
//Função para separar e destrinchar as linhas do arquivo
    public static SHOW atribuiValores(String linha) {
        int i = 0;
        SHOW show = new SHOW();
        ArrayList<String> separa = new ArrayList<>();

        while (i < linha.length()) {
            if (linha.charAt(i) == '"') {
                i++;
                StringBuilder aux = new StringBuilder();
                String prox = "";

                while (i + 1 < linha.length()) {
                    prox += linha.charAt(i);
                    prox += linha.charAt(i + 1);

                    if (linha.charAt(i) == '"') {
                        if (linha.charAt(i + 1) == ',') {
                            i++;
                            break;
                        }
                        i++;
                    }
                    aux.append(linha.charAt(i));
                    i++;
                    prox = "";
                }

                separa.add(aux.toString());
            } else {
                if (i < linha.length() && linha.charAt(i) == ',') {
                    if (linha.charAt(i + 1) == ',') {
                        separa.add("NaN");
                    }
                    i++; // Pula a vírgula
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

        //Atribui os valores
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
//Função para ler o arquivo
    public static ArrayList<SHOW> ler() {
        String linha = "";
        int aux = 0;
        ArrayList<SHOW> show = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("disneyplus.csv"));
            while ((linha = br.readLine()) != null) {
                //Ignora a primeira linha (nome das categorias)
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
//Função para realizar a pesquisa sequencial

    public static boolean pesquisaSequencial(ArrayList<SHOW> show, String title, Log log){
    	
	for(int i = 0; i < show.size(); i++){
		if(show.get(i).getTITLE().equals(title)){
			return true;
		} log.addComp();
	}

	return false;

    }

// ---------------------------------------------------------------------------------------------------- //
//Função Main
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SHOW> show = ler();
	ArrayList<SHOW> showClonado = new ArrayList<>();
        String idDesejado = sc.nextLine();
	String titleDesejado = "";

	Timer timer = new Timer();
	Log log = new Log();

	//While para criar o array de shows em que a pesquisa sera realizada
        while (!idDesejado.equals("FIM")) {
            for(int i = 0; i < show.size(); i++){
	
	        if(show.get(i).getID().equals(idDesejado)){
		    showClonado.add(show.get(i).clone());
		}
	    
	    }
	    idDesejado = sc.nextLine();
        }

	titleDesejado = sc.nextLine();
	
	//Pesquisa sequencial
	//Incializa o timer
	timer.start();

	while(!titleDesejado.equals("FIM")){
	    System.out.println(pesquisaSequencial(showClonado, titleDesejado, log) ? "SIM" : "NAO");	
	    titleDesejado = sc.nextLine();
	}
	
	//Finaliza o timer
	timer.stop();
	System.out.println("Comparações = " + log.getComp());
	System.out.println("Tempo = " + timer.getTime());
	log.createLog("866018_sequencial.txt", timer);

        sc.close();
    }
}


// ---------------------------------------------------------------------------------------------------- //
//Criação do Timer e do Log
class Timer{

	private Instant fim, inicio;
	
	Timer(){}
	public void start (){ this.inicio = Instant.now(); }
	public void stop () { this.fim = Instant.now(); }
	public double getTime() { return Duration.between(inicio, fim).toMillis() / 1000.0 ; }
}

class Log{
	
	private int comp, mov;

	Log(){
		comp = 0;
		mov = 0;
	}

	Log(int comp, int mov){
		this.comp = comp;
		this.mov = mov;
	}
	
	public void addComp(){ this.comp++;}
	public void addMov(){ this.mov++;}
	public void addComp(int comp) { this.comp += comp; }
	public void addMov(int mov) { this.mov += mov; }

	public void setComp(int comp){ this.comp = comp;}
	public int getComp(){return comp;}

	public static void createLog(String nameFile, Timer time){
		
	}
}

