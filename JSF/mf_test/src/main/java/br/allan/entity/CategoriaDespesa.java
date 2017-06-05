package br.allan.entity;

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
 */
@Entity
@Table(name = "tb_categoria_despesa")
@Access(AccessType.FIELD)
public class CategoriaDespesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_despesa")
    private Long idCategoriaDespesa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    public Long getIdCategoriaDespesa() {
        return idCategoriaDespesa;
    }

    public void setIdCategoriaDespesa(Long idCategoriaDespesa) {
        this.idCategoriaDespesa = idCategoriaDespesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
