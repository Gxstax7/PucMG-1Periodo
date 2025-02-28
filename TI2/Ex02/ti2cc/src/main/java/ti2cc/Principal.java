package ti2cc;

import ti2cc.DAO;
import ti2cc.Time;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		Time time= new Time(9, "bahia", "fonte nova", 1931, "BA");
		if(dao.inserirTime(time) == true) {
			System.out.println("Inserção com sucesso -> " + time.toString());
		}
		
		//Mostrar times mineiros		
		System.out.println("==== Mostrar times de Minas Gerais=== ");
		Time[] times = dao.getTimesMineiros();
		for(int i = 0; i < times.length; i++) {
			System.out.println(times[i].toString());
		}

		
		//Atualizar time
		time.setEstadio("novo estadio");
		dao.atualizarTime(time);
		
		
		//Mostrar todos os times
		System.out.println("==== Mostrar times === ");
		times = dao.getTimes();
		for(int i = 0; i < times.length; i++) {
			System.out.println(times[i].toString());
		}
		
		//Excluir usuário
		dao.excluirTime(time.getCodigo());
		
		//Mostrar times
		times = dao.getTimes();
		System.out.println("==== Mostrar times=== ");		
		for(int i = 0; i < times.length; i++) {
			System.out.println(times[i].toString());
		}
		
		dao.close();
	}
}