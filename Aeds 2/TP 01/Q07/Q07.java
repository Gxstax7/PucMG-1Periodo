import java.util.*;

class Q07{
	
	//metodo que a nova string recebe o ultimo caracter da frase recebida ate iterar sobre toda a frase
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
			MyIO.println(inverteString(frase));
			frase = MyIO.readLine();
		}

	}
}
