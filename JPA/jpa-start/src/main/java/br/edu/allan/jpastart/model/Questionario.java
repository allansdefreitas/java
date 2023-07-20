package br.edu.allan.jpastart.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
//
//
//@Entity
//@Table(name = "tbquestionario", schema="sasr")
public class Questionario implements Serializable{
	
	private static final long serialVersionUID = 1070742563388298622L;
	public static final String COLUMN_ID = "cqestisequ";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionario_sequence")
	@SequenceGenerator(name = "questionario_sequence", sequenceName = "sasr.tbquestionario_cqestisequ_seq", allocationSize = 1)
	@Column(name = COLUMN_ID)
	private Long codigoQuestionario;
	
	@NotNull
	@Column(name = "cqestinome")
	private String identificacaoQuestionario;
	
	@NotNull
	@Column(name = "cqestisitu")
	private String situacao; /*Em criação, Suspenso, Ativo, Desativado */
		
	@Column(name = "eqestifrasecoment")
	private String fraseAcimaComentario;

	@Column(name = "eqestifraseident")
	private String fraseAcimaIdentificacao;
	
	@Column(name = "ccatntcodi")
	private String codigoCategoriaNota;
	
	@NotNull
	@Column(name = "dqestiultmov")
	@Temporal(TemporalType.DATE)
	private Date dataUltimaModificacao;
	
	@NotNull
	@Column(name = "aqestincpf")
	private Long cpfUsuarioModificacao;
	
	@NotNull
	@Column(name = "tqestiulat")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAtualizacao;
	
	
	public Questionario() {
		super();
	}

	public Long getCodigoQuestionario() {
		return codigoQuestionario;
	}

	public void setCodigoQuestionario(Long codigoQuestionario) {
		this.codigoQuestionario = codigoQuestionario;
	}

	public String getIdentificacaoQuestionario() {
		return identificacaoQuestionario;
	}

	public void setIdentificacaoQuestionario(String identificacaoQuestionario) {
		this.identificacaoQuestionario = identificacaoQuestionario;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getFraseAcimaComentario() {
		return fraseAcimaComentario;
	}

	public void setFraseAcimaComentario(String fraseAcimaComentario) {
		this.fraseAcimaComentario = fraseAcimaComentario;
	}

	public String getFraseAcimaIdentificacao() {
		return fraseAcimaIdentificacao;
	}

	public void setFraseAcimaIdentificacao(String fraseAcimaIdentificacao) {
		this.fraseAcimaIdentificacao = fraseAcimaIdentificacao;
	}
	
	public String getCodigoCategoriaNota() {
		return codigoCategoriaNota;
	}

	public void setCodigoCategoriaNota(String codigoCategoriaNota) {
		this.codigoCategoriaNota = codigoCategoriaNota;
	}

	public Date getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}

	public void setDataUltimaModificacao(Date dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}

	public Long getCpfUsuarioModificacao() {
		return cpfUsuarioModificacao;
	}

	public void setCpfUsuarioModificacao(Long cpfUsuarioModificacao) {
		this.cpfUsuarioModificacao = cpfUsuarioModificacao;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoQuestionario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questionario other = (Questionario) obj;
		return Objects.equals(codigoQuestionario, other.codigoQuestionario);
	}

	@Override
	public String toString() {
		return "Questionario [codigoQuestionario=" + codigoQuestionario + ", identificacaoQuestionario="
				+ identificacaoQuestionario + ", situacao=" + situacao + ", fraseAcimaComentario="
				+ fraseAcimaComentario + ", fraseAcimaIdentificacao=" + fraseAcimaIdentificacao + ", codigoCategoriaNota="
				+ codigoCategoriaNota + ", dataUltimaModificacao=" + dataUltimaModificacao + ", cpfUsuarioModificacao="
				+ cpfUsuarioModificacao + ", ultimaAtualizacao=" + ultimaAtualizacao + "]";
	}

	
}
	
