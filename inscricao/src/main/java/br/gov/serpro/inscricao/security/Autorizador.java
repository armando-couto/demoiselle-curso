package br.gov.serpro.inscricao.security;

import javax.enterprise.inject.Alternative;

import br.gov.frameworkdemoiselle.security.Authorizer;

@Alternative
public class Autorizador implements Authorizer {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean hasPermission(String resource, String operation) {
		return true;
	}

	@Override
	public boolean hasRole(String arg0) {
		return true;
	}
}