package view;

import controller.ClienteController;
import controller.ProdutoController;
import controller.TipoProdutoController;
import controller.CarrinhoController;
import controller.CompraController;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ProdutoController produtoController = new ProdutoController();
    private static TipoProdutoController tipoProdutoController = new TipoProdutoController();
    private static ClienteController clienteController = new ClienteController();
    private static CarrinhoController carrinhoController = new CarrinhoController();
    private static CompraController compraController = new CompraController();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Bem-vindo ao sistema de Backoffice");
            System.out.println("1. Gerenciar Tipos de Produtos");
            System.out.println("2. Gerenciar Produtos");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Gerenciar Carrinho de Compras");
            System.out.println("5. Consultar Compras Finalizadas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (option) {
                case 1:
                    manageTipoProduto();
                    break;
                case 2:
                    manageProduto();
                    break;
                case 3:
                    manageCliente();
                    break;
                case 4:
                    manageCarrinho();
                    break;
                case 5:
                    consultaCompras();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (option != 0);
    }

    private static void manageTipoProduto() {
        int option;
        do {
            System.out.println("Gerenciar Tipos de Produtos");
            System.out.println("1. Cadastrar Tipo de Produto");
            System.out.println("2. Excluir Tipo de Produto");
            System.out.println("3. Consultar Tipos de Produtos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do tipo de produto: ");
                    String nome = scanner.nextLine();
                    tipoProdutoController.cadastrarTipoProduto(nome);
                    break;
                case 2:
                    System.out.print("Digite o nome do tipo de produto a ser excluído: ");
                    String nomeExcluir = scanner.nextLine();
                    tipoProdutoController.excluirTipoProduto(nomeExcluir);
                    break;
                case 3:
                    tipoProdutoController.consultarTiposProdutos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (option != 0);
    }

    private static void manageProduto() {
        int option;
        do {
            System.out.println("Gerenciar Produtos");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Consultar Produtos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o código do produto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o valor do produto: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Digite o tipo de produto: ");
                    String tipo = scanner.nextLine();
                    produtoController.cadastrarProduto(codigo, nome, valor, descricao, quantidade, tipo);
                    break;
                case 2:
                    System.out.print("Digite o código do produto a ser excluído: ");
                    String codigoExcluir = scanner.nextLine();
                    produtoController.excluirProduto(codigoExcluir);
                    break;
                case 3:
                    produtoController.consultarProdutos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (option != 0);
    }

    private static void manageCliente() {
        int option;
        do {
            System.out.println("Gerenciar Clientes");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Consultar Clientes");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o tipo de cliente (PF/PJ): ");
                    String tipo = scanner.nextLine();
                    if (tipo.equalsIgnoreCase("PF")) {
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o logradouro: ");
                        String logradouro = scanner.nextLine();
                        System.out.print("Digite o número: ");
                        String numero = scanner.nextLine();
                        System.out.print("Digite o complemento: ");
                        String complemento = scanner.nextLine();
                        System.out.print("Digite o CEP: ");
                        String cep = scanner.nextLine();
                        System.out.print("Digite o celular: ");
                        String celular = scanner.nextLine();
                        clienteController.cadastrarClientePF(cpf, nome, logradouro, numero, complemento, cep, celular);
                    } else if (tipo.equalsIgnoreCase("PJ")) {
                        System.out.print("Digite o CNPJ: ");
                        String cnpj = scanner.nextLine();
                        System.out.print("Digite o nome fantasia: ");
                        String nomeFantasia = scanner.nextLine();
                        System.out.print("Digite o logradouro: ");
                        String logradouro = scanner.nextLine();
                        System.out.print("Digite o número: ");
                        String numero = scanner.nextLine();
                        System.out.print("Digite o complemento: ");
                        String complemento = scanner.nextLine();
                        System.out.print("Digite o CEP: ");
                        String cep = scanner.nextLine();
                        System.out.print("Digite o telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Digite o email: ");
                        String email = scanner.nextLine();
                        clienteController.cadastrarClientePJ(cnpj, nomeFantasia, logradouro, numero, complemento, cep, telefone, email);
                    } else {
                        System.out.println("Tipo de cliente inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o CPF/CNPJ do cliente a ser excluído: ");
                    String identificadorExcluir = scanner.nextLine();
                    clienteController.excluirCliente(identificadorExcluir);
                    break;
                case 3:
                    clienteController.consultarClientes();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (option != 0);
    }

    private static void manageCarrinho() {
        int option;
        do {
            System.out.println("Gerenciar Carrinho de Compras");
            System.out.println("1. Adicionar Produto ao Carrinho");
            System.out.println("2. Remover Produto do Carrinho");
            System.out.println("3. Exibir Carrinho");
            System.out.println("4. Finalizar Compra");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o código do produto a ser adicionado: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    carrinhoController.adicionarProduto(codigo, quantidade);
                    break;
                case 2:
                    System.out.print("Digite o código do produto a ser removido: ");
                    String codigoRemover = scanner.nextLine();
                    carrinhoController.removerProduto(codigoRemover);
                    break;
                case 3:
                    carrinhoController.exibirCarrinho();
                    break;
                case 4:
                    compraController.finalizarCompra();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (option != 0);
    }

    private static void consultaCompras() {
        compraController.consultarCompras();
    }
}

