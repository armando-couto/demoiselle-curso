package br.gov.serpro.inscricao;

import java.io.Serializable;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.serpro.inscricao.business.TurmaBC;
import br.gov.serpro.inscricao.entity.Aluno;
import br.gov.serpro.inscricao.exception.TurmaException;

@RunWith(DemoiselleRunner.class)
public class TurmaTest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TurmaBC turmaBC;

	@Test(expected = TurmaException.class)
	public void matricularAlunoComSucesso() {
		Aluno aluno = new Aluno("Santos Dumont");

		turmaBC.matricular(aluno);
		Assert.assertTrue(turmaBC.estaMatriculado(aluno));
	}

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoDuplicado() {
		turmaBC.matricular(new Aluno("Orville Wright"));
		turmaBC.matricular(new Aluno("Orville Wright"));
	}

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		for (int i = 1; i <= 5; i++) {
			turmaBC.matricular(new Aluno("Aluno " + i));
		}

		turmaBC.matricular(new Aluno("Aluno 6"));
	}
}