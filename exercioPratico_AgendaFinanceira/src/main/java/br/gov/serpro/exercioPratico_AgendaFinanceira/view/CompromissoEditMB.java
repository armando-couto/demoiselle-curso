package br.gov.serpro.exercioPratico_AgendaFinanceira.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.exercioPratico_AgendaFinanceira.business.CompromissoBC;
import br.gov.serpro.exercioPratico_AgendaFinanceira.domain.Compromisso;

@ViewController
@NextView ("cadastro.jsf")
@PreviousView ("lista.jsf")
public class CompromissoEditMB extends AbstractEditPageBean<Compromisso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ResourceBundle bundle;
	
	@Inject
	private MessageContext messageContext;
	
	@Inject
	private CompromissoBC bc;

	@Override
	public String insert() {
		for (Compromisso compromisso : bc.findAll()) {
			if (compromisso.getNomeCompromisso().equalsIgnoreCase(getBean().getNomeCompromisso())) {
				messageContext.add(bundle.getString("erro1"), SeverityType.ERROR);
				return null;
			} 
		}
		if (getBean().getValorCompromisso().longValue() <= new Long(10)) {
			messageContext.add(bundle.getString("erro2"), SeverityType.ERROR);
			return null;
		} else {
			bc.insert(getBean());
			messageContext.add(bundle.getString("cadastrado.sucesso", getBean().getNomeCompromisso()));
			return getPreviousView();
		}
	}

	@Override
	public String update() {
		bc.update(getBean());
		messageContext.add(bundle.getString("alterado.sucesso", getBean().getNomeCompromisso()));
		return getPreviousView();
	}
	
	@Override
	public String delete() {
		return null;
	}

	@Override
	protected void handleLoad() {
		setBean(bc.load(getId()));		
	}
}