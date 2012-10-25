package br.gov.serpro.inscricao.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.inscricao.business.TurmaBC;
import br.gov.serpro.inscricao.entity.Aluno;

@ViewController
public class TurmaMB {

	private String nomeAluno;

	@Inject
	private TurmaBC turmaBC;

	public List<Aluno> getAlunosMatriculados() {
		return turmaBC.obterAlunosMatriculados();
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public void matricular() {
		turmaBC.matricular(new Aluno(nomeAluno));
	}
}