package auth;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class Security {
    public static String gerarSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashSenha(String senha, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String senhaComSalt = senha + salt;
            byte[] hash = md.digest(senhaComSalt.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer hash da senha", e);
        }
    }
}
