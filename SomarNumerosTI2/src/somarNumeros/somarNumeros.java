package somarNumeros;
import java.util.*;

class somarNumeros {

	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int num1 = sc.nextInt();
		int num2 =sc.nextInt();
		System.out.println("Soma = " + (num1 + num2));
		sc.close();
	}
}
