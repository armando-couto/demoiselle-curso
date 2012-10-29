package br.gov.serpro.exercioPratico_AgendaFinanceira.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.serpro.exercioPratico_AgendaFinanceira.domain.Compromisso;
import br.gov.serpro.exercioPratico_AgendaFinanceira.persistence.CompromissoDAO;

@BusinessController
public class CompromissoBC extends DelegateCrud<Compromisso, Long, CompromissoDAO> {

	private static final long serialVersionUID = 1L;

}