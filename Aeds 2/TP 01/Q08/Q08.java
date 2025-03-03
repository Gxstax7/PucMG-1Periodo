import java.util.*;

class Q08{
	
	public static int somaDigito (int numero){
		int soma = 0;
		if (numero <= 9){
			return numero;
		}else{
			return soma += numero % 10 + somaDigito (numero / 10);
		}
	}
	
	public static void main (String args []){
		int numero = MyIO.readInt();
		while (numero >= 0){
			try{
				System.out.println (somaDigito(numero));
				numero = MyIO.readInt();
			}catch(InputMismatchException e){
				break;
		}
	}
}
}

