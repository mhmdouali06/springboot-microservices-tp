package org.example.controller;


import org.example.domain.Personne;
import org.example.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("/all")
    public List<Personne> recupererList() {
        return personneService.recupererPersonnes();
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<Boolean> add(@RequestBody(required = true) Personne personne) {
        personneService.ajouterPersonne(personne);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) throws Exception {
        personneService.deletePersonne(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
