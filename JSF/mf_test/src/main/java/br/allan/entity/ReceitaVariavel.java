/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_receita_variavel")
@DiscriminatorValue(value = "var")
@PrimaryKeyJoinColumn(name = "id_receita_variavel", referencedColumnName = "id_receita")
@Access(AccessType.FIELD)
public class ReceitaVariavel extends Receita {
    
    
   //@Column(name = "date_")
    
}
