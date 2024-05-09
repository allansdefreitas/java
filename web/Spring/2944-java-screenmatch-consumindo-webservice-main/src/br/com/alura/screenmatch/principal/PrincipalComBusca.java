package br.com.alura.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.exception.ErrorYearConversionException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {

		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.setPrettyPrinting()
				.create();
		
		Scanner leitura = new Scanner(System.in);
		var tituloBusca = "";
		
		List<Titulo> titulos = new ArrayList<Titulo>();
		

		while (true) {

			System.out.println("Digite o nome da obra: ");
			tituloBusca = leitura.nextLine();

			if (tituloBusca.equalsIgnoreCase("Exit")) {
				break;
			}
			
			tituloBusca = tituloBusca.replace(" ", "+");
			String address = "https://www.omdbapi.com/?t=" + tituloBusca + "&apikey=cd70d0b3";

			try {

				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();

				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

				String json = response.body();
				System.out.println("JSON: " + json);

//			Gson gson = new Gson();
//			Titulo meuTitulo = gson.fromJson(json, Titulo.class);
//			System.out.println("Título: " + meuTitulo.getNome());
//			System.out.println(meuTitulo);


				TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
				System.out.println("Record: " + meuTituloOMDB);

				Titulo meuTitulo = new Titulo(meuTituloOMDB);
				System.out.println("Titulo convertido: " + meuTitulo);

				titulos.add(meuTitulo);
				
//				FileWriter writting = new FileWriter("movies.txt");
//				writting.write(tituloBusca);
//				writting.close();

			} catch (NumberFormatException ex) {
				System.out.println("An error occured: " + ex.getMessage() + ex.getClass());
			} catch (IllegalArgumentException ex) {
				System.out.println("An error occured: " + ex.getMessage() + ex.getClass());
//			ex.printStackTrace();
			} catch (ErrorYearConversionException ex) {
				System.out.println("An error occured: " + ex.getMessage() + ex.getClass());
			} catch (NullPointerException | IllegalStateException ex) {
				System.out.println("Multicatch example: " + ex.getMessage() + ex.getClass());
			} finally {
				System.out.println("No error occured");
			}
			
		}
		
		System.out.println(titulos);
		FileWriter writting = new FileWriter("movies.json");
		writting.write(gson.toJson(titulos));
		writting.close();
		
		System.out.println("The program finished successfully");
		
	}

}
