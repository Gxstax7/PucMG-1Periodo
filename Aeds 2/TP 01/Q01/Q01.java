import java.util.*;
import java.util.Scanner;

public class Q01 {
  
  String frase;
  
  Q01 (String frase){
    this.frase = frase;
  }
  
  public void atualiza (String frase){
    this.frase = frase;
  }
   
  private boolean isPalindromo(Q01 texto) {
      boolean resp = true;
      for (int i = 0; i < texto.frase.length() / 2; i++) {
          if (texto.frase.charAt(i) != texto.frase.charAt(texto.frase.length() - i - 1)) {
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
