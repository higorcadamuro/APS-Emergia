package view.screens;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import auth.UsuarioParaBD;
import model.Usuario;

public class TelaCadastro extends JFrame {

    private final JTextField nomeField;
    private final JTextField cpfCnpjField;
    private final JTextField telefoneField;
    private final JTextField emailField;
    private final JPasswordField senhaField;

    public TelaCadastro() {
        super("Cadastro - Emergia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Background
        ImageIcon bgIcon = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/imagens/Login_Page.jpg"))
        );
        JLabel background = new JLabel(bgIcon);
        background.setLayout(null);
        setContentPane(background);

        // Painel translúcido
        JPanel registerPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 150));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        registerPanel.setOpaque(false);
        registerPanel.setBounds(100, 160, 600, 800);
        background.add(registerPanel);

        // Título
        JLabel title = new JLabel("CADASTRO", SwingConstants.CENTER);
        title.setBounds(0, 30, 600, 40);
        title.setFont(new Font("Dialog", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        registerPanel.add(title);

        // Campos
        int y = 100, espacamento = 80;
        nomeField     = criarCampo("Nome/Responsável", y,      registerPanel); y += espacamento;
        cpfCnpjField  = criarCampo("CPF/CNPJ",       y,       registerPanel); y += espacamento;
        telefoneField = criarCampo("Telefone",        y,       registerPanel); y += espacamento;
        emailField    = criarCampo("E-mail",          y,       registerPanel); y += espacamento;
        senhaField    = new JPasswordField();
        senhaField.setBounds(70, y + 30, 460, 40);
        senhaField.setFont(new Font("Dialog", Font.PLAIN, 16));
        registerPanel.add(new JLabel("Senha", SwingConstants.CENTER)) // label
                .setBounds(70, y, 460, 25);
        registerPanel.add(senhaField);
        y += espacamento;

        // Botão CADASTRAR
        JButton cadastrarButton = new JButton("CADASTRAR");
        cadastrarButton.setBounds(210, y + 10, 180, 40);
        cadastrarButton.setFont(new Font("Dialog", Font.BOLD, 18));
        cadastrarButton.setFocusPainted(false);
        cadastrarButton.addActionListener(e -> {
            String nome     = nomeField.getText().trim();
            String cpfCnpj  = cpfCnpjField.getText().trim();
            String telefone = telefoneField.getText().trim();
            String email    = emailField.getText().trim();
            String senha    = new String(senhaField.getPassword()).trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha todos os campos obrigatórios.",
                        "Dados incompletos",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario usuario = new Usuario(nome, cpfCnpj, telefone, email, senha);
            boolean ok = UsuarioParaBD.cadastrar(usuario);
            if (ok) {
                JOptionPane.showMessageDialog(this,
                        "Conta criada com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new TelaLogin().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Falha ao criar conta. Email pode já existir.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        registerPanel.add(cadastrarButton);

        // Botão VOLTAR
        JButton voltarButton = new JButton("VOLTAR");
        voltarButton.setBounds(210, y + 70, 180, 40);
        voltarButton.setFont(new Font("Dialog", Font.BOLD, 18));
        voltarButton.setFocusPainted(false);
        voltarButton.addActionListener(e -> {
            dispose();
            new TelaLogin().setVisible(true);
        });
        registerPanel.add(voltarButton);
    }

    private JTextField criarCampo(String rotulo, int y, JPanel panel) {
        JLabel label = new JLabel(rotulo, SwingConstants.CENTER);
        label.setBounds(70, y, 460, 25);
        label.setFont(new Font("Dialog", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JTextField campo = new JTextField();
        campo.setBounds(70, y + 30, 460, 40);
        campo.setFont(new Font("Dialog", Font.PLAIN, 16));
        panel.add(campo);
        return campo;
    }
}
