package br.gov.serpro.exercioPratico_AgendaFinanceira.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "compromisso")
public class Compromisso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeCompromisso;
	
	private Date dataVencimento;
	
	private Date dataPagamento;
	
	private BigDecimal valorCompromisso;
	
	private BigDecimal valorPago;

	public Compromisso() {}
	
	public Compromisso(Long id, String nomeCompromisso, Date dataVencimento,
			Date dataPagamento, BigDecimal valorCompromisso,
			BigDecimal valorPago) {
		this.id = id;
		this.nomeCompromisso = nomeCompromisso;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorCompromisso = valorCompromisso;
		this.valorPago = valorPago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompromisso() {
		return nomeCompromisso;
	}

	public void setNomeCompromisso(String nomeCompromisso) {
		this.nomeCompromisso = nomeCompromisso;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorCompromisso() {
		return valorCompromisso;
	}

	public void setValorCompromisso(BigDecimal valorCompromisso) {
		this.valorCompromisso = valorCompromisso;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
}