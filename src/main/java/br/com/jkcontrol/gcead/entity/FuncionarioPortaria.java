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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_FUNC_PORTARIA")
@SequenceGenerator(name = "GCO_Visitante", sequenceName = "SQ_T_GCO_FUNC_PORTARIA", allocationSize = 1)
public class FuncionarioPortaria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_funcionario", nullable = false)
	private String nomeFuncioniario;
	
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDateTime dataNascimento;
	
	@Column(name = "nr_cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nr_rg", nullable = false)
	private String rg;
	
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@OneToMany
	private List<Movimentacao> movimentacoes;
	
	public FuncionarioPortaria() {
		
	}
	
	public FuncionarioPortaria(LocalDateTime dataNascimento, String cpf, String rg, LocalDateTime dataCadastro, String nomeFuncioniario) {
		super();
		this.nomeFuncioniario = nomeFuncioniario;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFuncioniario() {
		return nomeFuncioniario;
	}

	public void setNomeFuncioniario(String nomeFuncioniario) {
		this.nomeFuncioniario = nomeFuncioniario;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.getNomeFuncioniario() +
				"\nData de Nascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
				"\nCPF: " + this.getCpf() +
				"\nRG: " + this.getRg();
	}
}
