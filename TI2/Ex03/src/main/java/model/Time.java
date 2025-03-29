package model;

public class Time {
    private int codigo;
    private String nome;
    private String estadio;
    private int fundacao;
    private String estado;

    // Construtor com parâmetros
    public Time(int codigo, String nome, String estadio, int fundacao, String estado) {
        setCodigo(codigo);
        setNome(nome);
        setEstadio(estadio);
        setFundacao(fundacao);
        setEstado(estado);
    }

    // Construtor padrão
    public Time() {
        this.codigo = -1;
        this.nome = "";
        this.estadio = "";
        this.fundacao = 0;
        this.estado = "";
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo > 0) { // Validação: código deve ser positivo
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("Código deve ser um número positivo.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) { // Validação: nome não pode ser vazio
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        }
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        if (estadio != null && !estadio.trim().isEmpty()) { // Validação: estádio não pode ser vazio
            this.estadio = estadio;
        } else {
            throw new IllegalArgumentException("Estádio não pode ser vazio ou nulo.");
        }
    }

    public int getFundacao() {
        return fundacao;
    }

    public void setFundacao(int fundacao) {
        if (fundacao > 0) { // Validação: fundação deve ser um valor positivo
            this.fundacao = fundacao;
        } else {
            throw new IllegalArgumentException("Ano de fundação deve ser um número positivo.");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado != null && !estado.trim().isEmpty()) { // Validação: estado não pode ser vazio
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("Estado não pode ser vazio ou nulo.");
        }
    }

    // Método toString para exibir informações sobre o time
    @Override
    public String toString() {
        return "Time: " + nome + "   Estádio: " + estadio + "   Fundação: " + fundacao + "   Estado: " + estado;
    }

    // Método equals para comparar objetos Time
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Time time = (Time) obj;
        return codigo == time.codigo;
    }

    // Método hashCode para garantir consistência com equals
    @Override
    public int hashCode() {
        return Integer.hashCode(codigo);
    }
}
