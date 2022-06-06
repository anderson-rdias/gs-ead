package br.com.jkcontrol.gcead.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_CONDOMINIO")
@SequenceGenerator(name = "condominio", sequenceName = "SQ_TB_CONDOMINIO", allocationSize = 1)
public class Condominio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Condominio() {}
	
	public Condominio(String cnpj, String razaoSocial, String fantasia, LocalDate dataFundacao) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.dataFundacao = dataFundacao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condominio")
	private Long id;
	
	@Column(name = "nr_cnpj", length = 14, nullable = false)
	private String cnpj;
	
	@Column(name = "nm_fantasia", length = 80, nullable = false)
	private String fantasia;
	
	@Column(name = "ds_razao_social", length = 80, nullable = false)
	private String razaoSocial;
	
	@Column(name = "dt_fundacao")
	private LocalDate dataFundacao;
	
	@OneToMany
	private Set<Portaria> portarias;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public Set<Portaria> getPortarias() {
		return portarias;
	}

	public void setPortarias(Set<Portaria> portarias) {
		this.portarias = portarias;
	}

	@Override
	public String toString() {
		return "\nCPNJ: " + this.getCnpj() +
				"\nNome Fantasia: " + this.getFantasia() +
				"\nRazão Social: " + this.getRazaoSocial() +
				"\nData Fundação: " + this.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
