/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.jsfsimpleproject.model;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Allan Santos
 * 
 * Diário ----------------
 * Criação dos attrs e mapeamento. Pra que Usar equals e hashCode?
 * Próximo passo: usar exemplo softCorpPet e/ou vídeo aulas p/ implementar
 * (24/07 - 11:59)
 */

@Entity
@Table(name = "tb_product")
@Access(AccessType.FIELD)
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;
    
    @Column(name = "str_name")
    private String name;
    
    @Column(name = "num_price")
    private Float price;
    
    
    
    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
}
