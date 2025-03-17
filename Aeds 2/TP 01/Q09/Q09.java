import java.util.*;

class Q09{

	//o metodo recebe duas strings e as transformam em arrays de char, possibilitando a ordenação das letras.
	public static boolean isAnagrama (String palavra1, String palavra2){

		boolean resp = true;
		
		palavra1 = palavra1.toLowerCase();
		palavra2 = palavra2.toLowerCase();

		char [] palavraChar1 = palavra1.toCharArray();
		char [] palavraChar2 = palavra2.toCharArray();
		Arrays.sort (palavraChar1);
		Arrays.sort (palavraChar2);
		
		//caso o tamanho seja diferente não são anagramas, depois iteramos sobre os dois arrays ordenados, pois se são anagramas ambas teram a mesma disposição
		if (palavra1.length() != palavra2.length()){
			resp = false;
		}else{
			for (int i = 0; i < palavra1.length(); i++){
				if (palavraChar1[i] != palavraChar2[i]){
					resp = false;
				}
			}
		}

		return resp;
	}

	public static void main (String args[]){

		Scanner sc = new Scanner (System.in);
		String entrada = sc.nextLine();
		int a = 195;

		while (!entrada.equals("FIM")){
			String [] palavras = entrada.split (" - ");
			String primeiraPalavra = palavras[0];
			String segundaPalavra = palavras[1];        
		
			System.out.println (isAnagrama (primeiraPalavra, segundaPalavra) ? "SIM" : "N" + (char)a + "O");

			entrada = sc.nextLine();
		}
	}

}
