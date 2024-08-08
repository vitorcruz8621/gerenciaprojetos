package com.beltis.desafio.exceptions.tipos_excecoes;

public class ExcecaoAcessoNaoAutorizado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcecaoAcessoNaoAutorizado() {
		super("Aceso não autorizado.");
	}
}