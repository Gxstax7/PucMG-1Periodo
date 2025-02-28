package ti2cc;

public class Time{
	private int codigo;
	private String nome;
	private String estadio;
	private String estado;
	private int fundacao;
	
	public Time() {
		this.codigo = -1;
		this.nome= "";
		this.estadio = "";
		this.estado = "";
		this.fundacao = 0;
	}
	
	public Time(int codigo, String nome, String estadio, int fundacao, String estado) {
		this.codigo = codigo;
		this.nome = nome;
		this.estadio = estadio;
		this.fundacao = fundacao;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String Nome) {
		this.nome = nome;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getFundacao() {
		return fundacao;
	}

	public void setFundacao(int fundacao) {
		this.fundacao = fundacao;
	}

	@Override
	public String toString() {
		return "Time [codigo=" + codigo + ", nome=" + nome + ", estadio=" + estadio + ", fundacao=" + fundacao + ", estado=" + estado+ "]";
	}	
}
