package controller;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import data.CSVHandler;
import java.util.HashMap;
import java.util.Map;

public class ClienteController {

    private Map<String, Cliente> clientes = new HashMap<>();
    private CSVHandler csvHandler = new CSVHandler("clientes.csv");

    public ClienteController() {
        carregarClientes();
    }

    public void cadastrarClientePF(String cpf, String nome, String logradouro, String numero, String complemento, String cep, String celular) {
        Cliente cliente = new PessoaFisica(cpf, nome, logradouro, numero, complemento, cep, celular);
        clientes.put(cpf, cliente);
        salvarClientes();
        System.out.println("Cliente PF cadastrado com sucesso.");
    }

    public void cadastrarClientePJ(String cnpj, String nomeFantasia, String logradouro, String numero, String complemento, String cep, String telefone, String email) {
        Cliente cliente = new PessoaJuridica(cnpj, nomeFantasia, logradouro, numero, complemento, cep, telefone, email);
        clientes.put(cnpj, cliente);
        salvarClientes();
        System.out.println("Cliente PJ cadastrado com sucesso.");
    }

    public void excluirCliente(String identificador) {
        if (clientes.remove(identificador) != null) {
            salvarClientes();
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void consultarClientes() {
        clientes.values().forEach(System.out::println);
    }

    private void carregarClientes() {
        String[][] data = csvHandler.readCSV();
        if (data != null) {
            for (String[] row : data) {
                String tipo = row[0];
                if (tipo.equals("PF")) {
                    clientes.put(row[1], new PessoaFisica(row[1], row[2], row[3], row[4], row[5], row[6], row[7]));
                } else if (tipo.equals("PJ")) {
                    clientes.put(row[1], new PessoaJuridica(row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]));
                }
            }
        }
    }

    private void salvarClientes() {
        String[][] data = new String[clientes.size()][9];
        int i = 0;
        for (Cliente cliente : clientes.values()) {
            if (cliente instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) cliente;
                data[i][0] = "PF";
                data[i][1] = pf.getCpf();
                data[i][2] = pf.getNome();
                data[i][3] = pf.getEndereco().getLogradouro();
                data[i][4] = pf.getEndereco().getNumero();
                data[i][5] = pf.getEndereco().getComplemento();
                data[i][6] = pf.getEndereco().getCep();
                data[i][7] = pf.getCelular();
            } else if (cliente instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) cliente;
                data[i][0] = "PJ";
                data[i][1] = pj.getCnpj();
                data[i][2] = pj.getNomeFantasia();
                data[i][3] = pj.getEndereco().getLogradouro();
                data[i][4] = pj.getEndereco().getNumero();
                data[i][5] = pj.getEndereco().getComplemento();
                data[i][6] = pj.getEndereco().getCep();
                data[i][7] = pj.getTelefone();
                data[i][8] = pj.getEmail();
            }
            i++;
        }
        csvHandler.writeCSV(data);
    }
}
