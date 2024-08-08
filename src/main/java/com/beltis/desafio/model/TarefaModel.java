package com.beltis.desafio.model;

import com.beltis.desafio.utilitarios.Prioridade;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tarefas", schema = "public")
@EqualsAndHashCode(of = "id_tarefa")
@Data
public class TarefaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Integer idTarefa;
    
    @NotBlank(message = "O título da tarefa é obrigatório")
    @Size(min = 2, max = 100, message = "O título deve ter entre 2 e 100 caracteres")
    @Column(nullable = false)
    private String titulo;
    
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    @Column(length = 500, nullable = false)
    private String descricao;

    @NotEmpty(message = "A prioridade deve ser definida.")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @NotNull(message = "A prioridade deve ser estabelecida.")
    @Column(name = "estimativa_horas")
    private Integer estimativaHoras;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private ProjetoModel projeto;
}