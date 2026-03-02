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

import br.senai.com.clinica.entity.Veterinario;
import br.senai.com.clinica.exception.Response;
import br.senai.com.clinica.repository.VeterinarioRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {
    
    @Autowired
    private VeterinarioRepository repository;

    @PostMapping
    public Response createTelefone(@Valid @RequestBody Veterinario entity) {

        boolean CrmvJaExiste = repository.existsByCrmv(entity.getCrmv());
        if(CrmvJaExiste){
            return new Response(409, "Já existe um veterinário com esse crmv");
        }

        repository.save(entity);
        return new Response(201, "Veterinario adicionado com sucesso");
    }

    @GetMapping
    public List<Veterinario> getAllVeterinarios() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response updateVeterinario(@PathVariable Long id, @RequestBody Veterinario updated) {
        if (!repository.existsById(id)) {
            return new Response(201, "Veterinario não encontrado");
        }

        Veterinario veterinario = repository.findById(id).get();

        if (updated.getNome() != null) {
            veterinario.setNome(updated.getNome());
        }

        if (updated.getCrmv() != null) {
            veterinario.setCrmv(updated.getCrmv());
        }

        if (updated.getJornada() != null) {
            veterinario.setJornada(updated.getJornada());

        if (updated.getEspecializacao() != null) {
            veterinario.setEspecializacao(updated.getEspecializacao());
        }
    } 
        return new Response(201, "Telefone não encontrado");
    }

    @DeleteMapping("/{id}")
    public Response deleteTelefone(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Telefone não encontrado");
        }
        repository.deleteById(id);
        return new Response(204, "Telefone deletado com sucesso");

    }
    
}



