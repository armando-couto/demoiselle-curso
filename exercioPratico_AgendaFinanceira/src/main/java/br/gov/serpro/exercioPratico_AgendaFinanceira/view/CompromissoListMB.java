package br.gov.serpro.exercioPratico_AgendaFinanceira.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.serpro.exercioPratico_AgendaFinanceira.business.CompromissoBC;
import br.gov.serpro.exercioPratico_AgendaFinanceira.domain.Compromisso;

@ViewController
public class CompromissoListMB extends AbstractListPageBean<Compromisso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CompromissoBC bc;

	@Override
	protected List<Compromisso> handleResultList() {
		return bc.findAll();
	}
}