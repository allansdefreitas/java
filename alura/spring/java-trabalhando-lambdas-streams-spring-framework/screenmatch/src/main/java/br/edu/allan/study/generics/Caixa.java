package br.edu.allan.study.generics;

public class Caixa<T> {
	private T conteudo;

	
	
	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "Caixa [conteudo=" + conteudo + "]";
	}
	
	
}

