function toggleFormularioCadastro() {
	const formularioCadastro = document.getElementById("formulario-cadastro");
	const tabelaListagemProjetos = document.getElementById("tabela-listagem-projetos");
	const botaoCadastrarProjeto = document.getElementById("div-cadastrar-projeto");
	const tituloListaProjetos = document.getElementById("titulo-lista-projetos");

	if (formularioCadastro.classList.contains("d-none")) {
		formularioCadastro.classList.remove("d-none");
		tabelaListagemProjetos.classList.add("d-none");
		botaoCadastrarProjeto.classList.add("d-none");
		tituloListaProjetos.classList.add("d-none");

	} else {
		formularioCadastro.classList.add("d-none");
		tabelaListagemProjetos.classList.remove("d-none");
		botaoCadastrarProjeto.classList.remove("d-none");
		tituloListaProjetos.classList.remove("d-none");
	}
}

function toggleFormularioAlteracao(botaoAlterar = null) {
	const formularioAlteracao = document.getElementById("formulario-alteracao");
	const tabelaProjetos = document.getElementById("tabela-listagem-projetos");
	const botaoCadastrarProjeto = document.getElementById("div-cadastrar-projeto");
	const tituloListaProjetos = document.getElementById("titulo-lista-projetos");

	if (botaoAlterar === null) {
		console.log("botão nulo");
		formularioAlteracao.classList.add("d-none");
		tabelaProjetos.classList.remove("d-none");
		botaoCadastrarProjeto.classList.remove("d-none");
		tituloListaProjetos.classList.remove("d-none");
	} else {
		formularioAlteracao.classList.remove("d-none");
		tabelaProjetos.classList.add("d-none");
		botaoCadastrarProjeto.classList.add("d-none");
		tituloListaProjetos.classList.add("d-none");

		document.getElementById("alteracao-id").value = botaoAlterar.getAttribute('data-id');;
		document.getElementById("alteracao-titulo").value = botaoAlterar.getAttribute('data-titulo');
		document.getElementById("alteracao-descricao").value = botaoAlterar.getAttribute('data-descricao');
		document.getElementById("alteracao-dataInicio").value = botaoAlterar.getAttribute('data-dataInicio');
	}
}