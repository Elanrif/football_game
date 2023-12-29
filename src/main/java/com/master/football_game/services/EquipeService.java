package com.master.football_game.services;

import com.master.football_game.entities.Equipe;

import java.util.List;

public interface EquipeService {

    List<Equipe> getAllEquipes() ;
    Equipe getEquipeById(Long id);
    Equipe saveEquipe(Equipe equipe);
    Equipe updateEquipe(Equipe equipe);
    void deleteByIdEquipe(Long id);

    List<Equipe> findByEquipesName(String nomEquipe);
    //question 8 , récuperer les 2 equipes du match id = 3
    List<Equipe> findByMatchId(Long idMatch);
}
