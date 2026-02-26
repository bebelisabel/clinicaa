package br.senai.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.com.clinica.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
    
}
