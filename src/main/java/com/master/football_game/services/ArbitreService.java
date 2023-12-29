package com.master.football_game.services;

import com.master.football_game.entities.Arbitre;

import java.util.List;

public interface ArbitreService {

    List<Arbitre> getAllArbitres() ;
    Arbitre getArbitreById(Long id);
    Arbitre saveArbitre(Arbitre arbitre);
    Arbitre updateArbitre(Arbitre arbitre);
    void deleteByIdArbitre(Long id);
}
