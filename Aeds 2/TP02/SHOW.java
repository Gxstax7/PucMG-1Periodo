import java.util.*;
import java.io.*;

class SHOW{
	
	private String SHOW_ID, TITLE, TYPE, DIRECTOR, COUNTRY, RATING, DURATION;
	private List<String> CAST = new ArrayList<>();

	public static String leArquivo (){
		
		String linha = "", conteudo = "";

		try{
			BufferedReader br = new BufferedReader(new FileReader("disneyplus.csv"));		
			while((linha  = br.readLine()) != null){
				conteudo += br.readLine();
			}
		}catch(FileNotFoundException e){
			System.out.println("Erro!!");
		}catch(IOException e){
			System.out.println("Erro");
		}

		return conteudo;
	}

	public static void main (String args[]){

		String conteudo = "";
		Scanner sc = new Scanner (System.in);
		int idDesejado = sc.nextInt();

		conteudo = leArquivo();

	}

}
