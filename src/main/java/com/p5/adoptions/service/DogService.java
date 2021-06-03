package com.p5.adoptions.service;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.model.adapters.DogAdapter;
import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.repository.dogs.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository)
    {
        this.dogRepository = dogRepository;
    }

    public ListDTO<DogDTO> findAll() {
        List<DogDTO> dogs = DogAdapter.toListDto(dogRepository.findAll());
        return new ListDTO<>(dogs.size(), dogs);
    }

    public void addDog(DogDTO dogDTO) {
        if (dogDTO.getName() == null && dogDTO.getPhotoUrl() == null) {
            throw new RuntimeException("DogDTO must have a name and a photo!");
        }
        dogRepository.save(DogAdapter.fromDto(dogDTO));
    }

    public DogDTO findDog(String name) {
        if (name == null || name == "") {
            throw new RuntimeException("Must specify name!");
        }
        return DogAdapter.toDto(dogRepository.findDogByName(name));
    }

    public void deleteDog(String name){
        Dog toDelete = dogRepository.findDogByName(name);
        dogRepository.deleteById(toDelete.getId());
    }

    public DogDTO updateDog(DogDTO dog){
        if (dog.getName() == null && dog.getPhotoUrl() == null) {
            throw new RuntimeException("DogDTO must have a name and a photo!");
        }

        Dog toUpdate = dogRepository.findDogByName(dog.getName());
        if(toUpdate == null)
            throw new RuntimeException("DogDTO must exist!");

        toUpdate.setPhotoUrl(dog.getPhotoUrl());
        DogDTO updated = DogAdapter.toDto(dogRepository.save(toUpdate));

        return updated;
    }
}
