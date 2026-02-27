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

import br.senai.com.clinica.entity.Endereco;
import br.senai.com.clinica.exception.Response;
import br.senai.com.clinica.repository.EnderecoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    public Response createEndereco(@Valid @RequestBody Endereco endereco) {
        repository.save(endereco);
        return new Response(201, "Dono adicionado com sucesso");
    }
    @GetMapping
    public List<Endereco> getAllDonos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response updateEndereco(@PathVariable Long id, @RequestBody Endereco updated) {
        if (!repository.existsById(id)) {
            return new Response(201, "Endereço não encontrado");
        }
        
        Endereco endereco = repository.findById(id).get();

        if (updated.getCep() != null) {
            endereco.setCep(updated.getCep());
        }

        if (updated.getLogradouro() != null) {
            endereco.setLogradouro(updated.getLogradouro());
        }

        if (updated.getLocalidade() != null) {
            endereco.setLocalidade(updated.getLocalidade());
        }

        if (updated.getUf() != null) {
            endereco.setUf(updated.getUf());
        }

        if (updated.getBairro() != null) {
            endereco.setBairro(updated.getBairro());
        }

        if (updated.getNumero() != null) {
            endereco.setNumero(updated.getNumero());
        }

        if (updated.getComplemento() != null) {
            endereco.setComplemento(updated.getComplemento());
        }

        if (updated.getReferencia() != null) {
            endereco.setReferencia(updated.getReferencia());
        }

        if (updated.getPrincipal() != null) {
            endereco.setPrincipal(updated.getPrincipal());
        }

        return new Response(201, "Endereço não encontrado");
    }

    @DeleteMapping("/{id}")
    public Response deleteEndereco(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Endereço não encontrado");
        }
        repository.deleteById(id);
        return new Response(204, "Endereço deletado com sucesso");
    }

}
