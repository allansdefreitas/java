package br.edu.allan.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Episodio(
		@JsonAlias("Title") String titulo, 
		@JsonAlias("Episode") Integer numeroEpisodio,
		@JsonAlias ("imdbRating") String notaImdb,
		@JsonAlias ("Released") String dataLancamento
		) {

}
