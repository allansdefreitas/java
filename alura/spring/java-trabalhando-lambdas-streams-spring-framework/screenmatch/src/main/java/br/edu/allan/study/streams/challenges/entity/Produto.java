package br.edu.allan.study.streams.challenges.entity;

public class Produto {


    private String nome;
    private double valor;
    private String categoria;

    public Produto(String nome, double valor, String categoria) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
