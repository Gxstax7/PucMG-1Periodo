package dao;

import java.sql.*;
import model.Time;

public class TimeDAO {
	private Connection conexao;
	
	public TimeDAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "ti2";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "gustavoo";
		String password = "123";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirTime(Time time) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO times (codigo, nome, estadio, fundacao, estado) "
					       + "VALUES ("+time.getCodigo()+ ", '" + time.getNome() + "', '"  
					       + time.getEstadio() + "', " + time.getFundacao() + ", '" + time.getEstado() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarTime(Time time) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE times SET nome = '" + time.getNome() + "', estadio = '"  
				       + time.getEstadio() + "', fundacao = '" + time.getFundacao() + "', estado = '" + time.getEstado() + "'"
					   + " WHERE codigo = " + time.getCodigo();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirTime(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM times WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Time[] getTimes() {
		Time[] times = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM times");		
	         if(rs.next()){
	             rs.last();
	             times = new Time[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                times[i] = new Time(rs.getInt("codigo"), rs.getString("nome"), 
	                		                  rs.getString("estadio"), rs.getInt("fundacao"), rs.getString ("estado"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return times;
	}

	
	public Time[] getTimesMineiros() {
		Time[] times = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM times WHERE times.estado LIKE 'MG'");		
	         if(rs.next()){
	             rs.last();
	             times = new Time[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                times[i] = new Time(rs.getInt("codigo"), rs.getString("nome"), 
      		                  rs.getString("estadio"), rs.getInt("fundacao"), rs.getString ("estado"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return times;
	}
}