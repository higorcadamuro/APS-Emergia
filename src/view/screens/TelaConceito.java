package view.screens;

import javax.swing.*;
import java.awt.*;

public class TelaConceito extends JPanel {

    public TelaConceito() {
        setLayout(new BorderLayout());
        setBackground(new Color(209, 169, 84)); // cor de fundo

        // Painel central com layout absoluto para os componentes fixos
        JPanel painelConteudo = new JPanel(null);
        painelConteudo.setOpaque(false);

        // Título
        JLabel titulo = new JLabel("Conceito", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        titulo.setForeground(new Color(33, 33, 33));
        titulo.setBounds(0, 30, 1600, 50); // largura grande para centralizar
        painelConteudo.add(titulo);

        // Linha dourada abaixo do título
        JSeparator linha = new JSeparator();
        linha.setForeground(new Color(194, 145, 58));
        linha.setBackground(new Color(194, 145, 58));
        linha.setBounds(785, 80, 50, 5); // centralizado
        painelConteudo.add(linha);

        // Imagem ilustrativa
        ImageIcon img = new ImageIcon(getClass().getResource("/View/Resources/imagens/Farm_Image.jpg"));
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 100, 1600, 200);
        painelConteudo.add(imgLabel);

        add(painelConteudo, BorderLayout.CENTER);
    }
}