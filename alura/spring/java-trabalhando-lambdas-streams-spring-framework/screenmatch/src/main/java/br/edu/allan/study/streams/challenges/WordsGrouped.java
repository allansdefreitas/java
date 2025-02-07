package br.edu.allan.study.streams.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// 2 -Dada a lista de palavras (strings) abaixo, agrupe-as pelo seu tamanho.
// No código a seguir, há um exemplo prático do resultado esperado.
public class WordsGrouped {
        public static void main(String[] args) {
            List<String> words = Arrays.asList("java", "stream", "lambda", "code");

            // código do agrupamento
            Map< Integer, List<String> > groupedWords = words.stream()
                    .collect(Collectors.groupingBy(String::length));

            System.out.println(groupedWords);

            // Resultado Esperado: {4=[java, code], 6=[stream, lambda]}
        }
    }
