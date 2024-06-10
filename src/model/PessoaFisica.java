package model;

public class PessoaFisica extends Cliente {

    private String cpf;
    private String celular;

    public PessoaFisica(String cpf, String nome, String logradouro, String numero, String complemento, String cep, String celular) {
        super(cpf, nome, logradouro, numero, complemento, cep, celular);
        this.cpf = cpf;
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCelular() {
        return celular;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
