package br.com.tech4me.tech4pets.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pets.model.Pet;
import br.com.tech4me.tech4pets.service.PetService;

@RestController
@RequestMapping("/ficha")
public class PetController {
    @Autowired
    private PetService repositorio;

    @PostMapping
    public ResponseEntity<Pet> cadastrarPet(@RequestBody Pet pet){
        return new ResponseEntity<>(repositorio.cadastrar(pet), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> obterPets() {
       return new ResponseEntity<>(repositorio.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> obterPorId(@PathVariable String id) {
        Optional<Pet> pet = repositorio.obterPorId(id);

        if(pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirPorId(@PathVariable String id) {
        repositorio.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public Pet atualizarPet(@PathVariable String id, @RequestBody Pet pet){
        return repositorio.atualizarPorId(id, pet);
    }

}
