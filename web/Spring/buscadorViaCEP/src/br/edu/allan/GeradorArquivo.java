package br.edu.allan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    public void salvarArquivoJSON(Endereco endereco) throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter writting = new FileWriter(endereco.cep() + ".json");

        writting.write(gson.toJson(endereco));
        writting.close();


    }
}
