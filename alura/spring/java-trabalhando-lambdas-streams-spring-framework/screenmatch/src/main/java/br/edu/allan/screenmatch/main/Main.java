package br.edu.allan.screenmatch.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.allan.screenmatch.model.Episodio;
import br.edu.allan.screenmatch.model.Serie;
import br.edu.allan.screenmatch.model.Temporada;
import br.edu.allan.screenmatch.service.ConsumoAPI;
import br.edu.allan.screenmatch.service.ConversorDados;
import br.edu.allan.screenmatch.util.Constantes;

public class Main {

	private Scanner leitura = new Scanner(System.in);
	private ConsumoAPI consumoAPI = new ConsumoAPI();
	ConversorDados conversor = new ConversorDados();

	public void showMenu() {
		System.out.println("Enter the title of a TV Serie: ");
		var serieName = leitura.nextLine();

		serieName = serieName.replace(" ", "+");

		String addressSerie = Constantes.ADDRESS + serieName + "&apikey=" + Constantes.API_KEY;
		var json = consumoAPI.obterDados(addressSerie);
		Serie serie = conversor.obterDados(json, Serie.class);
		System.out.println(serie);

		List<Temporada> temporadas = new ArrayList<>();
		String addressSeason = null;
		String jsonSeason = null;
		
		for (int i = 1; i <= serie.totalTemporadas(); i++) {
		
			addressSeason = "https://www.omdbapi.com/?t="+ serieName +"&season=" + i + "&apikey=" + Constantes.API_KEY;
			jsonSeason = consumoAPI.obterDados(addressSeason);

			conversor = new ConversorDados();
			Temporada temporada = conversor.obterDados(jsonSeason, Temporada.class);
			temporadas.add(temporada);
		}

		temporadas.forEach(System.out::println);
		
//		for (int i = 0; i < serie.totalTemporadas(); i++) {
//			
//			List<Episodio> episodios = temporadas.get(i).episodios();
//			
//			for (int j = 0; j < episodios.size(); j++) {
//				System.out.println(episodios.get(j).titulo());
//			}
//		}
		
		temporadas.forEach(temporada -> temporada.episodios().forEach(e -> System.out.println(e.titulo() )));
		

	}

}
