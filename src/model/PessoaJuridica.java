package model;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String nomeFantasia;
    private String telefone;
    private String email;

    public PessoaJuridica(String cnpj, String nomeFantasia, String logradouro, String numero, String complemento, String cep, String telefone, String email) {
        super(cnpj, nomeFantasia, logradouro, numero, complemento, cep, email);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
