package br.com.jkcontrol.gcead.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_MOVIMENTACAO_PORTARIA")
@SequenceGenerator(name = "GCO_MOVIMENTACAO_PORTARIA", sequenceName = "SQ_TB_GCO_MOVIMENTACAO_PORTARIA", allocationSize = 1)
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Movimentacao() {
		this.dtMovimentacao = LocalDateTime.now();
	}
	
	public Movimentacao(String tpMovimentacao, LocalDateTime dataMovimentacao, Portaria portaria, FuncionarioPortaria funcionario, Visitante visitante) {
		this.tpMovimentacao = tpMovimentacao;
		this.portaria = portaria;
		this.funcionario = funcionario;
		this.visitante = visitante;
	}
	
	public Movimentacao(String tp_movimentacao) {
		this.tpMovimentacao = tp_movimentacao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GCO_MOVIMENTACAO_PORTARIA")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "portaria_id")
	private Portaria portaria;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private FuncionarioPortaria funcionario;
	
	@ManyToOne
	@JoinColumn(name = "visitante_id")
	private Visitante visitante;
	
	@Column(name = "tp_movimentacao")
	private String tpMovimentacao;
	
	@Column(name = "dt_movimentacao")
	private LocalDateTime dtMovimentacao;

	public String getTp_movimentacao() {
		return tpMovimentacao;
	}

	public void setTp_movimentacao(String tp_movimentacao) {
		this.tpMovimentacao = tp_movimentacao;
	}

	public LocalDateTime getDt_movimentacao() {
		return dtMovimentacao;
	}

	public void setDt_movimentacao(LocalDateTime dt_movimentacao) {
		this.dtMovimentacao = dt_movimentacao;
	}
	
	@Override
	public String toString() {
		return  "\nMovimentação: " + this.getTp_movimentacao()
			+ "\nData da Movimentação: " + this.getDt_movimentacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
}
