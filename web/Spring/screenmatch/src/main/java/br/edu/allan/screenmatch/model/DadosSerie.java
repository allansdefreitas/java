package br.edu.allan.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
@JsonAlias is used only to deserialize (write)
@JsonProperty is used to serialize and deserialize
@JsonIgnoreProperties(ignoreUnknown = true) to ignore non mapped properties
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias({"Title", "movieTitle"}) String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonProperty("imdbVotes") String votos) {

}
