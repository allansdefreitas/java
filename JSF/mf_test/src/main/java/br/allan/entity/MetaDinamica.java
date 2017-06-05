/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_meta_dinamica")
@DiscriminatorValue(value = "din")
@PrimaryKeyJoinColumn(name = "id_meta", referencedColumnName = "id_usuario") 
public class MetaDinamica extends Meta implements Serializable {
    
    @Column(name = "fl_porcentual_poupanca", nullable = false)
    private Float porcentualPoupanca;

    
    public Float getPorcentualPoupanca() {
        return porcentualPoupanca;
    }

    public void setPorcentualPoupanca(Float porcentualPoupanca) {
        this.porcentualPoupanca = porcentualPoupanca;
    }
  
}
