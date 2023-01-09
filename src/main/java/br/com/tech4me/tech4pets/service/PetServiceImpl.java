package br.com.tech4me.tech4pets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4pets.model.Pet;
import br.com.tech4me.tech4pets.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository repositorio;

    @Override
    public List<Pet> obterTodos() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Pet> obterPorId(String id) {
        return repositorio.findById(id);
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Pet cadastrar(Pet pet) {
        return repositorio.save(pet);
    }

    @Override
    public Pet atualizarPorId(String id, Pet pet) {
        pet.setId(id);
        return repositorio.save(pet);
    }

}
