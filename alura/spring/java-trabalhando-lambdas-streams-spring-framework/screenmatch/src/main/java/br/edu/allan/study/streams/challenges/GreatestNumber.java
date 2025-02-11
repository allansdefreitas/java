package br.edu.allan.study.streams.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GreatestNumber {
    // 1 - Dada a lista de números inteiros a seguir, encontre o maior número dela.
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> greatestNumber = numeros.stream()
                .reduce(Integer::max);

        if(greatestNumber.isPresent()){
            System.out.println("Greatest number: " + greatestNumber);
        }

        Optional<Integer> max = numeros.stream()
                .max(Integer::compare);
        max.ifPresent(System.out::println); // Esperado: 50
    }
}
