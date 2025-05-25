package model;

public class Usuario {
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String senhaHash;

    /** Construtor para inicializar todos os campos */
    public Usuario(String nome,
                   String cpfCnpj,
                   String telefone,
                   String email,
                   String senha) {
        this.nome      = nome;
        this.cpfCnpj   = cpfCnpj;
        this.telefone  = telefone;
        this.email     = email;
        // você está recebendo a senha em claro aqui, então
        // ou já a chama de senhaHash e espera que venha hash,
        // ou armazene em claro e deixe o hashing para UsuarioParaBD.
        this.senhaHash = senha;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
}
