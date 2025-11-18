package org.example.service;

import java.util.List;

import org.example.domain.Personne;

public interface PersonneService {
    List<Personne> recupererPersonnes();
    void ajouterPersonne(Personne personne);
    void deletePersonne(Integer id) throws Exception;
}

