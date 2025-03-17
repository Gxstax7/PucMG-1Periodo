import java.util.*;

class Q11{

	// metodo controla dois index para capturar qualquer repetição e encerrar a substring, caso seja maior que a anterior, assume seu valor e a maior substring é retornada
	public static int maiorSubstring (String frase){
        int maior = 0, cont = 0, index = 0;

        for (int i = 0; i < frase.length(); i++) {
        	for (int j = index; j < i; j++) {
                	if (frase.charAt(j) == frase.charAt(i)) {      
                    		index = j + 1;
                    		break;
                	}
            	}

        	cont = i - index + 1;

            	if (cont > maior){
                	maior = cont;
            	}

        }

        return maior;

	}

	public static void main (String args[]){
		Scanner scanner = new Scanner (System.in);
		String frase = scanner.nextLine();
		
		while(!frase.equals("FIM")){
			MyIO.println(maiorSubstring(frase));
			frase = scanner.nextLine();
		}
		scanner.close();
	}

}
