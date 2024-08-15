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

function validarFormularioAlteracao() {
    const titulo = document.getElementById('alteracao-titulo');
    const descricao = document.getElementById('alteracao-descricao');
    const dataInicio = document.getElementById('alteracao-dataInicio');
    const hoje = new Date().toISOString().split('T')[0];

    let valido = true;
    
    if (titulo.value.trim() === '') {
        exibirErro('alteracao-titulo-error', 'O título é obrigatório.');
        valido = false;
    } else {
        document.getElementById('alteracao-titulo-error').classList.add('d-none');
    }
    
    if (descricao.value.trim() === '') {
        exibirErro('alteracao-descricao-error', 'A descrição é obrigatória.');
        valido = false;
    } else {
        document.getElementById('alteracao-descricao-error').classList.add('d-none');
    }
    
    if (dataInicio.value === '') {
        exibirErro('alteracao-dataInicio-error', 'A data de início é obrigatória.');
        valido = false;
    } else if (dataInicio.value < hoje) {
        exibirErro('alteracao-dataInicio-error', 'A data de início não pode ser menor que a data atual.');
        valido = false;
    } else {
        document.getElementById('alteracao-dataInicio-error').classList.add('d-none');
    }

    return valido;
}