package model;

//Classe que representa um insumo para cálculo de emergia.

public class Insumo {
    private final String nome;
    private final double renovavel;
    private final double naoRenovavel;
    private final double economico;
    private final double uev;
    private final String unidade;

    public Insumo(String nome, double renovavel, double naoRenovavel,
                  double economico, double uev, String unidade) {
        this.nome = nome;
        this.renovavel = renovavel;
        this.naoRenovavel = naoRenovavel;
        this.economico = economico;
        this.uev = uev;
        this.unidade = unidade;
    }

    // Getters
    public String getNome() { return nome; }
    public double getRenovavel() { return renovavel; }
    public double getNaoRenovavel() { return naoRenovavel; }
    public double getEconomico() { return economico; }
    public double getUev() { return uev; }
    public String getUnidade() { return unidade; }
}