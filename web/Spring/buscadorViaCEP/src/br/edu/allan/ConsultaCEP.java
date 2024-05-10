package br.edu.allan;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {


    public Endereco buscarEndereco(String cep){
        URI enderecoRequest = URI.create("https://viacep.com.br/ws/"+cep+"/json/");

          HttpRequest request = HttpRequest.newBuilder()
                .uri(enderecoRequest)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException("Couldn't get address from this CEP " + e.getMessage());
        }


    }
}
