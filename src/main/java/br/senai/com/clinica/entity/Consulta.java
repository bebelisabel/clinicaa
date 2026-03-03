package br.senai.com.clinica.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_animal")
    private Animal animal;

    @NotNull(message = "É necessário informar a data e a hora da consulta! (ex.: 2026/02/10 11:00:00)") 
    private LocalDateTime data_hora;

    @OneToMany(mappedBy = "consulta")
    private List<VeterinarioConsulta> veterinarioConsultas;

    public Consulta(Long id, LocalDateTime data_hora) {
        this.id = id;
        this.data_hora = data_hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

}
