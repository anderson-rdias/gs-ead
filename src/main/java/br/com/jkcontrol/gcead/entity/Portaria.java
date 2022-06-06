package br.com.jkcontrol.gcead.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_PORTARIA")
@SequenceGenerator(name = "portaria", sequenceName = "SQ_TB_PORTARIA", allocationSize = 1)
public class Portaria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portaria")
	@Column(name="id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nr_portaria", nullable = false)
	private int numeroPortaria;
	
	@Column(name = "nm_portaria", nullable = false)
	private String nomePortaria;
	
	@Column(name = "st_status")
	private Boolean ativo;
	
	@Column(name="dt_inicio", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name="dt_termino", nullable = false)
	private LocalDate dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "condominio_id")
	private Condominio condominio;
	
	@OneToMany(mappedBy = "condominio")
	private Set<Portaria> portarias;

	public Portaria() {
	}

	public Portaria(int numeroPortaria, String nomePortaria, LocalDate dataInicio, LocalDate dataTermino, Condominio condominio) {
		this.numeroPortaria = numeroPortaria;
		this.nomePortaria = nomePortaria;
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

	public Set<Portaria> getPortarias() {
		return portarias;
	}

	public void setPortarias(Set<Portaria> portarias) {
		this.portarias = portarias;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
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
	

