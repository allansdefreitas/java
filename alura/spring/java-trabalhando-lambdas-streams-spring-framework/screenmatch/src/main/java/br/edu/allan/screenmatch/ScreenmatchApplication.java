package br.edu.allan.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.allan.screenmatch.model.Serie;
import br.edu.allan.screenmatch.service.ConsumoAPI;
import br.edu.allan.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ConsumoAPI consumoAPI = new ConsumoAPI();
		
//		String address = "http://www.omdbapi.com/?t=The+chosen&Season=1&&apikey=cd70d0b3";
//		address = "https://coffee.alexflipnote.dev/random.json";
		String address = "http://www.omdbapi.com/?t=The+chosen&apikey=cd70d0b3";
		
		var json = consumoAPI.obterDados(address);
		System.out.println(json);
		
		ConverteDados conversor = new ConverteDados();
        Serie dados = conversor.obterDados(json, Serie.class);
        System.out.println(dados);
		
		
	}

}
