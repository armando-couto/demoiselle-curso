package br.gov.serpro.inscricao.entity;

import java.io.Serializable;

public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	public Aluno() {
	}

	public Aluno(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object outro) {
		return ((Aluno) outro).nome.equals(this.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}