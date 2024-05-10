package br.edu.allan.screenmatch;

import br.edu.allan.screenmatch.model.DadosEpisodio;
import br.edu.allan.screenmatch.model.DadosSerie;
import br.edu.allan.screenmatch.model.DadosTemporada;
import br.edu.allan.screenmatch.service.ConsumoAPI;
import br.edu.allan.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final String APIKEY="6585022c";

		var consumoAPI = new ConsumoAPI();
		var endereco = "https://www.omdbapi.com/?t=House&apikey="+APIKEY;
//		var endereco = "https://www.omdbapi.com/?t=House&Season=1&apikey=6585022c";
		var json = consumoAPI.obterDados(endereco);
		System.out.println(json);

//		json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);

		// Show episodes data
		endereco = "https://www.omdbapi.com/?t=House&Season=1&episode=2&apikey="+APIKEY;
		json = consumoAPI.obterDados(endereco);
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);


		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int seasonNumber = 1; seasonNumber <= dadosSerie.totalTemporadas(); seasonNumber++){

			endereco = "https://www.omdbapi.com/?t=House&Season="+seasonNumber+"&apikey="+APIKEY;
			json = consumoAPI.obterDados(endereco);

			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}

		temporadas.forEach(System.out::println);

	}
}
