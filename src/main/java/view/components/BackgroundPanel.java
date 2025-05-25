package view.components;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image bgImage;

    public BackgroundPanel(String imagePath) {
        try {
            bgImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem: " + imagePath);
        }
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}