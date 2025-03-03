import java.util.*;

class Q07{

	public static String inverteString (String frase){
		
		String stringInvertida = "";
		for (int i = 0; i < frase.length(); i++){
			stringInvertida += frase.charAt(frase.length() - i - 1);
		}

		return stringInvertida;
	}

	public static void main (String args[]){
		
		String frase = MyIO.readLine();
		while (!frase.equals ("FIM")){
			System.out.println(inverteString(frase));
			frase = MyIO.readLine();
		}

	}
}
