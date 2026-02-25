package br.senai.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.com.clinica.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
