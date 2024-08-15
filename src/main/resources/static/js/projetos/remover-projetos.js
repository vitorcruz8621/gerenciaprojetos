function confirmarDelecaoProjeto(id) {
	const dataStringfy = {
		"idProjeto": 7,
		"titulo": "Novo Projeto",
		"descricao": "Novo Projeto",
		"dataInicio": "2024-08-31"
	};
	
	if (confirm("Tem certeza que deseja deletar este projeto?")) {
		fetch(`/web/projetos/${id}`, {
			method: 'DELETE',
			headers: {
				'Content-Type': 'application/json'
			},
			body: dataStringfy
		})
			.then(response => {
				if (response.ok) {
					window.location.reload();
				} else {
					alert("Ocorreu um erro ao tentar deletar o projeto.");
				}
			})
			.catch(error => {
				console.error('Erro:', error);
				alert("Ocorreu um erro ao tentar deletar o projeto.");
			});
	}
}