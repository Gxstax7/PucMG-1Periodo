import java.util.*;
import java.io.*;

public class Q18 {
	
	// metodo recursivo que controla o index, assim que o index se iguala ao tamanho do texto, return "" vazio para não acrescentar nada na string, tudo anteriormente é adicionado
	public static String textbf (String textoRecebido, int index){
		int converte = 0;
		char aux;
		if (index == textoRecebido.length()){
			return "";
		}else{
			converte = (int)textoRecebido.charAt(index);
			converte += 3;
			aux = (char)converte;
			return aux + textbf(textoRecebido, index + 1);
		}
	}

	public static void main (String args[]){
		
		String texto = "";
		texto = MyIO.readLine();
		while(!(texto.equals ("FIM"))){
			MyIO.println (textbf(texto, 0));
			texto = MyIO.readLine();
		}

	}

}
