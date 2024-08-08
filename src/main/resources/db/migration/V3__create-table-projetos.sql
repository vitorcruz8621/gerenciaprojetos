CREATE TABLE IF NOT EXISTS public.projetos (
    id_projeto SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    data_inicio DATE NOT NULL CHECK (data_inicio >= CURRENT_DATE)
);