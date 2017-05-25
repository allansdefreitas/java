package br.edu.ifpe.primeiroprojeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author allanfreitas
 */
@SessionScoped
@ManagedBean(name = "nomesManagedBean")
public class NomesBean {
    
    private String nome;
    private String sobrenome;
    private String mensagem;

    public void dizerOla(){
        this.mensagem = "Olá, " + this.nome + " " + this.sobrenome + " !";
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    
    
}
