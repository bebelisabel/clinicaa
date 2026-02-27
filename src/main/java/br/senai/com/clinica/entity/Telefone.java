package br.senai.com.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Telefone {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    
    private Long id;

    @PositiveOrZero
    @Max(9) @Min(8) private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
