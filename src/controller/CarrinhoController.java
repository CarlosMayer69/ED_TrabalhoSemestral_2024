package controller;

import model.Carrinho;
import model.Produto;

public class CarrinhoController {

    private Carrinho carrinho = new Carrinho();
    private ProdutoController produtoController = new ProdutoController();

    public void adicionarProduto(String codigo, int quantidade) {
        Produto produto = produtoController.getProduto(codigo);
        if (produto != null) {
            carrinho.adicionarProduto(produto, quantidade);
            System.out.println("Produto adicionado ao carrinho.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void removerProduto(String codigo) {
        Produto produto = produtoController.getProduto(codigo);
        if (produto != null) {
            carrinho.removerProduto(produto);
            System.out.println("Produto removido do carrinho.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void exibirCarrinho() {
        carrinho.exibirCarrinho();
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void resetCarrinho() {
        carrinho = new Carrinho();
    }
}
