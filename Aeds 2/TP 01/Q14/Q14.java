import java.util.*;
import java.io.RandomAccessFile;
import java.io.IOException;

class Q14{
	
	int quant;

	public Q14 (){
		quant = 0;
	}

	public void lerDados (){
		try{
			RandomAccessFile saida = new RandomAccessFile ("saidas.txt", "rw");
			for (int i = 0; i < quant; i++){
				double aux;
				aux = MyIO.readDouble();
				saida.writeDouble(aux);
			}
			saida.close();
		}catch(IOException e){
			System.out.println ("Erro!!");
		}
	}

	public void ExibirDados(){
		try{
			RandomAccessFile saida = new RandomAccessFile ("saidas.txt", "rw");
			for (int i = quant; i > 0; i--){
				saida.seek((i-1)*8);
				MyIO.print("" + saida.readDouble());
			}
			saida.close();
		}catch(IOException e){
			System.out.println ("Erro!!");
		}
	}

	public static void main (String args[]){
		Q14 arquivo = new Q14();
		arquivo.quant = MyIO.readInt();
		arquivo.lerDados();
		arquivo.ExibirDados();
	}
}
