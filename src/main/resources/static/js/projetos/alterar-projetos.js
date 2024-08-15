function alterarProjeto(event) {
	event.preventDefault();

	const form = event.target;
	const formData = new FormData(form);

	const data = {
		"idProjeto": Number.parseInt(formData.get('id')),
		"titulo": formData.get('titulo'),
		"descricao": formData.get('descricao'),
		"dataInicio": formData.get('dataInicio')
	};

	const dataStringfy = JSON.stringify(data);

	if (data.idProjeto !== null) {
		fetch(`/web/projetos/${data.idProjeto}`, {
			method: 'PUT',
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(data)
		})
			.then(response => {
				if (response.ok) {
					return response.ok
				}
				
				return response.text().then(text => { throw new Error(text); });
			})
			.then( () => {
				window.location.reload();
			})
			.catch(error => {
				console.error('Erro:', error);
				alert("Ocorreu um erro ao tentar atualizar o projeto.");
			});
	}
}