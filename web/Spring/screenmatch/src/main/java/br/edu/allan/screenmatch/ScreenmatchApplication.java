package br.edu.allan.screenmatch;

import br.edu.allan.screenmatch.model.DadosSerie;
import br.edu.allan.screenmatch.service.ConsumoAPI;
import br.edu.allan.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var endereco = "https://www.omdbapi.com/?t=House&apikey=6585022c";
//		var endereco = "https://www.omdbapi.com/?t=House&Season=1&apikey=6585022c";
		var json = consumoAPI.obterDados(endereco);
		System.out.println(json);

//		json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
