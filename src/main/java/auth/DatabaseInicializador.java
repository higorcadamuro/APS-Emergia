package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInicializador {
    // URL única para o banco (use o mesmo nome em toda a aplicação)
    private static final String DB_URL =
            "jdbc:sqlite:dados_usuarios.db" +
                    "?journal_mode=WAL" +
                    "&synchronous=NORMAL" +
                    "&locking_mode=NORMAL";

    // Bloco estático – roda ao carregar a classe
    static {
        initDatabase();
    }

    /** Cria a tabela se ainda não existir */
    public static void initDatabase() {
        String sql = """
            CREATE TABLE IF NOT EXISTS usuarios (
              id INTEGER PRIMARY KEY AUTOINCREMENT,
              nome TEXT NOT NULL,
              cpf_cnpj TEXT UNIQUE NOT NULL,
              telefone TEXT NOT NULL,
              email TEXT UNIQUE NOT NULL,
              salt TEXT NOT NULL,
              senha_hash TEXT NOT NULL
            );
            """;
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println(">>> Tabela 'usuarios' garantida no banco.");
        } catch (SQLException e) {
            System.err.println("[DatabaseInicializador] Erro ao criar tabela: " + e.getMessage());
        }
    }

    /** Sempre use este método para obter a conexão */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
