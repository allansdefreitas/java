package br.edu.allan.screenmatch.housework.generics;

import br.edu.allan.screenmatch.model.DadosSerie;

class Pessoa{
    String nome;
    Integer idade;

    public Pessoa(String nome) {
        this.nome = nome;
    }
}
public class TestaCaixa {
    public static void main(String[] args) {
        Caixa<String> caixaDeTexto = new Caixa();
        caixaDeTexto.setConteudo("Guardando texto na minha caixa!");

        Caixa<Integer> caixaDeIdade = new Caixa();
        caixaDeIdade.setConteudo(30);

        Caixa<Double> caixaDeValor = new Caixa<>();
        caixaDeValor.setConteudo(150.50);

        Caixa<Pessoa> caixaDeDadosSerie = new Caixa<>();
        caixaDeDadosSerie.setConteudo(new Pessoa("John"));

        System.out.println(caixaDeValor.somaConteudoNaCaixa(350.50));
        System.out.println(caixaDeValor.getConteudo());
        System.out.println(caixaDeValor.somaConteudoNaCaixa("texto"));
    }
}
