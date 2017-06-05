/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Allan Santos
 */
@Entity
@Table(name = "meta")
@Inheritance(strategy = InheritanceType.JOINED) 
@DiscriminatorColumn(name = "disc_meta", discriminatorType = DiscriminatorType.STRING, length= 3) 
public abstract class Meta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta")
    private Integer idMeta;

    @Column(name = "str_nome")
    private String nome;

    @Column(name = "dbl_valor_total")
    private Double valorTotal;

    @Column(name = "dbl_subtotal_valor")
    private Double subtotalValor;

    @Column(name = "date_de")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date de;

    @Column(name = "date_de")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ate;

    @Column(name = "investimento_mensal")
    private Double investimentoMensal;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioId;

    public Meta() {
    }

    public Meta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public Integer getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public Double getInvestimentoMensal() {
        return investimentoMensal;
    }

    public void setInvestimentoMensal(Double investimentoMensal) {
        this.investimentoMensal = investimentoMensal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSubtotalValor() {
        return subtotalValor;
    }

    public void setSubtotalValor(Double subtotalValor) {
        this.subtotalValor = subtotalValor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeta != null ? idMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meta)) {
            return false;
        }
        Meta other = (Meta) object;
        if ((this.idMeta == null && other.idMeta != null) || (this.idMeta != null && !this.idMeta.equals(other.idMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD.Meta[ idMeta=" + idMeta + " ]";
    }

}
