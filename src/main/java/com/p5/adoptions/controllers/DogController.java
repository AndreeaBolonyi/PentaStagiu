package com.p5.adoptions.controllers;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService)
    {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<DogDTO>> getAllDogs()
    {
        return ResponseEntity.ok(dogService.findAll());
    }

    @PostMapping
    public void addDog(@RequestBody DogDTO dogDTO) {
        dogService.addDog(dogDTO);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DogDTO> getDogByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(dogService.findDog(name));
    }

    @DeleteMapping("/{name}")
    public void deleteDog(@PathVariable("name") String name){
        dogService.deleteDog(name);
    }

    @PutMapping
    public ResponseEntity<DogDTO> updateDog(@RequestBody DogDTO dog){
        return ResponseEntity.ok(dogService.updateDog(dog));
    }
}
