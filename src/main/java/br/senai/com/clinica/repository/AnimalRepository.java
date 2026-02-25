package br.senai.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.com.clinica.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

    
}
