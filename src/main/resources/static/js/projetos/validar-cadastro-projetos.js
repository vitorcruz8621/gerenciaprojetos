function exibirErro(idElemento, mensagem) {
    const elemento = document.getElementById(idElemento);
    if (elemento) {
        elemento.textContent = mensagem;
        elemento.classList.add('d-block');
        elemento.classList.remove('d-none');
        
        setTimeout(() => {
            elemento.textContent = '';
            elemento.classList.add('d-none');
            elemento.classList.remove('d-block');
        }, 5000);
    }
}

function validarFormularioCadastro() {
    const titulo = document.getElementById('cadastro-titulo');
    const descricao = document.getElementById('cadastro-descricao');
    const dataInicio = document.getElementById('cadastro-dataInicio');
    const hoje = new Date().toISOString().split('T')[0];

    let valido = true;
    
    if (titulo.value.trim() === '') {
        exibirErro('cadastro-titulo-error', 'O título é obrigatório.');
        valido = false;
    } else {
        document.getElementById('cadastro-titulo-error').classList.add('d-none');
    }
    
    if (descricao.value.trim() === '') {
        exibirErro('cadastro-descricao-error', 'A descrição é obrigatória.');
        valido = false;
    } else {
        document.getElementById('cadastro-descricao-error').classList.add('d-none');
    }
    
    if (dataInicio.value === '') {
        exibirErro('cadastro-dataInicio-error', 'A data de início é obrigatória.');
        valido = false;
    } else if (dataInicio.value < hoje) {
        exibirErro('cadastro-dataInicio-error', 'A data de início não pode ser menor que a data atual.');
        valido = false;
    } else {
        document.getElementById('cadastro-dataInicio-error').classList.add('d-none');
    }

    return valido;
}