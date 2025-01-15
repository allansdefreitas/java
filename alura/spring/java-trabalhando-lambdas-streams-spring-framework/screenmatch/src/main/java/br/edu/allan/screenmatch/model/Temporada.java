package br.edu.allan.screenmatch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Temporada(
		@JsonAlias("Season") Integer numeroTemporada,
		@JsonAlias("Episodes") List<Episodio> episodios) {

}
