package br.senai.com.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Animal {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "A espécie não pode ser nula")
    private String especie;

    @NotBlank(message = "A raça não pode ser nula")
    private String raca;

    @Min(0) private Integer idade;

    @NotBlank(message = "Precisa ter informações médicas")
    private String infos_medicas;

    @NotNull(message = "Precisa do status")
    private Boolean status;

    @NotBlank(message = "Precisa do nome do dono")
    private String dono;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getInfos_medicas() {
        return infos_medicas;
    }
    public void setInfos_medicas(String infos_medicas) {
        this.infos_medicas = infos_medicas;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }

    
}
