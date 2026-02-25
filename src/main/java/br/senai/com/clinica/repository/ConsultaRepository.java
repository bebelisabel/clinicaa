package br.senai.com.clinica.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.com.clinica.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    
}
