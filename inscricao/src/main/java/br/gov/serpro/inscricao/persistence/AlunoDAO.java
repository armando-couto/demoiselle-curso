package br.gov.serpro.inscricao.persistence;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.inscricao.entity.Aluno;

@PersistenceController
public class AlunoDAO extends JPACrud<Aluno, Integer> {

	private static final long serialVersionUID = 1L;
	
	public void insert(Aluno aluno) {
		getEntityManager().persist(aluno);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findAll(){
		return getEntityManager().createQuery("select a from Aluno a").getResultList();
	}
}