import view.screens.TelaLogin;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);  // Inicia sua aplicação
        });
    }
}