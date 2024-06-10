package controller;

import model.Compra;
import model.Carrinho;
import data.CSVHandler;
import java.util.Queue;
import java.util.LinkedList;

public class CompraController {

    private Queue<Compra> comprasFinalizadas = new LinkedList<>();
    private CSVHandler csvHandler = new CSVHandler("compras.csv");
    private CarrinhoController carrinhoController = new CarrinhoController();

    public CompraController() {
        carregarCompras();
    }

    public void finalizarCompra() {
        Carrinho carrinho = carrinhoController.getCarrinho();
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho está vazio.");
            return;
        }
        Compra compra = new Compra(carrinho);
        comprasFinalizadas.add(compra);
        salvarCompras();
        carrinhoController.resetCarrinho();
        System.out.println("Compra finalizada com sucesso.");
    }

    public void consultarCompras() {
        comprasFinalizadas.forEach(System.out::println);
    }

    private void carregarCompras() {
        String[][] data = csvHandler.readCSV();
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
				String[] row = data[i];
			}
        }
    }

    private void salvarCompras() {
        // Implementar salvamento de compras no CSV
    }
}
