package auth;

import model.Usuario;
import java.sql.*;

public class UsuarioParaBD {
    private static final String TABELA = "usuarios";

    public static boolean cadastrar(Usuario usuario) {
        String sql = "INSERT INTO " + TABELA +
                " (nome, cpf_cnpj, telefone, email, salt, senha_hash) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = DatabaseInicializador.getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            conexao.setAutoCommit(false);

            String salt = Security.gerarSalt();
            String senhaHash = Security.hashSenha(usuario.getSenhaHash(), salt);

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpfCnpj());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, salt);
            pstmt.setString(6, senhaHash);

            pstmt.executeUpdate();
            conexao.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean autenticar(String email, String senha) {
        String sql = "SELECT senha_hash, salt FROM usuarios WHERE email = ?";

        try (Connection conexao = DatabaseInicializador.getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String hashArmazenado = rs.getString("senha_hash");
                String salt = rs.getString("salt");

                String hashDigitado = Security.hashSenha(senha, salt);
                return hashArmazenado.equals(hashDigitado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
