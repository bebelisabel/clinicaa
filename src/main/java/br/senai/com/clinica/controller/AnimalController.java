package br.senai.com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.com.clinica.entity.Animal;
import br.senai.com.clinica.exception.Response;
import br.senai.com.clinica.repository.AnimalRepository;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    
    @Autowired
    private AnimalRepository repository;

    @PostMapping
    public Response createAnimal(@Valid @RequestBody Animal animal) {
        repository.save(animal);
        return new Response(201, "Animal adicionado com sucesso");
        //esse código atualiza o sistema para adicionar um novo animal, dando o código 201, que significa 
        //que o recurso foi criado com sucesso.
    }

    @GetMapping
    public List<Animal> getAllAnimal(){
        return repository.findAll();
    }
    
    @PutMapping("/{id}")
    public Response updateAnimal(@PathVariable Long id, @RequestBody Animal updated) {
        if(!repository.existsById(id)) {
            return new Response(201, "Animal não encontrado");
            //esse código é para ver se o animal existe no sistema, caso não exista, o sistema traz o código 201
            //significando que o animal não foi encontrado, caso o id não bata com o animal solicitado.
        }
    
        Animal animal = repository.findById(id).get();

        if (updated.getNome() != null) {
            animal.setNome(updated.getNome());
        }

        if (updated.getEspecie() != null) {
            animal.setEspecie(updated.getEspecie());
        }

        if (updated.getRaca() != null) {
            animal.setRaca(updated.getRaca());
        }

        if (updated.getIdade() != null) {
            animal.setIdade(updated.getIdade());
        }

        if (updated.getInfosMedicas() != null) {
            animal.setInfosMedicas(updated.getInfosMedicas());
        }

        if (updated.getStatus() != null) {
            animal.setStatus(updated.getStatus());
        }

        if (updated.getDono() != null) {
            animal.setDono(updated.getDono());
        }

        repository.save(animal);

        return new Response(200, "Product atualizado com sucesso");
        //essa parte salva as atualizações do animal, dando o código 200, que significa sucesso ou 
        //requisição bem sucedida.
    }

    @DeleteMapping("/{id}")
    public Response deleteAnimal(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Animal não encontrado");
            //essa parte é para deletar o animal, e caso você procurar o id do animal de novo, ele vai dar
            //o código de erro 404, que significa que nada foi encontrado.
        }
        repository.deleteById(id);
        return new Response(204, "Animal deletado com sucesso");
        //esse é para deletar o animal, dando o código de sucesso, mesmo sem ter nada sobre o animal
        //no sistema, 204.
    }

}
