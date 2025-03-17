import java.util.*;

class Q06 {
	
	// metodo de comparação de vogais, caso não encontre nenhuma das 5, altera para false, ao contrario, segue verdadeira.
	public static boolean onlyVogal (String texto){
		boolean resp = true;
		for (int i = 0; i < texto.length(); i++){
			if (texto.charAt(i) != 'a' && texto.charAt(i) != 'e' && texto.charAt(i) != 'i' && texto.charAt(i) != 'o' && texto.charAt(i) != 'u')
				resp = false;
		}
		return resp;
	}

	// metodo de comparação de consoantes, compara cada caracter do texto recebido com todas as consoantes.
	public static boolean onlyConsoante (String texto){

		boolean resp = true;

		//iteração cria um novo char 'c' e itera sobre cada caracter do texto recebido
		for (char c : texto.toCharArray()){
			c = Character.toLowerCase(c);
			if ("bcdfghijklmnpqrstvwxyz".indexOf(c) == -1)
				resp = false;
		}

		return resp;
	}

	// metodo de comparação de inteiro, tenta transformar a string em inteiro com o metodo parse, caso não seja possivel, retorna exceção e o valor falso.
	public static boolean isInt (String texto){
		boolean resp = false;
		try{
			Integer.parseInt(texto);
			resp = true;
		}catch (NumberFormatException e){
			resp = false;
		}

		return resp;

	}

	// metodo semelhante ao anterior porem agora com double.
	public static boolean isReal (String texto){
		boolean resp = false;
		try{
			Double.parseDouble(texto);
			resp = true;
		}catch (NumberFormatException e){
			resp = false;
		}

		return resp;	
	}


	public static void main (String args []){

		String texto = MyIO.readLine();

		while (!texto.equals("FIM")){
			System.out.println((onlyVogal(texto) ? "SIM" : "NAO") + " " + (onlyConsoante(texto) ? " SIM" : " NAO")  + " " + (isInt(texto) ? " SIM" : " NAO") + " " + (isReal (texto) ? "SIM" : "NAO"));
			texto = MyIO.readLine();
		}

	}

}
