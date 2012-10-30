package br.gov.serpro.exercioPratico_AgendaFinanceira.business;

import java.math.BigDecimal;
import java.util.Date;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.serpro.exercioPratico_AgendaFinanceira.domain.Compromisso;
import br.gov.serpro.exercioPratico_AgendaFinanceira.persistence.CompromissoDAO;

@BusinessController
public class CompromissoBC extends DelegateCrud<Compromisso, Long, CompromissoDAO> {

	private static final long serialVersionUID = 1L;

	@Startup
	public void carregar() {
		getDelegate().insert(new Compromisso("teste 1", new Date(), new Date(), new BigDecimal(10000), new BigDecimal(100)));
		getDelegate().insert(new Compromisso("teste 2", new Date(), new Date(), new BigDecimal(10000), new BigDecimal(100)));
		getDelegate().insert(new Compromisso("teste 3", new Date(), new Date(), new BigDecimal(10000), new BigDecimal(100)));
		getDelegate().insert(new Compromisso("teste 4", new Date(), new Date(), new BigDecimal(10000), new BigDecimal(100)));
	}
}