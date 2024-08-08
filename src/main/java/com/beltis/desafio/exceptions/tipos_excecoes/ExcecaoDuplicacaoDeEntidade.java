package com.beltis.desafio.exceptions.tipos_excecoes;

public class ExcecaoDuplicacaoDeEntidade extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcecaoDuplicacaoDeEntidade () {
		super("Tentativa de cadastro de um registro já existente.");
	}
}