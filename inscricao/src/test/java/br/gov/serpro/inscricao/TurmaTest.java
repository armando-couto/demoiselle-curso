package br.gov.serpro.inscricao;

import java.io.Serializable;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.serpro.inscricao.entity.Aluno;
import br.gov.serpro.inscricao.exception.TurmaException;

@RunWith(DemoiselleRunner.class)
public class TurmaTest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Turma turma;

	@Test(expected = TurmaException.class)
	public void matricularAlunoComSucesso() {
		Aluno aluno = new Aluno("Santos Dumont");

		turma.matricular(aluno);
		Assert.assertTrue(turma.estaMatriculado(aluno));
	}

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoDuplicado() {
		turma.matricular(new Aluno("Orville Wright"));
		turma.matricular(new Aluno("Orville Wright"));
	}

	@Test(expected = TurmaException.class)
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		for (int i = 1; i <= 5; i++) {
			turma.matricular(new Aluno("Aluno " + i));
		}

		turma.matricular(new Aluno("Aluno 6"));
	}
}