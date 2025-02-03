package br.edu.allan.screenmatch.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.edu.allan.screenmatch.model.DadosEpisodio;
import br.edu.allan.screenmatch.model.DadosSerie;
import br.edu.allan.screenmatch.model.DadosTemporada;
import br.edu.allan.screenmatch.model.Episodio;
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
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);

		List<DadosTemporada> dadosTemporadas = new ArrayList<>();
		String addressSeason = null;
		String jsonSeason = null;
		
		for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
		
			addressSeason = "https://www.omdbapi.com/?t="+ serieName +"&season=" + i + "&apikey=" + Constantes.API_KEY;
			jsonSeason = consumoAPI.obterDados(addressSeason);

			conversor = new ConversorDados();
			DadosTemporada dadosTemporada = conversor.obterDados(jsonSeason, DadosTemporada.class);
			dadosTemporadas.add(dadosTemporada);
		}

//		dadosTemporadas.forEach(System.out::println);
		
//		for (int i = 0; i < dadosSerie.totalTemporadas(); i++) {
//			
//			List<Episodio> episodios = temporadas.get(i).episodios();
//			
//			for (int j = 0; j < episodios.size(); j++) {
//				System.out.println(episodios.get(j).titulo());
//			}
//		}
		
//		temporadas.forEach(dadosTemporada -> dadosTemporada.episodios().forEach(e -> System.out.println(e.titulo() )));

		// Streams
//		List<String> nomes = Arrays.asList("Allan", "Miquéias", "Júnior", "Ester", "Alexandre", "Neide");
//		
//		nomes.stream()
//			.sorted()
//			.limit(6)
//			.filter(n -> n.startsWith("E"))
//			.map(n -> n.toUpperCase())
//			.forEach(System.out::println);

		List<DadosEpisodio> dadosEpisodios = dadosTemporadas.stream()
				.flatMap(t -> t.episodios().stream() )
				.collect(Collectors.toList());
//				.toList(); // Retorna uma lista imutável
		
		
//		dadosEpisodios.forEach(System.out::println);
		System.out.println("\n\n10 Melhores episódios, segundo nota IMDb\n");
		
		int vezes = 0;
		dadosEpisodios.stream()
			.filter(e -> !(e.notaImdb().equalsIgnoreCase("N/A")) )
			.peek(e -> System.out.println("Primeiro filtro (N/A) " + e))
			.sorted(Comparator.comparing(DadosEpisodio::notaImdb).reversed())
			.peek(e -> System.out.println("Ordenação: " + e))
			.limit(10)
			.peek(e -> System.out.println("Limite: " + e))
			.map(e -> e.titulo().toUpperCase() )
			.peek(e -> System.out.println("Mapeamento: " + e))
			.forEach(System.out::println);
		
//		
//		List<Episodio> episodios = dadosTemporadas.stream()
//		.flatMap(t -> t.episodios().stream()
//				.filter(e -> !(e.notaImdb().equalsIgnoreCase("N/A")) )
//				.map(d -> new Episodio(t.numeroTemporada(), d))
//				).collect(Collectors.toList());
//	
//	
//		episodios.forEach(System.out::println);
//		
//		
//		System.out.println("\n\nQuer ver os episódios a partir de que ano de lançamento? ");
//		var ano = leitura.nextInt();
//		leitura.nextLine();
//		
//		LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//		
//		
//		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		
//		episodios.stream()
//			.filter(e -> ( e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca) ))
//			.forEach(e -> System.out.println(
//					"Temporada: " + e.getNumeroTemporada() +
//					" Episódio: " + e.getNumeroEpisodio() + 
//					" Data lançamento: " + e.getDataLancamento().format(formatador)
//			));
	
	}
}
