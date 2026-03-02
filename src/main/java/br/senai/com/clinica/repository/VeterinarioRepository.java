package br.senai.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.com.clinica.entity.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
    boolean existsByCrmv(String crmv);
}
