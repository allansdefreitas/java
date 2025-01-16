package br.edu.allan.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.allan.screenmatch.main.Main;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Main main = new Main();
		
		main.showMenu();
		
//		ConsumoAPI consumoAPI = new ConsumoAPI();
//		
////		String address = "http://www.omdbapi.com/?t=The+chosen&Season=1&&apikey=cd70d0b3";
////		address = "https://coffee.alexflipnote.dev/random.json";
//		
//		/* Series ----------------------------------------------- */
//		String addressSerie = "http://www.omdbapi.com/?t=Chicago+Med&apikey="+Constantes.API_KEY;
//		
//		var jsonSerie = consumoAPI.obterDados(addressSerie);
////		System.out.println(jsonSerie);
//		
//		ConverteDados conversor = new ConverteDados();
//        Serie dadosSerie = conversor.obterDados(jsonSerie, Serie.class);
//        System.out.println(dadosSerie);
//        
//        /* Episodes ----------------------------------------------- */
//        String addressEpisode = "https://www.omdbapi.com/?t=Chicago+Med&season=1&episode=1&apikey="+Constantes.API_KEY;
//        var jsonEpisode = consumoAPI.obterDados(addressEpisode);
////		System.out.println(jsonEpisode);
//		
//        Episodio dadosEpisodio = conversor.obterDados(jsonEpisode, Episodio.class);
//        System.out.println(dadosEpisodio);
//        
//        /* Seasons ----------------------------------------------- */
//        String addressSeason;
//        String jsonSeason;
//        
//        List<Temporada> temporadas = new ArrayList<>();
//        
//        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
//        	  addressSeason = "https://www.omdbapi.com/?t=Chicago+PD&season="+ i +"&apikey="+Constantes.API_KEY;
//              jsonSeason = consumoAPI.obterDados(addressSeason);
//              
//              conversor = new ConverteDados();
//              Temporada dadosTemporada  = conversor.obterDados(jsonSeason, Temporada.class);
//              temporadas.add(dadosTemporada);
//        }
//        
//        temporadas.forEach(System.out::println);
        
	}

}
