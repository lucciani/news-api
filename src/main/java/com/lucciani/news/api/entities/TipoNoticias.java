package com.lucciani.news.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_noticias")
public class TipoNoticias implements Serializable {

	private static final long serialVersionUID = 4361118088638930318L;

	private Long id;
	private String nomeTipo;

	private Jornalista jornalista;
	private List<Noticias> noticias;

	private Date dataCriacao;
	private Date dataAtualizacao;

	public TipoNoticias() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "nome_tipo", nullable = false)
	public String getNomeTipo() {
		return nomeTipo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Jornalista getJornalista() {
		return jornalista;
	}

	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	public List<Noticias> getNoticias() {
		return noticias;
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

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public void setJornalista(Jornalista jornalista) {
		this.jornalista = jornalista;
	}

	public void setNoticias(List<Noticias> noticias) {
		this.noticias = noticias;
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
		return "TipoNoticias [id=" + id + ", nomeTipo=" + nomeTipo + ", jornalista=" + jornalista + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

}
