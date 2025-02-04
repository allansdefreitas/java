package br.edu.allan.study.streams.advanced;

import br.edu.allan.study.streams.statistics.Aluno;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        /* 1 - Streams Infinitos */
//        Stream
//                .iterate(1, n -> n + 1)
//                .limit(10)
//                .forEach(System.out::println);

        /* 2 - FlatMap */
//        List<List<String>> list = List.of(
//                List.of("a", "b"),
//                List.of("c", "d")
//        );
//
//        list.forEach(System.out::println);

        // Juntou tudo das listas, tornando tudo String
//        Stream<String> stream = list.stream()
//                .flatMap(Collection::stream);
//
//        stream.forEach(System.out::println);

        /* 3 - Redução de Streams */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        result.ifPresent(System.out::println); //prints 15

        List<Double> numbersDouble = List.of(1.5, 2.1, 3.0, 4.5, 5.5);
        Optional<Double> resultDouble = numbersDouble.stream().reduce(Double::sum);
        resultDouble.ifPresent(System.out::println); //prints
    }
}
