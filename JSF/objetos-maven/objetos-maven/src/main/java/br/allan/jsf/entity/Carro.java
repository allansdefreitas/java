package br.allan.jsf.entity;

/**
 *
 * @author allanfreitas
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Access(AccessType.FIELD)
public class Carro implements Serializable {
    
    @Id
    @Column(name = "int_id_carro", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarro;
    
    @Column(name = "str_modelo")
    private String modelo;
    
    @Column(name = "str_fabricante")
    private String fabricante;
    
    @Column(name = "str_cor")
    private String cor;
    
    @Column(name = "dt_ano")
    @Temporal(TemporalType.DATE)
    private Date ano;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

}
