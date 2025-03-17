import java.util.*;

class Q20 {

	// verifica se so tem vogal recursivamente controlando o index, se chegar ate o final retorna true (não encontrou consoante ou outro caracter)
	public static boolean onlyVogal (String texto, int i){
		if(i == texto.length()){
			return true;
		}else{
			if (texto.charAt(i) != 'a' && texto.charAt(i) != 'e' && texto.charAt(i) != 'i' && texto.charAt(i) != 'o' && texto.charAt(i) != 'u'){
				return false;
			}else{
				return onlyVogal (texto, i+1);
			}
		}
	}

	// verifica se so tem consoante recursivamente controlando o index, se chegar ate o final retorna true (não encontrou vogal/numero ou outro caracter)
	public static boolean onlyConsoante (String texto, int i){
		if (i == texto.length()){
			return true;
		}else{
			char c = texto.charAt(i);
			c = Character.toLowerCase(c);
			if ("bcdfghijklmnpqrstvwxyz".indexOf(c) == -1)
			return false;
		}
			return onlyConsoante (texto, i+1);
	}


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
		Scanner sc = new Scanner (System.in);		
		String texto = sc.nextLine();
		while (!texto.equals("FIM")){
			System.out.println((onlyVogal(texto, 0) ? "SIM" : "NAO") + " " + (onlyConsoante(texto, 0) ? " SIM" : " NAO")  + " " + (isInt(texto) ? " SIM" : " NAO") + " " + (isReal (texto) ? "SIM" : "NAO"));
			texto = sc.nextLine();
		}
		sc.close();
	}

}
