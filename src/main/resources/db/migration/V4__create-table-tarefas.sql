CREATE TABLE IF NOT EXISTS public.tarefas (
    id_tarefa SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    prioridade VARCHAR(255) NOT NULL CHECK (prioridade IN ('MUITO_ALTA', 'ALTA', 'BAIXA', 'MUITO_BAIXA')),
    estimativa_horas INTEGER NOT NULL,
    projeto_id INTEGER,
    FOREIGN KEY (projeto_id) REFERENCES public.projetos(id_projeto) ON DELETE CASCADE
);