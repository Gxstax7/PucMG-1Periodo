import java.util.*;
import java.util.Random;

class Q04{

	public static String alteraString (String frase){
		String fraseAlterada = "";
		Random gerador = new Random();
		gerador.setSeed(4);
		char letraParaAlterar = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
		char letraAlterada = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));

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
		while(!frase.equals("FIM")){
			System.out.println(alteraString(frase));
			frase = sc.nextLine();
		}
		sc.close();
	}

}
