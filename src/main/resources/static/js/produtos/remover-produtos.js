function confirmarDelecao(id) {
	if (confirm("Tem certeza que deseja deletar este projeto?")) {
		fetch(`/web/projetos/${id}`, {
			method: 'DELETE',
		})
			.then(response => {
				if (response.ok) {
					// Atualiza a página para refletir a exclusão
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