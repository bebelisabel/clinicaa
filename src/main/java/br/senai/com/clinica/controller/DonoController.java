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

import br.senai.com.clinica.entity.Dono;
import jakarta.validation.Valid;
import br.senai.com.clinica.exception.Response;
import br.senai.com.clinica.repository.DonoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/dono")
public class DonoController {
    @Autowired
    private DonoRepository repository;

    @PostMapping
    public Response createDono(@Valid @RequestBody Dono dono) {
        repository.save(dono);
        return new Response(201, "Dono adicionado com sucesso");
    }
    @GetMapping
    public List<Dono> getAllDonos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response updateDono(@PathVariable Long id, @RequestBody Dono updated) {
        if (!repository.existsById(id)) {
            return new Response(201, "Dono não encontrado");
        }
        
        Dono dono = repository.findById(id).get();

        if (updated.getNome() != null) {
            dono.setNome(updated.getNome());
        }

        if (updated.getCpf() != null) {
            dono.setCpf(updated.getCpf());
        }

        if (updated.getStatus() != null) {
            dono.setStatus(updated.getStatus());
        }

        return new Response(201, "Dono não encontrado");  
    }

    @DeleteMapping("/{id}")
    public Response deleteDono(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Dono não encontrado");
        }
        repository.deleteById(id);
        return new Response(204, "Dono deletado com sucesso");
    }
}



