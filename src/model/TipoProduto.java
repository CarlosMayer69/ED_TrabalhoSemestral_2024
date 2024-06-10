package model;

public class TipoProduto {

    private String nome;

    public TipoProduto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "TipoProduto{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
