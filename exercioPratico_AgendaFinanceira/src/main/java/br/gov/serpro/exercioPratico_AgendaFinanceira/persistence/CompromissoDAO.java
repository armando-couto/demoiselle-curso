package br.gov.serpro.exercioPratico_AgendaFinanceira.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.exercioPratico_AgendaFinanceira.domain.Compromisso;

@PersistenceController
public class CompromissoDAO extends JPACrud<Compromisso, Long> {

	private static final long serialVersionUID = 1L;

}