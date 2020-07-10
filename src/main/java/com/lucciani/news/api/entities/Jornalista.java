package com.lucciani.news.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.lucciani.news.api.enums.PerfilEnum;

@Entity
@Table(name = "jornalista")
public class Jornalista implements Serializable {

	private static final long serialVersionUID = -7525482674868712706L;

	private Long id;
	private String nome;
	private String sobreNome;
	private String email;
	private String senha;
	private PerfilEnum perfil;

	private Date dataCriacao;
	private Date dataAtualizacao;

	private List<Noticias> noticias;
	private List<TipoNoticias> tipoNoticias;

	public Jornalista() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	@Column(name = "sobre_nome", nullable = true)
	public String getSobreNome() {
		return sobreNome;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	public PerfilEnum getPerfil() {
		return perfil;
	}

	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	@Column(name = "data_atualizacao", nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	@OneToMany(mappedBy = "jornalista", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	public List<Noticias> getNoticias() {
		return noticias;
	}

	@OneToMany(mappedBy = "jornalista", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	public List<TipoNoticias> getTipoNoticias() {
		return tipoNoticias;
	}

	
	//SET
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public void setNoticias(List<Noticias> noticias) {
		this.noticias = noticias;
	}

	public void setTipoNoticias(List<TipoNoticias> tipoNoticias) {
		this.tipoNoticias = tipoNoticias;
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
		return "Jornalista [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + ", senha="
				+ senha + ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao
				+ "]";
	}

}
