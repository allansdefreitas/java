package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite o nome da obra: ");
		var titulo = leitura.nextLine();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.omdbapi.com/?t="+titulo+"&apikey=cd70d0b3")).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		String json = response.body();
		System.out.println(json); 

//		Gson gson = new Gson();
//		Titulo meuTitulo = gson.fromJson(json, Titulo.class);
//		System.out.println("Título: " + meuTitulo.getNome());
//		System.out.println(meuTitulo);
		
		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.create();
		TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
		System.out.println("Record: " + meuTituloOMDB);
		Titulo meuTitulo = new Titulo(meuTituloOMDB);
		
		System.out.println(meuTitulo);

	}

}
