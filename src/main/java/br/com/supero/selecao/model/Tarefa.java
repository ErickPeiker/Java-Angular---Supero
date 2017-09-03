package br.com.supero.selecao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="task")
public class Tarefa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title", length = 100)
	@NotNull
	private String titulo;
	
	@Column(name = "status", length = 100)
	@NotNull
	private String status;
	
	@Column(name = "description", length = 100)
	@NotNull
	private String descricao;

	@Column(name = "creation", columnDefinition = "TIMESTAMP")
	private Date criacao;
	
	@Column(name = "updated", columnDefinition = "TIMESTAMP")
	private Date atualizacao;
	
	@Column(name = "deleted", columnDefinition = "TIMESTAMP")
	private Date remocao;
	
	@Column(name = "done", columnDefinition = "TIMESTAMP")
	private Date conclusao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}

	public Date getRemocao() {
		return remocao;
	}

	public void setRemocao(Date remocao) {
		this.remocao = remocao;
	}

	public Date getConclusao() {
		return conclusao;
	}

	public void setConclusao(Date conclusao) {
		this.conclusao = conclusao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atualizacao == null) ? 0 : atualizacao.hashCode());
		result = prime * result + ((conclusao == null) ? 0 : conclusao.hashCode());
		result = prime * result + ((criacao == null) ? 0 : criacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((remocao == null) ? 0 : remocao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (atualizacao == null) {
			if (other.atualizacao != null)
				return false;
		} else if (!atualizacao.equals(other.atualizacao))
			return false;
		if (conclusao == null) {
			if (other.conclusao != null)
				return false;
		} else if (!conclusao.equals(other.conclusao))
			return false;
		if (criacao == null) {
			if (other.criacao != null)
				return false;
		} else if (!criacao.equals(other.criacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (remocao == null) {
			if (other.remocao != null)
				return false;
		} else if (!remocao.equals(other.remocao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", titulo=" + titulo + ", status=" + status + ", descricao=" + descricao
				+ ", criacao=" + criacao + ", atualizacao=" + atualizacao + ", remocao=" + remocao + ", conclusao="
				+ conclusao + "]";
	}
	
}
