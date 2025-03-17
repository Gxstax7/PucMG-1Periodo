//Programa realizado com auxilio da documentação e auxilio de AI somente para realização/leitura
//https://docs.oracle.com/javase/10/docs/api/java/net/HttpURLConnection.html
//

import java.util.*;
import java.net.*;
import java.io.*;

class Q13{

	public static int [] contarCaracteres (String conteudo, String nome){
		conteudo = conteudo.toLowerCase();
		int contador[] = new int [26]; //array para contar as 26 ocorrencias
		String[] palavras = conteudo.split("\\s+");

		for (int i = 0; i < conteudo.length(); i++){	
			if (conteudo.charAt(i) == 'a'){
				contador[0]++;
			}
			
			if (conteudo.charAt(i) == 'e'){
				contador[1]++;
			}
			
			if (conteudo.charAt(i) == 'i'){
				contador[2]++;
			}
			
			if (conteudo.charAt(i) == 'o'){
				contador[3]++;
			}
			if (conteudo.charAt(i) == 'u'){
				contador[4]++;
			}
			
			if (conteudo.charAt(i) == ((char) 225)){
				contador[5]++;
			}
			if (conteudo.charAt(i) == ((char) 233)){
				contador[6]++;
			}
			
			if (conteudo.charAt(i) == ((char) 237)){
				contador[7]++;
			}
			
			if (conteudo.charAt(i) == ((char) 243)){
				contador[8]++;
			}
			
			if (conteudo.charAt(i) == ((char) 250)){
				contador[9]++;
			}
			if (conteudo.charAt(i) == ((char) 224)){
				contador[10]++;
			}
			
			if (conteudo.charAt(i) == ((char) 232)){
				contador[11]++;
			}
			if (conteudo.charAt(i) == ((char) 236)){
				contador[12]++;
			}
			
			if (conteudo.charAt(i) == ((char) 242)){
				contador[13]++;
			}
			
			if (conteudo.charAt(i) == ((char) 249)){
				contador[14]++;
			}
			
			if (conteudo.charAt(i) == ((char) 227)){
				contador[15]++;
			}
			if (conteudo.charAt(i) == ((char) 245)){
				contador[16]++;
			}
			
			if (conteudo.charAt(i) == ((char) 226)){
				contador[17]++;
			}
			if (conteudo.charAt(i) == ((char) 234)){
				contador[18]++;
			}
			
			if (conteudo.charAt(i) == ((char) 238)){
				contador[19]++;
			}
			
			if (conteudo.charAt(i) == ((char) 244)){
				contador[20]++;
			}
			
			if (conteudo.charAt(i) == ((char) 251)){
				contador[21]++;
			}
			
			if ("bcdfghijklmnpqrstvwxyz".indexOf(conteudo.charAt(i)) == 0){
				contador[22]++;
			}

		}
		
		for (String palavra : palavras){
			if (palavra.equals("<br>")){
				contador[23]++;
			}
			if (palavra.equals("<table>")){
				contador[24]++;
			}
			if (palavra.equals(nome)){
				contador[25]++;
			}
		}
		
		return contador;
	}

	public static void main (String args[]){
		Scanner sc = new Scanner (System.in);
		String nome = sc.nextLine(); //Recebe o nome da serie
		String site;

		while(!nome.equals("FIM")){
			site = sc.nextLine(); //Recebe o site (dentro do while pois se a serie for "FIM" não recebe o site)
			try{
				URL u = new URL (site); //Cria um objeto URL
				HttpURLConnection conexao = (HttpURLConnection) u.openConnection(); //Realiza a conexão http com o site fornecido
				conexao.setRequestMethod("GET");
				BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream())); //Criado leitor para ler conteudo do site, utilizando InputStreamReader para ler de binario e transformar em caracter
				
				String inputLine;
            			StringBuilder conteudo = new StringBuilder();//Criada string para receber o conteudo do site com StringBuilder por ser mutavel
				
				while ((inputLine = leitor.readLine()) != null) {
                			conteudo.append(inputLine); //recebe o conteudo
            			}
            			leitor.close();

				int contador[] = contarCaracteres(conteudo.toString(), nome);
				MyIO.println("a(" + (contador[0] - 1) + ") " + "e(" + (contador[1] - 1) + ") " + "i(" + contador[2] + ") " + "o(" + contador[3] + ") " + "u(" + contador[4] + ") " + "á(" + contador[5] + ") " + "é(" + contador[6] + ") " + "í(" + contador[7] + ") " + "ó(" + contador[8] + ") " + "ú(" + contador[9] + ") " + "à(" + contador[10] + ") " + "è(" + contador[11] + ") " + "ì(" + contador[12] + ") " + "ò(" + contador[13] + ") " + "ù(" + contador[14] + ") " + "ã(" + contador[15] + ") " + "õ(" + contador[16] + ") " + "â(" + contador[17] + ") " + "ê(" + contador[18] + ") " + "î(" + contador[19] + ") " + "ô(" + contador[20] + ") " + "û(" + contador[21] + ") " + "consoante(" + contador[22] + ") " + "<br>(" + contador[23] + ") " + "<table>(" + contador[24] + ") " + nome + "(" + contador[25] + ")");

			}catch(IOException e){
				System.out.println("Erro!"); //Erro quando url é invalida
			}
			nome = sc.nextLine();
		}
	}

}
