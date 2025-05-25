package view.screens;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import net.miginfocom.swing.MigLayout;

public class TelaConceito extends JPanel {

    public TelaConceito() {
        setLayout(new BorderLayout());
        setBackground(new Color(209, 169, 84)); // cor de fundo

        // Painel central com MigLayout preenchendo tudo
        JPanel painelConteudo = new JPanel(new MigLayout("insets 0, fill", "[grow]", "[grow]"));
        painelConteudo.setOpaque(false);

        // Painel interno que se adapta responsivamente
        JPanel painelResponsivo = new JPanel(new MigLayout("wrap 1, align center", "[grow, center]", ""));
        painelResponsivo.setOpaque(false);

        // ====== TÍTULO ======
        JLabel titulo = new JLabel("Conceito", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        titulo.setForeground(new Color(33, 33, 33));
        painelResponsivo.add(titulo, "gapbottom 10");

        // ====== LINHA DECORATIVA ======
        JSeparator linha = new JSeparator();
        linha.setForeground(new Color(194, 145, 58));
        linha.setBackground(new Color(194, 145, 58));
        painelResponsivo.add(linha, "growx, gapbottom 20");

        // ====== IMAGEM ILUSTRATIVA ======
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens/Farm_Image.jpg")));
        JLabel imgLabel = new JLabel(img);
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        painelResponsivo.add(imgLabel, "growx, center");

        // Adiciona o painel interno centralizado
        painelConteudo.add(painelResponsivo, "align center center, grow");

        // Adiciona ao centro da tela
        add(painelConteudo, BorderLayout.CENTER);
    }

    // 👇 Classe de teste embutida (Main)
    public static class MainConceito {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Teste - Tela Conceito");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setContentPane(new TelaConceito());
                frame.setVisible(true);
            });
        }
    }
}
