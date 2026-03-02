package br.senai.com.clinica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Veterinario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;

    @NotBlank(message = "Precisa do nome")
    private String nome;


    @Column (unique = true)
    @PositiveOrZero
    @Max(12) @Min(12) private String crmv;;
    private String especializacao;

    @NotNull(message = "Precisa da jornada do veterinário")
    private Integer jornada;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCrmv() {
        return crmv;
    }
    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
    public String getEspecializacao() {
        return especializacao;
    }
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    public Integer getJornada() {
        return jornada;
    }
    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }
    
    
}
