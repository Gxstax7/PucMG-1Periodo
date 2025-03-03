import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class Q03 {
	
		public String textbf (String textoRecebido){
		String textoCifrado = "";
		int converte = 0;
		for (int i=0; i<textoRecebido.length(); i++){
			converte = (int)textoRecebido.charAt(i);
			converte += 3;
			textoCifrado += (char)converte;
		}
		return textoCifrado;
	}

	public static void main (String args[]){
		
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, charset));
		Q03 cripto = new Q03();
		String texto = "";
		texto = MyIO.readLine();
		while(!(texto.equals ("FIM"))){
		System.out.println (cripto.textbf(texto));
		texto = MyIO.readLine();
		}
	}

}
