package br.senai.com.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Veterinario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    private String crmv;;
    private String especializacao;
    private int jornada;
    
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
    public int getJornada() {
        return jornada;
    }
    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    
}
