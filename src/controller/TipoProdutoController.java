package controller;

import java.util.HashSet;
import java.util.Set;

import data.CSVHandler;

public class TipoProdutoController {

    private static Set<String> tipos = new HashSet<>();
    private CSVHandler csvHandler = new CSVHandler("tipos_produtos.csv");

    public TipoProdutoController() {
        carregarTiposProdutos();
    }

    public void cadastrarTipoProduto(String nome) {
        if (tipos.add(nome)) {
            salvarTiposProdutos();
            System.out.println("Tipo de produto cadastrado com sucesso.");
        } else {
            System.out.println("Tipo de produto já existe.");
        }
    }

    public void excluirTipoProduto(String nome) {
        if (tipos.remove(nome)) {
            salvarTiposProdutos();
            System.out.println("Tipo de produto excluído com sucesso.");
        } else {
            System.out.println("Tipo de produto não encontrado.");
        }
    }

    public void consultarTiposProdutos() {
        tipos.forEach(System.out::println);
    }

    private void carregarTiposProdutos() {
        String[][] data = csvHandler.readCSV();
        if (data != null) {
            for (String[] row : data) {
                tipos.add(row[0]);
            }
        }
    }

    private void salvarTiposProdutos() {
        String[][] data = new String[tipos.size()][1];
        int i = 0;
        for (String tipo : tipos) {
            data[i][0] = tipo;
            i++;
        }
        csvHandler.writeCSV(data);
    }

    public static boolean tipoExiste(String nome) {
        return tipos.contains(nome);
    }
}

