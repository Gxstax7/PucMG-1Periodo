import java.util.*;
import java.util.Random;

class Q04{

	public static String alteraString (String frase, char letraParaAlterar, char letraAlterada){

		String fraseAlterada = "";
		
		// iteração para alterar a letra sorteada a ser alterada pela nova letra e concatenar em uma nova string
		for (int i = 0; i < frase.length(); i++){
			if(frase.charAt(i) == letraParaAlterar){
				fraseAlterada += letraAlterada;
			}else{
				fraseAlterada += frase.charAt(i);
			}
		}

		return fraseAlterada;
	}

	public static void main (String args[]){

		Scanner sc = new Scanner (System.in);
		String frase = sc.nextLine();
		Random gerador = new Random();
		gerador.setSeed(4); // seed fornecida no exercicio
		
		while(!frase.equals("FIM")){
			char letraParaAlterar = ((char)('a' + (Math.abs(gerador.nextInt()) % 26))); // sorteia a letra a ser alterada
			char letraAlterada = ((char)('a' + (Math.abs(gerador.nextInt()) % 26))); // sorteia a nova letra
			System.out.println(alteraString(frase, letraParaAlterar, letraAlterada));
			frase = sc.nextLine();
		}
		sc.close();
	}

}
