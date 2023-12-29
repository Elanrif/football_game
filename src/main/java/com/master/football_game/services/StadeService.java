package com.master.football_game.services;

import com.master.football_game.entities.Stade;

import java.util.List;

public interface StadeService {

    List<Stade> getAllStades() ;
    Stade getStadeById(Long id);
    Stade saveStade(Stade stade);
    Stade updateStade(Stade stade);
    void deleteByIdStade(Long id);
    Stade findByMatchesIdMatch(Long idMatch);
}
