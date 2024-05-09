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

import br.com.alura.screenmatch.exception.ErrorYearConversionException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite o nome da obra: ");
		var tituloBusca = leitura.nextLine();

		tituloBusca = tituloBusca.replace(" ", "+");
		String address = "https://www.omdbapi.com/?t=" + tituloBusca + "&apikey=cd70d0b3";
		
		try {

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(address)).build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			String json = response.body();
			System.out.println("JSON: " + json);

//			Gson gson = new Gson();
//			Titulo meuTitulo = gson.fromJson(json, Titulo.class);
//			System.out.println("Título: " + meuTitulo.getNome());
//			System.out.println(meuTitulo);

			Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

			TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
			System.out.println("Record: " + meuTituloOMDB);

//		try {
			Titulo meuTitulo = new Titulo(meuTituloOMDB);
			System.out.println("meuTitulo: " + meuTitulo);
		} catch (NumberFormatException ex) {
			System.out.println("An error occured: " + ex.getMessage());
		}catch(IllegalArgumentException ex) {
			System.out.println("An error occured: " + ex.getMessage());
//			ex.printStackTrace();
		}catch(ErrorYearConversionException ex) {
			System.out.println("An error occured: " + ex.getMessage());
		}
		catch(NullPointerException | IllegalStateException ex) {
			System.out.println("Multicatch example: " + ex.getMessage());
		}
		finally {
			System.out.println("The program finished successfully");
		}
		
//		System.exit(0);

	}

}
