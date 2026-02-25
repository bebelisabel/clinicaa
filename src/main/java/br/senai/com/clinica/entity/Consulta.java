package br.senai.com.clinica.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Consulta {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime Data_hora;
    private String obs_medicas;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getData_hora() {
        return Data_hora;
    }
    public void setData_hora(LocalDateTime data_hora) {
        Data_hora = data_hora;
    }
    public String getObs_medicas() {
        return obs_medicas;
    }
    public void setObs_medicas(String obs_medicas) {
        this.obs_medicas = obs_medicas;
    }

    
}
