package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.repository.animals.Animal;
import com.p5.adoptions.repository.shelter.AnimalShelter;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelterAdapter
{

    public static AnimalShelter fromDto(AnimalShelterDTO shelterDTO)
    {
        AnimalShelter animalShelter = new AnimalShelter()
                .setAddress(shelterDTO.getAddress())
                .setName(shelterDTO.getName())
                .setId(shelterDTO.getId())
                .setAnimals(AnimalAdpater.fromDto(shelterDTO.getAnimals()));
        return animalShelter;
    }

    public static AnimalShelterDTO toDto(AnimalShelter shelter)
    {
        return new AnimalShelterDTO()
                .setAddress(shelter.getAddress())
                .setId(shelter.getId())
                .setName(shelter.getName())
                .setAnimals(AnimalAdpater.toListDto(shelter.getAnimals()));
    }

    public static List<AnimalShelterDTO> toListDto(List<AnimalShelter> animals) {
        List<AnimalShelterDTO> dtos = new ArrayList<>();

        for (AnimalShelter animalShelter : animals) {
            dtos.add(toDto(animalShelter));
        }

        return dtos;
    }

}