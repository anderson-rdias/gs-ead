package br.com.jkcontrol.gcead.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "T_GCO_Visitante")
@SequenceGenerator(name = "GCO_Visitante", sequenceName = "SQ_TB_GCO_VISITANTE", allocationSize = 1)

public class Visitante implements Serializable{
	
		private static final long serialVersionUID = 1L;
		
		public Visitante() {
			this.dataCadastro = LocalDateTime.now();
		}
		
		public Visitante(String nome, String cpf, String rg, LocalDate dataNascimento) {
			this();
			this.nome = nome;
			this.cpf = cpf;
			this.rg = rg;
			this.dataNascimento = dataNascimento;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GCO_VISITANTE")
		private Long id;
		
		@Column(name = "nm_visitante", length = 80, nullable = false)
		private String nome;
		
		@Column(name = "dt_nasc")
		private LocalDate dataNascimento;
		
		@Column(name = "nr_cpf", length = 14, nullable = false, unique = true)
		private String cpf;
		
		@Column(name = "nr_rg", length = 12, nullable = false, unique = true)
		private String rg;
		
		@Column(name = "dt_cadastro")
		private LocalDateTime dataCadastro;
		
		@OneToMany(mappedBy = "visitante")
		private List<Movimentacao> movimentacoes;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public LocalDate getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public LocalDateTime getDataCadastro() {
			return dataCadastro;
		}

		public void setDataCadastro(LocalDateTime dataCadastro) {
			this.dataCadastro = dataCadastro;
		}

		public String getRg() {
			return rg;
		}
		
		public void setRg(String rg) {
			this.rg = rg;
		}

		@Override
		public String toString() {
			return  "\nNome: " + this.getNome()
				+ "\nCPF: " + this.getCpf()
				+ "\nRG: " + this.getRg()
				+ "\nNascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
	}
