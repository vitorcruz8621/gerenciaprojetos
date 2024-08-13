function salvarProjeto() {
    const form = document.querySelector('#form-cadastro-projeto');
    const formData = new FormData(form);
    const data = {
        titulo: formData.get('titulo'),
        descricao: formData.get('descricao'),
        dataInicio: formData.get('dataInicio')
    };

    fetch('/api/projetos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            window.location.href = '/listar-projetos'; // Redireciona para a lista de projetos
        } else {
            alert('Erro ao cadastrar o projeto.');
        }
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao cadastrar o projeto.');
    });
}

function desistirCadastro() {
    window.location.href = '/listar-projetos'; // Redireciona para a lista de projetos
}