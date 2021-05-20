package com.p5.adoptions.controllers;

import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cats")
public class CatController
{
    private final CatService catService;

    public CatController(CatService catService)
    {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<CatDTO>> getAllCats()
    {
        return ResponseEntity.ok(catService.findAll());
    }

    @PostMapping
    public void addCat(@RequestBody CatDTO catDto)
    {
        catService.addCat(catDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CatDTO> getCatByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(catService.findCat(name));
    }
}