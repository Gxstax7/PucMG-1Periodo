import java.util.*;
import java.io.*;

class SHOW {
	
	private String SHOW_ID, TITLE, TYPE, DIRECTOR, COUNTRY, RATING, DURATION, DATE_ADDED, DESCRIPTION;
	private ArrayList<String> CAST = new ArrayList<>();
	private ArrayList<String> LISTED_IN = new ArrayList<>();
	private int RELEASE_YEAR;

	// Getters e Setters
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

	//Função para ler o arquivo CSV e retorna numa String.
	public static String leArquivo() {
		String linha = "", conteudo = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader("disneyplus.csv"));
			while ((linha = br.readLine()) != null) {
				conteudo += linha;
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
		SHOW teste = new SHOW();
		conteudo = leArquivo();
		
		System.out.println(conteudo);

		String separa[] = conteudo.split(",");
		
		teste.setID(separa[12]);
		teste.setTYPE(separa[13]);
		teste.setTITLE(separa[14]);
		teste.setDIRECTOR(separa[15]);
	//	teste.setCAST(separa[4]);
		teste.setCOUNTRY(separa[17]);
		teste.setDATE(separa[18]);
//		teste.setRELEASE_YEAR(Integer.parseInt(separa[7]));
	//	teste.setLISTED_IN(separa[8]);
		teste.setDESCRIPTION(separa[23]);

		//int idDesejado = sc.nextInt();
		
		System.out.println("ID = " + teste.SHOW_ID);
		System.out.println("TYPE = " + teste.TYPE);
		System.out.println("TITLE = " + teste.TITLE);
		System.out.println("DIRECTOR = " + teste.DIRECTOR);
		System.out.println("COUNTRY = " + teste.COUNTRY);
		System.out.println("DATE = " + teste.DATE_ADDED);
	//	System.out.println("ANO = " + teste.REALEASE_YEAR);
		System.out.println("DESCRICAO = " + teste.DESCRIPTION);

	}
}

