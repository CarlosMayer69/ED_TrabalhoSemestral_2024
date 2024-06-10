package view;//Precisa ser finalizado!

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JPanel contentPane;
    private JTextField tfNomeProduto;
    private JTextField tfValorProduto;
    private JTextField tfDescricaoProduto;
    private JTextField tfQuantidadeProduto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainWindow() {
        setTitle("Sistema de Backoffice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        JPanel panelProduto = new JPanel();
        tabbedPane.addTab("Produto", null, panelProduto, null);
        panelProduto.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel lblNomeProduto = new JLabel("Nome:");
        panelProduto.add(lblNomeProduto);

        tfNomeProduto = new JTextField();
        panelProduto.add(tfNomeProduto);
        tfNomeProduto.setColumns(10);

        JLabel lblValorProduto = new JLabel("Valor:");
        panelProduto.add(lblValorProduto);

        tfValorProduto = new JTextField();
        panelProduto.add(tfValorProduto);
        tfValorProduto.setColumns(10);

        JLabel lblDescricaoProduto = new JLabel("Descrição:");
        panelProduto.add(lblDescricaoProduto);

        tfDescricaoProduto = new JTextField();
        panelProduto.add(tfDescricaoProduto);
        tfDescricaoProduto.setColumns(10);

        JLabel lblQuantidadeProduto = new JLabel("Quantidade:");
        panelProduto.add(lblQuantidadeProduto);

        tfQuantidadeProduto = new JTextField();
        panelProduto.add(tfQuantidadeProduto);
        tfQuantidadeProduto.setColumns(10);

        JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
        btnCadastrarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui é a lógica para cadastrar produto
            }
        });
        panelProduto.add(btnCadastrarProduto);

        JButton btnExcluirProduto = new JButton("Excluir Produto");
        btnExcluirProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui é a lógica para excluir produto
            }
        });
        panelProduto.add(btnExcluirProduto);

        JButton btnConsultarProduto = new JButton("Consultar Produto");
        btnConsultarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui é a lógica para consultar produto
            }
        });
        panelProduto.add(btnConsultarProduto);

        // Falta adicionar outros painéis e componentes para tipos de produtos, clientes, etc!

        JPanel panelCliente = new JPanel();
        tabbedPane.addTab("Cliente", null, panelCliente, null);
        panelCliente.setLayout(new GridLayout(0, 2, 10, 10));

        // Reservar campos e botões para cadastro, exclusão e consulta de clientes!
    }
}
