package br.senai.com.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Telefone {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    
    private Long id;
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
