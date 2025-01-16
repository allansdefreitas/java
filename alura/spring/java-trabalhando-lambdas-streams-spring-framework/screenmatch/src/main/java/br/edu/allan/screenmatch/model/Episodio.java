package br.edu.allan.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
	
	private String titulo;
	private Integer numeroTemporada;
	private Integer numeroEpisodio;
	private Double notaImdb;
	private LocalDate dataLancamento;
	
	public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
		super();
		this.numeroTemporada = numeroTemporada;
		this.titulo = dadosEpisodio.titulo();
		
		try {
			this.notaImdb = Double.valueOf(dadosEpisodio.notaImdb());
		}catch(NumberFormatException ex) {
			this.notaImdb = 0.0;
		}
		this.numeroEpisodio = dadosEpisodio.numeroEpisodio();
		
		try {
			this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
		}catch(DateTimeParseException ex) {
			this.dataLancamento = null;
		}
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getNumeroTemporada() {
		return numeroTemporada;
	}
	public void setNumeroTemporada(Integer numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}
	public Integer getNumeroEpisodio() {
		return numeroEpisodio;
	}
	public void setNumeroEpisodio(Integer numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}
	public Double getNotaImdb() {
		return notaImdb;
	}
	public void setNotaImdb(Double notaImdb) {
		this.notaImdb = notaImdb;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	@Override
	public String toString() {
		return "titulo=" + titulo + ", numeroTemporada=" + numeroTemporada + ", numeroEpisodio="
				+ numeroEpisodio + ", notaImdb=" + notaImdb + ", dataLancamento=" + dataLancamento;
	}
	
	
}
