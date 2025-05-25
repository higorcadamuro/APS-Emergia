package view.screens;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import net.miginfocom.swing.MigLayout;

public class TelaConceito extends JPanel {

    public TelaConceito() {
        setLayout(new BorderLayout());
        setBackground(new Color(209, 169, 84)); // cor de fundo

        // Painel central com layout MigLayout fixando posição
        JPanel painelConteudo = new JPanel(new MigLayout("insets 0, fill", "[grow]", "[grow]"));
        painelConteudo.setOpaque(false);

        // Painel interno absoluto, centralizado e com tamanho fixo
        JPanel painelAbsoluto = new JPanel(null);
        painelAbsoluto.setOpaque(false);
        painelAbsoluto.setPreferredSize(new Dimension(1600, 400));

        // Título
        JLabel titulo = new JLabel("Conceito", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        titulo.setForeground(new Color(33, 33, 33));
        titulo.setBounds(0, 30, 1600, 50);
        painelAbsoluto.add(titulo);

        // Linha dourada abaixo do título
        JSeparator linha = new JSeparator();
        linha.setForeground(new Color(194, 145, 58));
        linha.setBackground(new Color(194, 145, 58));
        linha.setBounds(785, 80, 50, 5);
        painelAbsoluto.add(linha);

        // Imagem ilustrativa
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens/Farm_Image.jpg")));
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 100, 1600, 200);
        painelAbsoluto.add(imgLabel);

        // Adiciona o painel absoluto centralizado no painel com MigLayout
        painelConteudo.add(painelAbsoluto, "align center center");

        // Insere no centro da tela
        add(painelConteudo, BorderLayout.CENTER);
    }
}
