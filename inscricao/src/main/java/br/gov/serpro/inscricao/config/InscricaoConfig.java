package br.gov.serpro.inscricao.config;

import java.io.Serializable;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "inscricao")
public class InscricaoConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	private int capacidadeTurma;

	public int getCapacidadeTurma() {
		return capacidadeTurma;
	}
}