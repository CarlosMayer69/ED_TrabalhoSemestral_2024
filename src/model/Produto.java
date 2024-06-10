package model;

public class Produto {

    private String codigo;
    private String nome;
    private double valor;
    private String descricao;
    private int quantidade;
    private String tipo;

    public Produto(String codigo, String nome, double valor, String descricao, int quantidade, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
