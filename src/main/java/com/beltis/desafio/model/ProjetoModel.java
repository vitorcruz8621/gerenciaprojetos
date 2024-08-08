package com.beltis.desafio.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "projetos", schema = "public")
@EqualsAndHashCode(of = "id_projeto")
@Data
public class ProjetoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Integer idProjeto;

    @NotBlank(message = "O título do projeto é obrigatório")
    @Size(min = 2, max = 100, message = "O título deve ter entre 2 e 100 caracteres")
    @Column(nullable = false)
    private String titulo;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    @Column(length = 500, nullable = false)
    private String descricao;

    @NotNull(message = "A data de início é obrigatória")
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    //@OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    //@OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //private List<TarefaModel> tarefas = new ArrayList<>();
}