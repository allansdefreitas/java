package br.edu.allan.screenmatch.service;


public interface IConversorDados {
    <T> T  obterDados(String json, Class<T> classe);
}