package br.gov.serpro.inscricao.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.security.RequiredPermission;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.inscricao.config.InscricaoConfig;
import br.gov.serpro.inscricao.entity.Aluno;
import br.gov.serpro.inscricao.exception.TurmaException;

@BusinessController
public class TurmaBC implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InscricaoConfig config;

	@Inject
	private ResourceBundle bundle;
	
	@Inject
	private MessageContext messageContext;

	@Inject
	private Logger logger;

	@Inject
	private AlunoBC alunoBC;
	
	@Startup
	public void iniciar() {
		logger.info("Iniciando ...");
	}

	@ExceptionHandler
	public void tratar(TurmaException e) {
		logger.warn(bundle.getString("matricula.erro"));
		throw e;
	}

	@Transactional
	@RequiredPermission(resource = "turma", operation = "matricular")
	public void matricular(Aluno aluno) {
		if (estaMatriculado(aluno)
				|| obterAlunosMatriculados().size() == config
						.getCapacidadeTurma()) {
			throw new TurmaException();
		}

		alunoBC.insert(aluno);

		String mensagem = bundle.getString("matricula.sucesso", aluno.getNome()); 
        logger.info(mensagem);
        messageContext.add(mensagem);
	}

	@RequiredPermission(resource = "turma", operation = "consultar")
	public boolean estaMatriculado(Aluno aluno) {
		return obterAlunosMatriculados().contains(aluno);
	}

	public List<Aluno> obterAlunosMatriculados() {
		return alunoBC.findAll();
	}
}