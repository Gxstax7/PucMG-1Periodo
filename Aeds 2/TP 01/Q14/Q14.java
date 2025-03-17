import java.util.*;
import java.io.RandomAccessFile;
import java.io.IOException;

class Q14{
	
	int quant;
	
	//construtor padrão pois a quantidade é importante ser lidada com uma "variavel global"
	public Q14 (){
		quant = 0;
	}

	// metodo para ler dados do teclado no terminal e salva-los no arquvivo "saidas.txt"
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

	//metodo para ler dados do arquivo controlando o seek para posicionar o ponteiro em posição decrescente, multiplicando por 8 pois é o tamanho que double ocupa (8 bytes)
	public void ExibirDados(){
		try{
			RandomAccessFile saida = new RandomAccessFile ("saidas.txt", "rw");
			for (int i = quant; i > 0; i--){
				saida.seek((i-1)*8);
				double aux = saida.readDouble();
				if(isInt(aux)){
					System.out.println("" + (int)aux);
				}else{
					System.out.println("" + aux);
				}
			}
			saida.close();
		}catch(IOException e){
			System.out.println ("Erro!!");
		}
	}

	// metodo para lidar com valores inteiros pois a saida devera ser com menor quantidade de casas decimais possiveis (Ex: 841.0 -> 841)
	public boolean isInt(double valor){
		if (valor == (int) valor){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main (String args[]){
		Q14 arquivo = new Q14();

		arquivo.quant = MyIO.readInt();
		arquivo.lerDados();
		arquivo.ExibirDados();
	}
}
