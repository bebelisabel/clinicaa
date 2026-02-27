package br.senai.com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.com.clinica.entity.Consulta;
import br.senai.com.clinica.exception.Response;
import br.senai.com.clinica.repository.ConsultaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    public Response createConsulta(@Valid @RequestBody Consulta consulta) {
        repository.save(consulta);
        return new Response(201, "Consulta adicionada com sucesso");
    }

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response updateConsulta(@PathVariable Long id, @RequestBody Consulta updated) {
        if (!repository.existsById(id)) {
            return new Response(201, "Consulta não encontrada");
        }

        Consulta consulta = repository.findById(id).get();

        if (updated.getData_hora() != null) {
            consulta.setData_hora(updated.getData_hora());
        }

        if (updated.getObs_medicas() != null) {
            consulta.setObs_medicas(updated.getObs_medicas());
        }
        return new Response(201, "Consulta não encontrada");

    }

    @DeleteMapping("/{id}")
    public Response deleteConsulta(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Consulta não encontrada");
        }
        repository.deleteById(id);
        return new Response(204, "Consulta deletada com sucesso");
    }
}
