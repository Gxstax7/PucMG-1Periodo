import java.util.*;

class Q06 {

	public static boolean onlyVogal (String texto){
		boolean resp = true;
		for (int i = 0; i < texto.length(); i++){
			if (texto.charAt(i) != 'a' && texto.charAt(i) != 'e' && texto.charAt(i) != 'i' && texto.charAt(i) != 'o' && texto.charAt(i) != 'u')
				resp = false;
		}
		return resp;
	}

	public static boolean onlyConsoante (String texto){
		boolean resp = true;
		for (char c : texto.toCharArray()){
			c = Character.toLowerCase(c);
			if ("bcdfghijklmnpqrstvwxyz".indexOf(c) == -1)
				resp = false;
		}
		return resp;
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
			System.out.println((onlyVogal(texto) ? "SIM" : "NAO") + " " + (onlyConsoante(texto) ? " SIM" : " NAO")  + " " + (isInt(texto) ? " SIM" : " NAO") + " " + (isReal (texto) ? "SIM" : "NAO"));
			texto = sc.nextLine();
		}
		sc.close();
	}

}
