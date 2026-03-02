package br.senai.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.com.clinica.entity.Dono;


public interface DonoRepository extends JpaRepository<Dono, Long>{
    boolean existsByCpf(String cpf);
}
