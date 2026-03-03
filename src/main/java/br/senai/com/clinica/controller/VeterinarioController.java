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
@RequestMapping("/veterinarios")
public class VeterinarioController {
      @Autowired
    private VeterinarioRepository repository;

    @PostMapping
    public Response cadastrarVeterinario(@Valid @org.springframework.web.bind.annotation.RequestBody Veterinario veterinario) {
        repository.save(veterinario);
        return new Response(201, "Veterinario(a) cadastrado(a) com sucesso!");
    }

    @GetMapping
    public List<Veterinario> getAllVeterinarios() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarVeterinario(@PathVariable Long id, @RequestBody Veterinario novo) {
        if (!repository.existsById(id)) {
            return new Response(404, "Veterinario(a) não encontrado(a)!");
        }

        Veterinario veterinario= repository.findById(id).get();

        if (novo.getNome() != null) {
            veterinario.setNome(novo.getNome());
        }
        if (novo.getCrmv() != null) {
            veterinario.setCrmv(novo.getCrmv());
        }
        if (novo.getEspecializacao() != null) {
            veterinario.setEspecializacao(novo.getEspecializacao());
        }
        if (novo.getJornada() != null) {
            veterinario.setJornada(novo.getJornada());
        }

        repository.save(veterinario);

        return new Response(200, "Veterinario(a) atualizado(a) com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response deletarVeterinario(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Veterinario(a) não encontrado(a)!");
        }
        repository.deleteById(id);
        return new Response(204, "Veterinario(a) deletado(a) com sucesso!");
    }
}



