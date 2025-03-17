import java.util.*;

class Q10{

	// metodo para contar palavras = contar quantidade de espaços + 1
	public static int contaPalavras(String frase){

		int cont = 0;

		for (int i = 0; i < frase.length(); i++){
			if (frase.charAt(i) == ' '){
				cont++;
			}
		}

		return cont + 1;
	}

	public static void main (String args []){

		Scanner sc = new Scanner (System.in);
		String frase = sc.nextLine();

		while (!frase.equals ("FIM")){
			System.out.println (contaPalavras(frase));
			frase = sc.nextLine();
		}

		sc.close();
	}


}
