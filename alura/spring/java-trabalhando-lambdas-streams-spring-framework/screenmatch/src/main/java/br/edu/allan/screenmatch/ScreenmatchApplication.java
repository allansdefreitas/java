package br.edu.allan.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.allan.screenmatch.service.ConsumoAPI;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String address = "http://www.omdbapi.com/?t=The+chosen&Season=1&&apikey=cd70d0b3";
		address = "https://coffee.alexflipnote.dev/random.json";
		
		ConsumoAPI consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados(address);
		
		System.out.println(json);
	}

}
