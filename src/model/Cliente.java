package model;

public class Cliente {
    private String cpf;
    protected String nome;
    protected Endereco endereco;
    private String celular;

    public Cliente(String cpf, String nome, String logradouro, String numero, String complemento, String cep, String celular) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = new Endereco(logradouro, numero, complemento, cep);
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getCelular() {
        return celular;
    }

    public String toCSV() {
        return cpf + "," + nome + "," + endereco.toCSV() + "," + celular;
    }

    public static Cliente fromCSV(String csv) {
        String[] parts = csv.split(",");
        Endereco endereco = new Endereco(parts[2], parts[3], parts[4], parts[5]);
        return new Cliente(parts[0], parts[1], endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getCep(), parts[6]);
    }
}
