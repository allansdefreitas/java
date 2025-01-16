package br.edu.allan.study.lambdas.unmodifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImutabilidadeExemplo {
    public static void main(String[] args) {
        List<String> listaOriginal = new ArrayList<>();
        listaOriginal.add("A");
        listaOriginal.add("B");

        List<String> listaImutavel = Collections.unmodifiableList(listaOriginal);

        // Tentativa de adicionar um elemento na lista imutável resultará em exceção
        listaImutavel.add("C"); // Lançará UnsupportedOperationException
    }
}