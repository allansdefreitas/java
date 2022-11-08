/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.jsf_ajax;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Allan Santos
 */
@ManagedBean(name="ajaxControll")
@ViewScoped
public class AjaxControll implements Serializable{
    private String texto;
    private String saida;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    
    public void textInverter(){
        StringBuffer stb = new StringBuffer(texto);
        saida = stb.reverse().toString();
    }
    
}
