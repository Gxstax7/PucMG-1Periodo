import java.util.*;

public class Q03 {
	
	public String textbf (String textoRecebido){
		String textoCifrado = "";
		int converte = 0;

		//iteração que converte um char para int, soma 3 e retorna para char, depois concatena a nova string que sera retornada
		for (int i=0; i<textoRecebido.length(); i++){
			converte = (int)textoRecebido.charAt(i);
			converte += 3;
			textoCifrado += (char)converte;
		}
		return textoCifrado;
	}

	public static void main (String args[]){
		
		Q03 cripto = new Q03();
		String texto = "";
		texto = MyIO.readLine();

		while(!(texto.equals ("FIM"))){
			MyIO.println (cripto.textbf(texto));
			texto = MyIO.readLine();
		}
	}

}
