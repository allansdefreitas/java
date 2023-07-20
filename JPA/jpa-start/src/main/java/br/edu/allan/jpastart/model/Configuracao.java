package br.edu.allan.jpastart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Configuracao {

    @Id
    private Integer id;

    @MapsId //Means that this att is FK and PK, so there is a composite PK in this entity
    @OneToOne
    private Usuario usuario;

    private boolean receberNotificacoes;

    private boolean endsessionauto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isReceberNotificacoes() {
        return receberNotificacoes;
    }

    public void setReceberNotificacoes(boolean receberNotificacoes) {
        this.receberNotificacoes = receberNotificacoes;
    }

    public boolean isEndsessionauto() {
        return endsessionauto;
    }

    public void setEndsessionauto(boolean endsessionauto) {
        this.endsessionauto = endsessionauto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Configuracao that = (Configuracao) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

	@Override
	public String toString() {
		return "Configuracao [id=" + id + ", receberNotificacoes=" + receberNotificacoes
				+ ", encerrarSessaoAutomaticamente=" + endsessionauto + "]";
	}

    
}
