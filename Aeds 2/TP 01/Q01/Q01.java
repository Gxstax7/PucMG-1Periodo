import java.util.*;
import java.util.Scanner;

public class Q01 {
  
  String frase;
  
  Q01 (String frase){	//construtor
    this.frase = frase;
  }
  
  public void atualiza (String frase){	//atualiza para nova frase
    this.frase = frase;
  }
   
  private boolean isPalindromo(Q01 texto) {	// função booleana para retornar se a mesma é palindromo
      boolean resp = true;
      for (int i = 0; i < texto.frase.length() / 2; i++) {
          if (texto.frase.charAt(i) != texto.frase.charAt(texto.frase.length() - i - 1)){ //condicional que compara a primeira e ultima letra, em caso de divergencia altera para false
              resp = false;
              break;
          }
      }
      return resp;
  }
    
  
    public static void main(String[] args) {
      String texto;
      texto = MyIO.readLine ();
      Q01 teste = new Q01 (texto);

      while(!(teste.frase.equals("FIM"))){

      	if (teste.isPalindromo(teste)){
        	System.out.println("SIM");
      	}else{
        	System.out.println("NAO");
      	}

      	texto = MyIO.readLine ();
      	teste.atualiza(texto);
      }
  }
  
}
