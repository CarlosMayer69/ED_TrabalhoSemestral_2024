package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Carrinho {

    private Map<Produto, Integer> produtos;
    private Stack<Produto> ordemProdutos;

    public Carrinho() {
        produtos = new HashMap<>();
        ordemProdutos = new Stack<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade);
        ordemProdutos.push(produto);
    }

    public void removerProduto(Produto produto) {
        if (produtos.containsKey(produto)) {
            produtos.remove(produto);
            ordemProdutos.remove(produto);
        }
    }

    public boolean estaVazio() {
        return produtos.isEmpty();
    }

    public void exibirCarrinho() {
        for (Produto produto : ordemProdutos) {
            System.out.println(produto + " - Quantidade: " + produtos.get(produto));
        }
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }
}
