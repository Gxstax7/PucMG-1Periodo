import java.util.*;

class Q16{

	public static boolean isPalindromo(String frase, int i, int j){
		if (j < i){
			return true;
		}else{
			if (frase.charAt(i) == frase.charAt(j)){
				return isPalindromo (frase, i+1, j-1);
			}else{
				return false;
			}
		}
	}

	public static void main (String args[]){
		Scanner sc = new Scanner (System.in);
		String frase = sc.nextLine();
		while (!frase.equals("FIM")){
			System.out.println(isPalindromo(frase, 0, frase.length() - 1) ? "SIM" : "NAO");
			frase = sc.nextLine();	
		}
		sc.close();
	}
}
