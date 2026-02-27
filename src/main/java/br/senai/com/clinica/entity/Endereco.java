package br.senai.com.clinica.entity;

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
public class Endereco {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    
    private Long id;

    @PositiveOrZero
    @Max(8) @Min(8) private String cep;

    @NotBlank(message = "Precisa do logradouro")
    private String logradouro;

    @NotBlank(message = "Precisa da localidade")
    private String localidade;

    @NotBlank(message = "Precisa da uf")
    private String uf;

    @NotBlank(message = "Precisa do bairro")
    private String bairro;

    @NotNull
    @Min(1) private Integer numero;

    private String complemento;
    private String referencia;

    @NotNull(message = "Precisa do principal")
    private Boolean principal;

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public Boolean getPrincipal() {
        return principal;
    }
    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

}
