package controller;

import java.util.HashMap;
import java.util.Map;

import data.CSVHandler;
import model.Produto;

public class ProdutoController {

    private Map<String, Produto> produtos = new HashMap<>();
    private CSVHandler csvHandler = new CSVHandler("produtos.csv");

    public ProdutoController() {
        carregarProdutos();
    }

    public void cadastrarProduto(String codigo, String nome, double valor, String descricao, int quantidade, String tipo) {
        if (!TipoProdutoController.tipoExiste(tipo)) {
            System.out.println("Tipo de produto não existe. Cadastre o tipo de produto primeiro.");
            return;
        }
        Produto produto = new Produto(codigo, nome, valor, descricao, quantidade, tipo);
        produtos.put(codigo, produto);
        salvarProdutos();
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void excluirProduto(String codigo) {
        if (produtos.remove(codigo) != null) {
            salvarProdutos();
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void consultarProdutos() {
        produtos.values().forEach(System.out::println);
    }

    private void carregarProdutos() {
        String[][] data = csvHandler.readCSV();
        if (data != null) {
            for (String[] row : data) {
                String codigo = row[0];
                String nome = row[1];
                double valor = Double.parseDouble(row[2]);
                String descricao = row[3];
                int quantidade = Integer.parseInt(row[4]);
                String tipo = row[5];
                produtos.put(codigo, new Produto(codigo, nome, valor, descricao, quantidade, tipo));
            }
        }
    }

    private void salvarProdutos() {
        String[][] data = new String[produtos.size()][6];
        int i = 0;
        for (Produto produto : produtos.values()) {
            data[i][0] = produto.getCodigo();
            data[i][1] = produto.getNome();
            data[i][2] = String.valueOf(produto.getValor());
            data[i][3] = produto.getDescricao();
            data[i][4] = String.valueOf(produto.getQuantidade());
            data[i][5] = produto.getTipo();
            i++;
        }
        csvHandler.writeCSV(data);
    }

	public Produto getProduto(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
}
