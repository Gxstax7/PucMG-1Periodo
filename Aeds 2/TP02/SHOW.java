import java.util.*;
import java.io.*;

class SHOW {
	
	private String SHOW_ID, TITLE, TYPE, DIRECTOR, COUNTRY, RATING, DURATION, DATE_ADDED, DESCRIPTION;
	private ArrayList<String> CAST = new ArrayList<>();
	private ArrayList<String> LISTED_IN = new ArrayList<>();
	private int RELEASE_YEAR;

	// ------------------------
	// Getters e Setters
	// ------------------------
	
	public String getID() {
		return SHOW_ID;
	}

	public void setID(String SHOW_ID) {
		this.SHOW_ID = SHOW_ID;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
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

	


	public void atribuiValores (String linha){
		
		int i = 0;
		ArrayList<String> separa = new ArrayList<>();
		
		//--------------------------------------------------------
		//Lógica para realizar o split de acordo com os atributos
		//--------------------------------------------------------

		while (i < linha.length()){

			if(linha.charAt(i) == '"'){
				i++;
				StringBuilder aux = new StringBuilder();
				while(i < linha.length() && linha.charAt(i) != '"'){
					aux.append(linha.charAt(i));
					i++;
				}
				separa.add(aux.toString());;
				i++; //Pula a segunda aspas
			}else{

			    if (i < linha.length() && linha.charAt(i) == ',') {
				    if(linha.charAt(i+1) == ','){
					    separa.add("NaN");
				    }
           			 i++;  // Pula a vírgula

       			}else{
					StringBuilder aux = new StringBuilder();
					while(i < linha.length() && linha.charAt(i) != ','){
						aux.append(linha.charAt(i));
						i++;
					}
					separa.add(aux.toString());
				}
			}
		}

		for (int j = 0 ; j < separa.size(); j++){
			System.out.println(separa.get(j));
		}


	}

	//Função para ler o arquivo CSV e retorna numa String.
	public static String leArquivo(SHOW show) {
		String linha = "", conteudo = "";
		int aux = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader("disneyplus.csv"));
			while ((linha = br.readLine()) != null) {
				
				conteudo += linha;
				if(aux == 16){
					show.atribuiValores(linha);
				}

				aux++;
			}
		} catch (Exception e) {
			System.out.println("Erro!!");
		}
		return conteudo;
	}

	//Func Main
	public static void main(String args[]) {
		String conteudo = "";
		Scanner sc = new Scanner(System.in);
		SHOW show = new SHOW();
		leArquivo(show);

	}
}
