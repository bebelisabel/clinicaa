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

import br.senai.com.clinica.entity.Telefone;
import br.senai.com.clinica.exception.Response;
import br.senai.com.clinica.repository.TelefoneRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneRepository repository;

    @PostMapping
    public Response createTelefone(@Valid @RequestBody Telefone telefone) {
        repository.save(telefone);
        return new Response(201, "Telefone adicionado com sucesso");
    }

    @GetMapping
    public List<Telefone> getAllTelefones() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response updateTelefone(@PathVariable Long id, @RequestBody Telefone updated) {
        if (!repository.existsById(id)) {
            return new Response(201, "Telefone não encontrado");
        }

        Telefone telefone = repository.findById(id).get();

        if (updated.getNumero() != null) {
            telefone.setNumero(updated.getNumero());

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
