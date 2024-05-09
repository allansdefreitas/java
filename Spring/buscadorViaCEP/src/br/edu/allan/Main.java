package br.edu.allan;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConsultaCEP consultaCEP = new ConsultaCEP();
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite um número de CEP para consulta:");
        var cep = leitura.nextLine();

        try {
            Endereco endereco = consultaCEP.buscarEndereco(cep);
            System.out.println("Found address: " + endereco);
            GeradorArquivo geradorArquivo = new GeradorArquivo();
            geradorArquivo.salvarArquivoJSON(endereco);

        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
}