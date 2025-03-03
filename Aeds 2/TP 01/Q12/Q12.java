/*
 Linha de pensamento: 4 validadores, se um for falso a senha é invalida e retorna false; 4 condicionais para validar e caso falsas alteram a resposta para falsa e retorna a resposta.
*/

import java.util.*;

class Q12{

	public boolean validaSenha (String senha){
		
		boolean digito = false;
		boolean letraMinuscula = false;
		boolean letraMaiuscula = false;
		boolean caractere = false;

		for (char c : senha.toCharArray()){
		
			if (Character.isUpperCase(c)){
				letraMaiuscula = true;
			}else if (Character.isLowerCase(c)){
				letraMinuscula = true;
			}else if (Character.isDigit(c)){
				digito = true;
			}else if (!(Character.isLetterOrDigit(c))){
				caractere = true;
			}

		}
			return digito && letraMaiuscula && caractere && letraMinuscula;
		}

	public static void main (String args []){
	
		Scanner sc = new Scanner (System.in);
		String senha = sc.nextLine();
		Q12 valid = new Q12();
		while (!senha.equals ("FIM")){
			if (senha.length() < 8){
			System.out.println ("NÃO");
			}else{
			System.out.println (valid.validaSenha(senha) ? "SIM" : "NÃO");
			}
		senha = sc.nextLine();
		}
		sc.close();
	}

}
