import java.util.*;

class Q08{
	
	// metodo recursivo que soma o ultimo digito e por ser inteiro passa a divisao por 10 sem o ultimo digito, caso base (num <=9) pois a divisao por 10 não sera mais possivel
	public static int somaDigito (int numero){

		int soma = 0;

		if (numero <= 9){
			return numero;
		}else{
			return soma += numero % 10 + somaDigito (numero / 10);
		}
	}
	
	public static void main (String args []){
		Scanner sc = new Scanner (System.in);
		int numero = sc.nextInt();
		while (numero >= 0){
			try{
				System.out.println (somaDigito(numero));
				numero = sc.nextInt();
			}catch(InputMismatchException e){
				break;
		}
	}
	sc.close();
}
}

