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

	


public void atribuiValores(String linha) {
    int i = 0;
    ArrayList<String> separa = new ArrayList<>();

    while (i < linha.length()) {  // Corrigido para i < linha.length()
        if (linha.charAt(i) == '"') {
            i++;
            StringBuilder aux = new StringBuilder();  // Usando StringBuilder para melhorar a performance de concatenação
            while (i < linha.length() && linha.charAt(i) != '"') {  // Garantindo que o índice i não ultrapasse o limite
                aux.append(linha.charAt(i));  // Adicionando caracteres ao StringBuilder
                i++;
            }
            separa.add(aux.toString());  // Convertendo para String e adicionando à lista
            i++;  // Pula a aspa de fechamento
        } else {
            if (i + 1 < linha.length() && linha.charAt(i) == ',' && linha.charAt(i + 1) == ',') {
                separa.add("NaN");
                i += 2;  // Pula a vírgula dupla
            } else {
                StringBuilder aux = new StringBuilder();  // Usando StringBuilder
                while (i < linha.length() && linha.charAt(i) != ',') {
                    aux.append(linha.charAt(i));  // Adicionando ao StringBuilder
                    i++;
                }
                separa.add(aux.toString());  // Convertendo para String e adicionando à lista
            }
        }
        if (i < linha.length() && linha.charAt(i) == ',') {
            i++;  // Pula a vírgula
        }
    }

    for (int j = 0; j < separa.size(); j++) {
        System.out.println(separa.get(j));
    }
}


	//Função para ler o arquivo CSV e retorna numa String.
	public static void leArquivo(SHOW show) {
		String linha = "", conteudo = "";
		int aux = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader("disneyplus.csv"));
			while ((linha = br.readLine()) != null) {
				
				conteudo = linha;
				if(aux == 8){
					show.atribuiValores(linha);
				}

				aux++;
			}
		} catch (Exception e) {
			System.out.println("Erro!!");
		}
	}

	//Func Main
	public static void main(String args[]) {
		String conteudo = "";
		Scanner sc = new Scanner(System.in);
		SHOW show = new SHOW();
		leArquivo(show);

	}
}
