package view.screens;

import view.components.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class MainMenu extends JFrame {
    private final String usuario;
    private BackgroundPanel contentPanel;
    private JLabel imagemLabel;
    private JLabel textoLabel;
    private int index = 0;

    private final String[] imagens = {
            "/imagens/Odum_Image.png",
            "/imagens/Odum_Image.png",
            "/imagens/Odum_Image.png",
            "/imagens/Odum_Image.png",
            "/imagens/Odum_Image.png"
    };

    private final String[] textos = {
            "<html><center><i>\"A emergia é a energia que a biosfera investe para produzir seus bens e serviços.\"</i><br>— H.T. Odum, 1996.</center></html>",
            "<html><center><i>\"A emergia permite avaliar a sustentabilidade ao considerar todos os fluxos de energia e matéria.\"</i><br>— Brown & Ulgiati, 2004.</center></html>",
            "<html><center><i>\"A emergia atribui valor a recursos naturais que não possuem preço de mercado.\"</i><br>— Ulgiati, 2001.</center></html>",
            "<html><center><i>\"A contabilidade emergética integra economia e ecologia, oferecendo uma visão holística.\"</i><br>— Brown & Ulgiati, 2004.</center></html>",
            "<html><center><i>\"A emergia é a energia usada direta e indiretamente para produzir um serviço ou produto.\"</i><br>— Ortega, 2005.</center></html>"
    };

    public MainMenu(String usuario) {
        super("Menu Principal");
        this.usuario = usuario;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        iniciarComponentes(usuario);
    }

    private void iniciarComponentes(String usuario) {
        // Configuração do painel do menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Color.decode("#2C2F33"));

        // Painel do usuário
        JPanel painelUsuario = criarPainelUsuario(usuario);

        // Painel de botões
        JPanel painelBotoes = criarPainelBotoes();

        // Carrossel de citações
        JPanel carrossel = criarCarrossel();

        // Botão Sair
        JPanel painelSair = criarPainelSair();

        // Montagem do menu
        menuPanel.add(painelUsuario);
        menuPanel.add(painelBotoes);
        menuPanel.add(carrossel);
        menuPanel.add(painelSair);

        // Configuração do painel de conteúdo
        contentPanel = new BackgroundPanel("/imagens/Menu_Page.jpg");
        contentPanel.setLayout(new BorderLayout());

        // Configuração do split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPanel, contentPanel);
        splitPane.setDividerLocation(250);
        splitPane.setEnabled(false);
        add(splitPane);

        iniciarCarrossel();
    }

    private JPanel criarPainelUsuario(String usuario) {
        JPanel painel = new JPanel();
        painel.setOpaque(false);
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        ImageIcon icone = new ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens/Logo_User.png")));
        Image imagemRedimensionada = icone.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        JLabel labelIcone = new JLabel(new ImageIcon(imagemRedimensionada));
        JLabel labelUsuario = new JLabel(usuario);
        labelUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
        labelUsuario.setForeground(Color.WHITE);
        labelUsuario.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        painel.add(Box.createRigidArea(new Dimension(20, 0)));
        painel.add(labelIcone);
        painel.add(labelUsuario);

        return painel;
    }

    private JPanel criarPainelBotoes() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setOpaque(false);

        String[] itens = {"Início", "Conceito", "Relatórios", "Metodologia", "Sobre Nós", "Calcular"};
        for (String texto : itens) {
            JButton botao = new JButton(texto);
            botao.setAlignmentX(Component.LEFT_ALIGNMENT);
            botao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            botao.setFont(new Font("Dialog", Font.BOLD, 16));
            botao.setForeground(texto.equals("Calcular") ? Color.decode("#D1A954") : Color.WHITE);
            botao.setOpaque(false);
            botao.setContentAreaFilled(false);
            botao.setBorderPainted(false);
            botao.setFocusPainted(false);
            botao.setHorizontalAlignment(SwingConstants.LEFT);

            switch (texto) {
                case "Conceito" -> botao.addActionListener(e -> mostrarPaginaConceito());
                case "Metodologia" -> botao.addActionListener(e -> mostrarPaginaMetodologia());
                case "Calcular" -> botao.addActionListener(e -> mostrarPaginaCalculo());
            }

            painel.add(Box.createRigidArea(new Dimension(20, 0)));
            painel.add(botao);
            painel.add(Box.createVerticalStrut(10));
        }

        return painel;
    }

    private JPanel criarCarrossel() {
        JPanel painel = new JPanel();
        painel.setOpaque(false);
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.add(Box.createVerticalStrut(150));

        imagemLabel = new JLabel();
        imagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagemLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        painel.add(imagemLabel);
        painel.add(Box.createVerticalStrut(10));

        textoLabel = new JLabel("", SwingConstants.CENTER);
        textoLabel.setForeground(Color.WHITE);
        textoLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
        textoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(textoLabel);

        return painel;
    }

    private JPanel criarPainelSair() {
        JButton botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Dialog", Font.BOLD, 18));
        botaoSair.setForeground(Color.decode("#D1A954"));
        botaoSair.setOpaque(false);
        botaoSair.setContentAreaFilled(false);
        botaoSair.setBorderPainted(false);
        botaoSair.setFocusPainted(false);
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.addActionListener(e -> System.exit(0));

        JPanel painel = new JPanel();
        painel.setOpaque(false);
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.add(Box.createVerticalGlue());
        painel.add(botaoSair);
        painel.add(Box.createVerticalStrut(20));

        return painel;
    }

    private void iniciarCarrossel() {
        atualizarCarrossel();
        Timer timer = new Timer(10000, e -> atualizarCarrossel());
        timer.start();
    }

    private void atualizarCarrossel() {
        URL url = getClass().getResource(imagens[index]);
        if (url != null) {
            Image imagem = new ImageIcon(url).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(new ImageIcon(imagem));
        }
        textoLabel.setText(textos[index]);
        index = (index + 1) % imagens.length;
    }

    private void mostrarPaginaCalculo() {
        contentPanel.removeAll();
        contentPanel.add(new TelaCalculo(), BorderLayout.CENTER);
        contentPanel.revalidate();
    }

    private void mostrarPaginaConceito() {
        contentPanel.removeAll();
        contentPanel.add(new TelaConceito(), BorderLayout.CENTER);
        contentPanel.revalidate();
    }

    private void mostrarPaginaMetodologia() {
        contentPanel.removeAll();
        contentPanel.add(new TelaMetodologia(), BorderLayout.CENTER);
        contentPanel.revalidate();
    }
}