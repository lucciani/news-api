package com.lucciani.news.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "noticias")
public class Noticias implements Serializable {

	private static final long serialVersionUID = -5502072305294127493L;

	private Long id;
	private String titulo;
	private String descricao;
	private String corpoNoticia;

	private Jornalista jornalista;
	private TipoNoticias tipo;

	private Date dataCriacao;
	private Date dataAtualizacao;

	public Noticias() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "titulo", nullable = false)
	public String getTitulo() {
		return titulo;
	}

	@Column(name = "descricao", nullable = true)
	public String getDescricao() {
		return descricao;
	}

	
	@Column(name = "corpo_noticia", nullable = true)
	public String getCorpoNoticia() {
		return corpoNoticia;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	public Jornalista getJornalista() {
		return jornalista;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public TipoNoticias getTipo() {
		return tipo;
	}

	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	@Column(name = "data_atualizacao", nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	
	//SET
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCorpoNoticia(String corpoNoticia) {
		this.corpoNoticia = corpoNoticia;
	}

	public void setJornalista(Jornalista jornalista) {
		this.jornalista = jornalista;
	}

	public void setTipo(TipoNoticias tipo) {
		this.tipo = tipo;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "Noticias [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", corpoNoticia="
				+ corpoNoticia + ", jornalista=" + jornalista + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

}
