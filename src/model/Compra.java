package model;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;

public class Compra {

    private Queue<Produto> ordemProdutos;
    private double valorTotal;

    public Compra(Carrinho carrinho) {
        ordemProdutos = new LinkedList<>(carrinho.getProdutos().keySet());
        calcularValorTotal(carrinho);
    }

    private void calcularValorTotal(Carrinho carrinho) {
        valorTotal = 0;
        for (Map.Entry<Produto, Integer> entry : carrinho.getProdutos().entrySet()) {
            valorTotal += entry.getKey().getValor() * entry.getValue();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compra: \n");
        for (Produto produto : ordemProdutos) {
            sb.append(produto).append("\n");
        }
        sb.append("Valor Total: ").append(valorTotal);
        return sb.toString();
    }
}
