package br.gov.serpro.exercioPratico_AgendaFinanceira;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.serpro.exercioPratico_AgendaFinanceira.business.CompromissoBC;
import br.gov.serpro.exercioPratico_AgendaFinanceira.domain.Compromisso;

@RunWith(DemoiselleRunner.class)
public class CompromissoTest {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CompromissoBC bc;

	@Test
	public void testeInsert() {
		for (Compromisso compromisso : bc.findAll()) {
			if (bc.findAll().contains(compromisso.getNomeCompromisso())) {
				System.out.println("Não já existe.");
			}
			if (compromisso.getValorCompromisso().longValue() <= new Long(10)) {
				System.out.println("Valor do Compromisso não pode ser menor que 10");
			}
		}
	}
	
	@Test
	public void testeUpdate() {
		
	}
}