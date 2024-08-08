INSERT INTO public.tarefas (titulo, descricao, prioridade, estimativa_horas, projeto_id) VALUES
-- Tarefas para o Projeto Alpha (id_projeto = 1)
('Analisar requisitos', 'Análise detalhada dos requisitos do projeto Alpha.', 'ALTA', 8, 1),
('Desenvolver funcionalidade A', 'Implementar a funcionalidade A do projeto Alpha.', 'MUITO_ALTA', 12, 1),
('Testar funcionalidade A', 'Realizar testes na funcionalidade A do projeto Alpha.', 'MUITO_ALTA', 6, 1),

-- Tarefas para o Projeto Beta (id_projeto = 2)
('Profiling de desempenho', 'Analisar o desempenho da aplicação para identificar gargalos.', 'ALTA', 10, 2),
('Otimizar consultas', 'Otimizar consultas SQL para melhorar a performance.', 'MUITO_ALTA', 8, 2),
('Revisar código', 'Revisar o código para garantir a eficiência e eliminar redundâncias.', 'BAIXA', 4, 2),

-- Tarefas para o Projeto Gamma (id_projeto = 3)
('Desenhar novos recursos', 'Desenvolver o design para novos recursos do projeto Gamma.', 'ALTA', 15, 3),
('Implementar recursos avançados', 'Codificar e integrar novos recursos ao sistema.', 'ALTA', 20, 3),
('Documentar novos recursos', 'Criar documentação técnica para os novos recursos.', 'MUITO_BAIXA', 6, 3),

-- Tarefas para o Projeto Delta (id_projeto = 4)
('Mapear sistemas externos', 'Mapear os sistemas externos para integração.', 'MUITO_BAIXA', 7, 4),
('Desenvolver interface de integração', 'Desenvolver a interface necessária para integração.', 'ALTA', 14, 4),
('Testar integração', 'Realizar testes para assegurar a correta integração com sistemas externos.', 'ALTA', 9, 4),

-- Tarefas para o Projeto Epsilon (id_projeto = 5)
('Corrigir bugs críticos', 'Identificar e corrigir bugs críticos no sistema.', 'ALTA', 10, 5),
('Realizar manutenção preventiva', 'Executar tarefas de manutenção para prevenir falhas.', 'MUITO_BAIXA', 8, 5),
('Atualizar documentação', 'Atualizar a documentação com as últimas alterações e correções.', 'BAIXA', 5, 5);
