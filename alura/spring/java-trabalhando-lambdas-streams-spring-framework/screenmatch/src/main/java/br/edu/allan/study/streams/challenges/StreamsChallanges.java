package br.edu.allan.study.streams.challenges;

import br.edu.allan.study.streams.challenges.entity.Produto;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsChallanges {


    public static void main(String[] args) {

        //  Concatenando elementos da lista
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");

        String resultado = nomes.stream()
                .collect(Collectors.joining(", "));
        System.out.println(resultado); // Esperado: "Alice, Bob, Charlie"


        // Reduzindo uma lista de inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        int somaDosQuadrados = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(somaDosQuadrados); // Esperado: 56 (4 + 16 + 36)

        // Particionando números ímpares e pares
        numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> particionado = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Pares: " + particionado.get(true));  // Esperado: [2, 4, 6]
        System.out.println("Ímpares: " + particionado.get(false)); // Esperado: [1, 3, 5]
        // Muito bom! Separa num Map os valores que satisfazem (ou não) determinda condição!

        //Agrupando produtos por categoria

        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Fone de Ouvido", 100.0, "Eletrônicos"),
                new Produto("Caneta", 5.0, "Papelaria")
        );

        System.out.println(produtos);

        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println(produtosPorCategoria);


        // Quantidade de produtos por categoria
        Map<String, Long> contagemPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));

        System.out.println(contagemPorCategoria);

        // Obtendo o produto mais caro de cada categoria
        Map<String, Optional<Produto>> maisCaroPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.maxBy(Comparator.comparingDouble(Produto::getValor))));

        System.out.println(maisCaroPorCategoria);

        // Soma dos valores por categoria
        Map<String, Double> somaPrecoPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.summingDouble(Produto::getValor)));

        System.out.println(somaPrecoPorCategoria);


    }
}
