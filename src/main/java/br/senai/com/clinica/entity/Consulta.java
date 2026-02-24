package br.senai.com.clinica.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Consulta {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private LocalDate data_hora;
    private String obs_medicas;
    public LocalDate getData_hora() {
        return data_hora;
    }
    public void setData_hora(LocalDate data_hora) {
        this.data_hora = data_hora;
    }
    public String getObs_medicas() {
        return obs_medicas;
    }
    public void setObs_medicas(String obs_medicas) {
        this.obs_medicas = obs_medicas;
    }

    
}
