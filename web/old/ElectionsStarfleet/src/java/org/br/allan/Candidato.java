/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.br.allan;

/**
 *
 * @author allanfreitas
 */
public class Candidato {
    private String nome;
    private int votos;
    private static int totalDeVotos;

    public static int getTotalDeVotos() {
        return totalDeVotos;
    }

    public static void setTotalDeVotos(int totalDeVotos) {
        Candidato.totalDeVotos = totalDeVotos;
    }

    
    
    public Candidato(String nome){
        this.nome = nome;
        this.votos = 0;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the votos
     */
    public int getVotos() {
        return votos;
    }

    /**
     * @param votos the votos to set
     */
    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    public float calcularPorcentagem(){
        float porcentual;
        int votosCandidato = this.getVotos();
        int totalDeVotos = Candidato.totalDeVotos;
        
        porcentual = ( (float) votosCandidato / totalDeVotos) * 100;
        return porcentual;
        
    }

}
