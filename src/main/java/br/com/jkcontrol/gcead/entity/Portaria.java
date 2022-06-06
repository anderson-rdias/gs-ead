package br.com.jkcontrol.gcead.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_PORTARIA")
public class Portaria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nr_portaria", nullable = false)
	private int numeroPortaria;
	
	@Column(name = "nm_portaria", nullable = false)
	private String nomePortaria;
	
	@Column(name = "st_status", nullable = false)
	private Boolean ativo;
	
	@Column(name="dt_inicio", nullable = false)
	private LocalDateTime dataInicio;
	
	@Column(name="dt_termino", nullable = false)
	private LocalDateTime dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "condominio_idCondominio")
	private Condominio condominio;
	
	@OneToMany(mappedBy = "portaria")
	private List<Condominio> condominios;

	public Portaria() {
	}

	public Portaria(int numeroPortaria, String nomePortaria, Boolean ativo, LocalDateTime dataInicio, LocalDateTime dataTermino, Condominio condominio) {
		super();
		this.numeroPortaria = numeroPortaria;
		this.nomePortaria = nomePortaria;
		this.ativo = ativo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.condominio = condominio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroPortaria() {
		return numeroPortaria;
	}

	public void setNumeroPortaria(int numeroPortaria) {
		this.numeroPortaria = numeroPortaria;
	}

	public String getNomePortaria() {
		return nomePortaria;
	}

	public void setNomePortaria(String nomePortaria) {
		this.nomePortaria = nomePortaria;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Condominio> getCondominios() {
		return condominios;
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
	@Override
	public String toString() {
		return "\nNúmero Portaria: " + this.getNumeroPortaria() +
				"\nNome Portaria:" + this.getNomePortaria() +
				"\nData Início: " + this.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
				"\nData Término: " + this.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
	

